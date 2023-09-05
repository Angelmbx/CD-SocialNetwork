package com.campusdual.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {

    private String name;
    private List<User> followedUsers;
    private List <Post> postList;
    Scanner sc = new Scanner(System.in);

    public User() {
    }

    public User(String name) {
        this.name = name;
        this.followedUsers = new ArrayList<>();
        this.postList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getFollowedUsers() {
        return followedUsers;
    }

    public void setFollowedUsers(List<User> followedUsers) {
        this.followedUsers = followedUsers;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public void followNewUser(User followedUser){
       followedUsers.add(followedUser);
    }

    public void unfollowUser(User unfollowedUser) {
        this.getFollowedUsers().remove(unfollowedUser);
    }

    public void listUsersPosts (User user){
        System.out.println("Posts by user "+user+": \n"+user.getPostList());
    }

    public Object createPost(){
        System.out.println("What kind of post? Choose a number \n 1.Text 2.Image 3.Video");
        String answer = sc.next();

        int actionButton = Integer.parseInt(answer);

        switch (actionButton){
            case 1: Text t = new Text();
                System.out.println(t);
            return t;
            case 2: Image img = new Image();
                System.out.println(img);
            return img;
            case 3: Video vid = new Video();
                System.out.printf(vid.toString());
            return vid;
            default:
                System.err.println("Choose between 1,2,3 to create a post.");
                return null;

        }

    }

    @Override
    public String toString() {
        return "NAME: '" + name + '\'' +
                ", FOLLOWING: " + followedUsers +
                ", POSTS: " + postList;

    }
}
