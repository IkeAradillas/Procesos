package Sincronització.ExerciciTaller;

public class CistellaCos {
    private int cos;
    boolean ple;

    public CistellaCos(){
        cos = 0;
        ple = false;
    }

    public int getCos() {
        return cos;
    }

    public synchronized void addCos() throws InterruptedException {
        if (ple) wait();
        cos++;
        if (cos==5) {
            ple=true;
            notifyAll();
        }
    }

    public synchronized void treureCos() throws InterruptedException {
        if (cos<1) wait();
        if (ple) {
            ple = false;
            notifyAll();
        }
        cos--;
    }


}
