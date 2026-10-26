package Sincronització.ExerciciCompte;

public class CompteEstalvi {
    private float saldo;

    public CompteEstalvi(float saldo) {
        this.saldo = saldo;
    }

    public float getSaldo() {
        return saldo;
    }

    // Si no fiquem synchronized pot donar diferent encara que hagi de ser 80000.0

    public synchronized void ingressar(float diners) {
        float aux;
        aux=getSaldo();
        aux=aux+diners;
        saldo=aux;
    }

    public synchronized void treure(float diners) {
        float aux;
        aux=getSaldo();
        aux=aux-diners;
        saldo=aux;
    }


}
