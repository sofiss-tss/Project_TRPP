package com.example.project_trpp.data.datasource.filedatasourse;

import android.content.Context;
import android.content.res.AssetManager;

import com.example.netwoevents.R;
import com.example.netwoevents.data.datasource.models.Item;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileContactDataSourse {
    private Context context;

    public FileContactDataSourse(Context context) {
        this.context = context;
    }


    public ArrayList<String> getStringFromAssetFile() throws IOException
    {
        ArrayList<String> arr = new ArrayList<>();
        try {
            String line;
            AssetManager assetManager = context.getAssets();
            InputStreamReader istream = new InputStreamReader(assetManager.open("names.txt"));
            BufferedReader in = new BufferedReader(istream);
            while ((line = in.readLine()) != null){
                arr.add(line);
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return arr;
    }

    public ArrayList<Item> getItemContact (){
        ArrayList<Integer> image = new ArrayList<>();
        ArrayList<Integer> image200 = new ArrayList<>();

        image.add(R.drawable.a);
        image.add(R.drawable.b);
        image.add(R.drawable.c);
        image.add(R.drawable.d);
        image.add(R.drawable.e);
        image.add(R.drawable.f);
        image.add(R.drawable.g);
        image.add(R.drawable.h);
        image.add(R.drawable.i);
        image.add(R.drawable.k);

        for (int i = 0; i<20; i++){
            image200.addAll(image);
        }



        String [] namesContact ;
        try {
            namesContact = getStringFromAssetFile().toArray(new
                    String[getStringFromAssetFile().size()]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Item> items= new ArrayList<>();
        for (int i = 0; i < 200; i++){
            Item item = new Item(image200.get(i),namesContact[i]);
            items.add(item);
        }

        return items;

    }
}
