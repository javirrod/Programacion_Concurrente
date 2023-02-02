/*	Define una colección de ciudades (almacenando nombre, provincia, habitantes y extensión para cada una de ellas) y realiza las siguientes operaciones utilizando Streams:
1.	¿De cuántas provincias diferentes son las ciudades?
2.	¿Cuántas ciudades hay?
3.	Calcula el número total de habitantes para una provincia determinada (introducida por el usuario, por ejemplo)
4.	Obtén una colección con los nombres de todas las ciudades
5.	Obtén una colección con los nombres de todas las provincias (sin repetir)
6.	¿Todas las ciudades son de más de 50.000 habitantes?
7.	¿Alguna ciudad de una provincia determinada (introducida por el usuario) tiene más de 10.000 habitantes?
*/

package Feedback2_Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("########################## Inicio del programa Ciudades - Streams ##########################");

        List<Ciudad> ciudades = Arrays.asList(
                new Ciudad("Azuqueca de Henares", "Guadalajara", 35182, 235.0),
                new Ciudad("Alovera", "Guadalajara", 9142, 20.0),
                new Ciudad("Guecho", "Bilbao", 80089, 12.0),
                new Ciudad("Baracaldo", "Bilbao", 100000, 25.0)
        );

        // 1. ¿De cuántas provincias diferentes son las ciudades?
        long numProvincias = ciudades.stream()
                .map(Ciudad::getProvincia)
                .distinct()
                .count();
        System.out.println("1. Las ciudades son de " + numProvincias + " provincias diferentes");

        // 2. ¿Cuántas ciudades hay?
        long numCiudades = ciudades.stream()
                .count();
        System.out.println("2. Hay " + numCiudades + " ciudades");

        // 3. Calcula el número total de habitantes para una provincia determinada (introducida por el usuario, por ejemplo)
        //String provincia = "Provincia A"; //Para probar con una provincia hardcodeada.
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce la provincia para saber su número de habitantes (ejemplo Guadalajara): ");
        String leerprovincia = sc.nextLine();
        long numHabitantes = ciudades.stream()
                .filter(c -> c.getProvincia().equals(leerprovincia))
                .mapToLong(Ciudad::getHabitantes)
                .sum();
        System.out.println("3. Hay " + numHabitantes + " habitantes en la provincia " + leerprovincia);

        // 4. Obtén una colección con los nombres de todas las ciudades
        List<String> nombresCiudades = ciudades.stream()
                .map(Ciudad::getNombre)
                .collect(Collectors.toList());
        System.out.println("4. Los nombres de las ciudades son: " + nombresCiudades);

        // 5. Obtén una colección con los nombres de todas las provincias (sin repetir)
        List<String> nombresProvincias = ciudades.stream()
                .map(Ciudad::getProvincia)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("5. Los nombres de las provincias son: " + nombresProvincias);

        // 6. ¿Todas las ciudades son de más de 50.000 habitantes?
        boolean todasCiudadesMas50k = ciudades.stream()
                .allMatch(c -> c.getHabitantes() > 50000);
        System.out.println("6. Todas las ciudades son de más de 50.000 habitantes: " + todasCiudadesMas50k);

        // 7. ¿Alguna ciudad de una provincia determinada (introducida por el usuario) tiene más de 10.000 habitantes?
        Scanner sc2 = new Scanner(System.in);
        System.out.print("Introduce una provincia para saber su número de habitantes (ejemplo Bilbao): ");
        String leerprovincia2 = sc2.nextLine();

        boolean algunaCiudadMas10k = ciudades.stream()
                .filter(c -> c.getProvincia().equals(leerprovincia2))
                .anyMatch(c -> c.getHabitantes() > 10000);

        System.out.println("7. Alguna ciudad de la provincia de " + leerprovincia2 + " tiene más de 10.000 habitantes: " + algunaCiudadMas10k);










    }
}