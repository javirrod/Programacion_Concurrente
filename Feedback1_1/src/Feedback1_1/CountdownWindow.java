package Feedback1_1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CountdownWindow extends JFrame {

    private JLabel label;
    private JProgressBar progressBar;
    private JButton startButton;
    private JButton cancelButton;
    private CountdownSwingWorker worker;

    public CountdownWindow() {

        label = new JLabel();

        progressBar = new JProgressBar();

        startButton = new JButton("Iniciar cuenta atrás");

        startButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                startCountdown();
            }
        });

        cancelButton = new JButton("Cancelar");

        cancelButton.setEnabled(false);

        cancelButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                cancelCountdown();

            }

        });


        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(label);

        add(progressBar);

        add(startButton);

        add(cancelButton);

    }

    private void cancelCountdown() {

        worker.cancel(true);

        startButton.setEnabled(true);

        cancelButton.setEnabled(false);

    }


    private void startCountdown() {

        worker = new CountdownSwingWorker(10, label, progressBar);

        worker.addPropertyChangeListener(new PropertyChangeListener() {

            @Override

            public void propertyChange(PropertyChangeEvent evt) {

                if ("progress".equals(evt.getPropertyName())) {

                    progressBar.setValue((Integer) evt.getNewValue());

                }
            }
        });
    }
}
