package ExamenPractica.Baños.Iker;

public class Persona extends Thread{
    boolean hombre;
    Baño b;

    public Persona(boolean hombre, Baño b){
        this.hombre = hombre;
        this.b = b;
    }

    @Override
    public void run(){
        try{
            Thread.sleep((int)(Math.random()*800)+50);
            b.entrarPersona(hombre);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Ha entrado al baño un/a " + (hombre ? "hombre" : "mujer") + " | Personas totales: " + b.cantidad );

        try {
            Thread.sleep((int)(Math.random()*800)+50);
            b.salirPersona();
            System.out.println("Ha salido del baño un/a" + (hombre? "hombre": "mujer"));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
