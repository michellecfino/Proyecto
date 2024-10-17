package Persistencia;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

import usuario.Usuario;

public class PersistenciaUsuario {

    private static final String FILE_NAME = "usuarios.json";

    public List<Usuario> cargarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
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
                    String password = jsonObject.getString("password");
                    String tipo = jsonObject.getString("tipo");
                    usuarios.add(new Usuario(username, password, tipo));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public void guardarUsuarios(List<Usuario> usuarios) {
        JSONArray jsonArray = new JSONArray();
        for (Usuario usuario : usuarios) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("username", usuario.getUsername());
            jsonObject.put("password", usuario.getPassword());
            jsonObject.put("tipo", usuario.getTipoUsuario());
            jsonArray.put(jsonObject);
        }
        try (FileWriter file = new FileWriter(FILE_NAME)) {
            file.write(jsonArray.toString());
            file.flush();
        } catch (IOException e) {
            e.print
