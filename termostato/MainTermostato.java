package termostato;

public class MainTermostato {

public static void main(String[] args) {

        System.out.println("=== CONTROL DE TERMOSTATO ===\n");

        // ── Constructor 1: sin parámetros ──────────────────
        System.out.println("--- Constructor sin parámetros ---");
        Termostato t1 = new Termostato();
        System.out.println(t1);

        // ── Constructor 2: con parámetros válidos ──────────
        System.out.println("\n--- Constructor con parámetros válidos ---");
        Termostato t2 = new Termostato("Sala", 22.5);
        System.out.println(t2);

        // ── Constructor 2: temperatura inicial fuera de rango ──
        System.out.println("\n--- Constructor con temperatura fuera de rango ---");
        Termostato t3 = new Termostato("Cocina", 50.0); // inválido → se queda en 15.0
        System.out.println(t3);

        // ── Cambios válidos de temperatura ─────────────────
        System.out.println("\n--- Cambiando temperatura correctamente ---");
        System.out.println("Temperatura actual: " + t2.getTemperatura() + "°C");
        t2.setTemperatura(28.0);
        System.out.println("Nueva temperatura:  " + t2.getTemperatura() + "°C"); // 28.0

        // ── Intentar subir por encima del máximo ────────────
        System.out.println("\n--- Intentar subir por encima de 30°C ---");
        t2.setTemperatura(35.0); // fuera de rango → se mantiene 28.0
        System.out.println("Temperatura después del intento: " + t2.getTemperatura() + "°C");

        // ── Intentar bajar por debajo del mínimo ────────────
        System.out.println("\n--- Intentar bajar por debajo de 15°C ---");
        t2.setTemperatura(10.0); // fuera de rango → se mantiene 28.0
        System.out.println("Temperatura después del intento: " + t2.getTemperatura() + "°C");

        // ── Exactamente en el límite mínimo y máximo ────────
        System.out.println("\n--- Temperaturas exactamente en los límites ---");
        t2.setTemperatura(15.0); // límite inferior → válido
        System.out.println("Límite inferior (15°C): " + t2.getTemperatura() + "°C");
        t2.setTemperatura(30.0); // límite superior → válido
        System.out.println("Límite superior (30°C): " + t2.getTemperatura() + "°C");

        // ── Nombre null → excepción ──────────────────────────
        System.out.println("\n--- Nombre null → excepción ---");
        try {
            Termostato tMalo = new Termostato(null, 20.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Error capturado: " + e.getMessage());
        }

        // ── Estado final de todos los termostatos ───────────
        System.out.println("\n--- Estado final ---");
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
    }
    
}
