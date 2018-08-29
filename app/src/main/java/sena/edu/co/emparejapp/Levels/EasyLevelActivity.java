package sena.edu.co.emparejapp.Levels;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import sena.edu.co.emparejapp.R;

public class EasyLevelActivity extends AppCompatActivity implements View.OnClickListener{

    // ------------------ Variables Logicas para el Juego ------------------

    int[] imagenes = new int[]{R.drawable.jimmy, R.drawable.kyle, R.drawable.kenny,R.drawable.stan};
    int[] juego_terminado = new int[8];
    int[] juego = new int[8];
    int[] cartas_seleccionadas = new int[2];
    int[] imagenes_seleccionadas = new int[2];
    int ganardor = 0;
    int turno = 0;

    TextView tvEstadoEL, tvDificultadEL, tvPlayer1EL,tvPuntosPlayer1EL, tvPlayer2EL, tvPuntosPlayer2EL;
    Button btnBuscarOponente;
    ImageButton imbOfflineEL;
    ImageButton imbCarta1EL, imbCarta2EL, imbCarta3EL, imbCarta4EL, imbCarta5EL, imbCarta6EL, imbCarta7EL, imbCarta8EL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_level);

        tvEstadoEL = findViewById(R.id.tvEstadoEL);
        tvDificultadEL = findViewById(R.id.tvDificultadEL);
        tvPlayer1EL = findViewById(R.id.tvPlayer1EL);
        tvPuntosPlayer1EL = findViewById(R.id.tvPuntosPlayer1EL);
        tvPlayer2EL = findViewById(R.id.tvPlayer2EL);
        tvPuntosPlayer2EL = findViewById(R.id.tvPuntosPlayer2EL);

        imbCarta1EL = findViewById(R.id.imbCarta1EL);
        imbCarta2EL = findViewById(R.id.imbCarta2EL);
        imbCarta3EL = findViewById(R.id.imbCarta3EL);
        imbCarta4EL = findViewById(R.id.imbCarta4EL);
        imbCarta5EL = findViewById(R.id.imbCarta5EL);
        imbCarta6EL = findViewById(R.id.imbCarta6EL);
        imbCarta7EL = findViewById(R.id.imbCarta7EL);
        imbCarta8EL = findViewById(R.id.imbCarta8EL);

        imbOfflineEL = findViewById(R.id.imbOfflineEL);
        btnBuscarOponente = findViewById(R.id.btnBuscarOponente);

        imbCarta1EL.setOnClickListener(this);
        imbCarta2EL.setOnClickListener(this);
        imbCarta3EL.setOnClickListener(this);
        imbCarta4EL.setOnClickListener(this);
        imbCarta5EL.setOnClickListener(this);
        imbCarta6EL.setOnClickListener(this);
        imbCarta7EL.setOnClickListener(this);
        imbCarta8EL.setOnClickListener(this);
        imbOfflineEL.setOnClickListener(this);
        btnBuscarOponente.setOnClickListener(this);

        asignarModoInicial();


        if (savedInstanceState == null)
        {
            asignarImagenes();
            for (int i = 0; i < 8; i++)
                juego_terminado[i] = 0;

            cartas_seleccionadas[0]=8;
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnBuscarOponente:

                break;
            case R.id.imbOfflineEL:
                modoGaming();
                break;
            case R.id.imbCarta1EL:
                imbCarta1EL.setImageResource(juego[0]);
                imagenes_seleccionadas[turno] = juego[0];
                cartas_seleccionadas[turno] = 0;
                imbCarta1EL.setEnabled(false);
                break;
            case R.id.imbCarta2EL:
                imbCarta2EL.setImageResource(juego[1]);
                imagenes_seleccionadas[turno] = juego[1];
                cartas_seleccionadas[turno] = 1;
                imbCarta2EL.setEnabled(false);
                break;
            case R.id.imbCarta3EL:
                imbCarta3EL.setImageResource(juego[2]);
                imagenes_seleccionadas[turno] = juego[2];
                cartas_seleccionadas[turno] = 2;
                imbCarta3EL.setEnabled(false);
                break;
            case R.id.imbCarta4EL:
                imbCarta4EL.setImageResource(juego[3]);
                imagenes_seleccionadas[turno] = juego[3];
                cartas_seleccionadas[turno] = 3;
                imbCarta4EL.setEnabled(false);
                break;
            case R.id.imbCarta5EL:
                imbCarta5EL.setImageResource(juego[4]);
                imagenes_seleccionadas[turno] = juego[4];
                cartas_seleccionadas[turno] = 4;
                imbCarta5EL.setEnabled(false);
                break;
            case R.id.imbCarta6EL:
                imbCarta6EL.setImageResource(juego[5]);
                imagenes_seleccionadas[turno] = juego[5];
                cartas_seleccionadas[turno] = 5;
                imbCarta6EL.setEnabled(false);
                break;
            case R.id.imbCarta7EL:
                imbCarta7EL.setImageResource(juego[6]);
                imagenes_seleccionadas[turno] = juego[6];
                cartas_seleccionadas[turno] = 6;
                imbCarta7EL.setEnabled(false);
                break;
            case R.id.imbCarta8EL:
                imbCarta8EL.setImageResource(juego[7]);
                imagenes_seleccionadas[turno] = juego[7];
                cartas_seleccionadas[turno] = 7;
                imbCarta8EL.setEnabled(false);
                break;
        }

        if (turno == 0) {

            turno = 1;
        } else {
            new Hilo().execute();
            turno = 1;
        }
    }

    // ----- Metodo que Estable los Elementos deshabilitados para cuando se inicia o reinicia el Nivel -----------

    private void asignarModoInicial() {
        imbCarta1EL.setEnabled(false);
        imbCarta2EL.setEnabled(false);
        imbCarta3EL.setEnabled(false);
        imbCarta4EL.setEnabled(false);
        imbCarta5EL.setEnabled(false);
        imbCarta6EL.setEnabled(false);
        imbCarta7EL.setEnabled(false);
        imbCarta8EL.setEnabled(false);

        // Todo: faltan reiniciar lo TextView

    }

    // --------------- Metodo que asignar las Imagenes de forma Aleatoria --------------------
    private void asignarImagenes() {
        int posicion, contador = 0;

        for (int i= 0; i < 4;)
        {
            posicion = (int) (Math.random()*8);
            if (juego[posicion]==0)
            {
                juego[posicion] = imagenes[i];
                contador++;
                if (contador==2)
                {
                    contador = 0;
                    i++;
                }
            }
        }

    }

    // ----------------------------------- Modos (Estados) -----------------------------------


    // --------------- Metodo que habilita las cartas para poder Jugar --------------------

    private void modoGaming() {
        imbCarta1EL.setEnabled(true);
        imbCarta2EL.setEnabled(true);
        imbCarta3EL.setEnabled(true);
        imbCarta4EL.setEnabled(true);
        imbCarta5EL.setEnabled(true);
        imbCarta6EL.setEnabled(true);
        imbCarta7EL.setEnabled(true);
        imbCarta8EL.setEnabled(true);
    }


    private void asignarModoGanador() {
        Toast.makeText(this, "Felicidades has Ganado", Toast.LENGTH_SHORT).show();
    }

    // ----------------------------------- Fin Modos (Estados) -----------------------------------


    class Hilo extends AsyncTask<Void,Integer,Void>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            imbCarta1EL.setEnabled(false);
            imbCarta2EL.setEnabled(false);
            imbCarta3EL.setEnabled(false);
            imbCarta4EL.setEnabled(false);
            imbCarta5EL.setEnabled(false);
            imbCarta6EL.setEnabled(false);
            imbCarta7EL.setEnabled(false);
            imbCarta8EL.setEnabled(false);

        }


        @Override
        protected Void doInBackground(Void... voids) {
            Thread timer = new Thread(){
              public void run(){
                  try {
                      sleep(1000);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }
            };
            timer.start();

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if (imagenes_seleccionadas[0] == imagenes_seleccionadas[1])
            {
                juego_terminado[cartas_seleccionadas[0]] = 1;
                juego_terminado[cartas_seleccionadas[1]] = 1;
                ganardor++;

                if (ganardor==4)
                {
                    asignarModoGanador();
                }
            }

            if (juego_terminado[0] == 0)
            {
                imbCarta1EL.setImageResource(R.drawable.cartel);
                imbCarta1EL.setEnabled(true);
            }

            if (juego_terminado[1] == 0)
            {
                imbCarta2EL.setImageResource(R.drawable.cartel);
                imbCarta2EL.setEnabled(true);
            }

            if (juego_terminado[2] == 0)
            {
                imbCarta3EL.setImageResource(R.drawable.cartel);
                imbCarta3EL.setEnabled(true);
            }

            if (juego_terminado[3] == 0)
            {
                imbCarta4EL.setImageResource(R.drawable.cartel);
                imbCarta4EL.setEnabled(true);
            }

            if (juego_terminado[4] == 0)
            {
                imbCarta5EL.setImageResource(R.drawable.cartel);
                imbCarta5EL.setEnabled(true);
            }

            if (juego_terminado[5] == 0)
            {
                imbCarta6EL.setImageResource(R.drawable.cartel);
                imbCarta6EL.setEnabled(true);
            }

            if (juego_terminado[6] == 0)
            {
                imbCarta7EL.setImageResource(R.drawable.cartel);
                imbCarta7EL.setEnabled(true);
            }

            if (juego_terminado[7] == 0)
            {
                imbCarta8EL.setImageResource(R.drawable.cartel);
                imbCarta8EL.setEnabled(true);
            }
        }
    }


}