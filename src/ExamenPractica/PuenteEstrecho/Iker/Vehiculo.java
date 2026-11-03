package ExamenPractica.PuenteEstrecho.Iker;

public class Vehiculo extends Thread{
    String lado;
    Puente p;

    public Vehiculo(String lado, Puente p){
        this.lado = lado;
        this.p = p;
    }

    @Override
    public void run(){
        while (true) {
            try {
                Thread.sleep((int) (Math.random() * 3000) + 50);
                p.sumarVehiculo(lado);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("El coche esta atravesant el pont per " + lado + ". Total de vehicles: " + p.cantidad);

            try {
                Thread.sleep((int) (Math.random() * 3000) + 50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            p.quitarVehiculo();
            System.out.println("El coche ja ha acabat d'atravesar el pont. Total de vehicles: " + p.cantidad);

        }
    }
}
