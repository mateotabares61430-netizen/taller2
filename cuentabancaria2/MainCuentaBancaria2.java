package cuentabancaria2;

public class MainCuentaBancaria2 {

public static void main(String[] args) {

        System.out.println("=== CUENTA BANCARIA CON SOBRECARGA ===\n");

        // ── Constructor 1: solo número de cuenta → saldo 0 ─
        System.out.println("--- Constructor 1: solo número de cuenta ---");
        CuentaBancaria2 c1 = new CuentaBancaria2("CB-001");
        System.out.println(c1);

        // ── Constructor 2: con depósito inicial ─────────────
        System.out.println("\n--- Constructor 2: con depósito inicial ---");
        CuentaBancaria2 c2 = new CuentaBancaria2("CB-002", 500000.0);
        CuentaBancaria2 c3 = new CuentaBancaria2("CB-003", 1200000.0);
        System.out.println(c2);
        System.out.println(c3);

        // ── Depósitos correctos ─────────────────────────────
        System.out.println("\n--- Realizando depósitos ---");
        c1.depositar(300000.0);
        c1.depositar(150000.0);

        // ── Retiros correctos ───────────────────────────────
        System.out.println("\n--- Realizando retiros ---");
        c2.retirar(200000.0);
        c3.retirar(1000000.0);

        // ── Retiro sin saldo suficiente → false ─────────────
        System.out.println("\n--- Retiro sin saldo suficiente ---");
        boolean resultado = c1.retirar(999999.0);
        System.out.println("  Retiro exitoso: " + resultado);

        // ── Depósito inicial negativo → excepción ───────────
        System.out.println("\n--- Depósito inicial negativo ---");
        try {
            CuentaBancaria2 cMala = new CuentaBancaria2("CB-999", -100000.0);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Número de cuenta vacío → excepción ─────────────
        System.out.println("\n--- Número de cuenta vacío ---");
        try {
            CuentaBancaria2 cMala2 = new CuentaBancaria2("");
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Depositar monto 0 → excepción ───────────────────
        System.out.println("\n--- Depositar monto 0 ---");
        try {
            c1.depositar(0);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Estado final ────────────────────────────────────
        System.out.println("\n--- Estado final ---");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
    }
    
}
