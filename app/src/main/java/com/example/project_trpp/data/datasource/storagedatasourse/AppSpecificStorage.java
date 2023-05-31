package com.example.project_trpp.data.datasource.storagedatasourse;

import android.content.Context;
import android.util.Log;

import com.example.netwoevents.data.datasource.models.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class AppSpecificStorage implements UserStorage {

    private Context context;
    public AppSpecificStorage(Context context) {
        this.context = context;
    }

    public void createAppStorage(User user){

        String directoryPath = context.getFilesDir().getAbsolutePath();
        //Создание файла
        String filename = "data.txt";
        String fileContents = user.getEmail()+ ' '+ user.getPassword() ;
        File file = new File(directoryPath, filename);
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(fileContents.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String readAppStorage(){
        String directoryPath = context.getFilesDir().getAbsolutePath();
        String filename = "data.txt";
        File file = new File(directoryPath, filename);

        try {
            FileInputStream inputStream = new FileInputStream(file);
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            String fileContents = new String(buffer);
            Log.d("File Contents", fileContents);
            inputStream.close();
            return fileContents;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Boolean saveData(User user) {

        createAppStorage(user);
        return true;
    }

    @Override
    public String showPassword() {
        return "77777";
    }

    @Override
    public String showEmail() {
        return "tsv7525@gmail.com";
    }
}
