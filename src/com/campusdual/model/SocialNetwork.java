package com.campusdual.model;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {


    private List<User> signedUpUsers = new ArrayList<>();
    private List<Post> totalPostsList = new ArrayList<>();
    private List<Comments> totalCommentsList = new ArrayList<>();


    public List<User> getSignedUpUsers() {
        return signedUpUsers;
    }

    public List<Post> getTotalPostsList() {
        return totalPostsList;
    }

    public List<Comments> getTotalCommentsList() {
        return totalCommentsList;
    }


    public void addNewUserPostComment(Object obj) {
        if (obj instanceof User) {
            signedUpUsers.add((User) obj);
        } else if (obj instanceof Post) {
            totalPostsList.add((Post) obj);
        } else if (obj instanceof Comments) {
            totalCommentsList.add((Comments) obj);
        }
    }

    public void deleteUserPostComment(Object obj) {
        if (obj instanceof User) {
            signedUpUsers.remove(obj);
        } else if (obj instanceof Post) {
            totalPostsList.remove(obj);
        } else if (obj instanceof Comments) {
            totalCommentsList.remove(obj);
        }
    }

    public int showCommentsNumber(Post post){
        return post.getCommentsList().size();
    }






}