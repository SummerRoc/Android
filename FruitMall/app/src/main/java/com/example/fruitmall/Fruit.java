package com.example.fruitmall;

public class Fruit {
    private int imageId;
    private  String  PreSent;

    public Fruit(int imageId, String PreSent){
        this.imageId = imageId;
        this.PreSent = PreSent;

    }

    public int getImageId() {
        return imageId;
    }

    public String getPreSent() {
        return PreSent;
    }

}
