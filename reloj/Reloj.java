package reloj;

public class Reloj {

// Constantes de límites
    private static final int MAX_HORAS   = 23;
    private static final int MAX_MINUTOS = 59;
    private static final int MAX_SEGUNDOS = 59;

    // Atributos privados
    private int horas;
    private int minutos;
    private int segundos;

    // ─────────────────────────────────────────────
    // Constructor 1: sin parámetros → 00:00:00
    // ─────────────────────────────────────────────
    public Reloj() {
        this.horas    = 0;
        this.minutos  = 0;
        this.segundos = 0;
    }

    // ─────────────────────────────────────────────
    // Constructor 2: con parámetros + validaciones
    // ─────────────────────────────────────────────
    public Reloj(int horas, int minutos, int segundos) {
        setHoras(horas);
        setMinutos(minutos);
        setSegundos(segundos);
    }

    // ─────────────────────────────────────────────
    // Setters con validación
    // ─────────────────────────────────────────────
    public void setHoras(int horas) {
        if (horas < 0 || horas > MAX_HORAS) {
            throw new IllegalArgumentException(
                "Las horas deben estar entre 0 y " + MAX_HORAS + ". Valor recibido: " + horas
            );
        }
        this.horas = horas;
    }

    public void setMinutos(int minutos) {
        if (minutos < 0 || minutos > MAX_MINUTOS) {
            throw new IllegalArgumentException(
                "Los minutos deben estar entre 0 y " + MAX_MINUTOS + ". Valor recibido: " + minutos
            );
        }
        this.minutos = minutos;
    }

    public void setSegundos(int segundos) {
        if (segundos < 0 || segundos > MAX_SEGUNDOS) {
            throw new IllegalArgumentException(
                "Los segundos deben estar entre 0 y " + MAX_SEGUNDOS + ". Valor recibido: " + segundos
            );
        }
        this.segundos = segundos;
    }

    // ─────────────────────────────────────────────
    // incrementarSegundo() → actualiza minutos y horas si es necesario
    // ─────────────────────────────────────────────
    public void incrementarSegundo() {
        this.segundos++;

        // ¿Se pasó de 59 segundos? → reinicia y sube un minuto
        if (this.segundos > MAX_SEGUNDOS) {
            this.segundos = 0;
            this.minutos++;

            // ¿Se pasó de 59 minutos? → reinicia y sube una hora
            if (this.minutos > MAX_MINUTOS) {
                this.minutos = 0;
                this.horas++;

                // ¿Se pasó de 23 horas? → reinicia el reloj a 00:00:00
                if (this.horas > MAX_HORAS) {
                    this.horas = 0;
                }
            }
        }
    }

    // ─────────────────────────────────────────────
    // incrementarN(int n) → incrementa N segundos de una vez
    // ─────────────────────────────────────────────
    public void incrementarSegundos(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("El valor a incrementar debe ser mayor a 0");
        }
        for (int i = 0; i < n; i++) {
            incrementarSegundo();
        }
    }

    // ─────────────────────────────────────────────
    // Getters
    // ─────────────────────────────────────────────
    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    // ─────────────────────────────────────────────
    // toString → formato HH:MM:SS con ceros a la izquierda
    // ─────────────────────────────────────────────
    @Override
    public String toString() {
        return String.format("Reloj{ %02d:%02d:%02d }", horas, minutos, segundos);
    }
    
}
