package com.jose.diceroller;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
//    private TextView resultado1;
//    private TextView resultado2;
    /*
    Atributos para generar un numero aleatorio
     */
    private Random random1 = new Random();
    private Random random2 = new Random();
    private TextView txtMensaje;

    private TextView txtPuntuacion;
    private TextView txtTiradas;
    private int puntuacion = 10;
    private GlobalVariables datos;

    private Handler handler;//atributo para retrasar la aparción de los mensajes



    //GlobalVariables puntuacion1 = (GlobalVariables) getApplicationContext();//variable global

    private int tiradas = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //setTheme(R.style.SplashTeme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtTiradas = findViewById(R.id.txtTiradas);
        String mensaje = "Tiradas Pendientes: " + String.valueOf(tiradas);
        txtTiradas.setText(mensaje);
        txtPuntuacion = findViewById(R.id.txt_puntuacion);
        String puntos = "X " + String.valueOf(puntuacion);
        txtPuntuacion.setText(puntos);//mensaje de número de tiradas


    }

    /**
     * función para lanzar el dado
     * @param view
     */
    public void lanzar(View view) {
        /*
        llamamos a la variables globales
         */
        datos = (GlobalVariables) getApplicationContext();//instanciamos la variable global
        //Toast.makeText(this, R.string.lanzar, Toast.LENGTH_SHORT).show();
//        resultado1 = findViewById(R.id.txt1);
//        resultado2 = findViewById(R.id.txt2);
        /*
        Imagenes iniciales que creamos para alojar los dados
         */
        ImageView diceImage = findViewById(R.id.image_dado1);
        ImageView diceImage2 = findViewById(R.id.image_dado2);
        ImageView coin = findViewById(R.id.imageView3);
        girar(diceImage);//llamamos a la función para que giren los dados
        girar(diceImage2);//llamamos a la función para que giren los dados
        girar(coin);


        tiradas --; // iniciamos el número de tiradas

        String mensaje = "Tiradas Pendientes: " + String.valueOf(tiradas);
        txtTiradas.setText(mensaje);//mensaje de número de tiradas

        int numero1 = random1.nextInt(6) + 1; //numero generado entre 6 y 1
//        resultado1.setText(Integer.toString(numero1)); //asigno el resultado al texto y lo transformo en string
        int numero2 = random2.nextInt(6) + 1; //numero generado entre 6 y 1

//        resultado2.setText(Integer.toString(numero2)); //asigno el resultado al texto y lo transformo en string
        txtMensaje = findViewById(R.id.txt_mensaje);//ventana del mensaje de ganar o perder
        //condicionales para que aparezcan los mensajes de gando o perdido monedas
        if ((numero1 + numero2) >= 6 ){//
            txtMensaje.setVisibility(View.INVISIBLE);
            txtMensaje.setTextColor(getColor(R.color.green));
            txtMensaje.setText(R.string.ganado);
            handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    txtMensaje.setVisibility(View.VISIBLE); // Hacer visible el TextView después de medio segundo
                }
            }, 500); // // medio segundo de retraso
            puntuacion++;

            if ((numero1 + numero2) == 12){
                txtMensaje.setVisibility(View.INVISIBLE);
                txtMensaje.setTextColor(getColor(R.color.green));
                txtMensaje.setText(R.string.ganado2);
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        txtMensaje.setVisibility(View.VISIBLE); // Hacer visible el TextView después de medio segundo
                    }
                }, 500); // medio segundo de retraso
                puntuacion++;
            }
        }else{
            txtMensaje.setVisibility(View.INVISIBLE);
            txtMensaje.setTextColor(getColor(R.color.red));
            txtMensaje.setText(R.string.perdido);
            handler = new Handler();//hacer que el mensaje salga con retraso
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    txtMensaje.setVisibility(View.VISIBLE); // Hacer visible el TextView después de medio segundo
                }
            }, 500); // medio segundo de retraso
            puntuacion--;
        }
        /*
        Actualizamo el numero de monedas de la variable global
         */
        datos.setPuntuacion(puntuacion);
        String puntos = "X " + String.valueOf(datos.getPuntuacion());
        txtPuntuacion.setText(puntos);//mensaje de número de monedas

        if (tiradas ==0 ){
            finish();//cerramos la primera vista
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);

            //agregar el cambio de pantalla
            //finish();
        }



        /*
        condicionales para que aparezcan la imagen del dado 1 en función del resultado del numero 1

         */
        if (numero1 == 1) {
            diceImage.setImageResource(R.drawable.dice_1);
        } else if (numero1 == 2) {
            diceImage.setImageResource(R.drawable.dice_2);

        } else if (numero1 == 3) {
            diceImage.setImageResource(R.drawable.dice_3);
        }else if (numero1 == 4) {
            diceImage.setImageResource(R.drawable.dice_4);
        }else if (numero1 == 5) {
            diceImage.setImageResource(R.drawable.dice_5);
        }else if (numero1 == 6) {
            diceImage.setImageResource(R.drawable.dice_6);
        }

         /*
        condicionales para que aparezcan la imagen del dado  en función del resultado del numero 2

         */
        if (numero2 == 1) {
            diceImage2.setImageResource(R.drawable.dice_1);
        } else if (numero2 == 2) {
            diceImage2.setImageResource(R.drawable.dice_2);

        } else if (numero2 == 3) {
            diceImage2.setImageResource(R.drawable.dice_3);
        }else if (numero1 == 4) {
            diceImage2.setImageResource(R.drawable.dice_4);
        }else if (numero2 == 5) {
            diceImage2.setImageResource(R.drawable.dice_5);
        }else if (numero2 == 6) {
            diceImage2.setImageResource(R.drawable.dice_6);
        }

    }

    /**
     * función que gira las imagenes
     * @param view
     */
    private void girar(View view){
        RotateAnimation animation = new RotateAnimation(0, 360, RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(500);
        view.startAnimation(animation);
    }





}