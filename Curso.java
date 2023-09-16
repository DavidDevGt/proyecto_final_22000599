public class Curso {
    // Atributos
    private String nombreDelCurso;
    private Profesor profesor;
    private Horario horario;

    public Curso(String nombreDelCurso) {
        this.nombreDelCurso = nombreDelCurso;
        this.profesor = null;
        this.horario = null;
    }

    public Curso(String nombreDelCurso, Profesor profesor, Horario horario) {
        this.nombreDelCurso = nombreDelCurso;
        this.profesor = profesor;
        this.horario = horario;
    }

    //setters y getters
    public void setNombreDelCurso(String nombre) {
        this.nombreDelCurso = nombre;
    }

    public String getNombreDelCurso() {
        return nombreDelCurso;
    }

    public void asignarProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void definirHorario(Horario horario) {
        this.horario = horario;
    }

    public Horario getHorario() {
        return horario;
    }

    // resetear datos
    public void reset() {
        this.nombreDelCurso = "";
        this.profesor = null;
        this.horario = null;
    }
}
