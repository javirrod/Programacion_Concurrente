package Feedback2_Streams;

public class Ciudad {
    private String nombre;
    private String provincia;
    private int habitantes;
    private double extension;

    public Ciudad(String nombre, String provincia, int habitantes, double extension) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.habitantes = habitantes;
        this.extension = extension;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }

    public double getExtension() {
        return extension;
    }

    public void setExtension(double extension) {
        this.extension = extension;
    }
}
