package com.example.project_trpp.data.datasource.models;

public class Message {
    public String getEmail() {
        return email;
    }
    public String getMessage() {
        return message;
    }

    private String email;
    private String message;

    public Message(String email, String message) {
        this.email = email;
        this.message = message;
    }
}
