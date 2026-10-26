package Sincronització.ExerciciTaller;

public class Encadellador extends Thread{
    CistellaCos c = new CistellaCos();
    CistellaManigues m = new CistellaManigues();
    int roba = 0;

    @Override
    public void run(){
        while (true) {
            try {
                c.treureCos();
                m.treureManiga();
                m.treureManiga();
                roba++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Total: " + roba);

            try {
                Thread.sleep((int) (Math.random() * 100) + 50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
