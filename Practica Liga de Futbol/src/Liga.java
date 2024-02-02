import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Liga {
    private ArrayList<Object> listaPer = new ArrayList<>();

    public static void main(String[] args) {
        Liga liga = new Liga();
        liga.menu();
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- T6-Ligafutbol ---");
            System.out.println("1) Insertar jugador");
            System.out.println("2) Insertar árbitro");
            System.out.println("3) Mostrar todo");
            System.out.println("4) Ordenar personas por velocidad (recursivo)");
            System.out.println("5) Mostrar solo jugadores");
            System.out.println("6) Buscar persona por nombre (iterativo)");
            System.out.println("7) Buscar persona por nombre (recursivo)");
            System.out.println("8) Jugador con más regate (iterativo)");
            System.out.println("9) Suma de todas las velocidades (recursivo)");
            System.out.println("0) Salir");

            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    insertaJugador();
                    break;
                case 2:
                    insertaArbitro();
                    break;
                case 3:
                    mostrarTodo();
                    break;
                case 4:
                    ordenaPerVeloRecursivo();
                    break;
                case 5:
                    mostrarSoloJugadores();
                    break;
                case 6:
                    buscarPersona();
                    break;
                case 7:
                    buscarPersonaRecursivo();
                    break;
                case 8:
                    jugadorMasRegate();
                    break;
                case 9:
                    sumaVelocidadesRecursivo();
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 0);
    }

    public void insertaJugador() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nombre del jugador: ");
        String nombre = scanner.nextLine();
        System.out.print("Posición del jugador: ");
        String posicion = scanner.nextLine();

        Jugador jugador = new Jugador(nombre, posicion);
        listaPer.add(jugador);
        System.out.println("Jugador insertado correctamente.");
    }

    public void insertaArbitro() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nombre del árbitro: ");
        String nombre = scanner.nextLine();
        System.out.print("Colegio del árbitro: ");
        String colegio = scanner.nextLine();

        Arbitro arbitro = new Arbitro(nombre, colegio);
        listaPer.add(arbitro);
        System.out.println("Árbitro insertado correctamente.");
    }

    public void mostrarTodo() {
        for (Object persona : listaPer) {
            System.out.println(persona.toString());
        }
    }

    public void ordenaPerVeloRecursivo() {
        ordenaPerVeloRecursivoAux(0);
        System.out.println("Personas ordenadas por velocidad (recursivo).");
    }

    private void ordenaPerVeloRecursivoAux(int index) {
        if (index < listaPer.size() - 1) {
            for (int i = index + 1; i < listaPer.size(); i++) {
                if (getVelocidadPersona(index) > getVelocidadPersona(i)) {
                    Collections.swap(listaPer, index, i);
                }
            }
            ordenaPerVeloRecursivoAux(index + 1);
        }
    }

    private int getVelocidadPersona(int index) {
        Object persona = listaPer.get(index);
        if (persona instanceof Jugador) {
            return ((Jugador) persona).getVelocidad();
        } else {
            return ((Arbitro) persona).getVelocidad();
        }
    }

    public void mostrarSoloJugadores() {
        for (Object persona : listaPer) {
            if (persona instanceof Jugador) {
                System.out.println(persona.toString());
            }
        }
    }

    public void buscarPersona() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre a buscar: ");
        String nombreBuscar = scanner.nextLine();

        for (Object persona : listaPer) {
            if (persona instanceof Jugador) {
                if (((Jugador) persona).getNombre().equalsIgnoreCase(nombreBuscar)) {
                    System.out.println("Jugador encontrado:\n" + persona.toString());
                    return;
                }
            } else if (persona instanceof Arbitro) {
                if (((Arbitro) persona).getNombre().equalsIgnoreCase(nombreBuscar)) {
                    System.out.println("Árbitro encontrado:\n" + persona.toString());
                    return;
                }
            }
        }

        System.out.println("Persona no encontrada.");
    }

    public void buscarPersonaRecursivo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre a buscar: ");
        String nombreBuscar = scanner.nextLine();

        int index = buscarPersonaRecursivoAux(nombreBuscar, 0);
        if (index != -1) {
            System.out.println("Persona encontrada:\n" + listaPer.get(index).toString());
        } else {
            System.out.println("Persona no encontrada.");
        }
    }

    private int buscarPersonaRecursivoAux(String nombreBuscar, int index) {
        if (index < listaPer.size()) {
            Object persona = listaPer.get(index);
            if (persona instanceof Jugador) {
                if (((Jugador) persona).getNombre().equalsIgnoreCase(nombreBuscar)) {
                    return index;
                }
            } else if (persona instanceof Arbitro) {
                if (((Arbitro) persona).getNombre().equalsIgnoreCase(nombreBuscar)) {
                    return index;
                }
            }
            return buscarPersonaRecursivoAux(nombreBuscar, index + 1);
        } else {
            return -1;
        }
    }

    public void jugadorMasRegate() {
        int maxRegate = -1;
        Jugador jugadorMasRegate = null;

        for (Object persona : listaPer) {
            if (persona instanceof Jugador) {
                if (((Jugador) persona).getRegate() > maxRegate) {
                    maxRegate = ((Jugador) persona).getRegate();
                    jugadorMasRegate = (Jugador) persona;
                }
            }
        }

        if (jugadorMasRegate != null) {
            System.out.println("Jugador con más regate:\n" + jugadorMasRegate.toString());
        } else {
            System.out.println("No hay jugadores registrados.");
        }
    }

    public void sumaVelocidadesRecursivo() {
        int sumaVelocidades = sumaVelocidadesRecursivoAux(0);
        System.out.println("La suma de todas las velocidades es: " + sumaVelocidades);
    }

    private int sumaVelocidadesRecursivoAux(int index) {
        if (index < listaPer.size()) {
            Object persona = listaPer.get(index);
            int velocidadActual = 0;
            if (persona instanceof Jugador) {
                velocidadActual = ((Jugador) persona).getVelocidad();
            } else if (persona instanceof Arbitro) {
                velocidadActual = ((Arbitro) persona).getVelocidad();
            }
            return velocidadActual + sumaVelocidadesRecursivoAux(index + 1);
        } else {
            return 0;
        }
    }
}
