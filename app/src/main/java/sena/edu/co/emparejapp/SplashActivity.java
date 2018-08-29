package sena.edu.co.emparejapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    //Instancio las imagenes y la animación.
    ImageView logoEmpareja, logoWs;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Asigno las instancias con el xml.
        logoEmpareja = findViewById(R.id.imgLogoS);
        logoWs = findViewById(R.id.imgWsS);

        //Traigo la clase de AnimationUtils y le asigno la animación a las imagenes.
        animation = AnimationUtils.loadAnimation(this, R.anim.splash_anim);
        logoEmpareja.setAnimation(animation);
        logoWs.setAnimation(animation);
        


        //Se crea el hilo para que se ejecute la aplicación en determinado tiempo.
        Thread hilo = new Thread(){
            //Traigo el metodo run y ejecuto el código en un try catch para que me capture el error en caso de
            // que el splash se cierre inesperadamente.
            public void run(){
                try {
                    //Coloco el tiempo de duración
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //Creo una intención para que cuando termine el splash me mande al xml de registro.
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
                //Finalizo el splash cuando se termine el tiempo.
                finish();
            }
        };
        //Ejecuto el hilo.
        hilo.start();

    }
}
