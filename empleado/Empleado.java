package empleado;

import java.time.LocalDate;

public class Empleado {

// Constante del salario mínimo legal
    private static final double SALARIO_MINIMO = 1000000.0;

    // Atributos privados
    private String cedula;
    private String nombre;
    private double salarioBase;
    private LocalDate fechaContratacion;

    // ─────────────────────────────────────────────
    // Constructor 1: sin parámetros → valores mínimos seguros
    // ─────────────────────────────────────────────
    public Empleado() {
        this.cedula            = "0000000000";
        this.nombre            = "Sin nombre";
        this.salarioBase       = SALARIO_MINIMO;  // mínimo legal
        this.fechaContratacion = LocalDate.now(); // hoy → siempre válido
    }

    // ─────────────────────────────────────────────
    // Constructor 2: con parámetros + validaciones
    // ─────────────────────────────────────────────
    public Empleado(String cedula, String nombre, double salarioBase, LocalDate fechaContratacion) {

        if (cedula == null || cedula.isEmpty()) {
            throw new IllegalArgumentException("La cedula no puede ser null ni estar vacia");
        }
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser null ni estar vacio");
        }

        this.cedula = cedula;
        this.nombre = nombre;

        // Setter para controlar salario mínimo
        setSalarioBase(salarioBase);

        // Setter para controlar que la fecha no sea futura
        setFechaContratacion(fechaContratacion);
    }

    // ─────────────────────────────────────────────
    // Setter salario: no puede ser menor al mínimo legal
    // ─────────────────────────────────────────────
    public void setSalarioBase(double salarioBase) {
        if (salarioBase < SALARIO_MINIMO) {
            throw new IllegalArgumentException(
                "El salario base no puede ser inferior al salario minimo legal ($" + SALARIO_MINIMO + ")"
            );
        }
        this.salarioBase = salarioBase;
    }

    // ─────────────────────────────────────────────
    // Setter fecha: no puede ser una fecha futura
    // ─────────────────────────────────────────────
    public void setFechaContratacion(LocalDate fechaContratacion) {
        if (fechaContratacion == null) {
            throw new IllegalArgumentException("La fecha de contratacion no puede ser null");
        }
        if (fechaContratacion.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException(
                "La fecha de contratacion no puede ser una fecha futura"
            );
        }
        this.fechaContratacion = fechaContratacion;
    }

    // ─────────────────────────────────────────────
    // Getters
    // ─────────────────────────────────────────────
    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public static double getSalarioMinimo() {
        return SALARIO_MINIMO;
    }

    // toString
    @Override
    public String toString() {
        return "Empleado{" +
               "cedula='"           + cedula            + "'" +
               ", nombre='"         + nombre            + "'" +
               ", salarioBase=$"    + salarioBase        +
               ", fechaContratacion=" + fechaContratacion +
               "}";
    }

}
