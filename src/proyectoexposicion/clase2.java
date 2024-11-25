/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoexposicion;

/**
 *
 * @author aless
 */
public class clase2{
    
    
    private String nombreTarea;
    private String descripcionTarea;
    private int idTarea;
    private boolean estadoTarea; // 
    private String limiteTiempo;

    
    public clase2(String nombre, String descripcion, int id, boolean estado, String tiempo) {
        this.nombreTarea = nombre;
        this.descripcionTarea = descripcion;
        this.idTarea = id;
        this.estadoTarea = estado;
        this.limiteTiempo = tiempo;
    }

   
    public String obtenerNombreTarea() {
        return nombreTarea;
    }

    public String obtenerDescripcionTarea() {
        return descripcionTarea;
    }

    public int obtenerIdTarea() {
        return idTarea;
    }

    public boolean verificarEstadoTarea() {
        return estadoTarea;
    }

    public String obtenerLimiteTiempo() {
        return limiteTiempo;
    }

    // Setters personalizados
    public void actualizarNombreTarea(String nombre) {
        this.nombreTarea = nombre;
    }

    public void actualizarDescripcionTarea(String descripcion) {
        this.descripcionTarea = descripcion;
    }

    public void actualizarIdTarea(int id) {
        this.idTarea = id;
    }

    public void cambiarEstadoTarea(boolean estado) {
        this.estadoTarea = estado;
    }

    public void actualizarLimiteTiempo(String tiempo) {
        this.limiteTiempo = tiempo;
    }


}
