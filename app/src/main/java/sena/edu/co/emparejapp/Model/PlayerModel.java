package sena.edu.co.emparejapp.Model;

public class PlayerModel {

    private int idPlayer;
    private String nicknamePlayer;
    private String tiempo;
    private int puntaje;

    public PlayerModel() {
    }

    public PlayerModel(int idPlayer, String nicknamePlayer, String tiempo, int puntaje) {
        this.idPlayer = idPlayer;
        this.nicknamePlayer = nicknamePlayer;
        this.tiempo = tiempo;
        this.puntaje = puntaje;
    }

    public int getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getNicknamePlayer() {
        return nicknamePlayer;
    }

    public void setNicknamePlayer(String nicknamePlayer) {
        this.nicknamePlayer = nicknamePlayer;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
