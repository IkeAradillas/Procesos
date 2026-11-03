package ExamenPractica.Barbero;

public class Barberia {

    int sillasMax;
    int clientesEsperando = 0;

    public Barberia(int sillasMax) {
        this.sillasMax = sillasMax;
    }

    public synchronized void esperarCliente() throws InterruptedException {

        // Si no hay clientes, el barbero se duerme
        while (clientesEsperando == 0) {
            System.out.println("El barbero se duerme...");
            wait();
        }

        // Hay un cliente esperando
        clientesEsperando--;

        System.out.println("El barbero empieza a cortar el pelo.");
    }

    public synchronized void llegaCliente() {

        // Si todas las sillas están ocupadas, se marcha
        if (clientesEsperando == sillasMax) {
            System.out.println("Un cliente se marcha porque no hay sillas.");
            return;
        }

        // Se sienta en una silla de espera
        clientesEsperando++;

        System.out.println("Llega un cliente. Clientes esperando: " + clientesEsperando);

        // Despierta al barbero si estaba durmiendo
        notifyAll();
    }

    public void cortarPelo() throws InterruptedException {

        Thread.sleep((int) (Math.random() * 3000) + 1000);

        System.out.println("El barbero termina de cortar el pelo.");
    }
}
