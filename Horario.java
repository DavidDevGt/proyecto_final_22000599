import java.util.ArrayList;

public class Horario {
    //Atributos
    private ArrayList<String> diasDeLaSemana;
    private String horaInicio;
    private String horaFinalizacion;

    //constructor
    public Horario(ArrayList<String> diasDeLaSemana, String horaInicio, String horaFinalizacion) {
        this.diasDeLaSemana = diasDeLaSemana;
        this.horaInicio = horaInicio;
        this.horaFinalizacion = horaFinalizacion;
    }

    //getters y setters
    public void setDiasDeLaSemana(ArrayList<String> dias) {
        this.diasDeLaSemana = dias;
    }

    public ArrayList<String> getDiasDeLaSemana() {
        return diasDeLaSemana;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraFinalizacion(String horaFinalizacion) {
        this.horaFinalizacion = horaFinalizacion;
    }

    public String getHoraFinalizacion() {
        return horaFinalizacion;
    }

    // Método para verificar si dos horarios se superponen
    public boolean validarHorario(Horario otroHorario) {
        for (String dia : this.diasDeLaSemana) {
            if (otroHorario.diasDeLaSemana.contains(dia)) {
                if (this.horaInicio.compareTo(otroHorario.horaFinalizacion) < 0 &&
                    this.horaFinalizacion.compareTo(otroHorario.horaInicio) > 0) {
                    return false; // se chocan los horarios
                }
            }
        }
        return true; // no se chocan los horarios
    }

    //para resetear los datos
    public void reset() {
        this.diasDeLaSemana = new ArrayList<>();
        this.horaInicio = "";
        this.horaFinalizacion = "";
    }
}
