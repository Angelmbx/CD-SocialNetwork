package com.campusdual;

import com.campusdual.model.SocialNetwork;
import com.campusdual.model.Text;
import com.campusdual.model.User;

public class Main {

    public static void main(String[] args) {
        SocialNetwork socialNetwork = new SocialNetwork();
        User u1 = new User("Jaime");
        User u2 = new User("Isabel");
        //Text t1 = new Text();


        /*
        //Creo 2 usuarios
        socialNetwork.addNewUserPostComment(u1);
        socialNetwork.addNewUserPostComment(u2);


        //User1 sigue a User2
        u1.followNewUser(u2);

        System.out.println("Registered users: "+socialNetwork.getSignedUpUsers().toString());

        System.out.println("Borrando a "+u1.getName()+"....");
        socialNetwork.deleteUserPostComment(u1);
        System.out.println("Registered users: "+socialNetwork.getSignedUpUsers().toString());*/

        socialNetwork.addNewUserPostComment(u1.createPost());

       /* socialNetwork.addNewUserPostComment(t1);
        System.out.println(t1);
        System.out.println("FECHA: "+t1.getDate());*/


    }

}
