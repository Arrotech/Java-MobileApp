package com.example.loginregister;

import android.content.Context;
import android.content.SharedPreferences;

public class UserLocalStore {

    public static final String SP_NAME = "userDetails";
    SharedPreferences userLocalDatabase;

    public UserLocalStore(Context context){

        userLocalDatabase = context.getSharedPreferences(SP_NAME, 0);
    }

    public void storeUserData(User user){

        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putString("username", user.username);
        spEditor.putString("firstname", user.firstname);
        spEditor.putString("lastname", user.lastname);
        spEditor.putString("email", user.email);
        spEditor.putString("password", user.password);
        spEditor.commit();

    }

    public User getLoggedInUser(){

        String username = userLocalDatabase.getString("username", "");
        String firstname = userLocalDatabase.getString("firstname", "");
        String lastname = userLocalDatabase.getString("lastname", "");
        String email = userLocalDatabase.getString("email", "");
        String password = userLocalDatabase.getString("password", "");

        User storedUser = new User(username, firstname, lastname, email, password);

        return storedUser;

    }

    public void setUserLoggedIn(boolean loggedIn){

        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putBoolean("loggedIn", loggedIn);
        spEditor.commit();


    }

    public boolean getUserLoggedIn(){

        if(userLocalDatabase.getBoolean("loggedIn", false) == true){

            return true;
        }else{
            return false;
        }


    }

    public void clearUserData(){

        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();

    }

}
