package ExamenPractica.Baños.Iker;

public class Baño {
    int cantidadMax = 0;
    boolean hombres;
    int cantidad;

    public Baño(int cantidadMax, boolean hombres){
        this.cantidadMax = cantidadMax;
        this.hombres = hombres;
    }

    public synchronized void entrarPersona(boolean hombres) throws InterruptedException {
        while (cantidad>= cantidadMax || (hombres != this.hombres)) wait();
        cantidad++;
        notifyAll();
    }

    public synchronized void salirPersona() throws InterruptedException {
        cantidad--;
        if (cantidad==0) hombres = !hombres;
        notifyAll();
    }

}
