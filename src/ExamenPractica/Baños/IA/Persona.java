package ExamenPractica.Baños.IA;

public class Persona extends Thread {

    char sexo;
    Baño b;

    public Persona(char sexo, Baño b) {
        this.sexo = sexo;
        this.b = b;
    }

    @Override
    public void run() {

        while (true) {

            try {
                // Tiempo antes de intentar entrar
                Thread.sleep((int) (Math.random() * 3000) + 500);

                b.entrar(sexo);

                // Tiempo dentro del baño
                Thread.sleep((int) (Math.random() * 3000) + 500);

                b.salir();

            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

