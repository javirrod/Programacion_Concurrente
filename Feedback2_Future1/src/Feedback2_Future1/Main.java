/*Future/CompletableFuture
        1.	Realiza una aplicación que descargue un fichero de Internet y, una vez esté descargado,
         lo abra para que el usuario pueda ver su contenido (podéis hacerlo simplemente con un fichero
         de texto o algo legible como tal)
        https://github.com/javirrod/Programacion_Concurrente/blob/main/prueba.txt
        */
package Feedback2_Future1;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Inicio del programa");
        String fileUrl = "https://github.com/javirrod/Programacion_Concurrente/blob/main/prueba.txt";
        CompletableFuture<Void> downloadTask = CompletableFuture.runAsync(() -> {
            try {
                URL website = new URL(fileUrl);
                ReadableByteChannel rbc = Channels.newChannel(website.openStream());
                File file = new File("C:\temp\file.txt");
                file.createNewFile();
                file.deleteOnExit();
                //arreglar java.nio.file.Files.copy(rbc, file.toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        downloadTask.thenRun(() -> {
            try {
                java.awt.Desktop.getDesktop().open(new File("file.txt"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
