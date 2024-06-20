package com.dauphine.event_management_backend.services.impl;

import com.dauphine.event_management_backend.config.SecurityConfig;
import com.dauphine.event_management_backend.dto.EventUserRequest;
import com.dauphine.event_management_backend.exceptions.eventusers.*;
import com.dauphine.event_management_backend.models.EventUser;
import com.dauphine.event_management_backend.repositories.EventUserRepository;
import com.dauphine.event_management_backend.services.EventUserService;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.UUID;

@Service
public class EventUserServiceImpl implements EventUserService {
    private final EventUserRepository eventUserRepository;
    private static final Logger logger = LoggerFactory.getLogger(EventUserServiceImpl.class);

    public EventUserServiceImpl(EventUserRepository eventUserRepository) {
        this.eventUserRepository = eventUserRepository;
    }

    @Override
    public EventUser retrieveUserById(UUID id) throws UserNotFoundByIdException {
        return eventUserRepository.findById(id).orElseThrow(() -> new UserNotFoundByIdException(id));

    }

    @Override
    public EventUser createUser(EventUserRequest eventUserRequest) throws InvalidEmailException, PseudoAlreadyExistsException,EmptyDataException {
        logger.debug("Trying to create user with pseudo: {}", eventUserRequest.getPseudo());
        if(eventUserRequest.getPseudo().isEmpty() || eventUserRequest.getPassword().isEmpty() || eventUserRequest.getEmail().isEmpty() || eventUserRequest.getUsername().isEmpty()){
            throw new EmptyDataException();
        }

        if(eventUserRepository.findByPseudo(eventUserRequest.getPseudo()) != null){
            throw new PseudoAlreadyExistsException(eventUserRequest.getPseudo());
        }
        if(!SecurityConfig.checkEMail(eventUserRequest.getEmail())){
            throw new InvalidEmailException();
        }

        String encodedPassword = SecurityConfig.hashPassword((eventUserRequest.getPassword()));
        EventUser eventUser = new EventUser(eventUserRequest.getUsername(), eventUserRequest.getPseudo(), encodedPassword, eventUserRequest.getEmail());
        return eventUserRepository.save(eventUser);
    }

    @Override
    public EventUser updateUser(UUID id, EventUserRequest eventUserRequest) throws UserNotFoundByIdException, EmptyDataException {
        EventUser eventUser = retrieveUserById(id);
        if(eventUserRequest.getPseudo().isEmpty() || eventUserRequest.getPassword().isEmpty() || eventUserRequest.getEmail().isEmpty() || eventUserRequest.getUsername().isEmpty()){
            throw new EmptyDataException();
        }
        eventUser.setAll(eventUserRequest.getUsername(), eventUserRequest.getPseudo(), eventUserRequest.getPassword(), eventUserRequest.getEmail());
        return eventUserRepository.save(eventUser);
    }

    @Override
    public void deleteUserById(UUID id) throws UserNotFoundByIdException{
        retrieveUserById(id);
        eventUserRepository.deleteById(id);
    }

    @Override
    public EventUser authenticateUser(String pseudo, String password) throws AuthenticationException {
        EventUser eventUser = eventUserRepository.findByPseudo(pseudo);

        if(eventUser == null){
            throw new AuthenticationException();
        }

        if(!SecurityConfig.checkPassword(password, eventUser.getPassword())){
            throw new AuthenticationException();
        }
        return eventUser;
    }
}
