package com.campusdual.model;

import com.campusdual.util.Input;

import java.util.Scanner;

public class Text extends Post{

    private User author;
    private String content;

    public Text() {
        System.out.println("Type whatever you want to say!: ");
        this.content = Input.string();
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Text post content: " + content;
    }


}
