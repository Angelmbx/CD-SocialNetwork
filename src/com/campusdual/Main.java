package com.campusdual;

import com.campusdual.model.*;
import com.campusdual.util.Input;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static List<User> signedUpUsers = new ArrayList<>();
    public static List<Post> totalPostsList = new ArrayList<>();
    public static List<Comments> totalCommentsList = new ArrayList<>();

    public static void main(String[] args) {

        initialUsers();
        mainMenu();

    }

    private static void initialUsers() {
        //Initial users so you can log in, or follow any of these once you sign up.

        User u1 = new User("Maria");
        User u2 = new User("Carlos");
        User u3 = new User("Isabel");
        User u4 = new User("Paco");

        signedUpUsers.add(u1);
        signedUpUsers.add(u2);
        signedUpUsers.add(u3);
        signedUpUsers.add(u4);
    }


    private static void createUser() {
        System.out.println("Enter user nickname: ");
        String userName = Input.string();

        User u = new User(userName);
        signedUpUsers.add(u);
    }

    private static void mainMenu() {
        System.out.println("-------WELCOME-------");
        System.out.println("How are you feeling today?");
        System.out.println("1. Sign up");
        System.out.println("2. Log in");
        System.out.println("3. Exit");

        int response = Input.integer();


        switch (response) {
            case 1:
                createUser();
                System.out.println("User added!");
                secondMenu();
                break;
            case 2:
                if(logIn()){ //checks if the user name is in the list.
                secondMenu();}
                else { System.out.println("User doesn't exist. Check it and try again later!");
                    System.exit(0);}
                break;
            case 3:
                System.out.println("See you soon!");
                System.exit(0);
        }

    }

    private static boolean logIn() {
        System.out.println("Enter user nickname: ");
        String userName = Input.string();

        Iterator<User> iterator = signedUpUsers.iterator();
        boolean logged = false;
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getName().equals(userName)) {
                System.out.println("Welcome back " + userName);
                logged = true;
           }/*  else if (!user.getName().equals(userName)){
                System.out.println("User doesn't exist.");
            }*/
        }
        return logged;
    }

    private static void secondMenu() {
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
        System.out.println("11. Exit");
    }
}


