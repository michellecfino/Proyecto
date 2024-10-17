package Persistencia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

import usuario.Estudiante;

public class PersistenciaEstudiante {

    private static final String FILE_NAME = "estudiantes.json";

    public List<Estudiante> cargarEstudiantes() {
        List<Estudiante> estudiantes = new ArrayList<>();
        try {
            File file = new File(FILE_NAME);
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                StringBuilder jsonBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    jsonBuilder.append(line);
                }
                reader.close();
                JSONArray jsonArray = new JSONArray(jsonBuilder.toString());
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String username = jsonObject.getString("username");
                    double progreso = jsonObject.getDouble("progreso");
                    List<Actividad> actividadesCompletadas = new ArrayList<>(); // Cargar según sea necesario
                    estudiantes.add(new Estudiante(username, progreso, actividadesCompletadas));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return estudiantes;
    }

    public void guardarEstudiantes(List<Estudiante> estudiantes) {
        JSONArray jsonArray = new JSONArray();
        for (Estudiante estudiante : estudiantes) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("username", estudiante.getUsername());
            jsonObject.put("progreso", estudiante.getProgreso());
            // Serializar actividades completadas
            jsonArray.put(jsonObject);
        }
        try (FileWriter file = new FileWriter(FILE_NAME)) {
            file.write(jsonArray.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
