package com.example.waiganjo.nihondishes;

/**
 * Created by Waiganjo on 11/19/2015.
 */
public class Dish {
     private int id;
     private int image;
     private String title;
     private String desc;

    public Dish(int id, int image, String title, String desc) {
        this.id = id;
        this.image = image;
        this.desc = desc;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }
}
