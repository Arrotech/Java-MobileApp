package com.example.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bLogout;
    EditText etUsername, etFirstName, etLastName;
    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        bLogout = (Button) findViewById(R.id.bLogout);

        bLogout.setOnClickListener(this);

        userLocalStore = new UserLocalStore(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if(authenticate() == true){
            displayUserDetails();

        }else{
            startActivity(new Intent(MainActivity.this, Login.class));
        }
    }

    private boolean authenticate(){

        return userLocalStore.getUserLoggedIn();
    }

    private void displayUserDetails(){

        User user = userLocalStore.getLoggedInUser();

        etUsername.setText(user.username);
        etFirstName.setText(user.firstname);
        etLastName.setText(user.lastname);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bLogout:

                userLocalStore.clearUserData();
                userLocalStore.getLoggedInUser();


                startActivity(new Intent(this, Login.class));

                break;
        }

    }
}
