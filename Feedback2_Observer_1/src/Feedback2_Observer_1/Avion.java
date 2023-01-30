package Feedback2_Observer_1;

public class Avion {
    private int altura;
    private int velocidad;
    private int direccion;

    public Avion(int altura, int velocidad, int direccion) {
        this.altura = altura;
        this.velocidad = velocidad;
        this.direccion = direccion;
    }
    //crear constructor vacío
    public Avion() {
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

    public void addObserver(AvionPerseguidor avionPerseguidor) {
    }
}
