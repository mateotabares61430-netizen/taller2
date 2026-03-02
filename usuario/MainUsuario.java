package usuario;

public class MainUsuario {

public static void main(String[] args) {

        System.out.println("=== PERFIL DE USUARIO ===\n");

        // ── Constructor 1: sin parámetros ──────────────────
        System.out.println("--- Constructor sin parámetros ---");
        Usuario u1 = new Usuario();
        System.out.println(u1);

        // ── Constructor 2: usuarios válidos ────────────────
        System.out.println("\n--- Usuarios creados correctamente ---");
        Usuario u2 = new Usuario("carlos_dev",  "carlos@gmail.com",  "miClave123");
        Usuario u3 = new Usuario("ana_torres",  "ana@hotmail.com",   "segura2024");
        Usuario u4 = new Usuario("pedro_ruiz",  "pedro@yahoo.com",   "12345678");  // exactamente 8
        System.out.println(u2);
        System.out.println(u3);
        System.out.println(u4);

        // ── Verificar contraseña correcta ──────────────────
        System.out.println("\n--- Verificar contraseña ---");
        System.out.println("Contraseña correcta:    " + u2.verificarContrasena("miClave123")); // true
        System.out.println("Contraseña incorrecta:  " + u2.verificarContrasena("wrongpass")); // false

        // ── Cambiar contraseña válida ──────────────────────
        System.out.println("\n--- Cambiar contraseña correctamente ---");
        u3.setContrasena("nuevaClave2025");
        System.out.println(u3);

        // ── Contraseña menor a 8 caracteres → excepción ───
        System.out.println("\n--- Contraseña menor a 8 caracteres ---");
        try {
            Usuario uMalo1 = new Usuario("fake_uno", "fake@correo.com", "abc123");
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Contraseña de exactamente 7 → excepción ───────
        System.out.println("\n--- Contraseña con exactamente 7 caracteres ---");
        try {
            Usuario uMalo2 = new Usuario("fake_dos", "fake2@correo.com", "1234567");
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Contraseña null → excepción ────────────────────
        System.out.println("\n--- Contraseña null ---");
        try {
            Usuario uMalo3 = new Usuario("fake_tres", "fake3@correo.com", null);
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Contraseña vacía → excepción ───────────────────
        System.out.println("\n--- Contraseña vacía ---");
        try {
            Usuario uMalo4 = new Usuario("fake_cuatro", "fake4@correo.com", "");
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Intentar cambiar contraseña inválida en objeto existente
        System.out.println("\n--- Cambiar contraseña a valor inválido en objeto existente ---");
        try {
            u2.setContrasena("corta");
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }
        System.out.println("  Contraseña sin cambios: " + u2.verificarContrasena("miClave123"));

        // ── Nombre de usuario null → excepción ────────────
        System.out.println("\n--- Nombre de usuario null ---");
        try {
            Usuario uMalo5 = new Usuario(null, "fake5@correo.com", "contrasena123");
        } catch (IllegalArgumentException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }

        // ── Estado final ───────────────────────────────────
        System.out.println("\n--- Estado final ---");
        System.out.println(u1);
        System.out.println(u2);
        System.out.println(u3);
        System.out.println(u4);
    }
    
}
