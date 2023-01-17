package Feedback1_1;

import javax.swing.*;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

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
                System.out.println("cancelado");
                break;

            }
            setProgress(100 * (seconds - i) / seconds);
            label.setText(String.valueOf(i));
            Thread.sleep(1000);
            progressBar.setValue(i);
        }
        System.out.println("Tarea finalizada");
        JFrame frame2 = new JFrame("Tarea finalizada");

        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("Cuenta atrás finalizada con éxito"));
        panel2.setVisible(true);
        frame2.add(panel2);
        frame2.pack();
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);

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
