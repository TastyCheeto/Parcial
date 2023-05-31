package com.example.parkingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    Button login, signup;
    EditText etUser,etPass;


    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitiateControllers();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = etUser.getText().toString();
                String password = etPass.getText().toString();

                try {
                    if (user.equals("admin") && password.equals("admin")) {
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent);
                    } else {
                        SharedPreferences preferences = getSharedPreferences("mypref", MODE_PRIVATE);

                        String username = preferences.getString("User","");
                        String pass = preferences.getString("Pass", "");
                        if (user.equals(username) && password.equals(pass)) {

                            Intent  displayScreen = new Intent(MainActivity.this, partyselector_Activity.class);
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString("display", username);
                            editor.commit();
                            startActivity(displayScreen);
                        } else
                            Toast.makeText(MainActivity.this, "Username or password are incorrect", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Error al Iniciar Sesion", Toast.LENGTH_SHORT).show();
                }


//                String userdetails = preferences.getString(user + password, "username or password is incorrect");
//                SharedPreferences.Editor editor = preferences.edit();

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerScreen = new Intent (MainActivity.this, register_Activity.class);
                startActivity(registerScreen);
            }
        });

    }

    private void InitiateControllers() {

        login = findViewById(R.id.loginbutton);
        signup = findViewById(R.id.signupbutton);
        etUser =  findViewById(R.id.UsernameInput);
        etPass = findViewById(R.id.PassInput);

    }

}