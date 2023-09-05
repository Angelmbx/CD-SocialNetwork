package com.campusdual.model;

import java.util.Scanner;

public class Text extends Post{

    private String content;

    Scanner sc = new Scanner(System.in);
    public Text() {
        System.out.println("Type whatever you want to say!: ");
        this.content = sc.nextLine();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Text post content: " + content;
    }
}
