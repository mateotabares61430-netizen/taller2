package producto;

public class Producto {


    private String codigo;
    private String nombre;
    private double precio;
    private int stock;

    
    public Producto(String codigo, String nombre, double precio, int stock) {

        if (codigo == null || codigo.isEmpty()) {
            throw new IllegalArgumentException("El codigo no puede ser null ni estar vacio");
        }
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser null ni estar vacio");
        }
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }

        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public Producto(String codigo, String nombre, int precio) {
        this(codigo, nombre, precio, 0);
    }

    
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    
    public void aumentarStock(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }
        this.stock += cantidad;
    }

    
    public boolean vender(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }
        if (cantidad > this.stock) {
            return false; 
        }
        this.stock -= cantidad;
        return true; 
    }

    
    public double valorInventario() {
        return precio * stock;
    }

    // Representacion en texto del objeto
    @Override
    public String toString() {
        return "Producto{" +
               "codigo='" + codigo + "'" +
               ", nombre='" + nombre + "'" +
               ", precio=" + precio +
               ", stock=" + stock +
               "}";
    }    

}
