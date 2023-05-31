package com.example.parkingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                preferences = getSharedPreferences("mypref",MODE_PRIVATE);
                String newUser = username.getText().toString();
                String newPassword = password.getText().toString();
                String newEmail = email.getText().toString();

                try {
                    if (newUser.isEmpty() || newEmail.isEmpty() || newPassword.isEmpty()){

                        SharedPreferences.Editor editor = preferences.edit();

                        editor.putString("User",newUser);
                        editor.putString("Pass",newPassword);
                        editor.putString("email",newEmail);
                        editor.commit();

                        Intent loginscreen = new Intent(register_Activity.this, MainActivity.class);
                        startActivity(loginscreen);
                    }
                } catch (Exception e)
                {
                    Toast.makeText(register_Activity.this, "Failed to sign up", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void InitiateControllers(){
        username = findViewById(R.id.UsernameInput);
        email = findViewById(R.id.EmailInput);
        password = findViewById(R.id.PassInput);
        register = findViewById(R.id.signupbutton);
    }

}