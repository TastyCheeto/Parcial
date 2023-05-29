package com.example.parkingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register_Activity extends AppCompatActivity {
    Button register;
    EditText username, email, password;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        InitiateControllers();
    }

    private void InitiateControllers(){
        username = findViewById(R.id.UsernameInput);
        email = findViewById(R.id.EmailInput);
        password = findViewById(R.id.PassInput);
        register = findViewById(R.id.signupbutton);
    }

    public void emptyField(){
        username.setText("");
        password.setText("");
        email.setText("");
    }
}