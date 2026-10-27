package Sincronització.ExerciciTaller;

public class CosidorCos extends Thread{
    Cistell c;

    public CosidorCos(Cistell c){
        this.c = c;
    }

    @Override
    public void run(){
        while (true) {
            try {
                c.addCos();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Cos afegit. Total: " + c.getCos());

            try {
                Thread.sleep((int) (Math.random() * 500) + 50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
