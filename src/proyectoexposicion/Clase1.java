
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
    
    
    
}
