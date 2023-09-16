import java.util.ArrayList;

public class Horario {
    // Atributos
    private ArrayList<String> diasDeLaSemana;
    private String horaInicio;
    private String horaFinalizacion;

    // Constructor
    public Horario(ArrayList<String> diasDeLaSemana, String horaInicio, String horaFinalizacion) {
        this.diasDeLaSemana = diasDeLaSemana;
        this.horaInicio = horaInicio;
        this.horaFinalizacion = horaFinalizacion;
    }

    // Métodos
    public void registrarHorario(ArrayList<String> dias, String horaInicio, String horaFinalizacion) {
        this.diasDeLaSemana = dias;
        this.horaInicio = horaInicio;
        this.horaFinalizacion = horaFinalizacion;
    }

    public void modificarHorario(ArrayList<String> dias, String horaInicio, String horaFinalizacion) {
        this.diasDeLaSemana = dias;
        this.horaInicio = horaInicio;
        this.horaFinalizacion = horaFinalizacion;
    }

    public boolean validarHorario(Horario otroHorario) {
        for (String dia : this.diasDeLaSemana) {
            if (otroHorario.diasDeLaSemana.contains(dia)) {
                if (this.horaInicio.compareTo(otroHorario.horaFinalizacion) < 0 &&
                    this.horaFinalizacion.compareTo(otroHorario.horaInicio) > 0) {
                    return false; //se chocan los horarios
                }
            }
        }
        return true; //no se chocan los horarios
    }

    public void eliminarHorario() {
        this.diasDeLaSemana.clear();
        this.horaInicio = "";
        this.horaFinalizacion = "";
    }
}
