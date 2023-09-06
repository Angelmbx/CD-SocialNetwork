package com.campusdual.model;

import com.campusdual.util.Input;

import java.util.Scanner;

public class Text extends PostContent{


    private String content;

    public Text() {
        System.out.println("Type whatever you want to say!: ");
        this.content = Input.string();
    }

    public Text(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }


}
