package ExamenPractica.PuenteEstrecho.IA;

public class Puente {

    int cantidad = 0;
    boolean izq;

    int esperandoIzq = 0;
    int esperandoDer = 0;

    public Puente(String lado) {
        izq = lado.equals("izq");
    }

    public synchronized void sumarVehiculo(String lado) throws InterruptedException {

        if (lado.equals("izq")) {
            esperandoIzq++;
        } else {
            esperandoDer++;
        }

        while (cantidad == 3 || (cantidad > 0 && ((lado.equals("izq") && !izq) || (lado.equals("der") && izq)))) wait();


        if (cantidad == 0) {
            izq = lado.equals("izq");
        }

        if (lado.equals("izq")) {
            esperandoIzq--;
        } else {
            esperandoDer--;
        }

        cantidad++;

        notifyAll();
    }

    public synchronized void quitarVehiculo() {

        cantidad--;

        if (cantidad == 0) {
            if (izq && esperandoDer > 0) {
                izq = false;
            } else if (!izq && esperandoIzq > 0) {
                izq = true;
            }
        }

        notifyAll();
    }
}