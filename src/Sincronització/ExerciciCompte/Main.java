package Sincronització.ExerciciCompte;

import java.util.ArrayList;

public class Main{
    public static void main(String[] args) throws InterruptedException {
        CompteEstalvi compte = new CompteEstalvi(50000);

        // 100 threads que facin un ingres de 500
        // 100 threads que facin treure 200

        ArrayList<Thread> ti = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Thread tii = new Thread(()->compte.ingressar(500));
            Thread tee = new Thread(()-> compte.treure(200));
            ti.add(tii);
            ti.add(tee);
            tii.start();
            tee.start();
        }

        for (Thread thread : ti) {
            thread.join();
        }

        System.out.println(compte.getSaldo());

    }

}
