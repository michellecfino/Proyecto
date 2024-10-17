package usuario;

public class Profesor extends Usuario {
    public Profesor(String username, String password) {
        super(username, password);
    }

    @Override
    public String getTipoUsuario() {
        return "Profesor";
    }

    // Métodos específicos del profesor, como crear y gestionar Learning Paths

    public void mostrarProgresoEstudiante(Estudiante estudiante) {
        System.out.println("Progreso de " + estudiante.getUsername() + ": " + estudiante.getProgreso() + "%");
        // También puedes mostrar las actividades completadas
        estudiante.mostrarProgreso();
    }
}

