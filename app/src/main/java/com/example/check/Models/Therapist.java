package com.example.check.Models;

public class Therapist  {

    private int Image;
    private String tName;


    public Therapist(int image, String tName) {
       this.Image = image;
        this.tName = tName;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }
}


