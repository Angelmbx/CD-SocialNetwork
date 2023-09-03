package model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private List<User> userList;
    private List <Post> postList;

    public User() {
    }

    public User(String name) {
        this.name = name;
        this.userList = new ArrayList<User>();
        this.postList = new ArrayList<Post>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    private static ArrayList<User> followNewUser(User user, User followedUser){
        user.getUserList().add(followedUser);

        return (ArrayList<User>) user.getUserList();
    }

    private static ArrayList<User> unfollowUser(User user, User unfollowedUser) {
        user.getUserList().remove(unfollowedUser);

        return (ArrayList<User>) user.getUserList();
    }

    private static void listUsersPosts (User user){
        System.out.println("Posts by user "+user+": \n"+user.getPostList());
    }

    private static void createPost(int actionButton){

        switch (actionButton){
            case 1: //text
            break;
            case 2: //image
            break;
            case 3: //video
            break;
            default:
                System.err.println("Choose between 1,2,3 to create a post.");

        }


    }
}
