//EJERCICIO 1 DE FEEDBACK
package Feedback1_1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import static java.lang.Integer.parseInt;

public class Programa {
    public static void main(String[] args) {
        // Crear la ventana y el panel
        JFrame frame = new JFrame("Programa de cuenta atrás");
        JPanel panel = new JPanel();

        // Crear un botón para iniciar la tarea en segundo plano
        JButton botonIniciar = new JButton("Iniciar cuenta atrás");
        //crear botón para detener la tarea
        JButton botonCancelar = new JButton("Detener tarea");
        //creo un boton llamado salir que cierre la ventana
        JButton botonSalir = new JButton("Salir"); //creo el boton salir

        // Añadir el botón al panel y la panel a la ventana
        panel.add(botonIniciar);
        panel.add(botonCancelar);
        panel.add(botonSalir); //añado el boton al panel
        botonCancelar.setEnabled(false);//no se puede pulsar de momento
        frame.add(panel);

        // Hacer la ventana visible
        frame.setVisible(true);
        JProgressBar progressBar = new JProgressBar(0, 5);//barra de progreso
        progressBar.setValue(100);//valor inicial
        progressBar.setStringPainted(true);//para ver el porcentaje
        panel.add(progressBar);

        //añadir etiqueta de texto para introducir segundos
        JLabel label = new JLabel("Introduce la cantidad de segundos:");
        panel.add(label);
        //añadir campo de texto para introducir segundos
        JTextField textField = new JTextField("5",5);
        panel.add(textField);
        //int numero = Integer.parseInt(textField.getText());

        //ajustar la ventana al tamaño de los componentes
        frame.pack();
        //coloca la ventana en el centro de la pantalla
        frame.setLocationRelativeTo(null);

//
    //CountdownSwingWorker worker = null;//creo un objeto de la clase CountdownSwingWorker

//        private void cancelar(ActionEvent evt){
//            botonCancelar.setEnabled(false);
//            botonIniciar.setEnabled(true);
//
//            if (worker.cancel(true)){
//                JOptionPane.showMessageDialog(frame, "¡Tarea cancelada!");
//                progressBar.setValue(0);
//            }
//        }
        botonSalir.addActionListener(new ActionListener() { //añado un listener al boton
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); //cierro la ventana
            }
        });

        botonIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botonCancelar.setEnabled(true);
                String text = textField.getText();
                int numero = Integer.parseInt(text);
                progressBar.setMaximum(numero);
                //progressBar.setValue(numero);
                //System.out.println(numero);
                // Crear la tarea en segundo plano
                CountdownSwingWorker worker = new CountdownSwingWorker(numero,label,progressBar);

                // Iniciar la tarea en segundo plano
                worker.execute();
                if (numero == 0){
                    JOptionPane.showMessageDialog(frame, "¡Tiempo agotado!");
                }
                //creo el listener para el botón cancelar mientras se está ejecutando la tarea y poder cancelarla
                botonCancelar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        worker.cancel(true);
                        JOptionPane.showMessageDialog(frame, "¡Tarea cancelada!");
                        progressBar.setValue(0);
                        botonCancelar.setEnabled(false);
                    }
                });
            }
        });
    }
    }



