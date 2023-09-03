package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Post {

    private LocalDateTime date;
    private List <Comments> commentsList;

    public Post() {
    }

    public Post(LocalDateTime date) {
        this.date = date;
        this.commentsList = new ArrayList<Comments>();
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<Comments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comments> commentsList) {
        this.commentsList = commentsList;
    }
}
