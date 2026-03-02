package circulo;

public class Circulo {
    
// Constante de PI
    private static final double PI = Math.PI;

    // Atributos privados
    private String nombre;
    private double radio;

    // ─────────────────────────────────────────────
    // Constructor 1: sin parámetros → valores mínimos seguros
    // ─────────────────────────────────────────────
    public Circulo() {
        this.nombre = "Circulo default";
        this.radio  = 1.0; // mínimo positivo válido
    }

    // ─────────────────────────────────────────────
    // Constructor 2: con parámetros + validaciones
    // ─────────────────────────────────────────────
    public Circulo(String nombre, double radio) {

        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser null ni estar vacio");
        }

        this.nombre = nombre;

        // Setter para validar que el radio sea positivo
        setRadio(radio);
    }

    // ─────────────────────────────────────────────
    // Setter radio: debe ser estrictamente positivo (> 0)
    // NO hay setter para área ni perímetro → se calculan
    // ─────────────────────────────────────────────
    public void setRadio(double radio) {
        if (radio <= 0) {
            throw new IllegalArgumentException(
                "El radio debe ser mayor a 0. Valor recibido: " + radio
            );
        }
        this.radio = radio;
    }

    // ─────────────────────────────────────────────
    // calcularArea() → PI * r²
    // No tiene setter → solo se puede calcular, nunca asignar
    // ─────────────────────────────────────────────
    public double calcularArea() {
        return PI * radio * radio;
    }

    // ─────────────────────────────────────────────
    // calcularPerimetro() → 2 * PI * r
    // ─────────────────────────────────────────────
    public double calcularPerimetro() {
        return 2 * PI * radio;
    }

    // ─────────────────────────────────────────────
    // Getters
    // ─────────────────────────────────────────────
    public String getNombre() {
        return nombre;
    }

    public double getRadio() {
        return radio;
    }

    // toString → muestra todo con 2 decimales
    @Override
    public String toString() {
        return String.format(
            "Circulo{ nombre='%s', radio=%.2f, area=%.2f, perimetro=%.2f }",
            nombre, radio, calcularArea(), calcularPerimetro()
        );
    }

}
