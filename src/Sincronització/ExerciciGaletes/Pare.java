package Sincronització.ExerciciGaletes;

public class Pare extends Thread{
    String nom;
    PotGaletes p;

    public Pare(String nom, PotGaletes p) {
        this.nom = nom;
        this.p=p;
    }

    @Override
    public void run() {
        while (true){
            try {
                p.afegeixGaleta();
                System.out.println("El pare esta posant galetes");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
