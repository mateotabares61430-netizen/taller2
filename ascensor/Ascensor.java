package ascensor;

public class Ascensor {

// Constantes de límites (con sótanos)
    private static final int PISO_MINIMO = -2;
    private static final int PISO_MAXIMO = 15;

    // Atributos privados
    private String edificio;
    private int pisoActual;
    private boolean enMovimiento;

    // ─────────────────────────────────────────────
    // Constructor 1: sin parámetros → valores mínimos seguros
    // ─────────────────────────────────────────────
    public Ascensor() {
        this.edificio     = "Edificio default";
        this.pisoActual   = 0;       // planta baja
        this.enMovimiento = false;   // quieto al inicio
    }

    // ─────────────────────────────────────────────
    // Constructor 2: con nombre de edificio y piso inicial
    // ─────────────────────────────────────────────
    public Ascensor(String edificio, int pisoInicial) {

        if (edificio == null || edificio.isEmpty()) {
            throw new IllegalArgumentException("El nombre del edificio no puede ser null ni estar vacio");
        }

        this.edificio     = edificio;
        this.enMovimiento = false;

        // Setter para validar el piso inicial
        setPisoActual(pisoInicial);
    }

    // ─────────────────────────────────────────────
    // Setter pisoActual: debe estar entre PISO_MINIMO y PISO_MAXIMO
    // ─────────────────────────────────────────────
    private void setPisoActual(int piso) {
        if (piso < PISO_MINIMO || piso > PISO_MAXIMO) {
            throw new IllegalArgumentException(
                "El piso " + piso + " no existe. Rango válido: " +
                PISO_MINIMO + " al " + PISO_MAXIMO
            );
        }
        this.pisoActual = piso;
    }

    // ─────────────────────────────────────────────
    // irAPiso() → solo se mueve si el piso es válido
    // ─────────────────────────────────────────────
    public boolean irAPiso(int piso) {

        // ¿El piso está fuera del rango?
        if (piso < PISO_MINIMO || piso > PISO_MAXIMO) {
            System.out.println("  ✗ Piso " + piso + " inválido. Rango permitido: " +
                               PISO_MINIMO + " al " + PISO_MAXIMO);
            return false;
        }

        // ¿Ya está en ese piso?
        if (piso == this.pisoActual) {
            System.out.println("  ✗ Ya estás en el piso " + piso + ". No hay movimiento.");
            return false;
        }

        // Movimiento válido
        String direccion = piso > this.pisoActual ? "↑ Subiendo" : "↓ Bajando";
        System.out.println("  " + direccion + " desde piso " + pisoActual + " → piso " + piso);
        this.enMovimiento = true;
        this.pisoActual   = piso;
        this.enMovimiento = false;
        return true;
    }

    // ─────────────────────────────────────────────
    // subirPiso() → sube exactamente 1 piso
    // ─────────────────────────────────────────────
    public boolean subirPiso() {

        if (this.pisoActual == PISO_MAXIMO) {
            System.out.println("  ✗ Ya estás en el piso máximo (" + PISO_MAXIMO + "). No puedes subir más.");
            return false;
        }

        this.pisoActual++;
        System.out.println("  ↑ Subió al piso " + this.pisoActual);
        return true;
    }

    // ─────────────────────────────────────────────
    // bajarPiso() → baja exactamente 1 piso
    // ─────────────────────────────────────────────
    public boolean bajarPiso() {

        if (this.pisoActual == PISO_MINIMO) {
            System.out.println("  ✗ Ya estás en el piso mínimo (" + PISO_MINIMO + "). No puedes bajar más.");
            return false;
        }

        this.pisoActual--;
        System.out.println("  ↓ Bajó al piso " + this.pisoActual);
        return true;
    }

    // ─────────────────────────────────────────────
    // Getters
    // ─────────────────────────────────────────────
    public String getEdificio() {
        return edificio;
    }

    public int getPisoActual() {
        return pisoActual;
    }

    public boolean isEnMovimiento() {
        return enMovimiento;
    }

    public int getPisoMinimo() {
        return PISO_MINIMO;
    }

    public int getPisoMaximo() {
        return PISO_MAXIMO;
    }

    // toString
    @Override
    public String toString() {
        // Muestra "Sótano 1", "Sótano 2" para pisos negativos
        String descripcionPiso;
        if (pisoActual < 0) {
            descripcionPiso = "Sotano " + Math.abs(pisoActual);
        } else if (pisoActual == 0) {
            descripcionPiso = "Planta baja";
        } else {
            descripcionPiso = "Piso " + pisoActual;
        }

        return "Ascensor{" +
               "edificio='"      + edificio       + "'" +
               ", pisoActual="   + pisoActual      +
               " (" + descripcionPiso + ")"        +
               ", rango=["       + PISO_MINIMO     +
               " al "            + PISO_MAXIMO     + "]" +
               "}";
    }
    
}
