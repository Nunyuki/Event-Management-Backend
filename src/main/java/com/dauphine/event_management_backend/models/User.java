package com.dauphine.event_management_backend.models;

import java.util.UUID;

public class User {
    private UUID id;
    private String username;
    private String pseudo;
    private String password;
    private String email;

    public User() {}

    public User(UUID id, String username, String pseudo, String password, String email) {
        this.id = id;
        this.username = username;
        this.pseudo = pseudo;
        this.password = password;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
