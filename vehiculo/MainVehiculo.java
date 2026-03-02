package vehiculo;

public class MainVehiculo {

public static void main(String[] args) {

        System.out.println("=== REGISTRO DE VEHÍCULOS ===\n");

        // ── Constructor 1: sin parámetros ──────────────────
        System.out.println("--- Constructor sin parámetros ---");
        Vehiculo v1 = new Vehiculo();
        System.out.println(v1);

        // ── Constructor 2: datos válidos ───────────────────
        System.out.println("\n--- Vehículos creados correctamente ---");
        Vehiculo v2 = new Vehiculo("ABC123", "Carlos Torres");
        Vehiculo v3 = new Vehiculo("xyz789", "Ana Lopez");   // minúsculas → se convierte a mayúsculas
        Vehiculo v4 = new Vehiculo("MnP456", "Pedro Ruiz");  // mixto → se convierte a mayúsculas
        System.out.println(v2);
        System.out.println(v3); // XYZ789
        System.out.println(v4); // MNP456

        // ── Cambiar propietario correctamente ──────────────
        System.out.println("\n--- Cambiar propietario ---");
        System.out.println("Propietario actual: " + v2.getPropietario());
        v2.cambiarPropietario("Maria Gomez");
        System.out.println("Propietario nuevo:  " + v2.getPropietario());

        // ── Cambiar propietario a null → excepción ─────────
        System.out.println("\n--- Cambiar propietario a null ---");
        try {
            v2.cambiarPropietario(null);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Formato inválido: solo letras ──────────────────
        System.out.println("\n--- Placa solo con letras ---");
        try {
            Vehiculo vMalo1 = new Vehiculo("ABCDEF", "Luis Perez");
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Formato inválido: solo números ─────────────────
        System.out.println("\n--- Placa solo con números ---");
        try {
            Vehiculo vMalo2 = new Vehiculo("123456", "Luis Perez");
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Formato inválido: números primero ──────────────
        System.out.println("\n--- Placa con números antes que letras ---");
        try {
            Vehiculo vMalo3 = new Vehiculo("123ABC", "Luis Perez");
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Formato inválido: longitud incorrecta ──────────
        System.out.println("\n--- Placa con longitud incorrecta ---");
        try {
            Vehiculo vMalo4 = new Vehiculo("AB12", "Luis Perez");
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Placa null → excepción ─────────────────────────
        System.out.println("\n--- Placa null ---");
        try {
            Vehiculo vMalo5 = new Vehiculo(null, "Luis Perez");
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Estado final ───────────────────────────────────
        System.out.println("\n--- Estado final ---");
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);
    }
    
}
