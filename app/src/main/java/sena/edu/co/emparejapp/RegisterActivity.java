package sena.edu.co.emparejapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    //Instancio los componentes
    ImageView imgWsR;
    TextView textoBienvenida;
    Button btnRegistrar;
    EditText etUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        imgWsR = findViewById(R.id.imgWsR);
        textoBienvenida = findViewById(R.id.etBienvenidaR);
        btnRegistrar = findViewById(R.id.btnRegistrarR);
        etUsuario = findViewById(R.id.etBienvenidaR);


    }
}
