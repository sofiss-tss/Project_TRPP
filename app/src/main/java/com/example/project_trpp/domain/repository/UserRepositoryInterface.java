package com.example.project_trpp.domain.repository;

import com.example.netwoevents.data.datasource.models.UserData;

public interface UserRepositoryInterface {

    String getUserEmail();
    String getUserPassword();
    Boolean  saveUserData(UserData userData);
}
