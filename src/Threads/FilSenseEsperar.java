package Threads;

public class FilSenseEsperar extends Thread{
    public FilSenseEsperar(String name) {
        super(name);
    }

    @Override
    public void start(){
        System.out.println("Son el fil " + getName());
    }

    public static void main(String[] args) throws InterruptedException{
        Fil f1 = new Fil("Fil1");
        Fil f2 = new Fil("Fil2");
        Fil f3 = new Fil("Fil3");

        Thread t1 = new Thread(() -> System.out.println("Soc el fil Fil4"));

        f1.start();
        f2.start();
        f3.start();
        t1.start();


        System.out.println("Acabat");

    }
}
