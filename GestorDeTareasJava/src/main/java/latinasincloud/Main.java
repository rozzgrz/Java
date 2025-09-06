package latinasincloud;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    private static List<String> tareas= new ArrayList<String>();
    private static Scanner scanner = new Scanner(
            System.in
    );
    public static void main(String[] args) {
        int opcion = 0;
        do{
            System.out.println("--- Gestor de Tareas ---");
            System.out.println("1. Ingresar Tarea ");
            System.out.println("2. Eliminar Tarea ");
            System.out.println("3. Mostrar Tarea ");
            System.out.println("4. Buscar Tarea ");
            System.out.println("5. Salir ");
            System.out.print(">Ingrese una opción: ");
            opcion = scanner.nextInt();

            scanner.nextLine();
            switch(opcion){
                case 1:
                    agregarTarea();
                    break;
                case 2:
                    eliminarTarea();
                    break;
                case 3:
                    mostrarTarea();
                    break;
                case 4:
                    buscarTarea();
                    break;
                case 5:
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }
        }while(opcion!=5);

    }
    private static void agregarTarea(){
        System.out.println("Ingrese su tarea ");
        String tarea = scanner.nextLine();
        if(tareas.isEmpty()){
            System.out.println("Tarea no puede ser encontrada");
            return;
        }
        tareas.add(tarea);
        System.out.println("La tarea ha sido agregada.");
    }
    private static void eliminarTarea(){
        System.out.println("Ingrese el indice de la tarea a eliminar:");
        int indice = scanner.nextInt();
        scanner.nextLine();
        String tareaEncontrada = tareas.get(indice);
        if(tareaEncontrada.isEmpty()){
            System.out.println("Tarea no existe en el indice ingresado");
            return;
        }
        tareas.remove(indice);
        System.out.println("La tarea ha sido eliminada.");
    }

    private static void mostrarTarea(){
        if(tareas.isEmpty()) {
            System.out.println("No hay tareas registradas.");
        }else{
            for(int i=0;i <tareas.size();i++){
                System.out.printf("Índice: %d - Tarea: %s. \n",i, tareas.get(i));
            }
        }
    }
    private static void buscarTarea(){
            System.out.print("> Ingrese palabra clave para buscar: ");
            String palabraClave = scanner.nextLine();
            boolean encontreResultados = false;
            for(String tarea: tareas) {
                if (tarea.toLowerCase().contains(palabraClave.toLowerCase())) {
                    encontreResultados = true;
                    System.out.printf("Índice: %d - Tarea: %s.\n", tareas.indexOf(tarea), tarea);
                }

            }
            if(!encontreResultados) {
                System.out.println("No hay tareas con palabra clave.");
            }
    }
}

