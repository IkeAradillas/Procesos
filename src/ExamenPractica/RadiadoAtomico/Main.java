package ExamenPractica.RadiadoAtomico;

public class Main {

    public static void main(String[] args) {

        Buffer b = new Buffer(3, 3);

        Productor p = new Productor(b);

        Consumidor c1 = new Consumidor(1, b);
        Consumidor c2 = new Consumidor(2, b);
        Consumidor c3 = new Consumidor(3, b);

        p.start();

        c1.start();
        c2.start();
        c3.start();
    }
}
