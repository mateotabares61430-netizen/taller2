package solicitudbeca;

public class SolicitudBeca {

// Constante del promedio mínimo para aprobar
    private static final double PROMEDIO_MINIMO_BECA = 4.5;

    // Estados posibles de la solicitud
    private static final String ESTADO_PENDIENTE = "Pendiente";
    private static final String ESTADO_APROBADA  = "Aprobada";
    private static final String ESTADO_RECHAZADA = "Rechazada";

    // Atributos privados
    private String codigo;
    private String nombreEstudiante;
    private double promedio;
    private String estado;

    // ─────────────────────────────────────────────
    // Constructor 1: sin parámetros → valores mínimos seguros
    // ─────────────────────────────────────────────
    public SolicitudBeca() {
        this.codigo           = "SOL-0000";
        this.nombreEstudiante = "Sin nombre";
        this.promedio         = 0.0;
        this.estado           = ESTADO_PENDIENTE; // siempre inicia Pendiente
    }

    // ─────────────────────────────────────────────
    // Constructor 2: con parámetros + validaciones
    // ─────────────────────────────────────────────
    public SolicitudBeca(String codigo, String nombreEstudiante, double promedio) {

        if (codigo == null || codigo.isEmpty()) {
            throw new IllegalArgumentException("El codigo no puede ser null ni estar vacio");
        }
        if (nombreEstudiante == null || nombreEstudiante.isEmpty()) {
            throw new IllegalArgumentException("El nombre del estudiante no puede ser null ni estar vacio");
        }
        if (promedio < 0.0 || promedio > 5.0) {
            throw new IllegalArgumentException(
                "El promedio debe estar entre 0.0 y 5.0. Valor recibido: " + promedio
            );
        }

        this.codigo           = codigo.toUpperCase();
        this.nombreEstudiante = nombreEstudiante;
        this.promedio         = promedio;
        this.estado           = ESTADO_PENDIENTE; // siempre inicia Pendiente
    }

    // ─────────────────────────────────────────────
    // aprobar() → solo funciona si promedio > 4.5
    // ─────────────────────────────────────────────
    public boolean aprobar() {

        // ¿Ya fue procesada antes?
        if (!estado.equals(ESTADO_PENDIENTE)) {
            System.out.println("  ✗ La solicitud ya fue procesada anteriormente. Estado: " + estado);
            return false;
        }

        // ¿El promedio supera el mínimo requerido?
        if (promedio <= PROMEDIO_MINIMO_BECA) {
            this.estado = ESTADO_RECHAZADA; // no cumple → se rechaza automáticamente
            System.out.println("  ✗ Solicitud RECHAZADA. Promedio " + promedio +
                               " no supera el mínimo de " + PROMEDIO_MINIMO_BECA);
            return false;
        }

        // Cumple todos los requisitos → se aprueba
        this.estado = ESTADO_APROBADA;
        System.out.println("  ✓ Solicitud APROBADA. Promedio " + promedio +
                           " supera el mínimo de " + PROMEDIO_MINIMO_BECA);
        return true;
    }

    // ─────────────────────────────────────────────
    // estaAprobada() → true solo si el estado es Aprobada
    // ─────────────────────────────────────────────
    public boolean estaAprobada() {
        return this.estado.equals(ESTADO_APROBADA);
    }

    // ─────────────────────────────────────────────
    // Getters
    // ─────────────────────────────────────────────
    public String getCodigo() {
        return codigo;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public double getPromedio() {
        return promedio;
    }

    public String getEstado() {
        return estado;
    }

    public static double getPromedioMinimoBeca() {
        return PROMEDIO_MINIMO_BECA;
    }

    // toString
    @Override
    public String toString() {
        return "SolicitudBeca{"                                          +
               "codigo='"           + codigo           + "'"            +
               ", estudiante='"     + nombreEstudiante + "'"            +
               ", promedio="        + promedio                          +
               ", estado='"         + estado           + "'"            +
               ", aprobada="        + estaAprobada()                    +
               "}";
    }
    
}
