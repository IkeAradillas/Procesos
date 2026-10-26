package Sincronització.ExerciciTaller;


public class Main {
    public static void main(String[] args) {
        CosidorCos c = new CosidorCos();
        CosidorManigues m = new CosidorManigues();
        Encadellador e = new Encadellador();

        c.start();
        m.start();
        e.start();
    }
}
