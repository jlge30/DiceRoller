package com.jose.diceroller;

import android.app.Application;

public class GlobalVariables extends Application{
    public String nombre;

    public int puntuacion;

    public  String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getPuntuacion(){
        return puntuacion;
    }
    public void setPuntuacion(int puntuacion){
        this.puntuacion = puntuacion;
    }
}
