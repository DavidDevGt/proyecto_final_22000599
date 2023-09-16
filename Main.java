import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Creando profesores
        Profesor profesor1 = new Profesor("Sebastián", "Desarrollo y Scripting con Python", "sebastian@galileo.gt");
        Profesor profesor2 = new Profesor("Ana", "Desarrollo Web", "ana@galileo.gt");

        // Creando horarios
        ArrayList<String> dias = new ArrayList<>();
        dias.add("Lunes");
        dias.add("Viernes");
        Horario horario1 = new Horario(dias, "10 am", "12 pm");
        Horario horario2 = new Horario(dias, "1 pm", "3 pm");

        // Creando cursos
        Curso curso1 = new Curso("Python Basic 101");
        curso1.asignarProfesor(profesor1);
        curso1.definirHorario(horario1);

        Curso curso2 = new Curso("Desarrollo Web 101");
        curso2.asignarProfesor(profesor2);
        curso2.definirHorario(horario2);

        // Creando semestre y añadiendo cursos
        Semestre semestre1 = new Semestre();
        semestre1.añadirCurso(curso1);
        semestre1.añadirCurso(curso2);

        // Creando carrera y añadiendo cursos al semestre
        Carrera carrera1 = new Carrera("Ingeniería en Ciberseguridad", "5 años");
        carrera1.añadirCursoASemestre(1, curso1);
        carrera1.añadirCursoASemestre(1, curso2);

        // Menú principal
        int opcionPrincipal = 0;
        while (opcionPrincipal != 4) {
            System.out.println("1. Editar datos carrera");
            System.out.println("2. Editar director carrera");
            System.out.println("3. Editar cursos carrera");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcionPrincipal = scanner.nextInt();

            switch (opcionPrincipal) {
                case 1:
                    System.out.println("Editar datos de la carrera aún no está implementado.");
                    break;
                case 2:
                    System.out.println("Editar director de la carrera aún no está implementado.");
                    break;
                case 3:
                    int opcionCursos = 0;
                    while (opcionCursos != 6) {
                        System.out.println("1. Editar información curso");
                        System.out.println("2. Editar horario curso");
                        System.out.println("3. Editar profesor curso");
                        System.out.println("4. Agregar curso");
                        System.out.println("5. Eliminar curso");
                        System.out.println("6. Regresar");
                        System.out.print("Seleccione una opción: ");
                        opcionCursos = scanner.nextInt();

                        switch (opcionCursos) {
                            case 1:
                                // EDITAR INFORMACIÓN DEL CURSO
                                System.out.print("¿Cuál curso deseas editar? (Por número, e.g. 1 para el primer curso): ");
                                int cursoAEditar = scanner.nextInt();
                                System.out.print("Nuevo nombre del curso: ");
                                scanner.nextLine();  // Limpiar el buffer
                                String nuevoNombreCurso = scanner.nextLine();
                                curso1.registrarCurso(nuevoNombreCurso);
                                break;
                            case 2:
                                // EDITAR HORARIO DEL CURSO
                                System.out.print("¿De qué curso deseas editar el horario? (Por número): ");
                                int cursoHorario = scanner.nextInt();
                                System.out.print("Nuevo horario de inicio (e.g. 10 am): ");
                                String inicio = scanner.next();
                                System.out.print("Nuevo horario de fin (e.g. 12 pm): ");
                                String fin = scanner.next();
                                ArrayList<String> nuevosDias = new ArrayList<>();
                                nuevosDias.add("Lunes");  // Puedes hacer esto más dinámico si es necesario
                                Horario nuevoHorario = new Horario(nuevosDias, inicio, fin);
                                curso1.definirHorario(nuevoHorario);
                                break;
                            case 3:
                                // EDITAR PROFESOR DEL CURSO
                                System.out.print("¿De qué curso deseas editar el profesor? (Por número): ");
                                int cursoProfesor = scanner.nextInt();
                                System.out.print("Nuevo nombre del profesor: ");
                                scanner.nextLine();  // Limpiar el buffer
                                String nombreProfesor = scanner.nextLine();
                                Profesor nuevoProfesor = new Profesor(nombreProfesor, "Especialidad", "correo@example.com");
                                curso1.asignarProfesor(nuevoProfesor);
                                break;
                            case 4:
                                // AGREGAR CURSO
                                System.out.print("Nombre del nuevo curso: ");
                                scanner.nextLine();  // Limpiar el buffer
                                String nombreCurso = scanner.nextLine();
                                Curso nuevoCurso = new Curso(nombreCurso);
                                semestre1.añadirCurso(nuevoCurso);
                                break;
                            case 5:
                                // ELIMINAR CURSO
                                System.out.print("¿Cuál curso deseas eliminar? (Por número): ");
                                int cursoAEliminar = scanner.nextInt();
                                semestre1.eliminarCurso(curso1);  // Aquí debes implementar la lógica para eliminar el curso basado en la elección del usuario
                                break;
                            case 6:
                                // REGRESAR AL MENÚ PRINCIPAL
                                break;
                            default:
                                System.out.println("Opción no válida. Intente de nuevo.");
                                break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
        scanner.close();
    }
}
