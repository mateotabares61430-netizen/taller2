package estudiante;

public class MainEstudiante {
    
public static void main(String[] args) {

        System.out.println("=== SISTEMA DE CALIFICACIONES ===\n");

        // ── Constructor 1: sin parámetros ──────────────────
        System.out.println("--- Constructor sin parámetros ---");
        Estudiante e1 = new Estudiante();
        System.out.println(e1);

        // ── Constructor 2: estudiantes válidos ─────────────
        System.out.println("\n--- Estudiantes creados correctamente ---");
        Estudiante e2 = new Estudiante("2021001", "Ana Torres",   4.8);
        Estudiante e3 = new Estudiante("2021002", "Carlos Ruiz",  3.5);
        Estudiante e4 = new Estudiante("2021003", "Maria Lopez",  2.5);
        Estudiante e5 = new Estudiante("2021004", "Pedro Gil",    0.0); // mínimo válido
        Estudiante e6 = new Estudiante("2021005", "Laura Paz",    5.0); // máximo válido
        System.out.println(e2);
        System.out.println(e3);
        System.out.println(e4);
        System.out.println(e5);
        System.out.println(e6);

        // ── estaAprobado() ─────────────────────────────────
        System.out.println("\n--- Verificando aprobación ---");
        System.out.println(e2.getNombre() + " aprobado: " + e2.estaAprobado()); // true
        System.out.println(e3.getNombre() + " aprobado: " + e3.estaAprobado()); // true
        System.out.println(e4.getNombre() + " aprobado: " + e4.estaAprobado()); // false

        // ── obtenerNota() ──────────────────────────────────
        System.out.println("\n--- Obteniendo notas ---");
        System.out.println(e2.getNombre() + " → " + e2.getPromedio() + " : " + e2.obtenerNota());
        System.out.println(e3.getNombre() + " → " + e3.getPromedio() + " : " + e3.obtenerNota());
        System.out.println(e4.getNombre() + " → " + e4.getPromedio() + " : " + e4.obtenerNota());
        System.out.println(e5.getNombre() + " → " + e5.getPromedio() + " : " + e5.obtenerNota());
        System.out.println(e6.getNombre() + " → " + e6.getPromedio() + " : " + e6.obtenerNota());

        // ── actualizarPromedio() correctamente ─────────────
        System.out.println("\n--- Actualizar promedio correctamente ---");
        System.out.println("Promedio actual de " + e4.getNombre() + ": " + e4.getPromedio());
        e4.actualizarPromedio(3.8);
        System.out.println("Nota actualizada: " + e4.obtenerNota());
        System.out.println("Ahora aprobado:   " + e4.estaAprobado());

        // ── Promedio mayor a 5.0 → excepción ──────────────
        System.out.println("\n--- Promedio mayor a 5.0 ---");
        try {
            Estudiante eMalo1 = new Estudiante("9999001", "Fake Uno", 5.1);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Promedio negativo → excepción ──────────────────
        System.out.println("\n--- Promedio negativo ---");
        try {
            Estudiante eMalo2 = new Estudiante("9999002", "Fake Dos", -1.0);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Actualizar con valor inválido → excepción ──────
        System.out.println("\n--- Actualizar promedio con valor inválido ---");
        try {
            e2.actualizarPromedio(6.0);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }
        System.out.println("  Promedio sin cambios: " + e2.getPromedio());

        // ── Código null → excepción ────────────────────────
        System.out.println("\n--- Código null ---");
        try {
            Estudiante eMalo3 = new Estudiante(null, "Fake Tres", 3.0);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Estado final ───────────────────────────────────
        System.out.println("\n--- Estado final ---");
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);
        System.out.println(e4);
        System.out.println(e5);
        System.out.println(e6);
    }

}
