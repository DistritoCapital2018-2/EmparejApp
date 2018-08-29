package sena.edu.co.emparejapp.InitialViews;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import sena.edu.co.emparejapp.ConexionSQLiteOpenHelper.ConexionSQLiteOpenHelper;
import sena.edu.co.emparejapp.R;
import sena.edu.co.emparejapp.Tabla.Tabla;

public class RegisterActivity extends AppCompatActivity {

    //Instancio los componentes
    ImageView imgWsR;
    TextView textoBienvenida;
    Button btnRegistrar;
    EditText etUsuario;
    //Instancio la conexión ConexionSQLiteOpenHelper llamada conexion.
    ConexionSQLiteOpenHelper conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        imgWsR = findViewById(R.id.imgWsR);
        textoBienvenida = findViewById(R.id.etBienvenidaR);
        btnRegistrar = findViewById(R.id.btnRegistrarR);
        etUsuario = findViewById(R.id.etBienvenidaR);

        //Creo la conexion.
        conexion = new ConexionSQLiteOpenHelper(this, Tabla.TABLA_PLAYER, null ,1);

    }

    //Al presionar el boton de registro, me hace el insert hacia la base de datos.
    public void onClick(View view) {

        switch (view.getId() ){

            case R.id.btnRegistrarR:
                registrarUsuario();
                break;

        }



    }

    private void registrarUsuario() {
        if(etUsuario.getText().toString().isEmpty()){
            Toast.makeText(this, "Ingresa un nickname", Toast.LENGTH_LONG);

        }else if (!etUsuario.getText().toString().isEmpty()){
            SQLiteDatabase db = conexion.getReadableDatabase();
            db.rawQuery("INSERT INTO "+Tabla.TABLA_PLAYER+" ("+Tabla.CAMPO_NICKNAME+") VALUES ("+etUsuario.getText().toString()+")",null);


            db.close();
        }

    }

}
