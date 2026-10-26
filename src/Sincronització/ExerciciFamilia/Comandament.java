package Sincronització.ExerciciFamilia;

public class Comandament {
    private boolean lliure;

    public Comandament() {
        lliure = true;
    }

    public synchronized void agafar() throws InterruptedException {
        while (!lliure) wait();

        lliure=false;
        notifyAll();

    }

    public synchronized void deixar(){
        lliure = true;
        notifyAll();
    }
}