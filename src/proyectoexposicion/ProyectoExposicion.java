
package proyectoexposicion;
import java.util.Scanner;
import java.util.Random;

// ADMINISTRADOR DE TAREAS
public class ProyectoExposicion {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rd = new Random();
        
        // Crear objeto "TAREA"
        // False indica pendiente
        Clase1 tarea_default = new Clase1("Tarea1", "primera tarea", 0, false, "00:00");
        
        Clase1[] tareas = new Clase1[5];
        
        int opcion = 0; // Eleccion de accion del usuario
        for (int i = 0; opcion != 6; i++) {
            
            System.out.println("OPCIONES");
            System.out.println("1. Nueva tarea");
            System.out.println("2. Mostrar tareas");
            System.out.println("3. Editar tarea");
            System.out.println("4. Eliminar tarea");
            System.out.println("5. Marcar tarea como hecha");
            System.out.println("6. Salir / Mostrar lo trabajado");
            
            System.out.print("Ingresa el numero de la opcion -> ");
            opcion = input.nextInt();
            
            switch (opcion){
                case 1:
                    
                    input.nextLine();
                    
                    if (i < tareas.length){
                    // Crear tarea

                    System.out.print("Nombre de la tarea -> "); String nombre_tarea = input.nextLine();
                    tarea_default.setNombre_tarea(nombre_tarea);
                    System.out.print("Descripcion -> "); String descripcion = input.nextLine();
                    tarea_default.setDescripcion(descripcion);

                    // El numero identificador de la tarea es en la posicion donde se encuentra en el arreglo
                    int identificador = i;

                    System.out.print("Identificador de tarea = " + identificador);
                    tarea_default.setIdentificador(identificador);
                    System.out.println(); // Salto de línea

                    System.out.print("Estado (Pendiente)"); boolean estado = false;
                    tarea_default.setEstado(estado);
                    System.out.println(); // Salto de línea

                    
                    String tiempo_limite;
                    do {
                        System.out.print("Ingresa límite de tiempo en formato HH:MM -> ");
                        tiempo_limite = input.next();

                        if (!validarFormatoHora(tiempo_limite)) {
                            System.out.println("Formato incorrect. ejemplo de como ingresarla hora (20:00)");
                        }
                    } while (!validarFormatoHora(tiempo_limite));

                    // Una vez validado, asignamos el tiempo límite a la tarea
                    tarea_default.setTiempo_limite(tiempo_limite);

                        
                    // Agregar tarea al array de tareas
                    tareas [i] = new Clase1(nombre_tarea, descripcion, identificador, estado, tiempo_limite);
                    
                    System.out.println("Tarea creada con exito");
                    
                    input.nextLine();
                    
                    // El arreglo solo soporta para 5 tareas
                    } else if (i == tareas.length -1) {
                        System.out.println("Solo tienes espacio para una tarea mas");
                        System.out.println("Seguro quieres agregar otra? Si o No -> ");
                        char eleccion = input.next().charAt(0);
                        
                        if (eleccion == 's' || eleccion == 'S'){
                            // LLamamos al método de crear tarea
                            
                            System.out.println("Tarea creada");
                            
                        } else {
                            break;
                        }
                    }
                    
                    break;
                    
                case 2:
                    // Mostrar detalles de tarea elegida por el usuario
                    
                    
                    System.out.print("Imprimir detalles de tarea: (Ingrese numero identifiacador) -> "); int n_tarea = input.nextInt();
                    
                    if (tareas[n_tarea] != null){
                    
                    System.out.println("Nomnre de la tarea: " + tareas[n_tarea].getNombre_tarea());
                    System.out.println("Descripcion de la tarea: " + tareas[n_tarea].getDescripcion());
                    System.out.println("Identificador de la tarea: " + tareas[n_tarea].getIdentificador());
                    System.out.print("Estado de la tarea: ");
                    if (tareas[n_tarea].isEstado() == false){
                        System.out.print("PENDIENTE");
                    } else {
                        System.out.print("TERMINADA");
                    }
                    System.out.println(); // Salto de linea

                    System.out.println("Tiempo limite de la tarea: " + tareas[n_tarea].getTiempo_limite());
                    
                    } else {
                        System.out.println("No hay tarea");
                    }
                    
                    break;
                    
                case 3:
                 
                 
                    System.out.print("Ingresa el número identificador de la tarea a editar -> ");
                    int idEditar = input.nextInt();

                    if (idEditar >= 0 && idEditar < tareas.length && tareas[idEditar] != null) {
                        // Mostrar información actual de la tarea
                        System.out.println("Tarea seleccionada:");
                        System.out.println("1. Nombre: " + tareas[idEditar].getNombre_tarea());
                        System.out.println("2. Descripción: " + tareas[idEditar].getDescripcion());
                        System.out.println("3. Estado: " + (tareas[idEditar].isEstado() ? "TERMINADA" : "PENDIENTE"));
                        System.out.println("4. Límite de tiempo: " + tareas[idEditar].getTiempo_limite());

                        System.out.println("¿Qué deseas editar?");
                        System.out.println("1. Nombre");
                        System.out.println("2. Descripción");
                        System.out.println("3. Estado");
                        System.out.println("4. Límite de tiempo");

                        int campoEditar = input.nextInt();
                        input.nextLine(); // Limpiar el buffer

                        switch (campoEditar) {
                            case 1:
                                System.out.print("Nuevo nombre -> ");
                                String nuevoNombre = input.nextLine();
                                tareas[idEditar].setNombre_tarea(nuevoNombre);
                                System.out.println("Nombre actualizado con éxito.");
                                break;
                            case 2:
                                System.out.print("Nueva descripción -> ");
                                String nuevaDescripcion = input.nextLine();
                                tareas[idEditar].setDescripcion(nuevaDescripcion);
                                System.out.println("Descripción actualizada con éxito.");
                                break;
                            case 3:
                                System.out.print("Nuevo estado (true para terminada, false para pendiente) -> ");
                                boolean nuevoEstado = input.nextBoolean();
                                tareas[idEditar].setEstado(nuevoEstado);
                                System.out.println("Estado actualizado con éxito.");
                                break;
                            case 4:
                                String nuevoTiempo;
                                do {
                                    System.out.print("Nuevo límite de tiempo (HH:MM) -> ");
                                    nuevoTiempo = input.nextLine();
                                    if (!validarFormatoHora(nuevoTiempo)) {
                                        System.out.println("Formato incorrecto. Ejemplo: 20:00");
                                    }
                                } while (!validarFormatoHora(nuevoTiempo));
                                tareas[idEditar].setTiempo_limite(nuevoTiempo);
                                System.out.println("Límite de tiempo actualizado con éxito.");
                                break;
                            default:
                                System.out.println("Opción inválida.");
                        }
                    } else {
                        System.out.println("Tarea no encontrada o ID inválido.");
                    }
                    break;
                    
                case 4:
                    // Eliminar tarea
                    
                    System.out.println("Que tarea deseas eliminar?");
                    
                    // Imprimir todas las tareas registradas en el arreglo
                    for (int tareas_registradas = 0; tareas_registradas < tareas.length; tareas_registradas++) {
                        
                        if (tareas[tareas_registradas] != null) {
                            
                            System.out.println("Tarea " + tareas[tareas_registradas].getIdentificador());
                            
                            // En vez de esto hay que usar el método
                            
                            System.out.println("Nomnre de la tarea: " + tareas[tareas_registradas].getNombre_tarea());
                            System.out.println("Descripcion de la tarea: " + tareas[tareas_registradas].getDescripcion());
                            
                            System.out.print("Estado de la tarea: ");
                            if (tareas[tareas_registradas].isEstado() == false){
                                System.out.print("PENDIENTE");
                            } else {
                                System.out.print("TERMINADA");
                            }
                            System.out.println(); // Salto de linea

                            System.out.println("Tiempo limite de la tarea: " + tareas[tareas_registradas].getTiempo_limite());

                        } else {
                            System.out.print("");
                        }
                        
                    }
                    System.out.print("Ingresa el numero (identificador) de la tarea para eliminarla -> ");
                    int remove = input.nextInt();
                            
                    // Proceso de eliminar
                    tareas[remove] = tarea_default;
                            
                    System.out.println("Tarea eliminada con éxito");
                    
                    break;
                    
                case 5:
                    // Marcar tarea como hecha
                    
                    // Usamos el método de imprimir y luego le preguntamos al user cual quiere marcar
                    
                    // Yo voy a hacer el método para marcarla
                    
                    break;
                    
                case 6:
                    break;
                    
                default:
                    System.out.println("Opcion no valida");
                    
                    
            
            }
            
            
        }
        
        System.out.println("Vuelve pronto");
        System.out.println("Trabajado hoy");
        // usar el método de impresion
                    
        // Si nos da tiempo, hcaemos la suma del total de hora trabajadas y lo imprimimos
            
       
    
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
