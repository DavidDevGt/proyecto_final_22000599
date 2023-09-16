public class Curso {
    // Atributos
    private String nombreDelCurso;
    private Profesor profesor;
    private Horario horario;

    // Constructor
    public Curso(String nombreDelCurso) {
        this.nombreDelCurso = nombreDelCurso;
        this.profesor = null;
        this.horario = null;
    }

    // Métodos
    public void registrarCurso(String nombre) {
        this.nombreDelCurso = nombre;
    }

    public void modificarDatosCurso(String nombre) {
        this.nombreDelCurso = nombre;
    }

    public void asignarProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public void definirHorario(Horario horario) {
        this.horario = horario;
    }

    public void eliminarCurso() {
        this.nombreDelCurso = "";
        this.profesor = null;
        this.horario = null;
    }

    public String getNombreDelCurso() {
        return nombreDelCurso;
    }

    public Profesor getProfesor() {
        return profesor;
    }
}
