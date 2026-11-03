package Examen.Multiplicacio;

import java.util.concurrent.ForkJoinPool;

public class MainMultiplicacio {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();

        int a = 2000;
        int b = 5;

        Multiplicacio multi = new Multiplicacio(a, b);
        long res = pool.invoke(multi);

        System.out.println("Resultat: " + res);
    }
}

