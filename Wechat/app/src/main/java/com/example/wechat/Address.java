package com.example.wechat;

public class Address {
    private int imageId;
    private String PreSent;

    public Address(int imageId, String PreSent) {
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
