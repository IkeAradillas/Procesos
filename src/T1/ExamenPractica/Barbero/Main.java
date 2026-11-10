package T1.ExamenPractica.Barbero;

public class Main {

    public static void main(String[] args) {

        Barberia b = new Barberia(3);

        Barbero barbero = new Barbero(b);

        Cliente c1 = new Cliente(b);
        Cliente c2 = new Cliente(b);
        Cliente c3 = new Cliente(b);
        Cliente c4 = new Cliente(b);
        Cliente c5 = new Cliente(b);
        Cliente c6 = new Cliente(b);
        Cliente c7 = new Cliente(b);

        barbero.start();

        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        c6.start();
        c7.start();
    }
}
