package com.example.project_trpp.data.datasource.models;

public class UserData {

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserData(String email, String password) {
        this.email = email;
        this.password = password;

    }
}
