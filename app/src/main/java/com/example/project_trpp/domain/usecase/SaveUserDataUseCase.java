package com.example.project_trpp.domain.usecase;

import android.util.Log;

import com.example.netwoevents.data.datasource.models.UserData;
import com.example.netwoevents.domain.repository.UserRepositoryInterface;

public class SaveUserDataUseCase {
    UserRepositoryInterface ur;

    public SaveUserDataUseCase(UserRepositoryInterface ur) {
        this.ur = ur;
    }

    public Boolean execute(UserData userData) {
        if (!ur.getUserEmail().isEmpty() && !ur.getUserPassword().isEmpty()) {
            Log.d("mytag","usecase");
            return ur.saveUserData(userData);
        }
        return false;
    }
}
