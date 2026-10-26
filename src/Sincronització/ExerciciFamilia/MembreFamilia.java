package Sincronització.ExerciciFamilia;

public class MembreFamilia extends Thread{
    String nom;
    Comandament com;

    public MembreFamilia(String nom, Comandament com) {
        this.nom = nom;
        this.com=com;
    }


    @Override
    public void run(){
        while (true){
            try {
                com.agafar();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(nom + " esta mirant la tele");
            try {
                Thread.sleep((int) (Math.random() * 400) + 100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            com.deixar();

            try {
                Thread.sleep((int) (Math.random() * 600) + 100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
