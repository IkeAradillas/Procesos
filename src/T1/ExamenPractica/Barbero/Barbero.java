package T1.ExamenPractica.Barbero;

public class Barbero extends Thread {

    Barberia b;

    public Barbero(Barberia b) {
        this.b = b;
    }

    @Override
    public void run() {

        while (true) {

            try {
                b.esperarCliente();

                b.cortarPelo();

            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
