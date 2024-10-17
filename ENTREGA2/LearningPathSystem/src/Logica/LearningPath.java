package Logica;

import java.util.ArrayList;
import java.util.List;

import actividad.Actividad;
import usuario.Estudiante;

public class LearningPath {
    private String titulo;
    private String descripcion;
    private List<Actividad> actividades;
    private List<Estudiante> estudiantesInscritos;

    public LearningPath(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.actividades = new ArrayList<>();
        this.estudiantesInscritos = new ArrayList<>();
    }

    public void agregarActividad(Actividad actividad) {
        actividades.add(actividad);
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantesInscritos.add(estudiante);
    }

    public List<Estudiante> getEstudiantesInscritos() {
        return estudiantesInscritos;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // Métodos para validar requisitos de actividades
    public void iniciarActividad(Estudiante estudiante, Actividad actividad) {
        if (!actividad.tieneRequisitosPreviosCumplidos(estudiante)) {
            System.out.println("Advertencia: No has completado los requisitos previos para esta actividad.");
        }
        // Lógica para iniciar la actividad
    }
}
