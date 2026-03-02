package tarea;

import java.time.LocalDate;

public class MainTarea {

public static void main(String[] args) {

        // 🔹 Usando el constructor por defecto
        Tarea tarea1 = new Tarea();
        System.out.println("Tarea 1 (constructor vacío): " + tarea1);

        // 🔹 Usando el constructor con parámetros
        Tarea tarea2 = new Tarea(
                LocalDate.of(2025, 3, 1),
                LocalDate.of(2025, 3, 10)
        );
        System.out.println("Tarea 2 (con fechas): " + tarea2);

        // 🔹 Probando validación (esto generará excepción)
        try {
            Tarea tareaInvalida = new Tarea(
                    LocalDate.of(2025, 3, 10),
                    LocalDate.of(2025, 3, 1)
            );
        } catch (IllegalArgumentException e) {
            System.out.println("Error detectado correctamente: " + e.getMessage());
        }
    }
    
}
