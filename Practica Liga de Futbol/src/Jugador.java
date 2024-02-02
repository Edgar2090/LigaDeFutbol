import java.util.Random;

public class Jugador {
    private String nombre;
    private String posicion;
    private int velocidad;
    private int regate;
    private boolean estaLesionado;

    public Jugador(String nombre, String posicion) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.velocidad = generarNumeroAleatorio(0, 100);
        this.regate = generarNumeroAleatorio(0, 100);
        this.estaLesionado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getRegate() {
        return regate;
    }

    public void setRegate(int regate) {
        this.regate = regate;
    }

    public boolean isEstaLesionado() {
        return estaLesionado;
    }

    public void setEstaLesionado(boolean estaLesionado) {
        this.estaLesionado = estaLesionado;
    }

    @Override
    public String toString() {
        return "Jugador" +
                "nombre='" + nombre + '\'' +
                ", posicion='" + posicion + '\'' +
                ", velocidad=" + velocidad +
                ", regate=" + regate +
                ", estaLesionado=" + estaLesionado +
                ' ';
    }

    private int generarNumeroAleatorio(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}

