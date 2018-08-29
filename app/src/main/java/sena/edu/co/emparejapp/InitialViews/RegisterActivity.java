package sena.edu.co.emparejapp.InitialViews;

import android.content.ContentValues;
import android.database.Cursor;
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

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

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

        //Instancio los componentes con el xml
        imgWsR = findViewById(R.id.imgWsR);
        textoBienvenida = findViewById(R.id.tvBienvenidaR);
        btnRegistrar = findViewById(R.id.btnRegistrarR);
        etUsuario = findViewById(R.id.etBienvenidaR);

        //Agrego el boton para que me escuche la accion del onClickListener.
        btnRegistrar.setOnClickListener(this);
        //Creo una nueva conexión.
        conexion = new ConexionSQLiteOpenHelper(this, Tabla.TABLA_PLAYER, null, 1);

    }

    //Evento onClick del boton registrar
    @Override
    public void onClick(View v) {
        //Realizo un switch con los id's de las vistas.
        switch (v.getId()) {
            case R.id.btnRegistrarR:
                //En caso de que sea el boton registrar, mando al metodo registrarUsuario.
                registrarUsuario();
                break;
        }
    }

    //Metodo registrar usuario
    private void registrarUsuario() {
        //Si el usuario coloca en el nickname un campo vacio, este le pedira que ingrese nuevamente.
        if (etUsuario.getText().toString().isEmpty()) {
            //Toast con el mensaje
            Toast.makeText(this, "Ingresa un nickname", Toast.LENGTH_LONG).show();

            //En caso de que el usuario agrege un nickname
        } else if (!etUsuario.getText().toString().isEmpty()) {
            //Obtengo la base de datos en modo escritura
            SQLiteDatabase db = conexion.getWritableDatabase();
            //Se agrega un nuevo map de valores.
            ContentValues datos = new ContentValues();
            datos.put(Tabla.CAMPO_NICKNAME,etUsuario.getText().toString());
            long id = db.insert(Tabla.TABLA_PLAYER, null, datos);
            Toast.makeText(getApplicationContext(), "Usuario N#:"+id , Toast.LENGTH_LONG).show();
            db.close();

        }


    }

}
