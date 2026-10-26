package Sincronització.ExerciciFamilia;

public class Main {
    public static void main(String[] args) {
        Comandament com = new Comandament();
        MembreFamilia pare = new MembreFamilia("Antonio", com);
        MembreFamilia mare = new MembreFamilia("Maria", com);
        MembreFamilia fil = new MembreFamilia("Toni", com);
        MembreFamilia filla = new MembreFamilia("Ona", com);

        pare.start();
        mare.start();
        fil.start();
        filla.start();


    }
}
