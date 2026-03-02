package tarea;

import java.time.LocalDate;

public class Tarea {

 private LocalDate fechaInicio;
    private LocalDate fechaFin;

    // 🔹 Constructor 1: Valores mínimos (no nulos)
    public Tarea() {
        this.fechaInicio = LocalDate.now();
        this.fechaFin = this.fechaInicio; // Mismo día como valor mínimo válido
    }

    // 🔹 Constructor 2: Con parámetros
    public Tarea(LocalDate fechaInicio, LocalDate fechaFin) {
        if (fechaInicio == null || fechaFin == null) {
            throw new IllegalArgumentException("Las fechas no pueden ser nulas.");
        }

        if (fechaFin.isBefore(fechaInicio)) {
            throw new IllegalArgumentException("La fecha de fin no puede ser anterior a la fecha de inicio.");
        }

        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    // 🔹 Getters
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    // 🔹 Setter con validación
    public void setFechaFin(LocalDate fechaFin) {
        if (fechaFin == null) {
            throw new IllegalArgumentException("La fecha de fin no puede ser nula.");
        }

        if (fechaFin.isBefore(this.fechaInicio)) {
            throw new IllegalArgumentException("La fecha de fin no puede ser anterior a la fecha de inicio.");
        }

        this.fechaFin = fechaFin;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        if (fechaInicio == null) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser nula.");
        }

        if (this.fechaFin != null && this.fechaFin.isBefore(fechaInicio)) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de fin.");
        }

        this.fechaInicio = fechaInicio;
    }

    @Override
    public String toString() {
        return "Tarea [fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
    }
    
}
