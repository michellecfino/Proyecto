package usuario;

import java.util.ArrayList;
import java.util.List;

public class Autenticacion {
    private List<Usuario> usuarios; // Lista de usuarios registrados

    public Autenticacion() {
        this.usuarios = new ArrayList<>();
    }

    // Método para registrar un nuevo usuario
    public boolean registrarUsuario(String username, String password, String tipo) {
        // Verificar que el usuario no exista
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username)) {
                return false; // El usuario ya existe
            }
        }

        // Crear un nuevo usuario
        Usuario nuevoUsuario;
        if (tipo.equalsIgnoreCase("profesor")) {
            nuevoUsuario = new Profesor(username, password);
        } else if (tipo.equalsIgnoreCase("estudiante")) {
            nuevoUsuario = new Estudiante(username, password);
        } else {
            return false; // Tipo de usuario no válido
        }

        usuarios.add(nuevoUsuario);
        return true; // Registro exitoso
    }

    // Método para iniciar sesión
    public Usuario iniciarSesion(String username, String password) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
                return usuario; // Autenticación exitosa
            }
        }
        return null; // Fallo en la autenticación
    }
}
