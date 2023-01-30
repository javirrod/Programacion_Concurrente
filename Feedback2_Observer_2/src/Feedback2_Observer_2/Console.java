package Feedback2_Observer_2;
import java.util.Observable;
import java.util.Observer;
public class Console implements Observer {
public void update(Observable o, Object arg) {
        List lista = (List) o;
        System.out.println("Eventos del partido:");
        for (String item : lista.getItems()) {
        System.out.println(item);
        }
        }
        }