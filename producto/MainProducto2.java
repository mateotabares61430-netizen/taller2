package producto;

public class MainProducto2 {

public static void main(String[] args) {

        // Crear un producto válido
        Producto p = new Producto("P001", "Manzana", 1500.0, 10);
        System.out.println(p);

        // Aumentar stock
        p.aumentarStock(5);
        System.out.println("Stock después de aumentar: " + p.getStock()); // 15

        // Vender con éxito
        boolean vendido = p.vender(3);
        System.out.println("Venta exitosa: " + vendido);         // true
        System.out.println("Stock después de vender: " + p.getStock()); // 12

        // Intentar vender más del stock disponible
        boolean vendido2 = p.vender(100);
        System.out.println("Venta exitosa: " + vendido2);        // false

        // Valor del inventario
        System.out.println("Valor inventario: " + p.valorInventario());

        // Probar validación del constructor
        try {
            Producto malo = new Producto("", "Pera", 500.0, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Error capturado: " + e.getMessage());
        }
    }
    
}
