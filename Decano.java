public class Decano {
    //atributos
    private String nombreDelDecano;
    private String facultad;
    private String correoElectronico;

    //constructor
    public Decano(String nombreDelDecano, String facultad, String correoElectronico) {
        this.nombreDelDecano = nombreDelDecano;
        this.facultad = facultad;
        this.correoElectronico = correoElectronico;
    }

    //setters y getters
    public void setNombreDelDecano(String nombre) {
        this.nombreDelDecano = nombre;
    }

    public String getNombreDelDecano() {
        return nombreDelDecano;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setCorreoElectronico(String correo) {
        this.correoElectronico = correo;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    // reset
    public void reset() {
        this.nombreDelDecano = "";
        this.facultad = "";
        this.correoElectronico = "";
    }
}
