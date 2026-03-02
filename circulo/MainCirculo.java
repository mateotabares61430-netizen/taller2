package circulo;

public class MainCirculo {

public static void main(String[] args) {

        System.out.println("=== GEOMETRÍA - CÍRCULO ===\n");

        // ── Constructor 1: sin parámetros ──────────────────
        System.out.println("--- Constructor sin parámetros ---");
        Circulo c1 = new Circulo();
        System.out.println(c1);

        // ── Constructor 2: círculos válidos ────────────────
        System.out.println("\n--- Círculos creados correctamente ---");
        Circulo c2 = new Circulo("Circulo A", 5.0);
        Circulo c3 = new Circulo("Circulo B", 10.0);
        Circulo c4 = new Circulo("Circulo C", 3.7);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);

        // ── Calcular área y perímetro por separado ─────────
        System.out.println("\n--- Calculando área y perímetro ---");
        System.out.printf("  %s → Área:      %.2f%n", c2.getNombre(), c2.calcularArea());
        System.out.printf("  %s → Perímetro: %.2f%n", c2.getNombre(), c2.calcularPerimetro());
        System.out.printf("  %s → Área:      %.2f%n", c3.getNombre(), c3.calcularArea());
        System.out.printf("  %s → Perímetro: %.2f%n", c3.getNombre(), c3.calcularPerimetro());

        // ── Cambiar radio correctamente → área se recalcula ─
        System.out.println("\n--- Cambiar radio → área se recalcula automáticamente ---");
        System.out.println("Antes:  " + c2);
        c2.setRadio(8.0);
        System.out.println("Después:" + c2); // área y perímetro se actualizan solos

        // ── Radio = 0 → excepción ──────────────────────────
        System.out.println("\n--- Radio igual a 0 ---");
        try {
            Circulo cMalo1 = new Circulo("Malo", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Radio negativo → excepción ─────────────────────
        System.out.println("\n--- Radio negativo ---");
        try {
            Circulo cMalo2 = new Circulo("Malo", -5.0);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Intentar setRadio(0) en objeto ya creado ───────
        System.out.println("\n--- Intentar cambiar radio a 0 en objeto existente ---");
        try {
            c3.setRadio(0);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }
        System.out.println("  Radio sin cambios: " + c3.getRadio());

        // ── Nombre null → excepción ────────────────────────
        System.out.println("\n--- Nombre null ---");
        try {
            Circulo cMalo3 = new Circulo(null, 5.0);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Estado final ───────────────────────────────────
        System.out.println("\n--- Estado final ---");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
    }
    
}
