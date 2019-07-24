package com.example.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity implements View.OnClickListener {

    Button bRegister;
    EditText etUsername, etFirstName, etLastName, etEmail, etPassword;
    TextView tvLoginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bRegister = (Button) findViewById(R.id.bRegister);
        tvLoginLink = (TextView) findViewById(R.id.tvLoginLink);

        bRegister.setOnClickListener(this);
        tvLoginLink.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bRegister:

                String username = etUsername.getText().toString();
                String firstname = etFirstName.getText().toString();
                String lastname = etLastName.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                User user = new User(username, firstname, lastname, email, password);

                registerUser(user);



//                String type = "reg";
//                BackgroundTask backgroundTask = new BackgroundTask(getApplicationContext());
//                backgroundTask.execute(type, username, firstname, lastname, email, password);

                break;
            case R.id.tvLoginLink:

                startActivity(new Intent(this, Login.class));

                break;
        }

    }

    private void registerUser(User user){

        ServerRequests serverRequests = new ServerRequests(this);
        serverRequests.storeUserDataInBackground(user, new GetUserCallback() {
            @Override
            public void done(User returnedUser) {
                startActivity(new Intent(Register.this, Login.class));
            }
        });
    }
}
