package T1.ExamenPractica.Baños.IA;

public class Baño {

    int cantidad = 0;
    int capacidad = 3;

    char turno = 'N'; // N = ningún sexo todavía

    int esperandoH = 0;
    int esperandoM = 0;

    public synchronized void entrar(char sexo) throws InterruptedException {

        // Contamos que hay una persona esperando
        if (sexo == 'H') {
            esperandoH++;
        } else {
            esperandoM++;
        }

        try {
            while (cantidad == capacidad ||
                    turno != 'N' && turno != sexo ||
                    (cantidad > 0 && sexo == 'H' && esperandoM > 0) ||
                    (cantidad > 0 && sexo == 'M' && esperandoH > 0)) {

                wait();
            }

        } catch (InterruptedException e) {

            // Si se interrumpe mientras espera,
            // dejamos de contarla como persona esperando
            if (sexo == 'H') {
                esperandoH--;
            } else {
                esperandoM--;
            }

            notifyAll();
            throw e;
        }

        // Ya puede entrar, así que deja de esperar
        if (sexo == 'H') {
            esperandoH--;
        } else {
            esperandoM--;
        }

        // Si es la primera persona, establecemos el turno
        if (turno == 'N') {
            turno = sexo;
        }

        cantidad++;

        System.out.println("ENTRA: " + sexo +
                " | Personas dentro: " + cantidad);
    }

    public synchronized void salir() {

        cantidad--;

        System.out.println("SALE | Personas dentro: " + cantidad);

        // Si el baño se queda vacío, comprobamos
        // si hay personas del otro sexo esperando
        if (cantidad == 0) {

            if (turno == 'H' && esperandoM > 0) {
                turno = 'M';
            } else if (turno == 'M' && esperandoH > 0) {
                turno = 'H';
            }
        }

        notifyAll();
    }
}
