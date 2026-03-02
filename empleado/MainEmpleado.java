package empleado;

import java.time.LocalDate;

public class MainEmpleado {

public static void main(String[] args) {

        System.out.println("=== GESTIÓN DE EMPLEADOS ===\n");
        System.out.println("Salario mínimo legal: $" + Empleado.getSalarioMinimo() + "\n");

        // ── Constructor 1: sin parámetros ──────────────────
        System.out.println("--- Constructor sin parámetros ---");
        Empleado e1 = new Empleado();
        System.out.println(e1);

        // ── Constructor 2: datos válidos ───────────────────
        System.out.println("\n--- Empleados creados correctamente ---");
        Empleado e2 = new Empleado("1234567890", "Ana Torres",    1500000.0, LocalDate.of(2020, 3, 15));
        Empleado e3 = new Empleado("0987654321", "Carlos Ruiz",   2000000.0, LocalDate.of(2018, 7, 1));
        Empleado e4 = new Empleado("1122334455", "Maria Lopez",   1000000.0, LocalDate.now()); // hoy → válido
        System.out.println(e2);
        System.out.println(e3);
        System.out.println(e4);

        // ── Salario por debajo del mínimo → excepción ──────
        System.out.println("\n--- Salario inferior al mínimo legal ---");
        try {
            Empleado eMalo1 = new Empleado("1111111111", "Pedro Gil", 500000.0, LocalDate.of(2022, 1, 10));
        } catch (IllegalArgumentException e) {
            System.out.println("Error capturado: " + e.getMessage());
        }

        // ── Fecha futura → excepción ───────────────────────
        System.out.println("\n--- Fecha de contratación futura ---");
        try {
            Empleado eMalo2 = new Empleado("2222222222", "Laura Paz", 1200000.0, LocalDate.of(2027, 6, 20));
        } catch (IllegalArgumentException e) {
            System.out.println("Error capturado: " + e.getMessage());
        }

        // ── Nombre null → excepción ────────────────────────
        System.out.println("\n--- Nombre null ---");
        try {
            Empleado eMalo3 = new Empleado("3333333333", null, 1200000.0, LocalDate.of(2021, 4, 5));
        } catch (IllegalArgumentException e) {
            System.out.println("Error capturado: " + e.getMessage());
        }

        // ── Actualizar salario con setter ──────────────────
        System.out.println("\n--- Actualizar salario correctamente ---");
        System.out.println("Salario antes: $" + e2.getSalarioBase());
        e2.setSalarioBase(1800000.0);
        System.out.println("Salario después: $" + e2.getSalarioBase());

        // ── Intentar bajar salario por debajo del mínimo ───
        System.out.println("\n--- Intentar bajar salario por debajo del mínimo ---");
        try {
            e2.setSalarioBase(800000.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Error capturado: " + e.getMessage());
        }
        System.out.println("Salario sin cambios: $" + e2.getSalarioBase());

        // ── Estado final ───────────────────────────────────
        System.out.println("\n--- Estado final ---");
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);
        System.out.println(e4);
    } 

}
