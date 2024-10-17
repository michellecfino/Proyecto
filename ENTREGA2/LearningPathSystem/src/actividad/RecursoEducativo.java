package actividad;

public class RecursoEducativo extends Actividad {
    private String tipoRecurso; // video, libro, sitio web, PDF

    public RecursoEducativo(String descripcion, String objetivo, int nivelDificultad, int duracionEsperada, String tipoRecurso) {
        super(descripcion, objetivo, nivelDificultad, duracionEsperada);
        this.tipoRecurso = tipoRecurso;
    }

    @Override
    public void completarActividad() {
        super.completarActividad();
        System.out.println("Recurso educativo completado con éxito.");
    }
}
