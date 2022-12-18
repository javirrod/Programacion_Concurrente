package Pruebas_Feedback_1_2;

public class TareaDeHiloLarga implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 20;i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
