package ExamenPractica.Canibales;

public class Bote {

    int misioneros = 0;
    int canibales = 0;

    int terminados = 0;
    boolean lleno = false;

    public synchronized void llegaMisionero() throws InterruptedException {

        while (lleno) {
            wait();
        }

        misioneros++;

        comprobarBote();

        while (!lleno) {
            wait();
        }

        terminarViaje();
    }

    public synchronized void llegaCanibal() throws InterruptedException {

        while (lleno) {
            wait();
        }

        canibales++;

        comprobarBote();

        while (!lleno) {
            wait();
        }

        terminarViaje();
    }

    private void comprobarBote() {

        if (misioneros + canibales == 3 &&
                !(misioneros == 2 && canibales == 1)) {

            lleno = true;

            System.out.println("Sale el bote con "
                    + misioneros + " misioneros y "
                    + canibales + " canibales.");

            notifyAll();
        }
    }

    private void terminarViaje() {

        terminados++;

        if (terminados == 3) {

            misioneros = 0;
            canibales = 0;
            terminados = 0;

            lleno = false;

            notifyAll();
        }
    }
}
