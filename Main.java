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
        final String ANSI_YELLOW = "\u001B[33m";

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
            System.out.println("5.Ver información del sistema");
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
                    scanner.nextLine(); // limpiar
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

                        if (opcionCursos >= 1 && opcionCursos <= 5) {
                            // Mostramos la lista de semestres disponibles
                            System.out.println(ANSI_BLUE + "--- Semestres Disponibles ---" + ANSI_RESET);
                            for (int i = 0; i < carrera1.obtenerSemestres().size(); i++) {
                                System.out.println((i + 1) + ". Semestre " + (i + 1));
                            }
                            System.out.println(ANSI_BLUE + "----------------------------" + ANSI_RESET);

                            // Preguntamos qué semestre quiere manejar
                            System.out.print(ANSI_GREEN + "Seleccione un semestre: " + ANSI_RESET);
                            int numSemestreSeleccionado = scanner.nextInt();

                            // Mostramos la lista de cursos disponibles del semestre seleccionado
                            System.out.println(ANSI_BLUE + "--- Cursos Disponibles ---" + ANSI_RESET);
                            ArrayList<Curso> cursosDelSemestre = carrera1
                                    .obtenerCursosDeSemestre(numSemestreSeleccionado);
                            for (int i = 0; i < cursosDelSemestre.size(); i++) {
                                System.out.println((i + 1) + ". " + cursosDelSemestre.get(i).getNombreDelCurso());
                            }
                            System.out.println(ANSI_BLUE + "--------------------------" + ANSI_RESET);
                        }

                        switch (opcionCursos) {
                            case 1:
                                // EDITAR INFO DEL CURSO
                                System.out.print(ANSI_CYAN + "¿Cuál curso deseas editar? (Por número): " + ANSI_RESET);
                                int cursoAEditar = scanner.nextInt();
                                System.out.print(ANSI_CYAN + "Nuevo nombre del curso: " + ANSI_RESET);
                                scanner.nextLine(); // limpiar
                                String nuevoNombreCurso = scanner.nextLine();
                                curso1.setNombreDelCurso(nuevoNombreCurso);
                                break;

                            case 2:
                                // EDITAR HORARIO
                                System.out.print(ANSI_CYAN + "¿De qué curso deseas editar el horario? (Por número): "
                                        + ANSI_RESET);
                                int cursoHorario = scanner.nextInt();
                                scanner.nextLine(); // Consumir el carácter de nueva línea

                                System.out.print(ANSI_CYAN + "Horario de inicio (10 am): " + ANSI_RESET);
                                String inicio = scanner.nextLine();

                                System.out.print(ANSI_CYAN + "Horario de fin (12 pm): " + ANSI_RESET);
                                String fin = scanner.nextLine();

                                ArrayList<String> nuevosDias = new ArrayList<>();
                                System.out.println(ANSI_CYAN + "Ingresa los días separados por comas (Lunes, Martes):"
                                        + ANSI_RESET);
                                String diasInput = scanner.nextLine();
                                String[] diasArray = diasInput.split(",");

                                for (String dia : diasArray) {
                                    nuevosDias.add(dia.trim());
                                }

                                Horario nuevoHorario = new Horario(nuevosDias, inicio, fin);
                                curso1.definirHorario(nuevoHorario);
                                break;

                            case 3:
                                // EDITAR PROFESOR
                                System.out.print(ANSI_CYAN + "¿De qué curso deseas editar el profesor? (Por número): "
                                        + ANSI_RESET);
                                int cursoProfesor = scanner.nextInt();
                                System.out.print(ANSI_CYAN + "Nuevo nombre del profesor: " + ANSI_RESET);
                                scanner.nextLine(); // limpiar
                                String nombreProfesor = scanner.nextLine();
                                Profesor nuevoProfesor = new Profesor(nombreProfesor, "Especialidad",
                                        "correo@example.com");
                                curso1.asignarProfesor(nuevoProfesor);
                                break;

                            case 4:
                                // AGREGAR CURSO
                                System.out.print(ANSI_CYAN + "Nombre del nuevo curso: " + ANSI_RESET);
                                scanner.nextLine(); // limpiar
                                String nombreCurso = scanner.nextLine();
                                Curso nuevoCurso = new Curso(nombreCurso);
                                semestre1.añadirCurso(nuevoCurso);
                                break;

                            case 5:
                                // ELIMINAR CURSO
                                System.out
                                        .print(ANSI_CYAN + "¿Cuál curso deseas eliminar? (Por número): " + ANSI_RESET);
                                int cursoAEliminar = scanner.nextInt();

                                if (cursoAEliminar == 1) {
                                    semestre1.eliminarCurso(curso1);
                                } else if (cursoAEliminar == 2) {
                                    semestre1.eliminarCurso(curso2);
                                } else {
                                    System.out.println(ANSI_YELLOW + "Intente de nuevo." + ANSI_RESET);
                                }

                                System.out.println(ANSI_RED + "Curso eliminado exitosamente." + ANSI_RESET);
                                break;

                            case 6:
                                // REGRESAR AL MENU
                                break;

                            default:
                                System.out.println(ANSI_YELLOW + "Intente de nuevo." + ANSI_RESET);
                                break;

                        }
                    }
                    break;
                case 4:
                    System.out.println(ANSI_RED + "Saliendo del sistema..." + ANSI_RESET);
                    break;
                case 5:
                    // Mostrar información del sistema
                    System.out.println(ANSI_BLUE + "====== Información del Sistema ======" + ANSI_RESET);
                    System.out.println("Nombre de la carrera: " + carrera1.obtenerNombre());
                    System.out.println("Duración de la carrera: " + carrera1.obtenerDuracion());
                    System.out.println("Director de la carrera: " + carrera1.obtenerDirector());

                    // Información de los cursos
                    System.out.println(ANSI_CYAN + "--- Cursos ---" + ANSI_RESET);
                    System.out.println("Curso 1: " + curso1.getNombreDelCurso());
                    System.out.println("Profesor: " + profesor1.getNombreDelProfesor());

                    System.out.println("Curso 2: " + curso2.getNombreDelCurso());
                    System.out.println("Profesor: " + profesor2.getNombreDelProfesor());

                    System.out.println(ANSI_BLUE + "====================================" + ANSI_RESET);
                    break;

                default:
                    System.out.println("Intente de nuevo.");
                    break;
            }
        }
        scanner.close();
    }
}
