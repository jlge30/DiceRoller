package com.jose.diceroller;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private TextView textView;
    private EditText editText;

    private TextView txtNombre;
    private GlobalVariables datos;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        datos = (GlobalVariables) getApplicationContext();//instanciamos la variable global
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.txt_puntos);//localizamos el txt de los puntos
        editText = findViewById(R.id.edit_nombre);//localizamos el Edit text del nombre introducio

        String puntos = "Monedas ganadas: " + String.valueOf(datos.getPuntuacion());//mostramos el valor de la puntuación global
        textView.setText(puntos);//mensaje de número de monedas


    }

}