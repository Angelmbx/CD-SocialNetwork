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

        // Some users posts

        Post p = new Post(u1, new Text("Trying out this new thing!"));
        totalPostsList.add(p);
        Post p2 = new Post(u1, new Text("Anybody out there?"));
        totalPostsList.add(p2);
        Post p3 = new Post(u1, new Text("Damn, I think I'm alone here."));
        totalPostsList.add(p3);
        Post p4 = new Post(u3, new Text("Today is gonna be a great day!"));
        totalPostsList.add(p4);
        Post p5 = new Post(u3, new Image("Sunny dawn landscape", 300, 400));
        totalPostsList.add(p5);
        // Some users comments

        Comment c = new Comment(u2, "Hey! I'm here!");
        p2.getCommentsList().add(c); //add the new comment to the post's comments list.
        Comment c1 = new Comment(u4, "Yeah, me too!");
        p2.getCommentsList().add(c1);
        Comment c2 = new Comment(u4, "No sir, there's a bunch of us here!");
        p3.getCommentsList().add(c2);
        Comment c3 = new Comment(u1, "Nice picture");
        p5.getCommentsList().add(c3);

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
            case 0:
                System.out.println("See you soon!");
                System.exit(0);
            default:
                System.out.println("Invalid answer. Choose an option between 0 to 2");
        }

    }

    private static void createUser() {
        System.out.println("Enter user nickname: ");
        String userName = Input.string();
        User u = null;

        // Checks if the username exists already.
        boolean usernameExists = false;
        for (User user : signedUpUsers) {
            if (user.getName().toLowerCase().equals(userName.toLowerCase())) {
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
        System.out.println("10. Show post's number of comments");
        System.out.println("0. Exit");

        int response = Input.integer();

        switch (response) {
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
                if (user.getName().toLowerCase().equals("ADMIN".toLowerCase())) {
                    deleteUser(user);
                } else {
                    System.out.println("Only admin user can delete another user.");
                    secondMenu(user);
                }
                break;
            case 6:
                deletePost(user);
                break;
            case 7:
                deleteComment(user);
                break;
            case 8:
                showUsersPosts(user); // preguntar si se deben ver los comentarios
                break;
            case 9:
                showUserCommentsMade(user);
                break;
            case 10:
                showPostsCommentsNumber(user);
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
                userToFollow = u;
                break;
            }
        }
        if (usernameExists) {
            followedUsers.add(userToFollow);
            System.out.println(userLogged.getName() + " is now following " + userToFollow.getName());
            System.out.println(userLogged.getName() + "'s follow list: " + "\n" + userLogged.getFollowedUsers() + "\n");
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
                userToUnfollow = u;
                break;
            }
        }
        if (usernameExists) {
            followedUsers.remove(userToUnfollow);
            System.out.println(userLogged.getName() + " is no longer following " + userToUnfollow.getName());
            System.out.println(userLogged.getName() + "'s follow list: " + "\n" + userLogged.getFollowedUsers() + "\n");
            secondMenu(userLogged);
        } else {
            System.out.println("User doesn't exist. Try again later.");
        }
    }

    private static void createPost(User userLogged) {
        System.out.println("What do you want to share?\n" + "1.Text | 2.Picture | 3.Video | 0. Back to the menu");
        int response = Input.integer();


        switch (response) {
            case 1:
                Text t = new Text();
                Post textPost = new Post(userLogged, t);
                userLogged.getPostList().add(textPost);
                totalPostsList.add(textPost);
                System.out.println("Text posted successfully");
                secondMenu(userLogged);
                break;
            case 2:
                Image img = new Image();
                Post imgPost = new Post(userLogged, img);
                userLogged.getPostList().add(imgPost);
                totalPostsList.add(imgPost);
                System.out.println("Picture posted successfully");
                secondMenu(userLogged);
                break;
            case 3:
                Video vid = new Video();
                Post vidPost = new Post(userLogged, vid);
                userLogged.getPostList().add(vidPost);
                totalPostsList.add(vidPost);
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
                userToDelete = u;
                break;
            }
        }
        if (usernameExists) {
            signedUpUsers.remove(userToDelete);
            System.out.println("User " + userToDelete.getName() + " has been deleted.");
            System.out.println("Users in the list:" + "\n" + signedUpUsers + "\n");
            secondMenu(userLogged);
        } else {
            System.out.println("User doesn't exist. Try again later.");
        }

    }

    private static void showUsersPosts(User userLogged) {
        System.out.println("Type the nickname of the user you want to check: ");
        String userName = Input.string();

        User author = null;

        // Checks if the username exists.
        boolean usernameExists = false;
        for (User u : signedUpUsers) {
            if (u.getName().toLowerCase().equals(userName.toLowerCase())) {
                usernameExists = true;
                author = u;
                break;
            }
        }
        if (usernameExists) {

            //shows posts by the typed username
            for (int i = 0; i < author.getPostList().size(); i++) {
                System.out.println( author.getPostList().get(i).getId()+ ": " + author.getPostList().get(i).toString());
            }


            secondMenu(userLogged);
        } else {
            System.out.println("User doesn't exist. Try again later.");
        }
    }

    private static void commentPost(User userLogged) {
        List<Post> postList = userLogged.getPostList();
        System.out.println("Type the nickname of the user who made the post: ");
        String userName = Input.string();

        User author = null;

        // Checks if the username exists.
        boolean usernameExists = false;
        for (User u : signedUpUsers) {
            if (u.getName().toLowerCase().equals(userName.toLowerCase())) {
                usernameExists = true;
                author = u;
                break;
            }
        }
        if (usernameExists) {

            //shows posts by the typed username
            for (int i = 0; i < author.getPostList().size(); i++) {
                System.out.println(i + ": " + author.getPostList().get(i).toString());
            }

            int index = Input.integer("Type the index of the post you want to comment: ");
            Post selectedPost = author.getPostList().get(index);

            Comment comment = new Comment(userLogged, Input.string("Write it now! "));
            selectedPost.getCommentsList().add(comment);


            secondMenu(userLogged);
        } else {
            System.out.println("User doesn't exist. Try again later.");
        }
    }

    private static void showPostsCommentsNumber(User userLogged) {

        //shows all the posts in the social network
        for (int i = 0; i < totalPostsList.size(); i++) {
            System.out.println(i + ": " + totalPostsList.get(i).toString());
        }

        int index = Input.integer("Type the index of the post you want to check the comments number ");
        Post selectedPost = totalPostsList.get(index);

        System.out.println("The number of comments for this post is: " + selectedPost.getCommentsList().size());

        secondMenu(userLogged);
    }

    private static void showUserCommentsMade(User userLogged) {
        List<Comment> userCommentsMade = new ArrayList<>();
        System.out.println("Type the nickname of the user you want to check: ");
        String userName = Input.string();

        User author = null;

        // Checks if the username exists.
        boolean usernameExists = false;
        for (User u : signedUpUsers) {
            if (u.getName().toLowerCase().equals(userName.toLowerCase())) {
                usernameExists = true;
                author = u;
                break;
            }
        }
        if (usernameExists) {

            //shows comments by the typed username
            for (Comment c : author.getCommentList()) {
                System.out.println(c);
            }

            secondMenu(userLogged);
        } else {
            System.out.println("User doesn't exist. Try again later.");

            secondMenu(userLogged);
        }

    }
    private static void deletePost(User userLogged) {
       List<Post> posts = userLogged.getPostList();

            //shows posts by the logged user
            for (int i = 0; i < posts.size(); i++) {
                System.out.println( posts.get(i).getId()+ ": " + posts.get(i).toString());
            }

            System.out.println("Select the number of the post you want to delete");
            int postIndex = Input.integer();

        for (int i = 0; i < posts.size(); i++) {
            if( postIndex == posts.get(i).getId()){

                posts.remove(i); //deletes the selected post
            }
        }
        System.out.println("Post deleted successfully");
            secondMenu(userLogged);

    }
    private static void deleteComment(User userLogged) {
        List<Comment> comments = userLogged.getCommentList();

        //shows posts by the logged user
        for (int i = 0; i < comments.size(); i++) {
            System.out.println( comments.get(i).getId()+ ": " + comments.get(i).toString());
        }

        System.out.println("Select the number of the post you want to delete");
        int postIndex = Input.integer();

        for (int i = 0; i < comments.size(); i++) {
            if( postIndex == comments.get(i).getId()){

                comments.remove(i); //deletes the selected post
            }
        }
        System.out.println("Post deleted successfully");
        secondMenu(userLogged);
    }




}



