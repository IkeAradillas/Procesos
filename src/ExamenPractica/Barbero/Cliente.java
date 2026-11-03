package ExamenPractica.Barbero;

public class Cliente extends Thread {

    Barberia b;

    public Cliente(Barberia b) {
        this.b = b;
    }

    @Override
    public void run() {

        try {
            Thread.sleep((int) (Math.random() * 3000) + 500);

            b.llegaCliente();

        } catch (InterruptedException e) {
            return;
        }
    }
}
