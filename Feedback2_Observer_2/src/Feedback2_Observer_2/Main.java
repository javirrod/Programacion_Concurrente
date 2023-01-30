/*2. Crea una aplicación en la que un ListView muestre el contenido de la lista, de forma que el ListView
 se actualice cada vez que se añadan elementos a la lista
  Para ello, crea una clase que implemente la interfaz Observer y que se suscriba a la lista.
  La clase Observer debe implementar el método update() de la interfaz Observer, de forma que cada vez que
  se añada un elemento a la lista, se actualice el ListView.*/

/* En este ejercicio se simulan los eventos de un partido de fútbol, donde se muestra en consola los eventos*/

package Feedback2_Observer_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Inicio del programa ListView Observer - Partido de fútbol");

        List lista = new List();
        Console console = new Console();
        lista.addObserver(console);

        Scanner input = new Scanner(System.in);

        lista.add("Inicio del partido");
        lista.add("Tiro a puerta");
        lista.add("Gol de Benzema");
        lista.add("Parada de Courtois");

        while (true) {
            System.out.print("Ingrese un nuevo elemento o escriba 'final' para salir: ");
            String newItem = input.nextLine();
            if (newItem.equals("final")) {
                System.out.println("Final del partido");
                break;
            } else {
                lista.add(newItem);
            }
        }






    }
}