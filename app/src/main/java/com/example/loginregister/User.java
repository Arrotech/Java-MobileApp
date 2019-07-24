package com.example.loginregister;

public class User {

    String username, firstname, lastname, email, password;

    public User(String username, String firstname, String lastname, String email, String password){

        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public User(String username, String password){

        this.username = username;
        this.password = password;
        this.firstname = "";
        this.lastname = "";
        this.email = "";
    }
}
