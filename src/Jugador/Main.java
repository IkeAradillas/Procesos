package Jugador;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        Jugador j1 = new Jugador("Iker");
        Jugador j2 = new Jugador("Isaac");
        Jugador j3 = new Jugador("Azan");

        PosaPunts p1 = new PosaPunts();
        p1.setJ(j1);

        PosaPunts p2 = new PosaPunts();
        p2.setJ(j2);

        PosaPunts p3 = new PosaPunts();
        p3.setJ(j3);

        ScheduledExecutorService schExService = Executors.newScheduledThreadPool(3);
        schExService.scheduleWithFixedDelay(p1, 1, 1, TimeUnit.SECONDS);
        schExService.scheduleWithFixedDelay(p2, 1, 1, TimeUnit.SECONDS);
        schExService.scheduleWithFixedDelay(p3, 1, 1, TimeUnit.SECONDS);

        try {
            schExService.awaitTermination(300, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        schExService.shutdownNow();

        System.out.println("El jugador 1: " + j1.getNom() + " ha aconseguit " + j1.getPunts() + " punts");
        System.out.println("El jugador 2: " + j2.getNom() + " ha aconseguit " + j2.getPunts() + " punts");
        System.out.println("El jugador 3: " + j3.getNom() + " ha aconseguit " + j3.getPunts() + " punts");

    }
}
