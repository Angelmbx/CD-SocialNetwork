package model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private List<User> followingList;
    private List <Post> postList;

    public User() {
    }

    public User(String name) {
        this.name = name;
        this.followingList = new ArrayList<User>();
        this.postList = new ArrayList<Post>();
    }
}
