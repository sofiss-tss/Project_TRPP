package com.example.project_trpp.data.repository;


import com.example.netwoevents.data.datasource.models.User;
import com.example.netwoevents.data.datasource.models.UserData;
import com.example.netwoevents.data.datasource.storagedatasourse.UserStorage;
import com.example.netwoevents.domain.repository.UserRepositoryInterface;

public class UserRepository implements UserRepositoryInterface {

   private UserStorage userStorage;

    public UserRepository(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    @Override
    public String getUserEmail() {
        return userStorage.showEmail();
    }

    @Override
    public String getUserPassword() {
       return userStorage.showPassword();
    }



    @Override
    public Boolean saveUserData(UserData userData) {

        User user  = new User(userData.getEmail(),userData.getPassword());
        return userStorage.saveData(user);

    }
}
