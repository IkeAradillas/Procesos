package ExamenPractica.RadiadoAtomico;

public class Productor extends Thread {

    Buffer b;

    public Productor(Buffer b) {
        this.b = b;
    }

    @Override
    public void run() {

        int contador = 1;

        while (true) {

            try {

                Thread.sleep((int) (Math.random() * 2000) + 500);

                b.producir("Elemento " + contador);

                contador++;

            } catch (InterruptedException e) {
                return;
            }
        }
    }
}



