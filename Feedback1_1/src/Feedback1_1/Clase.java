package Feedback1_1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clase {
    public static void main(String[] args) {
        // Crear la ventana y el panel
        JFrame frame = new JFrame("Programa de cuenta atrás");
        JPanel panel = new JPanel();

        // Crear un botón para iniciar la tarea en segundo plano
        JButton button = new JButton("Iniciar cuenta atrás");

        //crear botón para detener la tarea
        JButton button2 = new JButton("Detener tarea");
      //  button2.doClick();
        // Añadir el botón al panel y la panel a la ventana
        panel.add(button);
        panel.add(button2);
        frame.add(panel);

        // Hacer la ventana visible
        //frame.pack();
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


        //creo un boton llamado salir que cierre la ventana
        JButton button3 = new JButton("Salir"); //creo el boton
        panel.add(button3); //añado el boton al panel
        //ajustar la ventana al tamaño de los componentes
        frame.pack();
        //coloca la ventana en el centro de la pantalla
        frame.setLocationRelativeTo(null);

        button3.addActionListener(new ActionListener() { //añado un listener al boton
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); //cierro la ventana
            }
        });

        button.addActionListener(event -> {

            // CountdownSwingWorker task = new CountdownSwingWorker(10);
            CountdownSwingWorker task = new CountdownSwingWorker(5,new JLabel(),new JProgressBar());
            //button.doClick();

            task.execute();



        });
    }


    }



