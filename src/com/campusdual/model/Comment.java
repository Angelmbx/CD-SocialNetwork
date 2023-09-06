package com.campusdual.model;

import java.time.LocalDateTime;

public class Comment {

    private String text;
    private LocalDateTime date;
    private User author;


    public Comment() {
    this.date = LocalDateTime.now();
    }

    public Comment( User author, String text) {
        this.text = text;
        this.date = LocalDateTime.now();
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Comment by "+author+" at "+date + ": " + text;
    }
}
