package Sincronització.ExerciciTaller;

public class CistellaManigues {
    private int maniga;
    private boolean ple;

    public CistellaManigues(){
        maniga = 0;
        ple = false;
    }

    public int getManiga() {
        return maniga;
    }

    public synchronized void addManiga() throws InterruptedException {
        while (true) {
            if (ple) wait();
            maniga++;
            if (maniga == 8) {
                ple = true;
            }
            notifyAll();
        }
    }

    public synchronized void treureManiga() throws InterruptedException {
        while(true) {
            if (maniga < 2) wait();
            if (ple) {
                ple = true;
            }
            maniga--;
            notifyAll();
        }
    }
}
