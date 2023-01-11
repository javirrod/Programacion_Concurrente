package Feedback1_1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.List;

public class CountdownSwingWorker extends SwingWorker<Void, Void> {
    private int seconds=5;
    private JLabel label;
    private JProgressBar progressBar;

    public CountdownSwingWorker(int seconds, JLabel label, JProgressBar progressBar) {

        this.seconds = seconds;

        this.label = label;

        this.progressBar = progressBar;

    }

    @Override

    protected Void doInBackground() throws Exception {
        for (int i = seconds; i >= 0; i--) {
            if (isCancelled()) {
                break;
            }
            setProgress(100 * (seconds - i) / seconds);
            label.setText(String.valueOf(i));
            Thread.sleep(1000);
        }
        return null;
    }

   /* @Override
    protected void process(List<Integer> chunks) {
        int remainingSeconds = chunks.get(chunks.size() - 1);
        // Actualiza la interfaz de usuario con el tiempo restante
    }*/

    @Override
    protected void done() {
        try {
            get();
            label.setText("Cuenta atrás finalizada");
        } catch (InterruptedException | ExecutionException e) {
            // No hacemos nada, ya que la tarea ha sido cancelada
        } catch (CancellationException e) {
            label.setText("Cuenta atrás cancelada");
        }
    }


}
