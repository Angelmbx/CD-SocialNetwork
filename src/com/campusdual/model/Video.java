package com.campusdual.model;

import com.campusdual.util.Input;

public class Video extends Post{

    private String title;
    private String quality;
    private String duration;


    public Video() {
        System.out.println("Video title: ");
        this.title = Input.string();
        System.out.println("Resolution: ");
        this.quality = Input.string();
        System.out.println("Duration: ");
        this.duration = Input.string();
    }

    @Override
    public String toString() {
        return "Video title: " + title +
                ", resolution: " + quality +
                ", duration: " + duration;
    }
}
