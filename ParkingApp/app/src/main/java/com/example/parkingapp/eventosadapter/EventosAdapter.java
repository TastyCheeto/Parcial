package com.example.parkingapp.eventosadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.parkingapp.Models.Eventos;
import com.example.parkingapp.R;

import org.w3c.dom.Text;

import java.util.List;

public class EventosAdapter extends ArrayAdapter<Eventos> {
    List<Eventos> opciones;
    public EventosAdapter (Context context, List<Eventos>datos){
        super(context, R.layout.listview_eventos,datos);

        opciones = datos;
    }
    public View getView(int position, View converView, ViewGroup parent ){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_eventos, null);

        ImageView foto = (ImageView) item.findViewById(R.id.cardimage);
        foto.setImageResource(opciones.get(position).getImage());

        TextView titulo = (TextView) item.findViewById(R.id.cardtittle);
        titulo.setText(opciones.get(position).getTittle());

        TextView lugar = (TextView) item.findViewById(R.id.cardlocation);
        lugar.setText(opciones.get(position).getLocation());

        //TextView descripcion = (TextView) item.findViewById(R.id.desc);
        //titulo.setText(opciones.get(position).getTittle());

        TextView fecha = (TextView) item.findViewById(R.id.carddate);
        fecha.setText(opciones.get(position).getDate());

        return item;

    }
}
