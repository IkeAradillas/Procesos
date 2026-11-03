package ExamenPractica.PuenteEstrecho.Iker;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Puente p = new Puente("izq");
        Vehiculo v1 = new Vehiculo("der", p);
        Vehiculo v2 = new Vehiculo("izq", p);
        Vehiculo v3 = new Vehiculo("der", p);
        Vehiculo v4 = new Vehiculo("izq", p);

        v1.start();
        v2.start();
        v3.start();
        v4.start();

        Thread.sleep((int) (Math.random() * 3000) + 50);

        p.cambiarLado("der");
        System.out.println("El sentit ha cambiat a " + (p.izq ? "izq" : "der"));

        Thread.sleep((int) (Math.random() * 3000) + 50);

        p.cambiarLado("izq");
        System.out.println("El sentit ha cambiat a " + (p.izq ? "izq" : "der"));

        Thread.sleep((int) (Math.random() * 3000) + 50);

        p.cambiarLado("der");
        System.out.println("El sentit ha cambiat a " + (p.izq ? "izq" : "der"));

        Thread.sleep((int) (Math.random() * 3000) + 50);

        p.cambiarLado("izq");
        System.out.println("El sentit ha cambiat a " + (p.izq ? "izq" : "der"));

        Thread.sleep((int) (Math.random() * 3000) + 50);

        p.cambiarLado("der");
        System.out.println("El sentit ha cambiat a " + (p.izq ? "izq" : "der"));

    }
}
