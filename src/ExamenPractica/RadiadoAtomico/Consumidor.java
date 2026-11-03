package ExamenPractica.RadiadoAtomico;

public class Consumidor extends Thread {

    Buffer b;
    int id;
    int posicion = 0;

    public Consumidor(int id, Buffer b) {
        this.id = id;
        this.b = b;
    }

    @Override
    public void run() {

        while (true) {

            try {

                String dato = b.consumir(id, posicion);

                posicion++;

            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
