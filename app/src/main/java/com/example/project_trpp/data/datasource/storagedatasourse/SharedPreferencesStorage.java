package com.example.project_trpp.data.datasource.storagedatasourse;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.netwoevents.R;
import com.example.netwoevents.data.datasource.models.User;


public class SharedPreferencesStorage implements UserStorage {


    private Context context;
    private SharedPreferences sharedPref;
    private final static String KEY_EMAIL = "email";
    private final static String KEY_PASSWORD = "password";


    public SharedPreferencesStorage(Context context) {
        this.context = context;

        sharedPref = context.getSharedPreferences(
                String.valueOf(R.string.preference_file_key),
                Context.MODE_PRIVATE);
    }



    @Override
    public Boolean saveData(User user) {
        Log.d("mytag", user.getEmail());
       sharedPref.edit().putString(KEY_EMAIL, user.getEmail()).apply();
       sharedPref.edit().putString(KEY_PASSWORD, user.getPassword()).apply();
       return true;
    }

    @Override
    public String showPassword() {
        String password = sharedPref.getString(KEY_PASSWORD,"");
        return password;
    }

    @Override
    public String showEmail() {
        String email = sharedPref.getString(KEY_EMAIL,"");
        return email;
    }
}
