package termostato;

public class Termostato {

// Atributos privados
    private String nombre;
    private double temperatura;

    // Constantes del rango permitido
    private static final double TEMP_MINIMA = 15.0;
    private static final double TEMP_MAXIMA = 30.0;

    
    // Constructor 1: sin parámetros → valores mínimos seguros
    
    public Termostato() {
        this.nombre      = "Termostato default";
        this.temperatura = TEMP_MINIMA; // 15.0 → valor mínimo válido
    }

    
    // Constructor 2: con parámetros + validaciones
   
    public Termostato(String nombre, double temperaturaInicial) {

        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser null ni estar vacio");
        }

        this.nombre = nombre;
        this.temperatura = TEMP_MINIMA; // valor seguro antes de usar el setter

        // setter para validar la temperatura inicial
        // Si es inválida, se mantiene TEMP_MINIMA (último valor válido)
        setTemperatura(temperaturaInicial);
    }

    // ─────────────────────────────────────────────
    // Setter con lógica especial:
    // Si el valor está fuera del rango → mantiene el último valor válido
    // ─────────────────────────────────────────────
    public void setTemperatura(double nuevaTemperatura) {
        if (nuevaTemperatura >= TEMP_MINIMA && nuevaTemperatura <= TEMP_MAXIMA) {
            this.temperatura = nuevaTemperatura; // valor válido → se actualiza
        } else {
            // valor inválido → se mantiene el último valor válido (no se cambia nada)
            System.out.println("  ⚠ Temperatura " + nuevaTemperatura + "°C fuera de rango." +
                               " Se mantiene: " + this.temperatura + "°C");
        }
    }

  
    // Getters

    public String getNombre() {
        return nombre;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public double getTempMinima() {
        return TEMP_MINIMA;
    }

    public double getTempMaxima() {
        return TEMP_MAXIMA;
    }

    // toString
    @Override
    public String toString() {
        return "Termostato{" +
               "nombre='"      + nombre      + "'" +
               ", temperatura=" + temperatura + "°C" +
               ", rango=["      + TEMP_MINIMA + "°C - " + TEMP_MAXIMA + "°C]" +
               "}";
    }
    
}
