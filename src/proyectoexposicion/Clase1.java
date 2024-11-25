
package proyectoexposicion;

// Clase de tareas pendientes

import java.util.Scanner;

public class Clase1 {
    
    // Atributos
    private String nombre_tarea;
    private String descripcion;
    private int identificador;
    private boolean estado; // False indica pendiente y True Hecha
    private String tiempo_limite;
    
    // Construsctor para la creacion de una tarea

    public Clase1(String nombre_tarea, String descripcion, int identificador, boolean estado, String tiempo_limite) {
        this.nombre_tarea = nombre_tarea;
        this.descripcion = descripcion;
        this.identificador = identificador;
        this.estado = estado;
        this.tiempo_limite = tiempo_limite;
    }
    
    // Setters

    public void setNombre_tarea(String nombre_tarea) {
        this.nombre_tarea = nombre_tarea;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setTiempo_limite(String tiempo_limite) {
        this.tiempo_limite = tiempo_limite;
    }
    
    // Getters

    public String getNombre_tarea() {
        return nombre_tarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getIdentificador() {
        return identificador;
    }

    public boolean isEstado() {
        return estado;
    }

    public String getTiempo_limite() {
        return tiempo_limite;
    }
    
    

    public static void editarTarea(Clase1[] tareas, Scanner input) {
        System.out.print("Ingrese el número identificador de la tarea que desea editar -> ");
        int idTarea = input.nextInt();

        if (idTarea < 0 || idTarea >= tareas.length || tareas[idTarea] == null) {
            System.out.println("El identificador ingresado no es válido o la tarea no existe.");
            return;
        }

        Clase1 tarea = tareas[idTarea];
        System.out.println("Editando la tarea: " + tarea.getNombre_tarea());

        input.nextLine(); // Limpiar el buffer
        System.out.print("Nuevo nombre (actual: " + tarea.getNombre_tarea() + ", deja vacío para no cambiar) -> ");
        String nuevoNombre = input.nextLine();
        if (!nuevoNombre.isEmpty()) {
            tarea.setNombre_tarea(nuevoNombre);
        }

        System.out.print("Nueva descripción (actual: " + tarea.getDescripcion() + ", deja vacío para no cambiar) -> ");
        String nuevaDescripcion = input.nextLine();
        if (!nuevaDescripcion.isEmpty()) {
            tarea.setDescripcion(nuevaDescripcion);
        }

        System.out.print("Nuevo tiempo límite (actual: " + tarea.getTiempo_limite() + ", formato HH:MM) -> ");
        String nuevoTiempo = input.nextLine();
        if (!nuevoTiempo.isEmpty()) {
            while (!validarFormatoHora(nuevoTiempo)) {
                System.out.print("Formato inválido. Ingresa el tiempo límite nuevamente (HH:MM): ");
                nuevoTiempo = input.nextLine();
            }
            tarea.setTiempo_limite(nuevoTiempo);
        }

        System.out.print("¿Cambiar el estado de la tarea? (PENDIENTE/TERMINADA, actual: " + 
        (tarea.isEstado() ? "TERMINADA" : "PENDIENTE") + ") [S/N]: ");
        char cambiarEstado = input.nextLine().toUpperCase().charAt(0);
        if (cambiarEstado == 'S') {
            tarea.setEstado(!tarea.isEstado());
        }

        System.out.println("Tarea actualizada con éxito.");
    }

    // Método para validar el formato de hora HH:MM
    public static boolean validarFormatoHora(String tiempo) {
        String regex = "^([01]?\\d|2[0-3]):([0-5]\\d)$";
        return tiempo.matches(regex);
    } 
    
}
