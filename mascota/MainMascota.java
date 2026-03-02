package mascota;

public class MainMascota {

public static void main(String[] args) {

        System.out.println("=== REGISTRO DE MASCOTAS ===\n");

        // ── Constructor 1: sin parámetros ──────────────────
        System.out.println("--- Constructor sin parámetros ---");
        Mascota m1 = new Mascota();
        System.out.println(m1);

        // ── Constructor 2: nombre + meses totales ──────────
        System.out.println("\n--- Constructor con meses totales ---");
        Mascota m2 = new Mascota("Luna",    6);   //  6 meses
        Mascota m3 = new Mascota("Rocky",  18);   // 18 meses → 1 año 6 meses
        Mascota m4 = new Mascota("Michi",  24);   // 24 meses → 2 años exactos
        Mascota m5 = new Mascota("Toby",    1);   //  1 mes   → mínimo válido
        Mascota m6 = new Mascota("Rex",   360);   // 360 meses → máximo válido (30 años)
        System.out.println(m2);
        System.out.println(m3);
        System.out.println(m4);
        System.out.println(m5);
        System.out.println(m6);

        // ── Constructor 3: nombre + años + meses ───────────
        System.out.println("\n--- Constructor con años y meses ---");
        Mascota m7  = new Mascota("Nala",   2,  3);  // 2 años 3 meses  → 27 meses
        Mascota m8  = new Mascota("Bobby",  5,  0);  // 5 años exactos  → 60 meses
        Mascota m9  = new Mascota("Pelusa", 0,  8);  // solo 8 meses    →  8 meses
        Mascota m10 = new Mascota("Kira",  10, 11);  // 10 años 11 meses → 131 meses
        System.out.println(m7);
        System.out.println(m8);
        System.out.println(m9);
        System.out.println(m10);

        // ── Comparar mismo tiempo en ambos constructores ───
        System.out.println("\n--- Mismo tiempo, diferente constructor ---");
        Mascota conMeses = new Mascota("Firulais A",  27);     // 27 meses
        Mascota conAnios = new Mascota("Firulais B",   2,  3); // 2 años 3 meses → 27 meses
        System.out.println(conMeses); // 27 meses (2 años y 3 meses)
        System.out.println(conAnios); // 27 meses (2 años y 3 meses) → idéntico

        // ── getEdadEnAnios() ───────────────────────────────
        System.out.println("\n--- getEdadEnAnios() ---");
        System.out.println("  " + m2.getNombre()  + " → " + m2.getEdadEnAnios()  + " años completos"); //  0
        System.out.println("  " + m3.getNombre()  + " → " + m3.getEdadEnAnios()  + " años completos"); //  1
        System.out.println("  " + m7.getNombre()  + " → " + m7.getEdadEnAnios()  + " años completos"); //  2
        System.out.println("  " + m10.getNombre() + " → " + m10.getEdadEnAnios() + " años completos"); // 10

        // ── Edad = 0 → excepción ───────────────────────────
        System.out.println("\n--- Edad igual a 0 ---");
        try {
            Mascota mMala1 = new Mascota("Malo", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Edad negativa → excepción ──────────────────────
        System.out.println("\n--- Edad negativa ---");
        try {
            Mascota mMala2 = new Mascota("Malo", -3);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Edad mayor a 30 años → excepción ──────────────
        System.out.println("\n--- Edad mayor a 30 años (361 meses) ---");
        try {
            Mascota mMala3 = new Mascota("Malo", 361);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Meses fuera de rango en constructor 3 ─────────
        System.out.println("\n--- Meses fuera de rango (constructor años/meses) ---");
        try {
            Mascota mMala4 = new Mascota("Malo", 2, 12); // 12 meses inválido (0-11)
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Años negativos en constructor 3 ───────────────
        System.out.println("\n--- Años negativos (constructor años/meses) ---");
        try {
            Mascota mMala5 = new Mascota("Malo", -1, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Nombre null → excepción ────────────────────────
        System.out.println("\n--- Nombre null ---");
        try {
            Mascota mMala6 = new Mascota(null, 12);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Estado final ───────────────────────────────────
        System.out.println("\n--- Estado final ---");
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m7);
        System.out.println(m8);
        System.out.println(m10);
    }
    
}
