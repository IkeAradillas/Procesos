package Sincronització.ExerciciGaletes;

public class Fill extends Thread {
    String nom;
    PotGaletes p;

    public Fill(String nom, PotGaletes p) {
        this.nom = nom;
        this.p=p;
    }

    @Override
    public void run(){
        while (true){
            try {
                p.agafaGaleta();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(nom + " esta mentjant la galeta");
            try {
                Thread.sleep((int) (Math.random() * 400) + 100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            p.deixarPot();

            try {
                Thread.sleep((int) (Math.random() * 600) + 100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
