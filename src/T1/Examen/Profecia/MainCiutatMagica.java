package T1.Examen.Profecia;


public class MainCiutatMagica {
    public static void main(String[] args) {
        Clau c = new Clau();
        Profecia p = new Profecia(c);
        Guardia g = new Guardia(c);

        p.start();
        g.start();
    }
}
