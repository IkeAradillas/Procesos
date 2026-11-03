package Examen.Multiplicacio;

import java.util.concurrent.RecursiveTask;

public class Multiplicacio extends RecursiveTask<Long> {
    private int a;
    private int b;
    private static int LLINDAR = 1000;

    public Multiplicacio(int a, int b){
        this.a = a;
        this.b = b;
    }

    public long MultiplicacioR(int a, int b) {
        if (a<=LLINDAR) MultiplicacioS(a,b);
        if (a==1) return (b);
        if (a%2!=0) return (b+MultiplicacioR(a/2, b+b));
        else return MultiplicacioR(a/2, b+b);
    }

    public long MultiplicacioS(int a, int b) {
        long sum = 0;
        for (int i = 0; i <= a; i++) {
            sum += b;
        }
        return sum;
    }

    @Override
    protected Long compute() {
        if (a<=LLINDAR) return MultiplicacioS(a,b);
        else return MultiplicacioR(a,b);
    }
}
