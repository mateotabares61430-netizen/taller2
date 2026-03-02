package solicitudbeca;

public class MainSolicitudBeca {

public static void main(String[] args) {

        System.out.println("=== SISTEMA DE BECAS ===\n");
        System.out.println("Promedio mínimo para beca: " + SolicitudBeca.getPromedioMinimoBeca() + "\n");

        // ── Constructor 1: sin parámetros ──────────────────
        System.out.println("--- Constructor sin parámetros ---");
        SolicitudBeca s1 = new SolicitudBeca();
        System.out.println(s1);

        // ── Constructor 2: solicitudes válidas ─────────────
        System.out.println("\n--- Solicitudes creadas correctamente ---");
        SolicitudBeca s2 = new SolicitudBeca("SOL-001", "Ana Torres",   4.8); // supera 4.5 → aprobará
        SolicitudBeca s3 = new SolicitudBeca("SOL-002", "Carlos Ruiz",  4.5); // igual a 4.5 → no aprueba
        SolicitudBeca s4 = new SolicitudBeca("SOL-003", "Maria Lopez",  4.6); // supera 4.5 → aprobará
        SolicitudBeca s5 = new SolicitudBeca("sol-004", "Pedro Gil",    3.9); // minúsculas → mayúsculas
        SolicitudBeca s6 = new SolicitudBeca("SOL-005", "Laura Paz",    5.0); // máximo posible → aprobará
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);

        // ── aprobar() con promedio suficiente → true ───────
        System.out.println("\n--- Aprobar solicitudes con promedio suficiente ---");
        boolean r1 = s2.aprobar(); // 4.8 > 4.5 → true
        boolean r2 = s4.aprobar(); // 4.6 > 4.5 → true
        boolean r3 = s6.aprobar(); // 5.0 > 4.5 → true
        System.out.println("  " + s2.getNombreEstudiante() + " aprobada: " + r1);
        System.out.println("  " + s4.getNombreEstudiante() + " aprobada: " + r2);
        System.out.println("  " + s6.getNombreEstudiante() + " aprobada: " + r3);

        // ── aprobar() con promedio insuficiente → false ────
        System.out.println("\n--- Aprobar solicitudes con promedio insuficiente ---");
        boolean r4 = s3.aprobar(); // 4.5 = 4.5 → false (debe ser SUPERIOR, no igual)
        boolean r5 = s5.aprobar(); // 3.9 < 4.5 → false
        System.out.println("  " + s3.getNombreEstudiante() + " aprobada: " + r4);
        System.out.println("  " + s5.getNombreEstudiante() + " aprobada: " + r5);

        // ── estaAprobada() ─────────────────────────────────
        System.out.println("\n--- Verificando estado con estaAprobada() ---");
        System.out.println("  " + s2.getNombreEstudiante() + " → " + s2.estaAprobada()); // true
        System.out.println("  " + s3.getNombreEstudiante() + " → " + s3.estaAprobada()); // false
        System.out.println("  " + s4.getNombreEstudiante() + " → " + s4.estaAprobada()); // true
        System.out.println("  " + s5.getNombreEstudiante() + " → " + s5.estaAprobada()); // false

        // ── Intentar aprobar una solicitud ya procesada ────
        System.out.println("\n--- Intentar aprobar solicitud ya procesada ---");
        s2.aprobar(); // ya fue aprobada → no se puede volver a procesar
        s5.aprobar(); // ya fue rechazada → no se puede volver a procesar

        // ── Promedio fuera de rango → excepción ───────────
        System.out.println("\n--- Promedio fuera de rango ---");
        try {
            SolicitudBeca sMala1 = new SolicitudBeca("SOL-999", "Fake Uno", 5.1);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Promedio negativo → excepción ──────────────────
        System.out.println("\n--- Promedio negativo ---");
        try {
            SolicitudBeca sMala2 = new SolicitudBeca("SOL-998", "Fake Dos", -1.0);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Código null → excepción ────────────────────────
        System.out.println("\n--- Código null ---");
        try {
            SolicitudBeca sMala3 = new SolicitudBeca(null, "Fake Tres", 4.7);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Nombre null → excepción ────────────────────────
        System.out.println("\n--- Nombre null ---");
        try {
            SolicitudBeca sMala4 = new SolicitudBeca("SOL-997", null, 4.7);
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
