package Sincronització.ExerciciTaller;


public class Main {
    public static void main(String[] args) {
        Cistell cCosos = new Cistell();
        Cistell cManigues = new Cistell();
        CosidorCos cc = new CosidorCos(cCosos);
        CosidorManigues m = new CosidorManigues(cManigues);
        Encadellador e = new Encadellador(cCosos, cManigues);

        cc.start();
        m.start();
        e.start();
    }
}
