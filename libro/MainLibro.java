package libro;

public class MainLibro {

public static void main(String[] args) {

        System.out.println("=== SISTEMA DE BIBLIOTECA ===\n");

        // Constructor 1: sin parámetros → valores mínimos
        Libro libroVacio = new Libro();
        System.out.println("Libro con constructor vacío:");
        System.out.println("  " + libroVacio);

        System.out.println();

        // Constructor 2: con datos reales
        Libro libro1 = new Libro("9780743273565", "El Gran Gatsby",    "F. Scott Fitzgerald", 180);
        Libro libro2 = new Libro("9780061096525", "To Kill a Mockingbird", "Harper Lee",       281);
        Libro libro3 = new Libro("9780451524935", "1984",              "George Orwell",        328);

        System.out.println("Libros creados correctamente:");
        System.out.println("  " + libro1);
        System.out.println("  " + libro2);
        System.out.println("  " + libro3);

        // Probar ISBN con longitud incorrecta
        System.out.println("\n--- ISBN con longitud incorrecta ---");
        try {
            Libro libroMalo = new Libro("123", "Titulo", "Autor", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Error capturado: " + e.getMessage());
        }

        // Probar páginas = 0
        System.out.println("\n--- Numero de paginas invalido ---");
        try {
            Libro libroMalo2 = new Libro("9780743273565", "Titulo", "Autor", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Error capturado: " + e.getMessage());
        }

        // Probar páginas negativas
        System.out.println("\n--- Numero de paginas negativo ---");
        try {
            Libro libroMalo3 = new Libro("9780743273565", "Titulo", "Autor", -50);
        } catch (IllegalArgumentException e) {
            System.out.println("Error capturado: " + e.getMessage());
        }

        // Probar ISBN null
        System.out.println("\n--- ISBN null ---");
        try {
            Libro libroMalo4 = new Libro(null, "Titulo", "Autor", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Error capturado: " + e.getMessage());
        }

        // Mostrar getters
        System.out.println("\n--- Usando getters del libro1 ---");
        System.out.println("ISBN:    "   + libro1.getIsbn());
        System.out.println("Titulo:  "   + libro1.getTitulo());
        System.out.println("Autor:   "   + libro1.getAutor());
        System.out.println("Paginas: "   + libro1.getNumeroPaginas());
    }
    
}
