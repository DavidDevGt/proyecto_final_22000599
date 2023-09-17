import java.util.ArrayList;

public class Carrera {
    // Atributos
    private String nombreDeLaCarrera;
    private String duracionDeLaCarrera;
    private String directorDeLaCarrera;
    private ArrayList<Semestre> listaDeSemestres;

    // Constructor
    public Carrera(String nombreDeLaCarrera, String duracionDeLaCarrera) {
        this.nombreDeLaCarrera = nombreDeLaCarrera;
        this.duracionDeLaCarrera = duracionDeLaCarrera;
        this.listaDeSemestres = new ArrayList<>();
    }

    // Métodos para registrar y modificar datos de la carrera
    public void registrarCarrera(String nombre, String duracion) {
        this.nombreDeLaCarrera = nombre;
        this.duracionDeLaCarrera = duracion;
    }

    public void modificarDatosCarrera(String nombre, String duracion) {
        this.nombreDeLaCarrera = nombre;
        this.duracionDeLaCarrera = duracion;
    }

    public void actualizarNombre(String nombre) {
        this.nombreDeLaCarrera = nombre;
    }

    public void actualizarDuracion(String duracion) {
        this.duracionDeLaCarrera = duracion;
    }

    public void actualizarDirector(String director) {
        this.directorDeLaCarrera = director;
    }

    public String obtenerNombre() {
        return this.nombreDeLaCarrera;
    }

    public String obtenerDuracion() {
        return this.duracionDeLaCarrera;
    }

    public String obtenerDirector() {
        return this.directorDeLaCarrera;
    }

    // Método para agregar un curso a un semestre
    public void añadirCursoASemestre(int numeroSemestre, Curso curso) {
        if (numeroSemestre <= listaDeSemestres.size()) {
            listaDeSemestres.get(numeroSemestre - 1).añadirCurso(curso);
        }
    }

    // Método para eliminar info de la carrera
    public void eliminarCarrera() {
        this.nombreDeLaCarrera = "";
        this.duracionDeLaCarrera = "";
        this.listaDeSemestres.clear();
    }

    // Método todos los semestres
    public ArrayList<Semestre> obtenerSemestres() {
        return this.listaDeSemestres;
    }

    // Método lista de cursos de semestre
    public ArrayList<Curso> obtenerCursosDeSemestre(int numeroSemestre) {
        if (numeroSemestre <= listaDeSemestres.size()) {
            return listaDeSemestres.get(numeroSemestre - 1).obtenerCursos();
        }
        return new ArrayList<>(); // vacío si el semestre no existe
    }

    // Método para añadir un semestre
    public void añadirSemestre(Semestre semestre) {
        listaDeSemestres.add(semestre);
    }

}

class Semestre {
    // Atributos
    private ArrayList<Curso> listaDeCursos;

    // Constructor
    public Semestre() {
        this.listaDeCursos = new ArrayList<>();
    }

    // Método para añadir un curso al semestre
    public void añadirCurso(Curso curso) {
        listaDeCursos.add(curso);
    }

    // Método para eliminar un curso del semestre
    public void eliminarCurso(Curso curso) {
        listaDeCursos.remove(curso);
    }

    // Método para obtener la lista de cursos del semestre
    public ArrayList<Curso> obtenerCursos() {
        return this.listaDeCursos;
    }
}
