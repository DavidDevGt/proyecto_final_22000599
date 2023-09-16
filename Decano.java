public class Decano {
    // Atributos
    private String nombreDelDecano;
    private String facultad;
    private String correoElectronico;

    // Constructor
    public Decano(String nombreDelDecano, String facultad, String correoElectronico) {
        this.nombreDelDecano = nombreDelDecano;
        this.facultad = facultad;
        this.correoElectronico = correoElectronico;
    }

    // Métodos
    public void registrarDecano(String nombre, String facultad, String correo) {
        this.nombreDelDecano = nombre;
        this.facultad = facultad;
        this.correoElectronico = correo;
    }

    public void modificarDatosDecano(String nombre, String facultad, String correo) {
        this.nombreDelDecano = nombre;
        this.facultad = facultad;
        this.correoElectronico = correo;
    }

    public void eliminarDecano() {
        this.nombreDelDecano = "";
        this.facultad = "";
        this.correoElectronico = "";
    }
}
