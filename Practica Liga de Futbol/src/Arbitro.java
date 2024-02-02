import java.util.Random;

public class Arbitro {
    private String nombre;
    private String colegio;
    private int velocidad;
    private int acierto;
    private boolean estaActivo;

    public Arbitro(String nombre, String colegio) {
        this.nombre = nombre;
        this.colegio = colegio;
        this.velocidad = generarNumeroAleatorio(0, 100);
        this.acierto = generarNumeroAleatorio(0, 100);
        this.estaActivo = true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColegio() {
        return colegio;
    }

    public void setColegio(String colegio) {
        this.colegio = colegio;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getAcierto() {
        return acierto;
    }

    public void setAcierto(int acierto) {
        this.acierto = acierto;
    }

    public boolean isEstaActivo() {
        return estaActivo;
    }

    public void setEstaActivo(boolean estaActivo) {
        this.estaActivo = estaActivo;
    }

    @Override
    public String toString() {
        return "Arbitro{" +
                "nombre='" + nombre + '\'' +
                ", colegio='" + colegio + '\'' +
                ", velocidad=" + velocidad +
                ", acierto=" + acierto +
                ", estaActivo=" + estaActivo +
                '}';
    }

    private int generarNumeroAleatorio(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
