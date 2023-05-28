package com.example.parkingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.parkingapp.Models.Eventos;
import com.example.parkingapp.eventosadapter.EventosAdapter;

import java.util.ArrayList;
import java.util.List;

public class partyselector_Activity extends AppCompatActivity
{

    EventosAdapter ComplexAdapter;
    ListView lsteventos;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.partyselector);

        lsteventos = (ListView)findViewById(R.id.lsteventos);

        //complex Adapter

        Bundle b = getIntent().getExtras();
        if (b!=null){
            Eventos evento = new Eventos().restoreBundle(b);
            List<Eventos> eventos = LlenarListViewCompuesto();
            eventos.add(evento);
            ComplexAdapter = new EventosAdapter(
                    getApplicationContext(),
                    LlenarListViewCompuesto()
            );
            lsteventos.setAdapter(ComplexAdapter);
        }
        else{
            ComplexAdapter = new EventosAdapter(
                    getApplicationContext(),
                    LlenarListViewCompuesto()
            );
        }
        lsteventos.setAdapter(ComplexAdapter);
    }

    private List<Eventos> LlenarListViewCompuesto(){
        List<Eventos> eventos = new ArrayList<Eventos>();
        eventos.add(new Eventos(R.drawable.unsplash2,"Demencia Demenciosa","Alla onde Sara","oct 10"));
        eventos.add(new Eventos(R.drawable.unsplashart1, "Domingo de sexo", "ChuckECheese", "June 2"));
        eventos.add(new Eventos(R.drawable.samanthaunsplash, "Fiesta de viejo", "Samaria sector 7", "June 6"));
        eventos.add(new Eventos(R.drawable.aleksandrunsplash, "Ya no se que poner", "casa de bi+", "Jan 23"));

        return eventos;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }


}