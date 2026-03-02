package cuentabancaria2;

import java.time.LocalDate;

public class CuentaBancaria2 {

// Atributos privados
    private String numeroCuenta;
    private double saldo;
    private LocalDate fechaApertura;

    // ─────────────────────────────────────────────
    // Constructor 1: solo número de cuenta → saldo 0
    // ─────────────────────────────────────────────
    public CuentaBancaria2(String numeroCuenta) {
        this(numeroCuenta, 0); // llama al constructor 2 con saldo 0
    }

    // ─────────────────────────────────────────────
    // Constructor 2: número de cuenta + depósito inicial
    // ─────────────────────────────────────────────
    public CuentaBancaria2(String numeroCuenta, double depositoInicial) {

        if (numeroCuenta == null || numeroCuenta.isEmpty()) {
            throw new IllegalArgumentException("El numero de cuenta no puede ser null ni estar vacio");
        }
        if (depositoInicial < 0) {
            throw new IllegalArgumentException("El deposito inicial no puede ser negativo");
        }

        this.numeroCuenta  = numeroCuenta;
        this.saldo         = depositoInicial;
        this.fechaApertura = LocalDate.now(); // siempre es hoy
    }

    // ─────────────────────────────────────────────
    // Depositar → monto debe ser > 0
    // ─────────────────────────────────────────────
    public void depositar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser mayor a 0");
        }
        this.saldo += monto;
        System.out.println("  Depósito exitoso de $" + monto + " → Saldo actual: $" + this.saldo);
    }

    // ─────────────────────────────────────────────
    // Retirar → monto > 0, retorna true/false
    // ─────────────────────────────────────────────
    public boolean retirar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser mayor a 0");
        }
        if (monto > this.saldo) {
            System.out.println("  Saldo insuficiente. Saldo disponible: $" + this.saldo);
            return false;
        }
        this.saldo -= monto;
        System.out.println("  Retiro exitoso de $" + monto + " → Saldo actual: $" + this.saldo);
        return true;
    }

    // ─────────────────────────────────────────────
    // Getters
    // ─────────────────────────────────────────────
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    // toString
    @Override
    public String toString() {
        return "CuentaBancaria{" +
               "numeroCuenta='"  + numeroCuenta  + "'" +
               ", saldo=$"       + saldo          +
               ", fechaApertura=" + fechaApertura +
               "}";
    }

    
}
