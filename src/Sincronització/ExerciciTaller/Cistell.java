package Sincronització.ExerciciTaller;

public class Cistell {
    private int cos;
    private boolean pleCos;
    private int maniga;
    private boolean pleManiga;
    private boolean agafat;


    public Cistell(){
        cos = 0;
        pleCos = false;
        maniga = 0;
        pleManiga = false;

    }

    public int getCos() {
        return cos;
    }

    public synchronized void addCos() throws InterruptedException {
        if (pleCos || agafat) wait();
        cos++;
        if (cos==5) {
            pleCos=true;
        }
        notifyAll();
    }

    public synchronized void treureCos() throws InterruptedException {
        if (cos < 1) wait();
        agafat = true;
        if (pleCos) {
            pleCos = false;
        }
        cos--;
        notifyAll();
    }

    public int getManiga() {
        return maniga;
    }

    public synchronized void addManiga() throws InterruptedException {
        if (pleManiga || agafat) wait();
        maniga++;
        if (maniga == 8) {
            pleManiga = true;
        }
        notifyAll();

    }

    public synchronized void treureManiga() throws InterruptedException {
        if (maniga < 2) wait();
        agafat = true;
        if (pleManiga) {
            pleManiga = false;
        }
        if (maniga >= 2) maniga -= 2;
        notifyAll();
    }

    public synchronized void deixarCistell(){
        agafat = false;
        notifyAll();
    }
}
