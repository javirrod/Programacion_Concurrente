/*2.	Realiza una aplicación que comprima en .zip el contenido de un directorio y,
cuando termine, lo copie a otra carpeta indicada por el usuario (podéis ver aqui como trabajar
con ficheros zip en Java)
La ruta que se utilizará será “C:\temp\zipear”
*/

package Feedback2_Future2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main{
    public static void main(String[] args) {
        System.out.println("INICIO DEL PROGRAMA DE ZIPEADO Y COPIADO DE DIRECTORIOS............");
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Boolean> future = executorService.submit(() -> {
            File directoryToZip = new File("C:\\temp\\zipear");
            File zipFile = new File("C:\\temp\\zipeado.zip");

            try (FileOutputStream fos = new FileOutputStream(zipFile);
                 ZipOutputStream zos = new ZipOutputStream(fos)) {

                for (File file : directoryToZip.listFiles()) {
                    if (!file.isDirectory()) {
                        addToZip(zos, file);
                    }
                }
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        });

        try {
            if (future.get()) {
                System.out.println("Carpeta zipeada correctamente");
                copyZipFile("C:\\temp\\zipeado.zip", "C:\\temp\\zipear_copiado");
                System.out.println("Fichero copiado correctamente");
            }
        } catch (InterruptedException | ExecutionException | IOException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }

    private static void addToZip(ZipOutputStream zos, File file) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            ZipEntry zipEntry = new ZipEntry(file.getName());
            zos.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zos.write(bytes, 0, length);
            }
            zos.closeEntry();
        }
    }

    private static void copyZipFile(String source, String destination) throws IOException {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination + ".zip")) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
        }
    }
}