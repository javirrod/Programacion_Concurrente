import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

public class CountdownApplication {
    // La ventana principal de la aplicación
    private JFrame mainFrame;
    // La barra de progreso para mostrar la cuenta atrás
    private JProgressBar progressBar;
    // La etiqueta de texto para mostrar la cuenta atrás
    private JLabel countdownLabel;
    // El campo de texto para introducir el número de segundos para la cuenta atrás
    private JTextField secondsField;
    // El botón para iniciar la cuenta atrás
    private JButton startButton;
    // El botón para cancelar la cuenta atrás
    private JButton cancelButton;
    // La tarea en segundo plano que realiza la cuenta atrás
    //private CountdownTask countdownTask;
/*
    public CountdownApplication() {
        // Crea la ventana principal de la aplicación
        mainFrame = new JFrame("Cuenta atrás");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crea la barra de progreso para mostrar la cuenta atrás
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);

        // Crea la etiqueta de texto para mostrar la cuenta atrás
        countdownLabel = new JLabel("Tiempo restante: ");

        // Crea el campo de texto para introducir el número de segundos para la cuenta atrás
        secondsField = new JTextField(5);

        // Crea el botón para iniciar la cuenta atrás
        startButton = new JButton("Iniciar cuenta atrás");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtiene el número de segundos introducido por el usuario
                int seconds = Integer.parseInt(secondsField.getText());
                // Crea una nueva tarea en segundo plano para realizar la cuenta atrás
                countdownTask = new CountdownTask(seconds);
                // Inicia la tarea en segundo plano
                countdownTask.execute();
            }
        });

        // Crea el botón para cancelar la cuenta atrás
        cancelButton = new JButton("Cancelar cuenta atrás");



 */