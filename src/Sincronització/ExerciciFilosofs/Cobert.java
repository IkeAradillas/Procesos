package Sincronització.ExerciciFilosofs;

public class Cobert {
    boolean lliure;

    public Cobert(){
        lliure=true;
    }

    public synchronized void agafar() throws InterruptedException {
        while (!lliure) wait();

        // SendWait / SendSignal



        lliure=false;
        notifyAll();

    }

    public synchronized void deixar(){
        lliure = true;
        notifyAll();
    }
}
