import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";

        System.out.println("\n" + ANSI_BLUE + "=========================================");
        System.out.println("|            " + ANSI_CYAN + "MENU PRINCIPAL" + ANSI_BLUE + "             |");
        System.out.println("=========================================" + ANSI_RESET);
        System.out.println();
        System.out.println();


        Profesor profesor1 = new Profesor("Sebastián", "Desarrollo y Scripting con Python", "sebastian@galileo.gt");
        Profesor profesor2 = new Profesor("Ana", "Desarrollo Web", "ana@galileo.gt");

        ArrayList<String> dias = new ArrayList<>();
        dias.add("Lunes");
        dias.add("Viernes");
        Horario horario1 = new Horario(dias, "10 am", "12 pm");
        Horario horario2 = new Horario(dias, "1 pm", "3 pm");

        Curso curso1 = new Curso("Python Basic 101");
        curso1.asignarProfesor(profesor1);
        curso1.definirHorario(horario1);

        Curso curso2 = new Curso("Desarrollo Web 101");
        curso2.asignarProfesor(profesor2);
        curso2.definirHorario(horario2);

        Semestre semestre1 = new Semestre();
        semestre1.añadirCurso(curso1);
        semestre1.añadirCurso(curso2);

        Carrera carrera1 = new Carrera("Ciencias de la Computación", "4 años");
        carrera1.añadirCursoASemestre(1, curso1);
        carrera1.añadirCursoASemestre(1, curso2);

        // Menú
        int opcionPrincipal = 0;
        while (opcionPrincipal != 4) {
            System.out.println(ANSI_BLUE + "1. Editar datos carrera");
            System.out.println("2. Editar director carrera");
            System.out.println("3. Editar cursos carrera");
            System.out.println("4. Salir" + ANSI_RESET);
            System.out.print(ANSI_GREEN + "Seleccione una opción: " + ANSI_RESET);
            opcionPrincipal = scanner.nextInt();

            switch (opcionPrincipal) {
                case 1:
                    // EDITAR DATOS DE LA CARRERA
                    System.out.print("Nombre actual de la carrera: " + carrera1.obtenerNombre()
                            + "\n¿Cuál es el nuevo nombre de la carrera?: ");
                    scanner.nextLine(); // limpiar
                    String nuevoNombreCarrera = scanner.nextLine();

                    System.out.print("Duración actual de la carrera: " + carrera1.obtenerDuracion()
                            + "\n¿Cuál es la nueva duración de la carrera?: ");
                    String nuevaDuracionCarrera = scanner.nextLine();

                    carrera1.actualizarNombre(nuevoNombreCarrera);
                    carrera1.actualizarDuracion(nuevaDuracionCarrera);

                    System.out.println(ANSI_GREEN + "Datos actualizados exitosamente." + ANSI_RESET);
                    break;

                case 2:
                    // EDITAR DIRECTOR
                    scanner.nextLine(); //limpiar
                    System.out.print("Director actual de la carrera: " + carrera1.obtenerDirector()
                            + "\n¿Cuál es el nuevo director de la carrera?: ");
                    String nuevoDirectorCarrera = scanner.nextLine();
                    carrera1.actualizarDirector(nuevoDirectorCarrera);
                    System.out.println(ANSI_GREEN + "Director actualizado exitosamente." + ANSI_RESET);
                    break;

                case 3:
                    int opcionCursos = 0;
                    while (opcionCursos != 6) {
                        System.out.println(ANSI_CYAN + "1. Editar información curso");
                        System.out.println("2. Editar horario curso");
                        System.out.println("3. Editar profesor curso");
                        System.out.println("4. Agregar curso");
                        System.out.println("5. Eliminar curso");
                        System.out.println("6. Regresar" + ANSI_RESET);
                        System.out.print(ANSI_GREEN + "Seleccione una opción: " + ANSI_RESET);
                        opcionCursos = scanner.nextInt();

                        switch (opcionCursos) {
                            case 1:
                                // EDITAR INFO DEL CURSO
                                System.out.print(
                                        "¿Cuál curso deseas editar? (Por número): ");
                                int cursoAEditar = scanner.nextInt();
                                System.out.print("Nuevo nombre del curso: ");
                                scanner.nextLine(); // limpiar
                                String nuevoNombreCurso = scanner.nextLine();
                                curso1.registrarCurso(nuevoNombreCurso);
                                break;
                            case 2:
                                // EDITAR HORARIO
                                System.out.print("¿De qué curso deseas editar el horario? (Por número): ");
                                int cursoHorario = scanner.nextInt();
                                System.out.print("Nuevo horario de inicio (10 am): ");
                                String inicio = scanner.next();
                                System.out.print("Nuevo horario de fin (12 pm): ");
                                String fin = scanner.next();
                                ArrayList<String> nuevosDias = new ArrayList<>();
                                nuevosDias.add("Lunes");
                                Horario nuevoHorario = new Horario(nuevosDias, inicio, fin);
                                curso1.definirHorario(nuevoHorario);
                                break;
                            case 3:
                                // EDITAR PROFESOR
                                System.out.print("¿De qué curso deseas editar el profesor? (Por número): ");
                                int cursoProfesor = scanner.nextInt();
                                System.out.print("Nuevo nombre del profesor: ");
                                scanner.nextLine(); // limpiar
                                String nombreProfesor = scanner.nextLine();
                                Profesor nuevoProfesor = new Profesor(nombreProfesor, "Especialidad",
                                        "correo@example.com");
                                curso1.asignarProfesor(nuevoProfesor);
                                break;
                            case 4:
                                // AGREGAR CURSO
                                System.out.print("Nombre del nuevo curso: ");
                                scanner.nextLine(); // limpiar
                                String nombreCurso = scanner.nextLine();
                                Curso nuevoCurso = new Curso(nombreCurso);
                                semestre1.añadirCurso(nuevoCurso);
                                break;
                            case 5:
                                // ELIMINAR CURSO
                                System.out.print("¿Cuál curso deseas eliminar? (Por número): ");
                                int cursoAEliminar = scanner.nextInt();

                                if (cursoAEliminar == 1) {
                                    semestre1.eliminarCurso(curso1);
                                } else if (cursoAEliminar == 2) {
                                    semestre1.eliminarCurso(curso2);
                                } else {
                                    System.out.println("Intente de nuevo.");
                                }

                                System.out.println(ANSI_RED + "Curso eliminado exitosamente." + ANSI_RESET);
                                break;
                            case 6:
                                // REGRESAR AL MENU
                                break;
                            default:
                                System.out.println("Intente de nuevo.");
                                break;
                        }
                    }
                    break;
                case 4:
                    System.out.println(ANSI_RED + "Saliendo del sistema..." + ANSI_RESET);
                    break;
                default:
                    System.out.println("Intente de nuevo.");
                    break;
            }
        }
        scanner.close();
    }
}
