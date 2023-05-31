package com.example.project_trpp.domain.usecase;

import com.example.netwoevents.data.datasource.models.Item;
import com.example.netwoevents.domain.repository.ContactRepositoryInterface;

import java.util.ArrayList;

public class GetContactListUseCase {
    ContactRepositoryInterface cr;

    public GetContactListUseCase(ContactRepositoryInterface cr) {
        this.cr = cr;
    }

    public ArrayList<Item> execute(){
        return cr.getContactList();
    }


}
