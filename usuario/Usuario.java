package usuario;

public class Usuario {

// Constante de longitud mínima de contraseña
    private static final int LONGITUD_MINIMA_CONTRASENA = 8;

    // Atributos privados
    private String nombreUsuario;
    private String correo;
    private String contrasena;

    // ─────────────────────────────────────────────
    // Constructor 1: sin parámetros → valores mínimos seguros
    // ─────────────────────────────────────────────
    public Usuario() {
        this.nombreUsuario = "usuario_default";
        this.correo        = "default@correo.com";
        this.contrasena    = "default1";  // exactamente 8 caracteres → válida
    }

    // ─────────────────────────────────────────────
    // Constructor 2: con parámetros + validaciones
    // ─────────────────────────────────────────────
    public Usuario(String nombreUsuario, String correo, String contrasena) {

        if (nombreUsuario == null || nombreUsuario.isEmpty()) {
            throw new IllegalArgumentException("El nombre de usuario no puede ser null ni estar vacio");
        }
        if (correo == null || correo.isEmpty()) {
            throw new IllegalArgumentException("El correo no puede ser null ni estar vacio");
        }

        this.nombreUsuario = nombreUsuario;
        this.correo        = correo;

        // Setter para validar longitud mínima de contraseña
        setContrasena(contrasena);
    }

    // ─────────────────────────────────────────────
    // setContrasena() → mínimo 8 caracteres obligatorio
    // ─────────────────────────────────────────────
    public void setContrasena(String contrasena) {
        if (contrasena == null || contrasena.isEmpty()) {
            throw new IllegalArgumentException("La contrasena no puede ser null ni estar vacia");
        }
        if (contrasena.length() < LONGITUD_MINIMA_CONTRASENA) {
            throw new IllegalArgumentException(
                "La contrasena debe tener al menos " + LONGITUD_MINIMA_CONTRASENA +
                " caracteres. Longitud recibida: " + contrasena.length()
            );
        }
        this.contrasena = contrasena;
        System.out.println("  Contrasena actualizada correctamente");
    }

    // ─────────────────────────────────────────────
    // verificarContrasena() → compara sin exponer la contraseña
    // ─────────────────────────────────────────────
    public boolean verificarContrasena(String contrasena) {
        return this.contrasena.equals(contrasena);
    }

    // ─────────────────────────────────────────────
    // Getters → NO hay getter de contraseña por seguridad
    // ─────────────────────────────────────────────
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    // toString → nunca muestra la contraseña real
    @Override
    public String toString() {
        return "Usuario{" +
               "nombreUsuario='" + nombreUsuario + "'" +
               ", correo='"      + correo        + "'" +
               ", contrasena='"  + "*".repeat(contrasena.length()) + "'" + // oculta con asteriscos
               "}";
    }
    
}
