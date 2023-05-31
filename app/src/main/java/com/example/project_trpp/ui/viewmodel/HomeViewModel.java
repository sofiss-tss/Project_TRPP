package com.example.project_trpp.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.netwoevents.data.datasource.models.Message;
import com.example.netwoevents.domain.usecase.CheckEmailValidUseCase;
import com.example.netwoevents.domain.usecase.SendMessageUseCase;

public class HomeViewModel extends ViewModel {

    public MutableLiveData getResultLive() {
        return resultLive;
    }

    private final MutableLiveData<String> resultLive = new MutableLiveData<>();
    public Boolean getCorrectData() {
        return correctData;
    }
    private Boolean correctData = false;
    private SendMessageUseCase sendMessageUseCase = new SendMessageUseCase();
    public void checkMessage(Message msg)
    {
        String textToast;
        if (!CheckEmailValidUseCase.isEmailValid(msg.getEmail())) {
            textToast = "Проверьте адрес электронной почты";
            correctData = false;

        } else if (msg.getMessage().isEmpty()) {
            textToast = "Введите сообщение";
            correctData = false;
        } else {
            textToast = "Сообщение получено! Ожидайте ответа на почте";
            correctData = true;
        }
         resultLive.setValue(textToast);
    }
    public Boolean sendMessage(Message msg){
        if (getCorrectData()) {
            sendMessageUseCase.execute(msg);
            return true;
    }
        return false;
}
    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
