package Logica;

import Persistencia.PersistenciaUsuario;
import actividad.Actividad;
import usuario.*;
import Persistencia.PersistenciaLearningPath;

import java.util.ArrayList;
import java.util.List;

public class LearningPathsSystem {
    private List<Usuario> usuarios;
    private List<LearningPath> learningPaths;
    private PersistenciaUsuario usuarioPersistencia;
    private PersistenciaLearningPath learningPathPersistencia;

    public LearningPathsSystem() {
        usuarioPersistencia = new PersistenciaUsuario();
        learningPathPersistencia = new PersistenciaLearningPath();
        this.usuarios = usuarioPersistencia.cargarUsuarios();
        this.learningPaths = learningPathPersistencia.cargarLearningPaths();
    }
    
    //Se instancia a Profesor y a Estudiante y no a Usuario ya que Usuario es abs
    public void registrarUsuario(String username, String password, String tipo) {
        if ("profesor".equals(tipo)) {
            Profesor nuevoProfesor = new Profesor(username, password);
            usuarios.add(nuevoProfesor);
        } else if ("estudiante".equals(tipo)) {
            Estudiante nuevoEstudiante = new Estudiante(username, password);
            usuarios.add(nuevoEstudiante);
        } else {
            System.out.println("Tipo de usuario no reconocido.");
        }
        usuarioPersistencia.guardarUsuarios(usuarios);
    }

    public Usuario autenticarUsuario(String username, String password) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
                return usuario;
            }
        }
        return null;
    }

    public void crearLearningPath(String titulo, String descripcion) {
        LearningPath nuevoPath = new LearningPath(titulo, descripcion);
        learningPaths.add(nuevoPath);
        learningPathPersistencia.guardarLearningPaths(learningPaths);
    }

    public void inscribirEstudianteEnLearningPath(Estudiante estudiante, LearningPath learningPath) {
        if (!learningPath.getEstudiantesInscritos().contains(estudiante)) {
            learningPath.agregarEstudiante(estudiante);
            System.out.println("Estudiante inscrito en el Learning Path.");
        } else {
            System.out.println("El estudiante ya está inscrito en este Learning Path.");
        }
    }

    public void rastrearProgreso(Estudiante estudiante, LearningPath learningPath) {
        // Lógica para rastrear progreso
        System.out.println("Progreso del estudiante: " + estudiante.getProgreso() + "%");
    }

    private Usuario buscarUsuario(String username) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username)) {
                return usuario;
            }
        }
        return null;
    }

    public void iniciarActividad(Estudiante estudiante, Actividad actividad) {
            if (actividad.tieneRequisitosPreviosCumplidos(estudiante)) {
                // Permitir iniciar la actividad
                System.out.println("Iniciando actividad: " + actividad.getDescripcion());
            } else {
                System.out.println("No se puede iniciar la actividad. Requisitos previos no completados.");
                // Puedes mostrar una lista de los prerequisitos no completados aquí
            }
        }
    }




