package T1.Sincronització.ExerciciTaller;

public class CosidorManigues extends Thread{
    Cistell m;

    public CosidorManigues(Cistell m){
        this.m=m;
    }


    @Override
    public void run(){
        while (true) {
            try {
                m.addManiga();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Maniga afegida. Total: " + m.getManiga());

            try {
                Thread.sleep((int) (Math.random() * 500) + 50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
