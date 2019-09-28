package com.example.check.Models;

public class scroll {

    private int scrollImage;
    private String title;

    public scroll(int scrollImage, String title) {
        this.scrollImage = scrollImage;
        this.title = title;
    }

    public int getScrollImage() {
        return scrollImage;
    }

    public void setScrollImage(int scrollImage) {

        this.scrollImage = scrollImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

