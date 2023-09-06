package com.campusdual.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Comment {

    private final DateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
    private String text;
    private Date date;
    private User author;
    private static int nextId = 1;

    private int id;

    public Comment() {
    this.date = new Date();
    }

    public Comment( User author, String text) {
        this.text = text;
        this.date = new Date();
        this.author = author;
        this.author.getCommentList().add(this);
        this.id = nextId++;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
        return "Comment by "+author+" at "+sdf.format(date)+": " + text;
    }
}
