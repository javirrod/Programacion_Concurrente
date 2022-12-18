package Feedback1_2;

public class TareaAlive implements Runnable {
    private final Thread otroHilo;

    public TareaAlive(Thread otroHilo) {
        this.otroHilo = otroHilo;
    }

    @Override
    public void run() {
        while (otroHilo.isAlive()) {
            System.out.println("Yo hago cosas mientras el otro hilo siga en ejecución");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }

        System.out.println("El otro hilo ha terminado. Yo también");
    }
}
