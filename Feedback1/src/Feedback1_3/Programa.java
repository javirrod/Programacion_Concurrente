package Feedback1_3;

public class Programa {
    /* 3.	Realiza una aplicación que ejecute 4 hilos de forma que se ejecuten de forma ordenada uno detrás de
     otro esperando cada uno a que termine el anterior para ejecutarse
     */
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Inicio del programa. Ejecución de hilos en orden");

        //Creación de hilos pasándole la tarea que tiene que hacer el hilo, la tarea es de tipo Runnable.
        Thread hilo1 = new Thread(new TareaDeHilo(),"Hilo1");
        Thread hilo2 = new Thread(new TareaDeHilo(),"Hilo2");
        Thread hilo3 = new Thread(new TareaDeHilo(),"Hilo3");
        Thread hilo4 = new Thread(new TareaDeHilo(),"Hilo4");

        /*Inicio de los hilos y terminación de cada uno con el método join para que el siguiente no empiece hasta que
        haya finalizado el anterior.*/
        hilo1.start();
        hilo1.join();
        hilo2.start();
        hilo2.join();
        hilo3.start();
        hilo3.join();
        hilo4.start();
        hilo4.join();

        System.out.println("Fin del programa");
    }
}