package com.example.parkingapp.Models;

import android.os.Bundle;

import com.example.parkingapp.R;

public class Eventos {

    private int Image;
    private String Tittle;
    private String Location;
    private String Description;
    private String Date;

    private String Time;

   public Eventos(){
   }
    public Eventos(int f, String tittle, String location, String date, String time){ //String description
        Image = f;
        Tittle = tittle;
        Location = location;
        //Description = description;
        Date = date;
        Time = time;
    }
    public int getImage(){
        return Image;
    }
    public void setImage(int Image){
        this.Image =Image;
    }

    public String getTittle() {
        return Tittle;
    }

    public void setTittle(String tittle) {
        Tittle = tittle;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    /*public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }*/

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public Bundle EventsToBundle(){
        Bundle b = new Bundle();
        b.putString("tittle",this.getTittle());
        b.putString("location",this.getLocation());
        //b.putString("description",this.getDescription());
        b.putString("date",this.getDate());
        b.putString("time",this.getTime());
        return b;
    }

    public Eventos restoreBundle(Bundle b){
        return new Eventos(
                R.drawable.ic_launcher_background,
                b.getString("tittle"),
                b.getString("location"),
                //b.getString("description"),
                b.getString("date"),
                b.getString("time")
        );
    }

}
