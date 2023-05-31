package com.example.project_trpp.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.netwoevents.data.datasource.models.UserData;
import com.example.netwoevents.domain.usecase.SaveUserDataUseCase;

public class LoginViewModel extends ViewModel {

    private SaveUserDataUseCase saveUserDataUseCase;
    public LoginViewModel(SaveUserDataUseCase saveUserDataUseCase) {
        this.saveUserDataUseCase = saveUserDataUseCase;
    }
    public Boolean saveUserData (UserData userData){
        if (!userData.getEmail().isEmpty() && !userData.getPassword().isEmpty()){
            saveUserDataUseCase.execute(userData);
            return true;
        }
        return false;

    }

}
