import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TareaSegundoPlano {
    public static void main(String[] args) {
        // Crear la ventana y el panel
        JFrame frame = new JFrame("Tarea en segundo plano");
        JPanel panel = new JPanel();

        // Crear un botón para iniciar la tarea en segundo plano
        JButton button = new JButton("Iniciar tarea");
        button.addActionListener(event -> {
            // Crear una instancia de la clase Tarea y llamar al método start() para iniciar el hilo
            Tarea tarea = new Tarea();
            tarea.start();
        });

        // Añadir el botón al panel y la panel a la ventana
        panel.add(button);
        frame.add(panel);

        // Hacer la ventana visible
        frame.pack();
        frame.setVisible(true);
    }
}

class Tarea extends Thread {
    @Override
    public void run() {
        // Este código se ejecutará en un hilo independiente
        System.out.println("Iniciando tarea en segundo plano...");
        try {
            Thread.sleep(5000); // simular una tarea que tarda 5 segundos
            System.out.println("Tarea finalizada");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

