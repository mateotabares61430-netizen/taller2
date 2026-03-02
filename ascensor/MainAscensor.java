package ascensor;

public class MainAscensor {

public static void main(String[] args) {

        System.out.println("=== CONTROL DE ASCENSOR ===\n");

        // ── Constructor 1: sin parámetros ──────────────────
        System.out.println("--- Constructor sin parámetros ---");
        Ascensor a1 = new Ascensor();
        System.out.println(a1);

        // ── Constructor 2: con edificio y piso inicial ─────
        System.out.println("\n--- Ascensores creados correctamente ---");
        Ascensor a2 = new Ascensor("Torre Norte", 0);
        Ascensor a3 = new Ascensor("Torre Sur",  -2); // inicia en sótano 2
        Ascensor a4 = new Ascensor("Torre Este",  15); // inicia en piso máximo
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);

        // ── irAPiso() correctamente ────────────────────────
        System.out.println("\n--- Movimientos válidos con irAPiso() ---");
        a2.irAPiso(7);
        System.out.println(a2);
        a2.irAPiso(-1);  // baja a sótano 1
        System.out.println(a2);
        a2.irAPiso(15);  // sube al máximo
        System.out.println(a2);

        // ── irAPiso() al mismo piso → no se mueve ──────────
        System.out.println("\n--- Intentar ir al mismo piso ---");
        a2.irAPiso(15);

        // ── irAPiso() fuera de rango → no se mueve ─────────
        System.out.println("\n--- Pisos fuera de rango ---");
        a2.irAPiso(16);   // un piso arriba del máximo
        a2.irAPiso(-3);   // un piso abajo del mínimo
        a2.irAPiso(100);  // muy lejos del rango
        System.out.println("Piso sin cambios: " + a2.getPisoActual());

        // ── subirPiso() correctamente ──────────────────────
        System.out.println("\n--- Subir piso a piso ---");
        Ascensor a5 = new Ascensor("Torre Oeste", 0);
        System.out.println(a5);
        a5.subirPiso();
        a5.subirPiso();
        a5.subirPiso();
        System.out.println(a5);

        // ── bajarPiso() correctamente ──────────────────────
        System.out.println("\n--- Bajar piso a piso ---");
        a5.bajarPiso();
        a5.bajarPiso();
        a5.bajarPiso();
        a5.bajarPiso();  // baja a sótano 1
        System.out.println(a5);

        // ── subirPiso() en el piso máximo → no sube ────────
        System.out.println("\n--- Intentar subir desde el piso máximo ---");
        a4.subirPiso();

        // ── bajarPiso() en el piso mínimo → no baja ────────
        System.out.println("\n--- Intentar bajar desde el piso mínimo ---");
        a3.bajarPiso();

        // ── Constructor con piso inicial inválido → excepción
        System.out.println("\n--- Piso inicial fuera de rango ---");
        try {
            Ascensor aMalo1 = new Ascensor("Edificio Malo", 20);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Nombre de edificio null → excepción ───────────
        System.out.println("\n--- Nombre de edificio null ---");
        try {
            Ascensor aMalo2 = new Ascensor(null, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Estado final ───────────────────────────────────
        System.out.println("\n--- Estado final ---");
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);
        System.out.println(a5);
    }
    
}
