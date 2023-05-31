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

public class FileEventDataSourse {

    private Context context;

    public FileEventDataSourse(Context context) {
        this.context = context;
    }

    public ArrayList<String> getStringFromAssetFile() throws IOException
    {
        ArrayList<String> arr = new ArrayList<>();
        try {
            String line;
            AssetManager assetManager = context.getAssets();
            InputStreamReader istream = new InputStreamReader(assetManager.open("events.txt"));
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

    public ArrayList<Item> getItemEvent (){
        ArrayList<Integer> image = new ArrayList<>();
        ArrayList<Integer> image200 = new ArrayList<>();
        image.add(R.drawable.e1);
        image.add(R.drawable.e2);
        image.add(R.drawable.e3);
        image.add(R.drawable.e4);
        image.add(R.drawable.e5);
        image.add(R.drawable.e6);
        image.add(R.drawable.e7);
        image.add(R.drawable.e8);
        image.add(R.drawable.e9);
        image.add(R.drawable.e10);

        for (int i = 0; i<20; i++){
            image200.addAll(image);
        }



        String [] namesContact ;
        try {
            namesContact = getStringFromAssetFile().toArray(new String[getStringFromAssetFile().size()]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        ArrayList<Item> items= new ArrayList<>();
        for (int i = 0; i < 200; i++){
            Item item = new Item(image200.get(i),namesContact[i]);
            items.add(item);

        }
        return  items;

    }
}
