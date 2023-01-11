package Paquete_Pruebas;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class Test {
    public static void main(String[] args) {
        JProgressBar barra = new JProgressBar();
        barra.setMinimum(0);
        barra.setMaximum(100);
        barra.setValue(0);
        barra.setStringPainted(true);
        JFrame ventana = new JFrame();
        ventana.add(barra);
        ventana.setSize(300, 100);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (int i = 0; i <= 100; i++) {
            barra.setValue(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}