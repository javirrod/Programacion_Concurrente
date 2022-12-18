package Pruebas_Feedback_1_2;

public class Programa {
    /* 2.	Realiza una aplicación de texto que lance dos hilos de forma que el segundo se ejecute
    mientras dure la ejecución del primero
     */
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Inicio del programa. Ejecución de hilo mientras se otro hilo está activo");

        //Creación de hilos pasándole la tarea que tiene que hacer el hilo, la tarea es de tipo Runnable.
        Thread hilo1 = new Thread(new TareaDeHilo(),"Hilo1");
        Thread hilo2 = new Thread(new TareaDeHiloLarga(),"Hilo2");

        /*Inicio del hilo 1.*/
        hilo1.start();
        hilo2.start();
        //hilo1.join(); Si se descomenta esta línea, el hilo 2 nunca se ejecutará porque ya habrá terminado el primero.
        // Mientras siga activo el hilo1 se ejecutará el hilo 2
       // while (hilo1.isAlive()) {
        //    hilo2.start();
        //}
        hilo1.join();
        //Cuando el hilo1 ya no esté ejecutándose, cerrar el hilo 2
        if (!hilo1.isAlive()){
            hilo2.join();
        }


        System.out.println("Fin del programa");
    }
}