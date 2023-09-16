public class Profesor {
    // atributos
    private String nombreDelProfesor;
    private String especialidad;
    private String correoElectronico;

    // constructor
    public Profesor(String nombreDelProfesor, String especialidad, String correoElectronico) {
        this.nombreDelProfesor = nombreDelProfesor;
        this.especialidad = especialidad;
        this.correoElectronico = correoElectronico;
    }

    // getters y setters
    public void setNombreDelProfesor(String nombre) {
        this.nombreDelProfesor = nombre;
    }

    public String getNombreDelProfesor() {
        return nombreDelProfesor;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setCorreoElectronico(String correo) {
        this.correoElectronico = correo;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    //reset
    public void reset() {
        this.nombreDelProfesor = "";
        this.especialidad = "";
        this.correoElectronico = "";
    }
}
