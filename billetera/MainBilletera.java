package billetera;

public class MainBilletera {

public static void main(String[] args) {

        System.out.println("=== BILLETERA DIGITAL ===\n");

        // ── Constructor 1: sin parámetros ──────────────────
        System.out.println("--- Constructor sin parámetros ---");
        Billetera b1 = new Billetera();
        System.out.println(b1);

        // ── Constructor 2: solo ID → saldo 0 ───────────────
        System.out.println("\n--- Constructor con solo ID ---");
        Billetera b2 = new Billetera("BW-1001");
        System.out.println(b2);

        // ── Constructor 3: ID + saldo inicial ──────────────
        System.out.println("\n--- Constructor con ID y saldo inicial ---");
        Billetera b3 = new Billetera("BW-2001", 500000.0);
        Billetera b4 = new Billetera("bw-3001", 150000.0); // minúsculas → mayúsculas
        Billetera b5 = new Billetera("BW-4001",      0.0); // saldo 0 válido
        System.out.println(b3);
        System.out.println(b4);
        System.out.println(b5);

        // ── Pagos exitosos ─────────────────────────────────
        System.out.println("\n--- Pagos exitosos ---");
        b3.pagar(100000.0);
        b3.pagar(200000.0);
        b3.pagar(200000.0); // paga exactamente lo que queda
        System.out.println(b3);

        // ── Pago con saldo insuficiente → false ────────────
        System.out.println("\n--- Pago con saldo insuficiente ---");
        boolean r1 = b4.pagar(200000.0); // solo tiene 150000
        System.out.println("  Pago exitoso: " + r1);
        System.out.println("  Saldo sin cambios: $" + b4.getSaldo());

        // ── Pago exactamente igual al saldo → true ─────────
        System.out.println("\n--- Pago exactamente igual al saldo ---");
        boolean r2 = b4.pagar(150000.0);
        System.out.println("  Pago exitoso: " + r2);
        System.out.println(b4);

        // ── Intentar pagar con saldo en 0 → false ──────────
        System.out.println("\n--- Intentar pagar con saldo en 0 ---");
        boolean r3 = b4.pagar(1.0);
        System.out.println("  Pago exitoso: " + r3);

        // ── Monto = 0 → excepción ──────────────────────────
        System.out.println("\n--- Monto igual a 0 ---");
        try {
            b3.pagar(0);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Monto negativo → excepción ─────────────────────
        System.out.println("\n--- Monto negativo ---");
        try {
            b3.pagar(-50000.0);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Saldo inicial negativo → excepción ────────────
        System.out.println("\n--- Saldo inicial negativo ---");
        try {
            Billetera bMala1 = new Billetera("BW-9999", -100.0);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── ID null → excepción ────────────────────────────
        System.out.println("\n--- ID null ---");
        try {
            Billetera bMala2 = new Billetera(null, 50000.0);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── ID vacío → excepción ───────────────────────────
        System.out.println("\n--- ID vacío ---");
        try {
            Billetera bMala3 = new Billetera("", 50000.0);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Estado final ───────────────────────────────────
        System.out.println("\n--- Estado final ---");
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
        System.out.println(b5);
    }
    
}
