package vuelo;

public class Vuelo {

// Constante de capacidad máxima fija
    private static final int CAPACIDAD_MAXIMA = 150;

    // Atributos privados
    private String numeroVuelo;
    private String origen;
    private String destino;
    private int asientosReservados;

    // ─────────────────────────────────────────────
    // Constructor 1: sin parámetros → valores mínimos seguros
    // ─────────────────────────────────────────────
    public Vuelo() {
        this.numeroVuelo       = "AA000";
        this.origen            = "Sin origen";
        this.destino           = "Sin destino";
        this.asientosReservados = 0;
    }

    // ─────────────────────────────────────────────
    // Constructor 2: con parámetros + validaciones
    // ─────────────────────────────────────────────
    public Vuelo(String numeroVuelo, String origen, String destino) {

        if (numeroVuelo == null || numeroVuelo.isEmpty()) {
            throw new IllegalArgumentException("El numero de vuelo no puede ser null ni estar vacio");
        }
        if (origen == null || origen.isEmpty()) {
            throw new IllegalArgumentException("El origen no puede ser null ni estar vacio");
        }
        if (destino == null || destino.isEmpty()) {
            throw new IllegalArgumentException("El destino no puede ser null ni estar vacio");
        }
        if (origen.equalsIgnoreCase(destino)) {
            throw new IllegalArgumentException("El origen y el destino no pueden ser iguales");
        }

        this.numeroVuelo        = numeroVuelo.toUpperCase();
        this.origen             = origen;
        this.destino            = destino;
        this.asientosReservados = 0; // siempre inicia vacío
    }

    // ─────────────────────────────────────────────
    // reservar(int cantidad) → falla si el avión ya está lleno
    // o si la cantidad supera los asientos disponibles
    // ─────────────────────────────────────────────
    public boolean reservar(int cantidad) {

        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad de asientos a reservar debe ser mayor a 0");
        }

        // ¿El avión ya está lleno?
        if (estaLleno()) {
            System.out.println("  ✗ Vuelo " + numeroVuelo + " lleno. No hay asientos disponibles.");
            return false;
        }

        // ¿Hay suficientes asientos para la cantidad pedida?
        if (cantidad > asientosDisponibles()) {
            System.out.println("  ✗ Solo quedan " + asientosDisponibles() +
                               " asiento(s). No se pueden reservar " + cantidad + ".");
            return false;
        }

        // Reserva exitosa
        this.asientosReservados += cantidad;
        System.out.println("  ✓ Reserva exitosa de " + cantidad +
                           " asiento(s). Disponibles: " + asientosDisponibles());
        return true;
    }

    // ─────────────────────────────────────────────
    // asientosDisponibles() → cuántos quedan libres
    // ─────────────────────────────────────────────
    public int asientosDisponibles() {
        return CAPACIDAD_MAXIMA - asientosReservados;
    }

    // ─────────────────────────────────────────────
    // estaLleno() → true si no queda ningún asiento
    // ─────────────────────────────────────────────
    public boolean estaLleno() {
        return asientosReservados >= CAPACIDAD_MAXIMA;
    }

    // ─────────────────────────────────────────────
    // Getters
    // ─────────────────────────────────────────────
    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public int getAsientosReservados() {
        return asientosReservados;
    }

    public static int getCapacidadMaxima() {
        return CAPACIDAD_MAXIMA;
    }

    // toString
    @Override
    public String toString() {
        return "Vuelo{"                                              +
               "numero='"           + numeroVuelo           + "'"  +
               ", ruta='"           + origen                        +
               " → "                + destino               + "'"  +
               ", reservados="      + asientosReservados            +
               "/" + CAPACIDAD_MAXIMA                               +
               ", disponibles="     + asientosDisponibles()         +
               ", lleno="           + estaLleno()                   +
               "}";
    }
    
}
