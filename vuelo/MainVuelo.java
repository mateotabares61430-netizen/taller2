package vuelo;

public class MainVuelo {

public static void main(String[] args) {

        System.out.println("=== RESERVA DE VUELOS ===\n");
        System.out.println("Capacidad máxima por vuelo: " + Vuelo.getCapacidadMaxima() + " asientos\n");

        // ── Constructor 1: sin parámetros ──────────────────
        System.out.println("--- Constructor sin parámetros ---");
        Vuelo v1 = new Vuelo();
        System.out.println(v1);

        // ── Constructor 2: vuelos válidos ──────────────────
        System.out.println("\n--- Vuelos creados correctamente ---");
        Vuelo v2 = new Vuelo("AV101", "Bogotá",    "Medellín");
        Vuelo v3 = new Vuelo("AV202", "Cali",      "Cartagena");
        Vuelo v4 = new Vuelo("av303", "Manizales", "Bogotá");   // minúsculas → mayúsculas
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);

        // ── Reservas válidas ───────────────────────────────
        System.out.println("\n--- Realizando reservas ---");
        v2.reservar(50);
        v2.reservar(80);
        v2.reservar(10);
        System.out.println(v2);

        // ── estaLleno() ────────────────────────────────────
        System.out.println("\n--- ¿Está lleno el vuelo? ---");
        System.out.println("  Vuelo " + v2.getNumeroVuelo() + " lleno: " + v2.estaLleno()); // true
        System.out.println("  Vuelo " + v3.getNumeroVuelo() + " lleno: " + v3.estaLleno()); // false

        // ── asientosDisponibles() ──────────────────────────
        System.out.println("\n--- Asientos disponibles ---");
        System.out.println("  Vuelo " + v2.getNumeroVuelo() + ": " + v2.asientosDisponibles() + " disponibles");
        System.out.println("  Vuelo " + v3.getNumeroVuelo() + ": " + v3.asientosDisponibles() + " disponibles");

        // ── Intentar reservar en vuelo lleno → false ───────
        System.out.println("\n--- Intentar reservar en vuelo lleno ---");
        boolean r1 = v2.reservar(1);
        System.out.println("  Reserva exitosa: " + r1);

        // ── Pedir más asientos de los disponibles → false ──
        System.out.println("\n--- Pedir más asientos de los disponibles ---");
        v3.reservar(100);   // quedan 150, ok
        boolean r2 = v3.reservar(80); // solo quedan 50
        System.out.println("  Reserva exitosa: " + r2);
        System.out.println(v3);

        // ── Llenar vuelo exactamente ───────────────────────
        System.out.println("\n--- Llenar vuelo exactamente ---");
        v3.reservar(50);   // completa los últimos asientos
        System.out.println(v3);
        System.out.println("  ¿Lleno?: " + v3.estaLleno());

        // ── Cantidad de reserva = 0 → excepción ───────────
        System.out.println("\n--- Reservar 0 asientos ---");
        try {
            v4.reservar(0);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Cantidad negativa → excepción ──────────────────
        System.out.println("\n--- Reservar cantidad negativa ---");
        try {
            v4.reservar(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Origen igual al destino → excepción ───────────
        System.out.println("\n--- Origen igual al destino ---");
        try {
            Vuelo vMalo1 = new Vuelo("XX999", "Bogotá", "Bogotá");
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Número de vuelo null → excepción ──────────────
        System.out.println("\n--- Número de vuelo null ---");
        try {
            Vuelo vMalo2 = new Vuelo(null, "Bogotá", "Cali");
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Estado final ───────────────────────────────────
        System.out.println("\n--- Estado final ---");
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);
    }
    
}
