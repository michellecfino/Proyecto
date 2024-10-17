package actividad;

import java.util.List;

public class Encuesta extends Actividad {
    private List<String> preguntasAbiertas; // Preguntas de la encuesta

    public Encuesta(String descripcion, String objetivo, int nivelDificultad, int duracionEsperada, List<String> preguntasAbiertas) {
        super(descripcion, objetivo, nivelDificultad, duracionEsperada);
        this.preguntasAbiertas = preguntasAbiertas;
    }

    @Override
    public void completarActividad() {
        super.completarActividad();
        System.out.println("Encuesta completada.");
    }
}
