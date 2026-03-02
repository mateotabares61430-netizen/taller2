package libro;

public class Libro {

    // Atributos privados
    private String isbn;
    private String titulo;
    private String autor;
    private int numeroPaginas;

    // Constructor 1: sin parámetros → valores mínimos seguros
    public Libro() {
        this.isbn          = "0000000000000"; // 13 numeros
        this.titulo        = "Sin titulo";
        this.autor         = "Sin autor";
        this.numeroPaginas = 1;               // mínimo válido (> 0)
    }

    // Constructor 2: con todos los parámetros + validaciones
    public Libro(String isbn, String titulo, String autor, int numeroPaginas) {

        if (isbn == null || isbn.length() != 13) {
            throw new IllegalArgumentException("El ISBN debe tener exactamente 13 caracteres");
        }
        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("El titulo no puede ser null ni estar vacio");
        }
        if (autor == null || autor.isEmpty()) {
            throw new IllegalArgumentException("El autor no puede ser null ni estar vacio");
        }
        if (numeroPaginas <= 0) {
            throw new IllegalArgumentException("El numero de paginas debe ser mayor a 0");
        }

        this.isbn          = isbn;
        this.titulo        = titulo;
        this.autor         = autor;
        this.numeroPaginas = numeroPaginas;
    }

    // Getters 
    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    // toString
    @Override
    public String toString() {
        return "Libro{" +
               "isbn='"          + isbn          + "'" +
               ", titulo='"      + titulo        + "'" +
               ", autor='"       + autor         + "'" +
               ", numeroPaginas=" + numeroPaginas +
               "}";
    }
    
}
