package Jugador;

public class Jugador {
    private String nom;
    private int punts;

    public Jugador (String nom){
        this.nom=nom;
    }

    public String getNom() {
        return nom;
    }

    public int getPunts() {
        return punts;
    }

    public void setPunts(int punts) {
        this.punts = punts;
    }
}
