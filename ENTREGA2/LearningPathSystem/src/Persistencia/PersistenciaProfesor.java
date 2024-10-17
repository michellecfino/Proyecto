package Persistencia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

import usuario.Profesor;

public class PersistenciaProfesor {

    private static final String FILE_NAME = "profesores.json";

    public List<Profesor> cargarProfesores() {
        List<Profesor> profesores = new ArrayList<>();
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
                    profesores.add(new Profesor(username, jsonObject.getString("password")));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return profesores;
    }

    public void guardarProfesores(List<Profesor> profesores) {
        JSONArray jsonArray = new JSONArray();
        for (Profesor profesor : profesores) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("username", profesor.getUsername());
            jsonObject.put("password", profesor.getPassword());
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
