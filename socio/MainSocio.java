package socio;

public class MainSocio {

public static void main(String[] args) {

        // 🔹 Constructor por defecto
        Socio socio1 = new Socio();
        System.out.println("Socio 1: " + socio1);

        // 🔹 Constructor con parámetros válidos
        Socio socio2 = new Socio("Carlos", "Oro");
        System.out.println("Socio 2: " + socio2);

        // 🔹 Cambiando membresía con setter
        socio2.setTipoMembresia("Plata");
        System.out.println("Socio 2 actualizado: " + socio2);

        // 🔹 Intentando asignar valor inválido
        try {
            socio2.setTipoMembresia("Diamante");
        } catch (IllegalArgumentException e) {
            System.out.println("Error detectado correctamente: " + e.getMessage());
        }
    }
    
}
