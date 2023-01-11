import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class Countdown {
    private static int seconds;
    private static JFrame frame;
    private static JPanel panel;
    private static JLabel label;
    private static JProgressBar progressBar;
    private static Timer timer;

    public static void main(String[] args) {
        // Pedir al usuario que introduzca la cantidad de segundos
        String input = JOptionPane.showInputDialog("Introduce la cantidad de segundos:");
        seconds = Integer.parseInt(input);

        // Crear la ventana y el panel
        frame = new JFrame("Cuenta atrás");
        panel = new JPanel();

        // Crear la etiqueta de texto y la barra de progreso
        label = new JLabel("Tiempo restante: " + seconds + " segundos");
        progressBar = new JProgressBar(0, seconds);
        progressBar.setValue(seconds);

        // Añadir la etiqueta y la barra de progreso al panel
        panel.add(label);
        panel.add(progressBar);

        // Añadir el panel a la ventana y hacerla visible
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

        // Crear un temporizador para actualizar la cuenta atrás
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Decrementar el tiempo restante y actualizar la barra de progreso y la etiqueta
                seconds--;
                progressBar.setValue(seconds);
                label.setText("Tiempo restante: " + seconds + " segundos");

                // Si el tiempo se ha agotado, detener el temporizador y mostrar un mensaje
                if (seconds == 0) {
                    timer.stop();
                    JOptionPane.showMessageDialog(frame, "¡Tiempo agotado!");
                }
            }
        });

        // Iniciar el temporizador
        timer.start();
    }
}