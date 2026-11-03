package ExamenPractica.PuenteEstrecho.Iker;

public class Puente {
    int cantidad = 0;
    boolean izq;

    public Puente(String lado){
        izq = lado.equals("izq");
    }

    public synchronized void sumarVehiculo(String lado) throws InterruptedException {
        while (cantidad == 3 || (lado.equals("izq") && !izq) || (lado.equals("der") && izq)) wait();
        System.out.println("ENTRA: " + lado + " | Sentido puente: " + (izq ? "izq" : "der"));
        cantidad++;
        notifyAll();

    }


    public synchronized void quitarVehiculo(){
        cantidad--;
        notifyAll();
    }


    public synchronized void cambiarLado(String lado) throws InterruptedException {

        while (cantidad != 0) wait();
        izq = lado.equals("izq");
        notifyAll();

    }

}
