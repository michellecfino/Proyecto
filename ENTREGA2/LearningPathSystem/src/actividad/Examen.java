package actividad;
import java.util.List;

import preguntas.*;
public class Examen extends Actividad {
    private List<PreguntaAbierta> preguntas; // Lista de preguntas abiertas

    public Examen(String descripcion, String objetivo, int nivelDificultad, int duracionEsperada, List<PreguntaAbierta> preguntas) {
        super(descripcion, objetivo, nivelDificultad, duracionEsperada);
        this.preguntas = preguntas;
    }

    @Override
    public void completarActividad() {
        // Lógica para evaluar respuestas
        super.completarActividad();
        System.out.println("Examen completado y enviado para evaluación.");
    }
}
