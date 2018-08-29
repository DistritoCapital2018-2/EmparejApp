package sena.edu.co.emparejapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Se crea el hilo para que se ejecute la aplicación en determinado tiempo.
        Thread hilo = new Thread(){
            //Traigo el metodo run y ejecuto el código en un try catch para que me capture el error en caso de
            // que el splash se cierre inesperadamente.
            public void run(){
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //startActivity(new Intent(this, MainActivity.class));
                finish();
            }
        };
        hilo.start();
    }
}
