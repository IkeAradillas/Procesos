package T1.Sincronització.ExerciciTaller;

public class Encadellador extends Thread{

    Cistell cCos;
    Cistell cManigues;

    public Encadellador(Cistell cCos, Cistell cManigues){
        this.cCos = cCos;
        this.cManigues = cManigues;
    }

    private int roba = 0;

    @Override
    public void run(){
        while (true) {
            try {
                cCos.treureCos();
                cManigues.treureManiga();
                roba++;
                cCos.deixarCistell();
                cManigues.deixarCistell();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Total: " + roba);

            try {
                Thread.sleep((int) (Math.random() * 1000) + 50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
