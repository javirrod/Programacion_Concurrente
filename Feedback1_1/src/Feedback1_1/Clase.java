package Feedback1_1;

import javax.swing.*;

public class Clase {
    public static void main(String[] args) {
        // Crear la ventana y el panel
        JFrame frame = new JFrame("Programa de cuenta atrás");
        JPanel panel = new JPanel();

        // Crear un botón para iniciar la tarea en segundo plano
        JButton button = new JButton("Iniciar cuenta atrás");
        button.addActionListener(event -> {
            // Crear una instancia de la clase Tarea y llamar al método start() para iniciar el hilo
            //Tarea tarea = new Tarea();
            //tarea.start();

            Tarea task = new Tarea(10);
            task.execute();
        });
        //crear botón para detener la tarea
        JButton button2 = new JButton("Detener tarea");
        button2.doClick();
        // Añadir el botón al panel y la panel a la ventana
        panel.add(button);
        panel.add(button2);
        frame.add(panel);

        // Hacer la ventana visible
        frame.pack();
        frame.setVisible(true);
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(100);
        panel.add(progressBar);

        //añadir etiqueta de texto para introducir segundos
        JLabel label = new JLabel("Introduce la cantidad de segundos:");
        panel.add(label);
        //añadir campo de texto para introducir segundos
        JTextField textField = new JTextField(10);
        panel.add(textField);




    }





}
