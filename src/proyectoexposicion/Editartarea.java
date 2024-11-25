/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoexposicion;

import java.util.Scanner;

/**
 *
 * @author aless
 */
import java.util.Scanner;

public class Editartarea {

    public static void editarTarea(clase2[] tareas, Scanner input) {
        System.out.print("Ingrese el número identificador de la tarea que desea editar -> ");
        int idTarea = input.nextInt();

        if (idTarea < 0 || idTarea >= tareas.length || tareas[idTarea] == null) {
            System.out.println("El identificador ingresado no es válido o la tarea no existe.");
            return;
        }

        clase2 tarea = tareas[idTarea];
        System.out.println("Editando la tarea: " + tarea.obtenerNombreTarea());

        input.nextLine(); // Limpiar el buffer
        System.out.print("Nuevo nombre (actual: " + tarea.obtenerNombreTarea() + ", deja vacío para no cambiar) -> ");
        String nuevoNombre = input.nextLine();
        if (!nuevoNombre.isEmpty()) {
            tarea.actualizarNombreTarea(nuevoNombre);
        }

        System.out.print("Nueva descripción (actual: " + tarea.obtenerDescripcionTarea() + ", deja vacío para no cambiar) -> ");
        String nuevaDescripcion = input.nextLine();
        if (!nuevaDescripcion.isEmpty()) {
            tarea.actualizarDescripcionTarea(nuevaDescripcion);
        }

        System.out.print("Nuevo tiempo límite (actual: " + tarea.obtenerLimiteTiempo() + ", formato HH:MM) -> ");
        String nuevoTiempo = input.nextLine();
        if (!nuevoTiempo.isEmpty()) {
            while (!validarFormatoHora(nuevoTiempo)) {
                System.out.print("Formato inválido. Ingresa el tiempo límite nuevamente (HH:MM): ");
                nuevoTiempo = input.nextLine();
            }
            tarea.actualizarLimiteTiempo(nuevoTiempo);
        }

        System.out.print("¿Cambiar el estado de la tarea? (PENDIENTE/TERMINADA, actual: " + 
        (tarea.verificarEstadoTarea() ? "TERMINADA" : "PENDIENTE") + ") [S/N]: ");
        char cambiarEstado = input.nextLine().toUpperCase().charAt(0);
        if (cambiarEstado == 'S') {
            tarea.cambiarEstadoTarea(!tarea.verificarEstadoTarea());
        }

        System.out.println("Tarea actualizada con éxito.");
    }

   public static boolean validarFormatoHora(String tiempo) {
        if (tiempo == null || tiempo.length() != 5 || tiempo.charAt(2) != ':') {
            return false;
        }

        
        if (!Character.isDigit(tiempo.charAt(0)) || !Character.isDigit(tiempo.charAt(1)) ||
            !Character.isDigit(tiempo.charAt(3)) || !Character.isDigit(tiempo.charAt(4))) {
            return false;
        }

      
        int horas = (tiempo.charAt(0) - '0') * 10 + (tiempo.charAt(1) - '0');
        int minutos = (tiempo.charAt(3) - '0') * 10 + (tiempo.charAt(4) - '0');

        
        return horas >= 0 && horas <= 23 && minutos >= 0 && minutos <= 59;
    }
}

