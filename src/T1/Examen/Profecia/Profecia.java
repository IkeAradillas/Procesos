package T1.Examen.Profecia;

public class Profecia extends Thread{
    Clau c;

    public Profecia(Clau c){
        this.c = c;
    }

    @Override
    public void run(){
        while (true){
            try{
                Thread.sleep((int) (Math.random()*1000 +50));
                c.comprobarProfecia();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (c.profecia) System.out.println("Profecia complida!!");

            try {
                Thread.sleep((int)(Math.random()*1000 + 50));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
