package sensor;

public class Sensor {

// Constantes del rango permitido
    private static final double HUMEDAD_MINIMA = 0.0;
    private static final double HUMEDAD_MAXIMA = 100.0;

    // Estados del sensor
    private static final String ESTADO_OK    = "OK";
    private static final String ESTADO_ERROR = "Error";

    // Atributos privados
    private String  id;
    private double  humedad;
    private boolean enError;    // true si recibió un valor fuera de rango
    private String  estado;     // "OK" o "Error"

    // ─────────────────────────────────────────────
    // Constructor 1: sin parámetros → valores mínimos seguros
    // ─────────────────────────────────────────────
    public Sensor() {
        this.id       = "SENSOR-0000";
        this.humedad  = HUMEDAD_MINIMA; // 0.0 → valor mínimo válido
        this.enError  = false;
        this.estado   = ESTADO_OK;
    }

    // ─────────────────────────────────────────────
    // Constructor 2: con ID y lectura inicial
    // ─────────────────────────────────────────────
    public Sensor(String id, double humedadInicial) {

        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException(
                "El ID del sensor no puede ser null ni estar vacio"
            );
        }

        this.id      = id.toUpperCase();
        this.enError = false;
        this.estado  = ESTADO_OK;
        this.humedad = HUMEDAD_MINIMA; // valor seguro antes de registrar

        // Registra la lectura inicial → puede marcar error si es inválida
        registrarLectura(humedadInicial);
    }

    // ─────────────────────────────────────────────
    // registrarLectura() → si el valor está fuera de rango
    // marca enError = true y no actualiza la humedad
    // ─────────────────────────────────────────────
    public void registrarLectura(double valor) {

        if (valor < HUMEDAD_MINIMA || valor > HUMEDAD_MAXIMA) {

            // Valor inválido → marca estado de error
            this.enError = true;
            this.estado  = ESTADO_ERROR;
            System.out.println("  ⚠ Lectura fuera de rango: " + valor +
                               "%. Rango válido: " + (int) HUMEDAD_MINIMA +
                               " - " + (int) HUMEDAD_MAXIMA +
                               ". Sensor marcado en ERROR.");

        } else {

            // Valor válido → actualiza humedad y limpia el error
            this.humedad = valor;
            this.enError = false;
            this.estado  = ESTADO_OK;
            System.out.println("  ✓ Lectura registrada: " + valor + "%");
        }
    }

    // ─────────────────────────────────────────────
    // resetearError() → limpia el estado de error
    // y vuelve al último valor seguro (0.0)
    // ─────────────────────────────────────────────
    public void resetearError() {
        if (!enError) {
            System.out.println("  ✗ El sensor no está en estado de error. No hay nada que resetear.");
            return;
        }
        this.humedad = HUMEDAD_MINIMA;
        this.enError = false;
        this.estado  = ESTADO_OK;
        System.out.println("  ✓ Error reseteado. Humedad vuelve a " + HUMEDAD_MINIMA + "%");
    }

    // ─────────────────────────────────────────────
    // Getters
    // ─────────────────────────────────────────────
    public String getId() {
        return id;
    }

    public double getHumedad() {
        return humedad;
    }

    public boolean isEnError() {
        return enError;
    }

    public String getEstado() {
        return estado;
    }

    // toString
    @Override
    public String toString() {
        return "Sensor{"                          +
               "id='"       + id       + "'"     +
               ", humedad="  + humedad  + "%"    +
               ", estado='"  + estado   + "'"    +
               ", enError="  + enError            +
               "}";
    }
    
}
