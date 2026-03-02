package billetera;

public class Billetera {

// Atributos privados
    private String id;
    private double saldo;

    // ─────────────────────────────────────────────
    // Constructor 1: sin parámetros → valores mínimos seguros
    // ─────────────────────────────────────────────
    public Billetera() {
        this.id    = "BW-0000";
        this.saldo = 0.0;
    }

    // ─────────────────────────────────────────────
    // Constructor 2: solo ID → saldo 0
    // ─────────────────────────────────────────────
    public Billetera(String id) {
        this(id, 0.0); // llama al constructor 3
    }

    // ─────────────────────────────────────────────
    // Constructor 3: ID + saldo inicial
    // ─────────────────────────────────────────────
    public Billetera(String id, double saldoInicial) {

        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException(
                "El ID de la billetera no puede ser null ni estar vacio"
            );
        }
        if (saldoInicial < 0) {
            throw new IllegalArgumentException(
                "El saldo inicial no puede ser negativo. Valor recibido: " + saldoInicial
            );
        }

        this.id    = id.toUpperCase();
        this.saldo = saldoInicial;
    }

    // ─────────────────────────────────────────────
    // pagar() → solo procede si monto > 0 y hay saldo suficiente
    // ─────────────────────────────────────────────
    public boolean pagar(double monto) {

        // ¿El monto es válido?
        if (monto <= 0) {
            throw new IllegalArgumentException(
                "El monto del pago debe ser mayor a 0. Valor recibido: " + monto
            );
        }

        // ¿Hay saldo suficiente?
        if (monto > this.saldo) {
            System.out.println("  ✗ Pago rechazado. Saldo insuficiente." +
                               " Saldo actual: $" + saldo +
                               " | Monto requerido: $" + monto);
            return false;
        }

        // Todo válido → se descuenta el pago
        this.saldo -= monto;
        System.out.println("  ✓ Pago exitoso de $" + monto +
                           " | Saldo restante: $" + saldo);
        return true;
    }

    // ─────────────────────────────────────────────
    // Getters
    // ─────────────────────────────────────────────
    public String getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    // toString
    @Override
    public String toString() {
        return "Billetera{" +
               "id='"    + id    + "'" +
               ", saldo=$" + saldo  +
               "}";
    }
    
}
