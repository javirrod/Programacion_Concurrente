package Feedback1_2;

public class Programa {
    public static void main(String[] args) throws InterruptedException {
        TareaPrincipal tareaPrincipal = new TareaPrincipal();
        Thread hiloPrincipal = new Thread(tareaPrincipal);

        TareaAlive tareaAlive = new TareaAlive(hiloPrincipal);
        Thread hiloAlive = new Thread(tareaAlive);

        hiloPrincipal.start();
        hiloAlive.start();

        hiloPrincipal.join();
        hiloAlive.join();


        System.out.println("\n###Se han terminado los dos hilos###\nEl programa termina");
    }
}