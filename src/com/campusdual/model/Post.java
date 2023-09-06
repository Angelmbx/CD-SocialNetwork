package com.campusdual.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {

    private static int nextId = 1;

    private final DateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
    private Date date;
    private List <Comment> commentsList = new ArrayList<>();
    private User author;
    private int id;
    private PostContent postContent;

    public Post(User author, PostContent postContent) {
        this.date = new Date();
        this.author = author;
        this.postContent = postContent;
        this.author.getPostList().add(this);
        this.id = nextId++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Comment> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comment> commentsList) {
        this.commentsList = commentsList;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public PostContent getPostContent() {
        return postContent;
    }

    public void setPostContent(PostContent postContent) {
        this.postContent = postContent;
    }


    @Override
    public String toString() {
        return author +" at "+sdf.format(date)+" POSTED: " + postContent;
    }
}
