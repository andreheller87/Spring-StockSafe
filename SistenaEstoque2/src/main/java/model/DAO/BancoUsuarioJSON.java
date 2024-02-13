package model.DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 
 * 
 * @author André Heller
 */
import model.Usuario;

public class BancoUsuarioJSON {
	public static final String FILENAME = "Usuarios.json";

	public static ArrayList<Usuario> lerUsuarios() {
		ArrayList<Usuario> usuarios = new ArrayList<>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
			StringBuilder jsonString = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				jsonString.append(line);
			}
			reader.close();

			JSONArray jsonArray = new JSONArray(jsonString.toString());
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				int id = jsonObject.getInt("id");
				String nome = jsonObject.getString("nome");
				String senha = jsonObject.getString("senha");
				int acesso = jsonObject.getInt("nivelAcesso");
				Usuario usuario = new Usuario(id, nome, senha, acesso);
				usuarios.add(usuario);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return usuarios;
	}

	public static void escreverUsuarios(ArrayList<Usuario> usuarios) {
		JSONArray jsonArray = new JSONArray();
		for (Usuario usuario : usuarios) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", usuario.getId());
			jsonObject.put("nome", usuario.getNome());
			jsonObject.put("senha", usuario.getSenha());
			jsonObject.put("nivelAcesso", usuario.getNivelAcesso());
			jsonArray.put(jsonObject);
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))) {
			writer.write(jsonArray.toString(4)); // O valor 4 é usado para formatar a saída com espaçamento
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
