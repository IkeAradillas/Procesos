package ExamenPractica.Baños.IA;

public class Main {
    public static void main(String[] args) {

        Baño b = new Baño();

        Persona p1 = new Persona('H', b);
        Persona p2 = new Persona('M', b);
        Persona p3 = new Persona('H', b);
        Persona p4 = new Persona('M', b);
        Persona p5 = new Persona('H', b);
        Persona p6 = new Persona('M', b);

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();

    }
}
