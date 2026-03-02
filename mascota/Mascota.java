package mascota;

public class Mascota {

// Constante de edad máxima permitida (30 años en meses)
    private static final int EDAD_MAXIMA_MESES = 360; // 30 * 12

    // Atributos privados
    private String nombre;
    private int    edadEnMeses; // siempre se guarda en meses internamente

    // ─────────────────────────────────────────────
    // Constructor 1: sin parámetros → valores mínimos seguros
    // ─────────────────────────────────────────────
    public Mascota() {
        this.nombre      = "Sin nombre";
        this.edadEnMeses = 1; // mínimo válido (> 0)
    }

    // ─────────────────────────────────────────────
    // Constructor 2: nombre + edad en MESES
    // Ej: new Mascota("Luna", 6) → 6 meses
    // ─────────────────────────────────────────────
    public Mascota(String nombre, int meses) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser null ni estar vacio");
        }
        this.nombre = nombre;

        // Setter valida que los meses sean correctos
        setEdadEnMeses(meses);
    }

    // ─────────────────────────────────────────────
    // Constructor 3: nombre + edad en AÑOS y MESES
    // Ej: new Mascota("Luna", 2, 3) → 27 meses
    // ─────────────────────────────────────────────
    public Mascota(String nombre, int anios, int meses) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser null ni estar vacio");
        }
        if (anios < 0) {
            throw new IllegalArgumentException("Los años no pueden ser negativos");
        }
        if (meses < 0 || meses > 11) {
            throw new IllegalArgumentException(
                "Los meses deben estar entre 0 y 11. Valor recibido: " + meses
            );
        }

        this.nombre = nombre;

        // Convierte años + meses a meses totales y valida
        setEdadEnMeses((anios * 12) + meses);
    }

    // ─────────────────────────────────────────────
    // Setter edadEnMeses: debe ser > 0 y <= EDAD_MAXIMA_MESES
    // ─────────────────────────────────────────────
    private void setEdadEnMeses(int meses) {
        if (meses <= 0) {
            throw new IllegalArgumentException(
                "La edad debe ser mayor a 0 meses. Valor recibido: " + meses
            );
        }
        if (meses > EDAD_MAXIMA_MESES) {
            throw new IllegalArgumentException(
                "La edad no puede superar " + EDAD_MAXIMA_MESES +
                " meses (30 años). Valor recibido: " + meses
            );
        }
        this.edadEnMeses = meses;
    }

    // ─────────────────────────────────────────────
    // getEdadEnMeses() → devuelve la edad en meses
    // ─────────────────────────────────────────────
    public int getEdadEnMeses() {
        return edadEnMeses;
    }

    // ─────────────────────────────────────────────
    // getEdadEnAnios() → devuelve solo los años completos
    // Ej: 27 meses → 2 años
    // ─────────────────────────────────────────────
    public int getEdadEnAnios() {
        return edadEnMeses / 12;
    }

    // ─────────────────────────────────────────────
    // getMesesRestantes() → meses sobrantes después de los años
    // Ej: 27 meses → 3 meses restantes
    // ─────────────────────────────────────────────
    public int getMesesRestantes() {
        return edadEnMeses % 12;
    }

    // ─────────────────────────────────────────────
    // Getter nombre
    // ─────────────────────────────────────────────
    public String getNombre() {
        return nombre;
    }

    // toString → muestra edad en ambos formatos
    @Override
    public String toString() {
        return String.format(
            "Mascota{ nombre='%s', edad=%d meses (%d años y %d meses) }",
            nombre,
            edadEnMeses,
            getEdadEnAnios(),
            getMesesRestantes()
        );
    }
    
}
