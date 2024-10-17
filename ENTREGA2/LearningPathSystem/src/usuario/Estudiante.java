package usuario;

import java.util.ArrayList;
import java.util.List;
import actividad.*;

public class Estudiante extends Usuario {
    private List<Actividad> actividadesCompletadas;
    private double progreso; // Porcentaje de progreso
    private String fechaInicio; // Fecha de inicio del Learning Path

    public Estudiante(String username, String password) {
        super(username, password);
        this.actividadesCompletadas = new ArrayList<>();
        this.progreso = 0.0;
        this.fechaInicio = "";
    }

    public double getProgreso() {
        return progreso;
    }

    public List<Actividad> getActividadesCompletadas() {
        return actividadesCompletadas;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    // Método para actualizar el progreso
    public void actualizarProgreso(int totalActividades) {
        this.progreso = (double) actividadesCompletadas.size() / totalActividades * 100;
    }

    // Método para completar una actividad
    public void completarActividad(Actividad actividad) {
        actividadesCompletadas.add(actividad);
        // Actualizar progreso - deberás pasar el total de actividades del Learning Path
        actualizarProgreso(0/* total de actividades del Learning Path */);
    }

	@Override
	public String getTipoUsuario() {
		// TODO Auto-generated method stub
		return null;
	}
	public void mostrarProgreso() {
	    System.out.println("Progreso de " + getUsername() + ": " + progreso + "%");
	    System.out.println("Actividades completadas: " + actividadesCompletadas.size());
	    for (Actividad actividad : actividadesCompletadas) {
	        System.out.println("- " + actividad.getDescripcion());
	    }
	}

}
