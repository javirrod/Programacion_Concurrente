package Feedback2_Observer_1;

public class AvionPerseguidor implements Observer {
    private int altura;
    private int velocidad;
    private int direccion;

    @Override
    public void update(Avion avion) {
        setAltura(avion.getAltura());
        setVelocidad(avion.getVelocidad());
        setDireccion(avion.getDireccion());
    }

    public int getAltura() {
        return altura;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }
}
