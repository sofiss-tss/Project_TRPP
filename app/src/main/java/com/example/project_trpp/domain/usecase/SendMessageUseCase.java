package com.example.project_trpp.domain.usecase;



import com.example.netwoevents.data.datasource.models.Message;


public class SendMessageUseCase {
    private String email;
    private String message;

    public void execute(Message msg) {
        email = msg.getEmail();
        message = msg.getMessage();
    }
}
