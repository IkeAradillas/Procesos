package Sincronització.ExerciciFilosofs;

public class Filosof extends Thread{
    String nom;
    Cobert izq;
    Cobert der;

    public Filosof(String nom, Cobert izq, Cobert der){
        this.nom = nom;
        this.izq = izq;
        this.der = der;
    }

    @Override
    public void run(){
        while (true) {
            try {
                izq.agafar();
                System.out.println(nom + " ha agafat el primer");
                Thread.sleep(1000);
                der.agafar();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(nom + " esta mentjant");
            try {
                Thread.sleep((int) (Math.random() * 100) + 50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            izq.deixar();
            der.deixar();

            try {
                Thread.sleep((int) (Math.random() * 500) + 100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
