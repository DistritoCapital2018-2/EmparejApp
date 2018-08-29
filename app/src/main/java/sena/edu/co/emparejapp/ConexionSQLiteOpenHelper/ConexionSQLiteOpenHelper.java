package sena.edu.co.emparejapp.ConexionSQLiteOpenHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import sena.edu.co.emparejapp.Tabla.Tabla;

public class ConexionSQLiteOpenHelper extends SQLiteOpenHelper {

    public ConexionSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Tabla.CREAR_TABLA_PLAYER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Tabla.TABLA_PLAYER);
        onCreate(db);
    }
}
