package T1.ExamenPractica.PuenteEstrecho.IA;

public class Vehiculo extends Thread {

    String lado;
    Puente p;

    public Vehiculo(String lado, Puente p) {
        this.lado = lado;
        this.p = p;
    }

    @Override
    public void run() {

        try {
            Thread.sleep((int) (Math.random() * 3000) + 50);

            p.sumarVehiculo(lado);

            try {
                System.out.println("El coche esta atravesant el pont per "
                        + lado + ". Total de vehicles: " + p.cantidad);

                Thread.sleep((int) (Math.random() * 3000) + 50);

            } finally {
                p.quitarVehiculo();
                System.out.println("El coche ja ha acabat d'atravesar el pont.");
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}