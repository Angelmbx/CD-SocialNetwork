package com.campusdual.model;

import com.campusdual.util.Input;

public class Image extends PostContent{

    private String title;
    private int height;
    private int width;

    public Image() {
        System.out.println("Image title: ");
        this.title = Input.string();
        System.out.println("Height:");
        this.height = Input.integer();
        System.out.println("Width: ");
        this.width = Input.integer();
    }

    public Image(String title, int height, int width) {
        this.title = title;
        this.height = height;
        this.width = width;
    }

    @Override
    public String toString() {
        return "Image title: "+ title + " PROPERTIES: " +
                "height= " + height +
                ", width= " + width;
    }
}
