package Persistencia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

import Logica.LearningPath;

public class PersistenciaLearningPath {

    private static final String FILE_NAME = "learningPaths.json";

    public List<LearningPath> cargarLearningPaths() {
        List<LearningPath> learningPaths = new ArrayList<>();
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
                    String titulo = jsonObject.getString("titulo");
                    String descripcion = jsonObject.getString("descripcion");
                    // Cargar actividades asociadas
                    List<Actividad> actividades = new ArrayList<>(); // Cargar según sea necesario
                    learningPaths.add(new LearningPath(titulo, descripcion, actividades));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return learningPaths;
    }

    public void guardarLearningPaths(List<LearningPath> learningPaths) {
        JSONArray jsonArray = new JSONArray();
        for (LearningPath path : learningPaths) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("titulo", path.getTitulo());
            jsonObject.put("descripcion", path.getDescripcion());
            // Serializar actividades asociadas
            jsonArray.put(jsonObject);
        }
        try (FileWriter file = new FileWriter(FILE_NAME
