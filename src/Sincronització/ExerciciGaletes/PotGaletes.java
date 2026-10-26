package Sincronització.ExerciciGaletes;

public class PotGaletes {
    private boolean lliure;
    private boolean ple;
    private int galetes=0;

    public PotGaletes(int galetes) {
        this.lliure = true;
        this.galetes = galetes;
        ple= this.galetes != 0;
    }

    public synchronized void afegeixGaleta() throws InterruptedException {
        while (ple) wait();
        galetes++;
        ple = true;
        notifyAll();
    }

    public synchronized void agafaGaleta() throws InterruptedException {
        while (!lliure && !ple) wait();

        lliure=false;
        galetes--;
        if (galetes==0) ple=false;
        notifyAll();
    }

    public synchronized void deixarPot(){
        lliure=true;
        notifyAll();
    }


}
