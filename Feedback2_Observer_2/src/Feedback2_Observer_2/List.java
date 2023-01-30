package Feedback2_Observer_2;
import java.util.ArrayList;
import java.util.Observable;
public class List extends Observable {
    private ArrayList<String> items = new ArrayList<>();

    public void add(String item) {
        items.add(item);
        setChanged();
        notifyObservers();
    }

    public ArrayList<String> getItems() {
        return items;
    }
}