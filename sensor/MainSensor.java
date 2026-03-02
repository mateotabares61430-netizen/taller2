package sensor;

public class MainSensor {

public static void main(String[] args) {

        System.out.println("=== SENSOR DE HUMEDAD ===\n");

        // ── Constructor 1: sin parámetros ──────────────────
        System.out.println("--- Constructor sin parámetros ---");
        Sensor s1 = new Sensor();
        System.out.println(s1);

        // ── Constructor 2: con lectura válida ──────────────
        System.out.println("\n--- Sensores creados con lectura válida ---");
        Sensor s2 = new Sensor("SENSOR-001",  55.0);  // válido
        Sensor s3 = new Sensor("SENSOR-002",   0.0);  // límite mínimo válido
        Sensor s4 = new Sensor("sensor-003", 100.0);  // límite máximo válido
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);

        // ── Constructor 2: con lectura inválida → error ────
        System.out.println("\n--- Sensores creados con lectura inválida ---");
        Sensor s5 = new Sensor("SENSOR-004", 105.0);  // fuera de rango → error
        Sensor s6 = new Sensor("SENSOR-005",  -1.0);  // fuera de rango → error
        System.out.println(s5);
        System.out.println(s6);

        // ── Lecturas válidas ───────────────────────────────
        System.out.println("\n--- Registrando lecturas válidas ---");
        s2.registrarLectura(30.0);
        s2.registrarLectura(75.5);
        s2.registrarLectura(100.0);
        System.out.println(s2);

        // ── Lecturas inválidas → marcan error ──────────────
        System.out.println("\n--- Registrando lecturas fuera de rango ---");
        s3.registrarLectura(101.0);  // fuera de rango → error
        System.out.println("  ¿En error?: " + s3.isEnError());
        System.out.println("  Estado:     " + s3.getEstado());
        System.out.println("  Humedad sin cambios: " + s3.getHumedad() + "%");

        s4.registrarLectura(-5.0);   // fuera de rango → error
        System.out.println(s4);

        // ── Resetear error ─────────────────────────────────
        System.out.println("\n--- Resetear error ---");
        System.out.println("Antes:  " + s3);
        s3.resetearError();
        System.out.println("Después:" + s3);

        // ── Resetear sensor sin error → aviso ─────────────
        System.out.println("\n--- Resetear sensor que no tiene error ---");
        s2.resetearError();

        // ── Lectura válida después de resetear → limpia error
        System.out.println("\n--- Lectura válida después del error ---");
        System.out.println("Antes:  " + s5);
        s5.registrarLectura(60.0);   // lectura válida → limpia el error
        System.out.println("Después:" + s5);

        // ── Límites exactos ────────────────────────────────
        System.out.println("\n--- Límites exactos del rango ---");
        Sensor s7 = new Sensor("SENSOR-007", 50.0);
        s7.registrarLectura(0.0);    // límite inferior → válido
        System.out.println("  Límite inferior (0%):   " + s7.getHumedad() + "%");
        s7.registrarLectura(100.0);  // límite superior → válido
        System.out.println("  Límite superior (100%): " + s7.getHumedad() + "%");

        // ── ID null → excepción ────────────────────────────
        System.out.println("\n--- ID null ---");
        try {
            Sensor sMalo = new Sensor(null, 50.0);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Estado final ───────────────────────────────────
        System.out.println("\n--- Estado final ---");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);
    }
    
}
