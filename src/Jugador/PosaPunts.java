package Jugador;

public class PosaPunts implements Runnable {
    private Jugador j;

    public void setJ(Jugador j) {
        this.j = j;
    }

    @Override
    public void run() {
        int punts = (int) (Math.random()*50);
        j.setPunts(j.getPunts() + punts);
        System.out.println(j.getNom() + " ha obtingut " + punts + " punts");
    }
}
