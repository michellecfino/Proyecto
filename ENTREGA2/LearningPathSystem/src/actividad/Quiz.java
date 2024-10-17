package actividad;

import java.util.List;

import preguntas.Pregunta;

public class Quiz extends Actividad {
    private List<Pregunta> preguntas; // Lista de preguntas del quiz
    private int calificacionMinima;

    public Quiz(String descripcion, String objetivo, int nivelDificultad, int duracionEsperada, List<Pregunta> preguntas, int calificacionMinima) {
        super(descripcion, objetivo, nivelDificultad, duracionEsperada);
        this.preguntas = preguntas;
        this.calificacionMinima = calificacionMinima;
    }

    @Override
    public void completarActividad() {
        // Lógica para completar el quiz (evaluar respuestas, etc.)
        super.completarActividad();
        System.out.println("Quiz completado.");
    }
}
