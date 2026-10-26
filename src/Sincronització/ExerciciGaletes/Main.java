package Sincronització.ExerciciGaletes;

public class Main {

    public static void main(String[] args) {
        PotGaletes pg = new PotGaletes(1);
        Fill f1 = new Fill("Azan", pg);
        Fill f2 = new Fill("Isaac", pg);
        Pare p = new Pare("Iker", pg);

        f1.start();
        f2.start();
        p.start();

    }

}
