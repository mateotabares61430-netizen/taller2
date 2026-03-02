package estudiante;

public class Estudiante {

// Constantes del rango permitido
    private static final double PROMEDIO_MINIMO = 0.0;
    private static final double PROMEDIO_MAXIMO = 5.0;
    private static final double PROMEDIO_APROBACION = 3.0;

    // Atributos privados
    private String codigo;
    private String nombre;
    private double promedio;

    // ─────────────────────────────────────────────
    // Constructor 1: sin parámetros → valores mínimos seguros
    // ─────────────────────────────────────────────
        public Estudiante() {
        this.codigo   = "0000";
        this.nombre   = "Sin nombre";
        this.promedio = PROMEDIO_MINIMO; // 0.0 → valor mínimo válido
        }

    // ─────────────────────────────────────────────
    // Constructor 2: con parámetros + validaciones
    // ─────────────────────────────────────────────
    public Estudiante(String codigo, String nombre, double promedio) {

        if (codigo == null || codigo.isEmpty()) {
            throw new IllegalArgumentException("El codigo no puede ser null ni estar vacio");
        }
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser null ni estar vacio");
        }

        this.codigo   = codigo;
        this.nombre   = nombre;

        // Setter para validar que el promedio esté en rango 0.0 - 5.0
        setPromedio(promedio);
    }

    // ─────────────────────────────────────────────
    // Setter promedio: debe estar entre 0.0 y 5.0
    // ─────────────────────────────────────────────
    private void setPromedio(double promedio) {
        if (promedio < PROMEDIO_MINIMO || promedio > PROMEDIO_MAXIMO) {
            throw new IllegalArgumentException(
                "El promedio debe estar entre " + PROMEDIO_MINIMO +
                " y " + PROMEDIO_MAXIMO + ". Valor recibido: " + promedio
            );
        }
        this.promedio = promedio;
    }

    // ─────────────────────────────────────────────
    // actualizarPromedio() → valida y actualiza el promedio
    // ─────────────────────────────────────────────
    public void actualizarPromedio(double nuevoPromedio) {
        setPromedio(nuevoPromedio); // reutiliza la validación del setter
        System.out.println("  Promedio actualizado a: " + this.promedio);
    }

    // ─────────────────────────────────────────────
    // estaAprobado() → true si promedio >= 3.0
    // ─────────────────────────────────────────────
    public boolean estaAprobado() {
        return this.promedio >= PROMEDIO_APROBACION;
    }

    // ─────────────────────────────────────────────
    // obtenerNota() → devuelve la nota en texto según el promedio
    // ─────────────────────────────────────────────
    public String obtenerNota() {
        if (promedio >= 4.5) return "Excelente";
        if (promedio >= 4.0) return "Sobresaliente";
        if (promedio >= 3.5) return "Bueno";
        if (promedio >= 3.0) return "Aceptable";
        if (promedio >= 2.0) return "Insuficiente";
        return "Reprobado";
    }

    // ─────────────────────────────────────────────
    // Getters
    // ─────────────────────────────────────────────
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPromedio() {
        return promedio;
    }

    // toString
    @Override
    public String toString() {
        return "Estudiante{" +
               "codigo='"   + codigo   + "'"   +
               ", nombre='" + nombre   + "'"   +
               ", promedio=" + promedio         +
               ", nota='"   + obtenerNota() + "'" +
               ", aprobado=" + estaAprobado()   +
               "}";
    }
    
}
