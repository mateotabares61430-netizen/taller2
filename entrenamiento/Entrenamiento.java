package entrenamiento;

public class Entrenamiento {

// Constante de tiempo máximo permitido (24 horas en minutos)
    private static final int TIEMPO_MAXIMO_MINUTOS = 1440; // 24 * 60

    // Atributos privados
    private String nombre;
    private int    tiempoEnMinutos; // siempre se guarda en minutos

    // ─────────────────────────────────────────────
    // Constructor 1: sin parámetros → valores mínimos seguros
    // ─────────────────────────────────────────────
    public Entrenamiento() {
        this.nombre          = "Entrenamiento default";
        this.tiempoEnMinutos = 1; // mínimo válido (> 0)
    }

    // ─────────────────────────────────────────────
    // Constructor 2: nombre + tiempo en MINUTOS TOTALES
    // Ej: new Entrenamiento("Cardio", 90) → 90 minutos
    // ─────────────────────────────────────────────
    public Entrenamiento(String nombre, int minutosTotales) {

        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser null ni estar vacio");
        }

        this.nombre = nombre;

        // Setter para validar los minutos
        setTiempoEnMinutos(minutosTotales);
    }

    // ─────────────────────────────────────────────
    // Constructor 3: nombre + tiempo en HORAS y MINUTOS
    // Ej: new Entrenamiento("Cardio", 1, 30) → 90 minutos
    // ─────────────────────────────────────────────
    public Entrenamiento(String nombre, int horas, int minutos) {

        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser null ni estar vacio");
        }
        if (horas < 0) {
            throw new IllegalArgumentException("Las horas no pueden ser negativas");
        }
        if (minutos < 0 || minutos > 59) {
            throw new IllegalArgumentException("Los minutos deben estar entre 0 y 59");
        }

        this.nombre = nombre;

        // Convierte horas + minutos a minutos totales y valida
        setTiempoEnMinutos((horas * 60) + minutos);
    }

    // ─────────────────────────────────────────────
    // Setter tiempo: debe ser > 0 y <= TIEMPO_MAXIMO
    // ─────────────────────────────────────────────
    private void setTiempoEnMinutos(int minutos) {
        if (minutos <= 0) {
            throw new IllegalArgumentException(
                "El tiempo debe ser mayor a 0 minutos. Valor recibido: " + minutos
            );
        }
        if (minutos > TIEMPO_MAXIMO_MINUTOS) {
            throw new IllegalArgumentException(
                "El tiempo no puede superar " + TIEMPO_MAXIMO_MINUTOS +
                " minutos (24 horas). Valor recibido: " + minutos
            );
        }
        this.tiempoEnMinutos = minutos;
    }

    // ─────────────────────────────────────────────
    // Getters
    // ─────────────────────────────────────────────
    public String getNombre() {
        return nombre;
    }

    public int getTiempoEnMinutos() {
        return tiempoEnMinutos;
    }

    // Devuelve las horas completas del tiempo guardado
    public int getHoras() {
        return tiempoEnMinutos / 60;
    }

    // Devuelve los minutos restantes después de las horas
    public int getMinutosRestantes() {
        return tiempoEnMinutos % 60;
    }

    // toString → muestra el tiempo en ambos formatos
    @Override
    public String toString() {
        return String.format(
            "Entrenamiento{ nombre='%s', tiempo=%d min (%dh %02dm) }",
            nombre,
            tiempoEnMinutos,
            getHoras(),
            getMinutosRestantes()
        );
    }
    
}
