package actividad;

import java.util.List;

import usuario.Estudiante;

public abstract class Actividad {
    private String descripcion;
    private String objetivo;
    private int nivelDificultad;
    private int duracionEsperada; // en minutos
    private List<Actividad> requisitosPrevios;
    private boolean completada;

    public Actividad(String descripcion, String objetivo, int nivelDificultad, int duracionEsperada) {
        this.descripcion = descripcion;
        this.objetivo = objetivo;
        this.nivelDificultad = nivelDificultad;
        this.duracionEsperada = duracionEsperada;
        this.completada = false;
    }

    public boolean tieneRequisitosPreviosCumplidos(Estudiante estudiante) {
        // Lógica para verificar si se han cumplido los requisitos previos
        return true; // Suponiendo que siempre se cumplen para este ejemplo
    }

    public void completarActividad() {
        this.completada = true;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    // Métodos adicionales según el tipo de actividad (quiz, tarea, etc.)
}
