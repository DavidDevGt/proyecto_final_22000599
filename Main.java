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
        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_WHITE = "\u001B[37m";

        System.out.println("\n" + ANSI_BLUE + "=========================================");
        System.out.println(ANSI_RED + "|" + ANSI_CYAN + "           " + ANSI_GREEN + "SISTEMA DE GESTIÓN" + ANSI_CYAN
                + "          " + ANSI_RED + "|");
        System.out.println(ANSI_BLUE + "=========================================" + ANSI_RESET);
        System.out.println();

        Profesor profesor1 = new Profesor("Sebastián", "Desarrollo y Scripting con Python", "sebastian@galileo.gt");
        Profesor profesor3 = new Profesor("Carlos", "Inteligencia Artificial", "carlos@galileo.gt");
        Profesor profesor2 = new Profesor("Ana", "Desarrollo Web", "ana@galileo.gt");
        Profesor profesor4 = new Profesor("Luisa", "Redes y Comunicaciones", "luisa@galileo.gt");
        Profesor profesor5 = new Profesor("Pedro", "Bases de Datos Avanzadas", "pedro@galileo.gt");

        ArrayList<String> dias1 = new ArrayList<>();
        dias1.add("Lunes");
        dias1.add("Viernes");

        ArrayList<String> dias2 = new ArrayList<>();
        dias2.add("Martes");
        dias2.add("Jueves");

        ArrayList<String> dias3 = new ArrayList<>();
        dias3.add("Miércoles");
        dias3.add("Viernes");

        ArrayList<String> dias4 = new ArrayList<>();
        dias4.add("Lunes");
        dias4.add("Miércoles");

        Horario horario1 = new Horario(dias1, "10 am", "12 pm");
        Horario horario2 = new Horario(dias1, "1 pm", "3 pm");
        Horario horario3 = new Horario(dias2, "2 pm", "4 pm");
        Horario horario4 = new Horario(dias3, "9 am", "11 am");
        Horario horario5 = new Horario(dias4, "3 pm", "5 pm");

        Curso curso1 = new Curso("Python en el Backend");
        curso1.asignarProfesor(profesor1);
        curso1.definirHorario(horario1);

        Curso curso2 = new Curso("Desarrollo Web con Javascript");
        curso2.asignarProfesor(profesor2);
        curso2.definirHorario(horario2);

        Curso curso3 = new Curso("Introducción a la IA");
        curso3.asignarProfesor(profesor3);
        curso3.definirHorario(horario3);

        Curso curso4 = new Curso("Redes Computacionales");
        curso4.asignarProfesor(profesor4);
        curso4.definirHorario(horario4);

        Curso curso5 = new Curso("Bases de Datos II");
        curso5.asignarProfesor(profesor5);
        curso5.definirHorario(horario5);

        Semestre semestre1 = new Semestre();
        Semestre semestre2 = new Semestre();

        Carrera carrera1 = new Carrera("Desarrollo Fullstack Web", "4 años");
        carrera1.añadirSemestre(semestre1);
        carrera1.añadirCursoASemestre(1, curso1);
        carrera1.añadirCursoASemestre(1, curso2);
        carrera1.añadirCursoASemestre(1, curso3);

        Carrera carrera2 = new Carrera("Ingeniería de Sistemas", "5 años");
        carrera2.añadirSemestre(semestre2);
        carrera2.añadirCursoASemestre(1, curso4);
        carrera2.añadirCursoASemestre(1, curso5);

        // Menú
        int opcionPrincipal = 0;
        Carrera carreraActual = null;

        while (opcionPrincipal != 4) {
            System.out.println(ANSI_BLUE + "1. Editar datos carrera");
            System.out.println("2. Editar director carrera");
            System.out.println("3. Editar cursos carrera");
            System.out.println("4. Salir" + ANSI_RESET);
            System.out.println("5. Ver información del sistema");
            System.out.print(ANSI_GREEN + "Seleccione una opción: " + ANSI_RESET);
            opcionPrincipal = scanner.nextInt();

            if (opcionPrincipal >= 1 && opcionPrincipal <= 3) {
                // Esto es para evitar que te pregunte 2 veces en el case 5
                System.out.println(ANSI_CYAN + "Seleccione una carrera:" + ANSI_RESET);
                System.out.println("1. " + carrera1.obtenerNombre());
                System.out.println("2. " + carrera2.obtenerNombre());
                int opcionCarrera = scanner.nextInt();

                if (opcionCarrera == 1) {
                    carreraActual = carrera1;
                } else {
                    carreraActual = carrera2;
                }
            }

            switch (opcionPrincipal) {
                case 1:
                    // EDITAR DATOS DE LA CARRERA
                    System.out.print("Nombre actual de la carrera: " + carreraActual.obtenerNombre()
                            + "\n¿Cuál es el nuevo nombre de la carrera?: ");
                    scanner.nextLine(); // limpiar
                    String nuevoNombreCarrera = scanner.nextLine();

                    System.out.print("Duración actual de la carrera: " + carreraActual.obtenerDuracion()
                            + "\n¿Cuál es la nueva duración de la carrera?: ");
                    String nuevaDuracionCarrera = scanner.nextLine();

                    carreraActual.actualizarNombre(nuevoNombreCarrera);
                    carreraActual.actualizarDuracion(nuevaDuracionCarrera);

                    System.out.println(ANSI_GREEN + "Datos actualizados exitosamente." + ANSI_RESET);
                    break;

                case 2:
                    // EDITAR DIRECTOR
                    scanner.nextLine(); // limpiar
                    System.out.print("Director actual de la carrera: " + carreraActual.obtenerDirector()
                            + "\n¿Cuál es el nuevo director de la carrera?: ");
                    String nuevoDirectorCarrera = scanner.nextLine();
                    carreraActual.actualizarDirector(nuevoDirectorCarrera);
                    System.out.println(ANSI_GREEN + "Director actualizado exitosamente." + ANSI_RESET);
                    break;

                case 3:
                    int opcionCursos = 0;
                    ArrayList<Curso> cursosDelSemestre = null;

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
                            // Mostrar semestres
                            System.out.println(ANSI_BLUE + "--- Semestres Disponibles ---" + ANSI_RESET);
                            for (int i = 0; i < carrera1.obtenerSemestres().size(); i++) {
                                System.out.println((i + 1) + ". Semestre " + (i + 1));
                            }
                            System.out.println(ANSI_BLUE + "----------------------------" + ANSI_RESET);

                            // que semestre quiere
                            System.out.print(ANSI_GREEN + "Seleccione un semestre: " + ANSI_RESET);
                            int numSemestreSeleccionado = scanner.nextInt();
                            Semestre semestreSeleccionado = carrera1.obtenerSemestres()
                                    .get(numSemestreSeleccionado - 1);

                            // la lista de cursos del semestre
                            System.out.println(ANSI_BLUE + "--- Cursos Disponibles ---" + ANSI_RESET);
                            cursosDelSemestre = semestreSeleccionado.obtenerCursos();
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
                                if (cursoAEditar > 0 && cursoAEditar <= cursosDelSemestre.size()) {
                                    Curso cursoSeleccionado = cursosDelSemestre.get(cursoAEditar - 1);
                                    System.out.print(ANSI_CYAN + "Nuevo nombre del curso: " + ANSI_RESET);
                                    scanner.nextLine(); // limpiar
                                    String nuevoNombreCurso = scanner.nextLine();
                                    cursoSeleccionado.setNombreDelCurso(nuevoNombreCurso);
                                } else {
                                    System.out.println(ANSI_RED + "Número de curso inválido." + ANSI_RESET);
                                }
                                break;

                            case 2:
                                // EDITAR HORARIO
                                System.out.print(ANSI_CYAN + "¿De qué curso deseas editar el horario? (Por número): "
                                        + ANSI_RESET);
                                int cursoHorario = scanner.nextInt();
                                if (cursoHorario > 0 && cursoHorario <= cursosDelSemestre.size()) {
                                    Curso cursoParaHorario = cursosDelSemestre.get(cursoHorario - 1);
                                    scanner.nextLine();

                                    System.out.print(ANSI_CYAN + "Horario de inicio (Ejemplo: 10:00): " + ANSI_RESET);
                                    String inicio = scanner.nextLine();

                                    System.out.print(ANSI_CYAN + "Horario de fin (Ejemplo: 14:30): " + ANSI_RESET);
                                    String fin = scanner.nextLine();

                                    if (inicio.compareTo(fin) >= 0) {
                                        System.out.println(
                                                ANSI_RED + "Hora de inicio no puede ser mayor o igual a hora de fin."
                                                        + ANSI_RESET);
                                        break;
                                    }

                                    ArrayList<String> nuevosDias = new ArrayList<>();
                                    System.out.println(ANSI_CYAN
                                            + "Ingresa los días separados por comas (Lunes, Martes):" + ANSI_RESET);
                                    String diasInput = scanner.nextLine();
                                    String[] diasArray = diasInput.split(",");

                                    for (String dia : diasArray) {
                                        nuevosDias.add(dia.trim());
                                    }

                                    Horario nuevoHorario = new Horario(nuevosDias, inicio, fin);
                                    boolean horarioValido = true;

                                    for (Curso otroCurso : cursosDelSemestre) {
                                        if (otroCurso != cursoParaHorario
                                                && !nuevoHorario.validarHorario(otroCurso.getHorario())) {
                                            horarioValido = false;
                                            break;
                                        }
                                    }

                                    if (horarioValido) {
                                        cursoParaHorario.definirHorario(nuevoHorario);
                                    } else {
                                        System.out.println(
                                                ANSI_RED + "El horario se superpone con otro curso." + ANSI_RESET);
                                    }
                                } else {
                                    System.out.println(ANSI_RED + "Número de curso inválido." + ANSI_RESET);
                                }
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

                                if (cursoAEliminar > 0 && cursoAEliminar <= cursosDelSemestre.size()) {
                                    Curso cursoParaEliminar = cursosDelSemestre.get(cursoAEliminar - 1);
                                    semestre1.eliminarCurso(cursoParaEliminar);
                                    System.out.println(ANSI_RED + "Curso eliminado exitosamente." + ANSI_RESET);
                                } else {
                                    System.out.println(ANSI_YELLOW + "Intente de nuevo." + ANSI_RESET);
                                }
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

                    // 1. lista de carreras
                    ArrayList<Carrera> carreras = new ArrayList<>();
                    carreras.add(carrera1);
                    carreras.add(carrera2); // Aqui deberia de usar un ciclo para que cuando agregue uno automaticamente
                                            // se agregue aca, pero pues

                    System.out.println(ANSI_CYAN + "=== Elije una Carrera ===" + ANSI_RESET);
                    for (int i = 0; i < carreras.size(); i++) {
                        System.out.println((i + 1) + ". " + carreras.get(i).obtenerNombre());
                    }
                    System.out.print(ANSI_GREEN + "Seleccione una carrera: " + ANSI_RESET);
                    int carreraElegidaIndex = scanner.nextInt() - 1;
                    Carrera carreraElegida = carreras.get(carreraElegidaIndex);

                    // 2. lista de semestres de la carrera
                    System.out.println(ANSI_CYAN + "=== Elije un Semestre de " + carreraElegida.obtenerNombre() + " ==="
                            + ANSI_RESET);
                    ArrayList<Semestre> semestres = carreraElegida.obtenerSemestres();
                    for (int i = 0; i < semestres.size(); i++) {
                        System.out.println((i + 1) + ". Semestre " + (i + 1));
                    }
                    System.out.print(ANSI_GREEN + "Seleccione un semestre: " + ANSI_RESET);
                    int semestreElegidoIndex = scanner.nextInt() - 1;
                    Semestre semestreElegido = semestres.get(semestreElegidoIndex);

                    // 3. info de los cursos del semestre
                    System.out.println(
                            ANSI_CYAN + "=== Cursos del Semestre " + (semestreElegidoIndex + 1) + " ===" + ANSI_RESET);
                    ArrayList<Curso> cursos = semestreElegido.obtenerCursos();
                    for (Curso curso : cursos) {
                        System.out.println("   Curso: " + curso.getNombreDelCurso());
                        Profesor profesor = curso.getProfesor();
                        System.out.println("      Profesor: " + profesor.getNombreDelProfesor());
                        System.out.println("      Especialidad: " + profesor.getEspecialidad());
                        Horario horarioCurso = curso.getHorario();
                        System.out.println("      Horario: " + horarioCurso.getDiasDeLaSemana() + " de "
                                + horarioCurso.getHoraInicio() + " a " + horarioCurso.getHoraFinalizacion());
                    }
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
