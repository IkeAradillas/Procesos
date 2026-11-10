package T1.ExamenPractica.Canibales;

public class Persona extends Thread {

    boolean misionero;
    Bote b;

    public Persona(boolean misionero, Bote b) {
        this.misionero = misionero;
        this.b = b;
    }

    @Override
    public void run() {

        try {

            if (misionero) {
                b.llegaMisionero();
            } else {
                b.llegaCanibal();
            }

        } catch (InterruptedException e) {
            return;
        }
    }
}


