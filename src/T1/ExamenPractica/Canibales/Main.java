package T1.ExamenPractica.Canibales;

public class Main {
    public static void main(String[] args) {

        Bote b = new Bote();

        Persona p1 = new Persona(true, b);
        Persona p2 = new Persona(true, b);
        Persona p3 = new Persona(false, b);

        Persona p4 = new Persona(false, b);
        Persona p5 = new Persona(false, b);
        Persona p6 = new Persona(true, b);

        Persona p7 = new Persona(true, b);
        Persona p8 = new Persona(true, b);
        Persona p9 = new Persona(true, b);

        p1.start();
        p2.start();
        p3.start();

        p4.start();
        p5.start();
        p6.start();

        p7.start();
        p8.start();
        p9.start();
    }
}
