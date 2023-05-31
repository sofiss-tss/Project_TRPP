package com.example.project_trpp.data.datasource.storagedatasourse;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.netwoevents.data.datasource.models.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExternalStorage implements UserStorage {

    private Context context;

    public ExternalStorage(Context context) {
        this.context = context;
    }

    public void createFileInExternalStorage(User user) {
        String fileName = "data_external.txt";
        // Проверяем, доступно ли внешнее хранилище устройства для записи
        String state = Environment.getExternalStorageState();
        if (!Environment.MEDIA_MOUNTED.equals(state)) {
            // Внешнее хранилище не доступно
            return;
        }

        // Получаем директорию, в которой будет создан файл
        File directory = Environment.getExternalStorageDirectory();

        // Создаем файл с указанным именем
        File file = new File(directory, fileName);

        try {
            // Создаем новый файл
            file.createNewFile();

            // Открываем файл для записи
            FileWriter writer = new FileWriter(file);

            // Записываем переданный контент в файл
            writer.write(user.getEmail()+ ' '+ user.getPassword());

            // Закрываем файловый поток
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Проверяем, есть ли разрешение на запись во внешнее хранилище
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // Запрашиваем разрешение на запись во внешнее хранилище
            ActivityCompat.requestPermissions((Activity)context,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    1);
        }
    }

    @Override
    public Boolean saveData(User user) {
        createFileInExternalStorage(user);
        return true;
}

    @Override
    public String showPassword() {
        return null;
    }

    @Override
    public String showEmail() {
        return null;
    }
}
