package com.example.parkingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.parkingapp.Models.Eventos;

public class MainActivity2 extends AppCompatActivity {
    EditText tittle, location, date, time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        InitiateControllers();


    }
    private void InitiateControllers() {
        tittle = (EditText) findViewById(R.id.inputeventname);
        location = (EditText) findViewById(R.id.inputeventlocation);
        date = (EditText) findViewById(R.id.inputDate);
        time = (EditText)findViewById(R.id.inputtime);

    }

    public void AddEvent (View view){

        try {
            Eventos newEvent = new Eventos(
                    R.drawable.ic_launcher_background,
                    tittle.getText().toString(),
                    location.getText().toString(),
                    date.getText().toString(),
                    time.getText().toString()
            );
            Intent i = new Intent(getApplicationContext(),partyselector_Activity.class);
            i.putExtras(newEvent.EventsToBundle());
            startActivity(i);
        }catch(Exception e){

        }
    }

}