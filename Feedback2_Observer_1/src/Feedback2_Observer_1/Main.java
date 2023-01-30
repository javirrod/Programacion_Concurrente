package Feedback2_Observer_1;

import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Avion avionPerseguido = new Avion();
        AvionPerseguidor avionPerseguidor = new AvionPerseguidor();
        AvionPerseguidor avionPerseguidor2 = new AvionPerseguidor();

        avionPerseguido.addObserver(avionPerseguidor);

        for (int i = 0; i < 3; i++) {
            Scanner scan = new Scanner(System.in);

            System.out.println("Ingrese la ruta del avión perseguido (altura, velocidad, dirección): \n" +
                    "(Presione enter después de cada valor)\n" +
                    "En total dispone de 3 cambios en los parámetros de la ruta. Para más cambios, adquiera la versión PRO");
            avionPerseguido.setAltura(scan.nextInt());
            avionPerseguido.setVelocidad(scan.nextInt());
            avionPerseguido.setDireccion(scan.nextInt());

            //actualizar los datos a los perseguidores
            avionPerseguidor.update(avionPerseguido);
            avionPerseguidor2.update(avionPerseguido);

            System.out.println("Avión Perseguido: Altura = " + avionPerseguido.getAltura() +
                    ", Velocidad = " + avionPerseguido.getVelocidad() +
                    ", Dirección = " + avionPerseguido.getDireccion());

            System.out.println("Avión Perseguidor: Altura = " + avionPerseguidor.getAltura() +
                    ", Velocidad = " + avionPerseguidor.getVelocidad() +
                    ", Dirección = " + avionPerseguidor.getDireccion());

            System.out.println("Avión Perseguidor 2: Altura = " + avionPerseguidor2.getAltura() +
                    ", Velocidad = " + avionPerseguidor2.getVelocidad() +
                    ", Dirección = " + avionPerseguidor2.getDireccion());
        }
        System.out.println("### FIN DEL PROGRAMA ###");

    }
}
