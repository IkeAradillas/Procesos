package T1.ExamenPractica.PuenteEstrecho.IA;

public class Main {

    public static void main(String[] args) {

        Puente p = new Puente("izq");

        Vehiculo v1 = new Vehiculo("der", p);
        Vehiculo v2 = new Vehiculo("izq", p);
        Vehiculo v3 = new Vehiculo("der", p);
        Vehiculo v4 = new Vehiculo("izq", p);

        v1.start();
        v2.start();
        v3.start();
        v4.start();
    }
}
