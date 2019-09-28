package com.example.check.Models;

import com.example.check.Fragments.music;

public class Music  {

     private String name ;
     private int photo;



    public Music(String name, int photo) {
        this.name = name;
        this.photo = photo;
    }

     /// getter


    public String getName() {
        return name;
    }

    public int getPhoto() {
        return photo;
    }
    /// Setter


    public void setName(String name) {
        this.name = name;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
