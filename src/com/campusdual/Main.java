package com.campusdual;

import com.campusdual.model.*;
import com.campusdual.util.Input;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<User> signedUpUsers = new ArrayList<>();
    public static List<Post> totalPostsList = new ArrayList<>();
    public static List<Comment> totalCommentsList = new ArrayList<>();

    public static void main(String[] args) {

        initialUsers();
        mainMenu();

    }
    private static void initialUsers() {
        //Initial users so you can log in, or follow any of these once you sign up.

        User admin = new User("Admin"); // Admin user who can Delete other users.

        User u1 = new User("Maria");
        User u2 = new User("Carlos");
        User u3 = new User("Isabel");
        User u4 = new User("Paco");

        signedUpUsers.add(admin);
        signedUpUsers.add(u1);
        signedUpUsers.add(u2);
        signedUpUsers.add(u3);
        signedUpUsers.add(u4);
    }
    private static void mainMenu() {
        System.out.println("-------WELCOME-------");
        System.out.println("How are you feeling today?");
        System.out.println("1. Sign up");
        System.out.println("2. Log in");
        System.out.println("0. Exit");

        int response = Input.integer();


        switch (response) {
            case 1:
                createUser();
                break;
            case 2:
                logIn();
                break;
            case 3:
                System.out.println("See you soon!");
                System.exit(0);
            default:
                System.out.println("Invalid answer. Choose an option between 0 to 2");
        }

    }
    private static void  createUser() {
        System.out.println("Enter user nickname: ");
        String userName = Input.string();
        User u = null;

        // Checks if the username exists already.
        boolean usernameExists = false;
        for (User user : signedUpUsers) {
            if (user.getName().toLowerCase().equals(userName.toLowerCase()))  {
                usernameExists = true;
                break;
            }
        }

        if (usernameExists) {
            System.out.println("Username is already taken. Try again later.");
        } else {
            u = new User(userName);
            signedUpUsers.add(u); // Crea el usuario y lo agrega a la lista de usuarios.
            System.out.println("Registered successfully. Nice to have you here " + userName + "!");
            System.out.println(signedUpUsers);
            secondMenu(u);
        }
    }
    private static void logIn() {
        System.out.println("Enter user nickname: ");
        String userName = Input.string();
        User userLogged = null;

        // Checks if the username exists already.
        boolean usernameExists = false;
        for (User user : signedUpUsers) {
            if (user.getName().toLowerCase().equals(userName.toLowerCase())) {
                usernameExists = true;
                userLogged = user;
                break;
            }
        }
        if (usernameExists) {
                System.out.println("Welcome back " + userName);
                secondMenu(userLogged);
            } else {
            System.out.println("User doesn't exist. Try again later.");
        }
    }
    private static void secondMenu(User user) {
        System.out.println("---------- LOGGED IN ----------");
        System.out.println("What do you want to do now?");
        System.out.println("1. Follow another user");
        System.out.println("2. Unfollow user");
        System.out.println("3. Create post");
        System.out.println("4. Comment post");
        System.out.println("5. Delete user");
        System.out.println("6. Delete post");
        System.out.println("7. Delete comment");
        System.out.println("8. Show user's posts");
        System.out.println("9. Show user's comments");
        System.out.println("10. Show post's comments");
        System.out.println("0. Exit");

        int response = Input.integer();

        switch(response) {
            case 1:
                followUser(user);
                break;
            case 2:
                unfollowUser(user);
                break;
            case 3:
                createPost(user);
                break;
            case 4:
                commentPost(user);
                break;
            case 5:
                if (user.getName().toLowerCase().equals("ADMIN".toLowerCase())){
                deleteUser(user);
                }else {
                    System.out.println("Only admin user can delete another user.");
                    secondMenu(user);
                }
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 0:
                System.out.println("See you soon!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid answer. Choose an option between 0 to 10");
        }

    }
    private static void followUser(User userLogged) {
        ArrayList<User> followedUsers = (ArrayList<User>) userLogged.getFollowedUsers();

        System.out.println("Type the username you want to follow");
        String userName = Input.string();

        User userToFollow = null;

        // Checks if the username exists.
        boolean usernameExists = false;
        for (User u : signedUpUsers) {
            if (u.getName().toLowerCase().equals(userName.toLowerCase())) {
                usernameExists = true;
                userToFollow= u;
                break;
            }
        }
        if (usernameExists) {
            followedUsers.add(userToFollow);
            System.out.println(userLogged.getName()+" is now following "+userToFollow.getName());
            System.out.println(userLogged.getName()+"'s follow list: "+"\n"+userLogged.getFollowedUsers()+"\n");
            secondMenu(userLogged);
        } else {
            System.out.println("User doesn't exist. Try again later.");
        }
    }
    private static void unfollowUser(User userLogged) {
        ArrayList<User> followedUsers = (ArrayList<User>) userLogged.getFollowedUsers();

        System.out.println("Type the username you want to unfollow");
        String userName = Input.string();

        User userToUnfollow = null;

        // Checks if the username exists.
        boolean usernameExists = false;
        for (User u : signedUpUsers) {
            if (u.getName().toLowerCase().equals(userName.toLowerCase())) {
                usernameExists = true;
                userToUnfollow= u;
                break;
            }
        }
        if (usernameExists) {
            followedUsers.remove(userToUnfollow);
            System.out.println(userLogged.getName()+" is no longer following "+userToUnfollow.getName());
            System.out.println(userLogged.getName()+"'s follow list: "+"\n"+userLogged.getFollowedUsers()+"\n");
            secondMenu(userLogged);
        } else {
            System.out.println("User doesn't exist. Try again later.");
        }
    }
    private static void createPost(User userLogged) {
        System.out.println("What do you want to share?\n"+"1.Text | 2.Picture | 3.Video | 0. Back to the menu");
        int response = Input.integer();

        switch (response){
            case 1:
                Text t = new Text();
                userLogged.getPostList().add(t);
                System.out.println("Text posted successfully");
                secondMenu(userLogged);
                break;
            case 2:
                Image img = new Image();
                userLogged.getPostList().add(img);
                System.out.println("Picture posted successfully");
                secondMenu(userLogged);
                break;
            case 3:
                Video vid = new Video();
                userLogged.getPostList().add(vid);
                System.out.println("Video posted successfully");
                secondMenu(userLogged);
                break;
            case 0:
                secondMenu(userLogged);
            default:
                System.out.println("Invalid answer. Choose an option between 0 to 3");
        }


    }
    private static void deleteUser(User userLogged) {

        System.out.println("Type the username you want to delete");
        String userName = Input.string();

        User userToDelete = null;

        // Checks if the username exists.
        boolean usernameExists = false;
        for (User u : signedUpUsers) {
            if (u.getName().toLowerCase().equals(userName.toLowerCase())) {
                usernameExists = true;
                userToDelete= u;
                break;
            }
        }
        if (usernameExists) {
            signedUpUsers.remove(userToDelete);
            System.out.println("User "+userToDelete.getName()+" has been deleted.");
            System.out.println("Users in the list:"+"\n"+signedUpUsers+"\n");
            secondMenu(userLogged);
        } else {
            System.out.println("User doesn't exist. Try again later.");
        }

    }
    private static void commentPost(User userLogged) {
        ArrayList<Post> postList = (ArrayList<Post>) userLogged.getPostList();
        System.out.println("Type the nickname of the user who made the post: ");
        String userName = Input.string();

        User author = null;

        // Checks if the username exists.
        boolean usernameExists = false;
        for (User u : signedUpUsers) {
            if (u.getName().toLowerCase().equals(userName.toLowerCase())) {
                usernameExists = true;
                author= u;
                break;
            }
        }
        if (usernameExists) {
            System.out.println(author.getPostList());
            secondMenu(userLogged);
        } else {
            System.out.println("User doesn't exist. Try again later.");
        }


    }




}


