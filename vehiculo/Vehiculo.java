package vehiculo;

public class Vehiculo {

// Atributos privados
    private String placa;
    private String propietario;

    // ─────────────────────────────────────────────
    // Constructor 1: sin parámetros → valores mínimos seguros
    // ─────────────────────────────────────────────
    public Vehiculo() {
        this.placa       = "AAA000"; // formato válido por defecto
        this.propietario = "Sin propietario";
    }

    // ─────────────────────────────────────────────
    // Constructor 2: con parámetros + validaciones
    // ─────────────────────────────────────────────
    public Vehiculo(String placa, String propietario) {

        if (propietario == null || propietario.isEmpty()) {
            throw new IllegalArgumentException("El propietario no puede ser null ni estar vacio");
        }

        this.propietario = propietario;

        // Usamos el setter para validar y convertir la placa a mayúsculas
        setPlaca(placa);
    }

    // ─────────────────────────────────────────────
    // Setter placa: valida formato ABC123 y guarda en mayúsculas
    // ─────────────────────────────────────────────
    public void setPlaca(String placa) {
        if (placa == null || placa.isEmpty()) {
            throw new IllegalArgumentException("La placa no puede ser null ni estar vacia");
        }

        // Convertir a mayúsculas antes de validar
        String placaMayusculas = placa.toUpperCase();

        // Validar formato: exactamente 3 letras seguidas de 3 números
        if (!placaMayusculas.matches("[A-Z]{3}[0-9]{3}")) {
            throw new IllegalArgumentException(
                "La placa '" + placa + "' no tiene el formato valido (3 letras + 3 numeros). Ej: ABC123"
            );
        }

        this.placa = placaMayusculas;
    }

    // ─────────────────────────────────────────────
    // Setter propietario: no puede ser null ni vacío
    // ─────────────────────────────────────────────
    public void cambiarPropietario(String nuevoPropietario) {
        if (nuevoPropietario == null || nuevoPropietario.isEmpty()) {
            throw new IllegalArgumentException("El nuevo propietario no puede ser null ni estar vacio");
        }
        this.propietario = nuevoPropietario;
        System.out.println("  Propietario actualizado a: " + this.propietario);
    }

    // ─────────────────────────────────────────────
    // Getters
    // ─────────────────────────────────────────────
    public String getPlaca() {
        return placa;
    }

    public String getPropietario() {
        return propietario;
    }

    // toString
    @Override
    public String toString() {
        return "Vehiculo{" +
               "placa='"       + placa       + "'" +
               ", propietario='" + propietario + "'" +
               "}";
    }
    
}
