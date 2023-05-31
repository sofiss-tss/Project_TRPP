package com.example.project_trpp.data.datasource.models;

public class Item {
    private int image;
    private String names;
    public Item(int image, String names) {
        this.image = image;
        this.names = names;
    }

    public String getText() {
        return names;
    }
    public int getImage() {
        return image;
    }

}
