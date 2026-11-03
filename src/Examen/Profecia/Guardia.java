package Examen.Profecia;

public class Guardia extends Thread{
    Clau c;

    public Guardia(Clau c){
        this.c = c;
    }

    @Override
    public void run(){
        while (true){
            try {
                Thread.sleep((int)(Math.random()*1000)+50);
                c.obrir();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("El guardia ha obert la torre");

            try {
                Thread.sleep((int)(Math.random()*500)+50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            c.tancar();
            System.out.println("El guardia ha sortit de la torre");
        }
    }
}
