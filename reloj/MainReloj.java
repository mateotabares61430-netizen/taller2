package reloj;

public class MainReloj {

public static void main(String[] args) {

        System.out.println("=== RELOJ DIGITAL ===\n");

        // ── Constructor 1: sin parámetros → 00:00:00 ──────
        System.out.println("--- Constructor sin parámetros ---");
        Reloj r1 = new Reloj();
        System.out.println(r1);

        // ── Constructor 2: con parámetros válidos ──────────
        System.out.println("\n--- Relojes creados correctamente ---");
        Reloj r2 = new Reloj(10, 30, 45);
        Reloj r3 = new Reloj(23, 59, 58); // cerca del límite máximo
        Reloj r4 = new Reloj(0,   0,  0); // límite mínimo
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);

        // ── Incrementar un segundo normal ──────────────────
        System.out.println("\n--- Incrementar un segundo ---");
        System.out.println("Antes:  " + r2);
        r2.incrementarSegundo();
        System.out.println("Después:" + r2); // 10:30:46

        // ── Segundos llegan a 60 → sube un minuto ─────────
        System.out.println("\n--- Segundos llegan a 60 → sube minuto ---");
        Reloj r5 = new Reloj(5, 10, 59);
        System.out.println("Antes:  " + r5); // 05:10:59
        r5.incrementarSegundo();
        System.out.println("Después:" + r5); // 05:11:00

        // ── Minutos llegan a 60 → sube una hora ───────────
        System.out.println("\n--- Minutos llegan a 60 → sube hora ---");
        Reloj r6 = new Reloj(8, 59, 59);
        System.out.println("Antes:  " + r6); // 08:59:59
        r6.incrementarSegundo();
        System.out.println("Después:" + r6); // 09:00:00

        // ── 23:59:59 → vuelve a 00:00:00 ──────────────────
        System.out.println("\n--- Medianoche: 23:59:59 → 00:00:00 ---");
        System.out.println("Antes:  " + r3); // 23:59:58
        r3.incrementarSegundo();
        System.out.println("Después:" + r3); // 23:59:59
        r3.incrementarSegundo();
        System.out.println("Después:" + r3); // 00:00:00 ← reinicio del día

        // ── Incrementar varios segundos de una vez ─────────
        System.out.println("\n--- Incrementar 120 segundos (2 minutos) ---");
        Reloj r7 = new Reloj(12, 0, 0);
        System.out.println("Antes:  " + r7); // 12:00:00
        r7.incrementarSegundos(120);
        System.out.println("Después:" + r7); // 12:02:00

        // ── Incrementar 3600 segundos (1 hora) ────────────
        System.out.println("\n--- Incrementar 3600 segundos (1 hora) ---");
        Reloj r8 = new Reloj(6, 0, 0);
        System.out.println("Antes:  " + r8); // 06:00:00
        r8.incrementarSegundos(3600);
        System.out.println("Después:" + r8); // 07:00:00

        // ── Horas fuera de rango → excepción ──────────────
        System.out.println("\n--- Horas fuera de rango ---");
        try {
            Reloj rMalo1 = new Reloj(24, 0, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Minutos fuera de rango → excepción ────────────
        System.out.println("\n--- Minutos fuera de rango ---");
        try {
            Reloj rMalo2 = new Reloj(10, 60, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Segundos fuera de rango → excepción ───────────
        System.out.println("\n--- Segundos fuera de rango ---");
        try {
            Reloj rMalo3 = new Reloj(10, 30, 60);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Valor negativo → excepción ─────────────────────
        System.out.println("\n--- Valor negativo ---");
        try {
            Reloj rMalo4 = new Reloj(-1, 0, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Estado final ───────────────────────────────────
        System.out.println("\n--- Estado final ---");
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r7);
        System.out.println(r8);
    }
    
}
