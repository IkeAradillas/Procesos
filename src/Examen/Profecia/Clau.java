package Examen.Profecia;

public class Clau {
    boolean profecia = false;
    boolean obert = false;

    public synchronized void obrir() throws InterruptedException {
        while (!profecia && !obert) wait();
        obert = true;
        notifyAll();
    }

    public synchronized void comprobarProfecia() throws InterruptedException {
        while (true){
            Thread.sleep((int) (Math.random() * 1000 + 50));
            if ((int) ((Math.random() * 10)) != 5) {
                System.out.println("Profecia no cumplida");
                profecia = false;
                notifyAll();
            }
            else break;
        }
/*        while ((int) ((Math.random() * 100)) != 50){
            profecia = false;
            notifyAll();
        }

 */
        profecia = true;
        notifyAll();

    }

    public synchronized void tancar(){
        obert = false;
        profecia =false;
        notifyAll();
    }




}
