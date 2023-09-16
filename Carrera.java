import java.util.ArrayList;

public class Carrera {
    // Atributos
    private String nombreDeLaCarrera;
    private String duracionDeLaCarrera;
    private ArrayList<Semestre> listaDeSemestres;

    // Constructor
    public Carrera(String nombreDeLaCarrera, String duracionDeLaCarrera) {
        this.nombreDeLaCarrera = nombreDeLaCarrera;
        this.duracionDeLaCarrera = duracionDeLaCarrera;
        this.listaDeSemestres = new ArrayList<>();
    }

    // Métodos
    public void registrarCarrera(String nombre, String duracion) {
        this.nombreDeLaCarrera = nombre;
        this.duracionDeLaCarrera = duracion;
    }

    public void modificarDatosCarrera(String nombre, String duracion) {
        this.nombreDeLaCarrera = nombre;
        this.duracionDeLaCarrera = duracion;
    }

    public void añadirCursoASemestre(int numeroSemestre, Curso curso) {
        if (numeroSemestre <= listaDeSemestres.size()) {
            listaDeSemestres.get(numeroSemestre - 1).añadirCurso(curso);
        }
    }

    public void eliminarCarrera() {
        this.nombreDeLaCarrera = "";
        this.duracionDeLaCarrera = "";
        this.listaDeSemestres.clear();
    }
    
    public String getNombreDeLaCarrera() {
        return nombreDeLaCarrera;
    }

    public String getDuracionDeLaCarrera() {
        return duracionDeLaCarrera;
    }
}

class Semestre {
    // Atributos
    private ArrayList<Curso> listaDeCursos;

    // Constructor
    public Semestre() {
        this.listaDeCursos = new ArrayList<>();
    }

    // Métodos
    public void añadirCurso(Curso curso) {
        listaDeCursos.add(curso);
    }
}
