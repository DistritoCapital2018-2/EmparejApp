package sena.edu.co.emparejapp.Tabla;

public class Tabla {

    public static final String TABLA_PLAYER = "player";
    public static final String CAMPO_ID = "id_player";
    public static final String CAMPO_NICKNAME = "nickname_player";
    public static final String CAMPO_TIEMPO = "tiempo_player";
    public static final String CAMPO_PUNTAJE = "puntaje_player";


    public static final String CREAR_TABLA_PLAYER = "CREATE TABLE "+TABLA_PLAYER+" ("+CAMPO_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_NICKNAME+" TEXT,"
            +CAMPO_TIEMPO+" TEXT, "+CAMPO_PUNTAJE+" INTEGER);";
}
