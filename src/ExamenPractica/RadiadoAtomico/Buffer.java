package ExamenPractica.RadiadoAtomico;
import java.util.ArrayList;

public class Buffer {

    ArrayList<Elemento> elementos = new ArrayList<>();

    int capacidad;
    int numConsumidores;

    long primeraSecuencia = 0;
    long siguienteSecuencia = 0;

    public Buffer(int capacidad, int numConsumidores) {
        this.capacidad = capacidad;
        this.numConsumidores = numConsumidores;
    }

    public synchronized void producir(String dato) throws InterruptedException {

        while (elementos.size() >= capacidad) {
            wait();
        }

        elementos.add(new Elemento(dato));

        siguienteSecuencia++;

        System.out.println("Producido: " + dato);

        notifyAll();
    }

    public synchronized String consumir(int id, long posicion) throws InterruptedException {

        while (posicion >= siguienteSecuencia) {
            wait();
        }

        int indice = (int) (posicion - primeraSecuencia);

        Elemento e = elementos.get(indice);

        e.leidos++;

        System.out.println("Consumidor " + id + " lee: " + e.dato);

        // Si todos han leído este elemento,
        // podemos eliminar los elementos ya leídos por todos.
        while (!elementos.isEmpty() &&
                elementos.get(0).leidos == numConsumidores) {

            elementos.remove(0);
            primeraSecuencia++;
        }

        notifyAll();

        return e.dato;
    }
}