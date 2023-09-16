public class Profesor {
    // Atributos
    private String nombreDelProfesor;
    private String especialidad;
    private String correoElectronico;

    // Constructor
    public Profesor(String nombreDelProfesor, String especialidad, String correoElectronico) {
        this.nombreDelProfesor = nombreDelProfesor;
        this.especialidad = especialidad;
        this.correoElectronico = correoElectronico;
    }

    // Métodos
    public void registrarProfesor(String nombre, String especialidad, String correo) {
        this.nombreDelProfesor = nombre;
        this.especialidad = especialidad;
        this.correoElectronico = correo;
    }

    public void modificarDatosProfesor(String nombre, String especialidad, String correo) {
        this.nombreDelProfesor = nombre;
        this.especialidad = especialidad;
        this.correoElectronico = correo;
    }

    public void eliminarProfesor() {
        this.nombreDelProfesor = "";
        this.especialidad = "";
        this.correoElectronico = "";
    }

    public String getNombreDelProfesor() {
        return nombreDelProfesor;
    }
}
