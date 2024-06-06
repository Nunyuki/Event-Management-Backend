package com.dauphine.event_management_backend.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "registration")
public class Registration {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @ManyToOne
    @JoinColumn(name = "event_user_id", nullable = false)
    private EventUser eventUser;

    @Column(name = "registration_date", nullable = false)
    private Date registrationDate;

    public Registration() {}

    public Registration(UUID id, Event event, EventUser eventUser, Date registrationDate) {
        this.id = id;
        this.event = event;
        this.eventUser = eventUser;
        this.registrationDate = registrationDate;
    }
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

        public void setEvent(Event event) {
        this.event = event;
    }

    public EventUser getEventUser() {
        return eventUser;
    }

    public void setEventUser(EventUser eventUser) {
        this.eventUser = eventUser;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
