package Feedback1_1;

import javax.swing.SwingWorker;
import java.util.List;

public class Tarea extends SwingWorker<Void, Integer> {
    private int seconds;

    public Tarea(int seconds) {
        this.seconds = seconds;
    }

    @Override
    protected Void doInBackground() throws Exception {
        for (int i = seconds; i >= 0; i--) {
            setProgress(100 * (seconds - i) / seconds);
            publish(i);
            Thread.sleep(1000);
        }
        return null;
    }

    @Override
    protected void process(List<Integer> chunks) {
        int remainingSeconds = chunks.get(chunks.size() - 1);
        // Actualiza la interfaz de usuario con el tiempo restante
    }

    @Override
    protected void done() {
        // Actualiza la interfaz de usuario al finalizar la cuenta atrás
    }


}
