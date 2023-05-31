package com.example.project_trpp.data.repository;

import android.content.Context;

import com.example.netwoevents.data.datasource.filedatasourse.FileContactDataSourse;
import com.example.netwoevents.data.datasource.models.Item;
import com.example.netwoevents.domain.repository.ContactRepositoryInterface;

import java.util.ArrayList;

public class ContactRepository implements ContactRepositoryInterface {

    private Context context;
    private ArrayList<Item> items ;

    public ContactRepository(Context context) {
        this.context = context;
    }


    public ArrayList<Item> getContactList (){


        FileContactDataSourse getContactFromFile = new FileContactDataSourse(context);
        items = getContactFromFile.getItemContact();
        return items;
    }
}
