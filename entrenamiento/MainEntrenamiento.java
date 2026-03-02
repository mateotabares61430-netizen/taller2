package entrenamiento;

public class MainEntrenamiento {

public static void main(String[] args) {

        System.out.println("=== CRONÓMETRO DE ENTRENAMIENTO ===\n");

        // ── Constructor 1: sin parámetros ──────────────────
        System.out.println("--- Constructor sin parámetros ---");
        Entrenamiento e1 = new Entrenamiento();
        System.out.println(e1);

        // ── Constructor 2: nombre + minutos totales ────────
        System.out.println("\n--- Constructor con minutos totales ---");
        Entrenamiento e2 = new Entrenamiento("Cardio",         90);  // 1h 30m
        Entrenamiento e3 = new Entrenamiento("Pesas",          45);  // 0h 45m
        Entrenamiento e4 = new Entrenamiento("Natación",      120);  // 2h 00m
        Entrenamiento e5 = new Entrenamiento("Ciclismo",        1);  // mínimo válido
        Entrenamiento e6 = new Entrenamiento("Maratón",      1440);  // máximo válido (24h)
        System.out.println(e2);
        System.out.println(e3);
        System.out.println(e4);
        System.out.println(e5);
        System.out.println(e6);

        // ── Constructor 3: nombre + horas + minutos ────────
        System.out.println("\n--- Constructor con horas y minutos ---");
        Entrenamiento e7 = new Entrenamiento("Yoga",        1, 30);  // 90 min
        Entrenamiento e8 = new Entrenamiento("Crossfit",    0, 45);  // 45 min
        Entrenamiento e9 = new Entrenamiento("Triatlón",    3,  0);  // 180 min
        Entrenamiento e10= new Entrenamiento("Stretching",  0, 20);  // 20 min
        System.out.println(e7);
        System.out.println(e8);
        System.out.println(e9);
        System.out.println(e10);

        // ── Comparar mismo tiempo en ambos constructores ───
        System.out.println("\n--- Mismo tiempo, diferente constructor ---");
        Entrenamiento minutos = new Entrenamiento("Rutina A", 150);
        Entrenamiento horasMin= new Entrenamiento("Rutina B",   2, 30);
        System.out.println(minutos);  // 150 min (2h 30m)
        System.out.println(horasMin); // 150 min (2h 30m) → idéntico

        // ── Tiempo = 0 → excepción ─────────────────────────
        System.out.println("\n--- Tiempo igual a 0 minutos ---");
        try {
            Entrenamiento eMalo1 = new Entrenamiento("Malo", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Tiempo negativo → excepción ────────────────────
        System.out.println("\n--- Tiempo negativo ---");
        try {
            Entrenamiento eMalo2 = new Entrenamiento("Malo", -30);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Tiempo mayor a 24h → excepción ────────────────
        System.out.println("\n--- Tiempo mayor a 24 horas ---");
        try {
            Entrenamiento eMalo3 = new Entrenamiento("Malo", 1441);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Minutos fuera de rango en constructor 3 ────────
        System.out.println("\n--- Minutos fuera de rango (constructor horas/minutos) ---");
        try {
            Entrenamiento eMalo4 = new Entrenamiento("Malo", 1, 60); // 60 min inválido
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Horas negativas en constructor 3 ───────────────
        System.out.println("\n--- Horas negativas (constructor horas/minutos) ---");
        try {
            Entrenamiento eMalo5 = new Entrenamiento("Malo", -1, 30);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Nombre null → excepción ────────────────────────
        System.out.println("\n--- Nombre null ---");
        try {
            Entrenamiento eMalo6 = new Entrenamiento(null, 60);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Estado final ───────────────────────────────────
        System.out.println("\n--- Estado final ---");
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e7);
        System.out.println(e9);
        System.out.println(e6);
    }
    
}
