package com.campusdual.model;

import java.time.LocalDateTime;

public class Comment {

    private Text text;
    private LocalDateTime date;
    private User author;

    public Comment() {
    this.date = LocalDateTime.now();
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
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
