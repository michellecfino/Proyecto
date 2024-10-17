package actividad;

public class ActividadSeguimiento extends Actividad {
    private String resultado; // Resultado de la actividad (e.g., "Completada", "Insatisfactoria")
    private String recomendacion; // Recomendación basada en el resultado

    public ActividadSeguimiento(String descripcion, String objetivo, int nivelDificultad, int duracionEsperada, String recomendacion) {
        super(descripcion, objetivo, nivelDificultad, duracionEsperada);
        this.resultado = "No completada"; // Estado inicial
        this.recomendacion = recomendacion;
    }

    @Override
    public void completarActividad() {
        super.completarActividad();
        this.resultado = "Completada"; // Cambiar estado al completarse
        System.out.println("Actividad de seguimiento completada.");
    }

    public void evaluarActividad(boolean esExitosa) {
        if (esExitosa) {
            this.resultado = "Exitosa";
            // Aquí se podría agregar lógica para actualizar recomendaciones
            System.out.println("Actividad evaluada como exitosa.");
        } else {
            this.resultado = "Insatisfactoria";
            System.out.println("Actividad evaluada como insatisfactoria.");
        }
    }

    public String getResultado() {
        return resultado;
    }

    public String getRecomendacion() {
        return recomendacion;
    }
}
