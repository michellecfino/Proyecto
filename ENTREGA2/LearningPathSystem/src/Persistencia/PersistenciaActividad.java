package Persistencia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

import actividad.Actividad;

public class PersistenciaActividad {

    private static final String FILE_NAME = "actividades.json";

    public List<Actividad> cargarActividades() {
        List<Actividad> actividades = new ArrayList<>();
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
                    String descripcion = jsonObject.getString("descripcion");
                    String tipo = jsonObject.getString("tipo");
                    // Crear actividad según el tipo
                    // Lógica para crear y agregar actividades
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return actividades;
    }

    public void guardarActividades(List<Actividad> actividades) {
        JSONArray jsonArray = new JSONArray();
        for (Actividad actividad : actividades) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("descripcion", actividad.getDescripcion());
            jsonObject.put("tipo", actividad.getTipoActividad());
            // Serializar otros atributos necesarios
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
