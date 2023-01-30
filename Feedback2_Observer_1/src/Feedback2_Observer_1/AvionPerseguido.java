package Feedback2_Observer_1;

import java.util.ArrayList;
import java.util.List;

public class AvionPerseguido extends Avion {
    private List<Observer> observadores = new ArrayList<>();

    public AvionPerseguido(int altura, int velocidad, int direccion) {
        super(altura, velocidad, direccion);
    }

    public void addObserver(Observer observer) {
        observadores.add(observer);
    }

    public void removeObserver(Observer observer) {
        observadores.remove(observer);
    }

    public void notificarObservadores() {
        for (Observer observer : observadores) {
            observer.update(this);
        }
    }

    @Override
    public void setAltura(int altura) {
        super.setAltura(altura);
        notificarObservadores();
    }

    @Override
    public void setVelocidad(int velocidad) {
        super.setVelocidad(velocidad);
        notificarObservadores();
    }

    @Override
    public void setDireccion(int direccion) {
        super.setDireccion(direccion);
        notificarObservadores();
    }
}
