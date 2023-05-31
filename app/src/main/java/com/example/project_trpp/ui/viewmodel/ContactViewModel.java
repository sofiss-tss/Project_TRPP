package com.example.project_trpp.ui.viewmodel;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class ContactViewModel extends AndroidViewModel {
    private final MutableLiveData<String> resultLiveName = new MutableLiveData<>();
    private final MutableLiveData<Integer> resultLiveImage = new MutableLiveData<>();
    public MutableLiveData<String> getResultLiveName() {
        return resultLiveName;
    }
    public MutableLiveData<Integer> getResultLiveImage() {
        return resultLiveImage;
    }

    public void getDataFromContactList(Bundle bundle){
        if (bundle != null) {
            resultLiveName.setValue(bundle.getString("bundleText"));
            resultLiveImage.setValue(bundle.getInt("bundleImage"));
        }
    }
    public ContactViewModel(@NonNull Application application) {
        super(application);
    }
}
