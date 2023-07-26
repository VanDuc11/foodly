package com.example.foodly.Model;

import android.view.View;

import androidx.annotation.NonNull;

public class HomeHorHeader {
    int img;
    String name;

    public HomeHorHeader(int img, String name) {
        this.img = img;
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
