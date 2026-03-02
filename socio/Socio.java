package socio;

public class Socio {

private String nombre;
    private String tipoMembresia;

    // 🔹 Constructor 1: Valores mínimos (no nulos)
    public Socio() {
        this.nombre = "Sin nombre";
        this.tipoMembresia = "Bronce"; // valor mínimo válido
    }

    // 🔹 Constructor 2: Con parámetros
    public Socio(String nombre, String tipoMembresia) {
        this.nombre = nombre;
        setTipoMembresia(tipoMembresia); // usamos el setter para validar
    }

    // Getter
    public String getTipoMembresia() {
        return tipoMembresia;
    }

    public String getNombre() {
        return nombre;
    }

    // 🔹 Setter con validación
    public void setTipoMembresia(String tipoMembresia) {

        if (tipoMembresia == null) {
            throw new IllegalArgumentException("El tipo de membresía no puede ser nulo.");
        }

        if (tipoMembresia.equals("Bronce") ||
            tipoMembresia.equals("Plata") ||
            tipoMembresia.equals("Oro")) {

            this.tipoMembresia = tipoMembresia;

        } else {
            throw new IllegalArgumentException(
                "Tipo de membresía inválido. Solo se permite: Bronce, Plata u Oro."
            );
        }
    }

    @Override
    public String toString() {
        return "Socio [nombre=" + nombre + ", tipoMembresia=" + tipoMembresia + "]";
    }
    
}
