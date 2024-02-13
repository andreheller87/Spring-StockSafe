package model.DAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Produto;
import model.ProdutoDeserializer;

public class BancoProdutoJSON {

	private static final String BASE_URL = "http://localhost:8080/products";
	static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); // Formato da data

	public static List<Produto> lerProdutos() throws IOException, URISyntaxException {
		URL url = new URL(BASE_URL);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
			String json = reader.lines().reduce((line1, line2) -> line1 + line2).orElse("");

			return converterJSONParaListaProdutos(json);
		}
	}

	private static List<Produto> converterJSONParaListaProdutos(String json) {
		Gson gson = new GsonBuilder().registerTypeAdapter(Produto.class, new ProdutoDeserializer()).create();

		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(json);
		JsonArray jsonArray = element.getAsJsonArray();

		List<Produto> produtos = new ArrayList<>();
		for (JsonElement jsonElement : jsonArray) {
			JsonObject jsonObject = jsonElement.getAsJsonObject();
			Long id = jsonObject.get("id").getAsLong();
			Long codLote = jsonObject.get("codLote").getAsLong();
			String nome = jsonObject.get("nome").getAsString();
			Float valor = jsonObject.get("valor").getAsFloat();

			try {
				SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
				Date data = isoFormat.parse(jsonObject.get("data").getAsString());
				Date validade = isoFormat.parse(jsonObject.get("validade").getAsString());

				int quantidade = jsonObject.get("quantidade").getAsInt();
				String armazenamento = jsonObject.get("armazenamento").getAsString();
                 String observacao = jsonObject.get("observacao").getAsString();
				Produto produto = new Produto(id, codLote, nome, valor, data, validade, quantidade, armazenamento);
				produto.setObservacao(observacao);
				produtos.add(produto);
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}

		return produtos;
	}

	public static void inserirProduto(Produto produto) throws IOException, URISyntaxException {
		URL url = new URL(BASE_URL);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.setDoOutput(true);
		connection.setRequestProperty("Content-Type", "application/json");

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		String validadeFormatted = dateFormat.format(produto.getValidade());
		String dataFormatted = dateFormat.format(produto.getData());

		String json = "{" + "\"nome\": \"" + produto.getNome() + "\"," + "\"valor\": " + produto.getValor() + ","
				+ "\"validade\": \"" + validadeFormatted + "\"," + "\"quantidade\": " + produto.getQuantidade() + ","
				+ "\"observacao\": \"" + produto.getObservacao() + "\"," + "\"armazenamento\": \""
				+ produto.getArmazenamento() + "\"," + "\"data\": \"" + dataFormatted + "\"," + "\"codLote\": "
				+ produto.getCodLote() + "}";

		try (OutputStream os = connection.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8)) {
			osw.write(json);
			osw.flush();
		}

		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
			String response = br.lines().collect(java.util.stream.Collectors.joining("\n"));

		}
	}

	public static void deleteProduto(Produto produto) throws IOException {
		String deleteUrl = BASE_URL + "/" + produto.getId();
		URL url = new URL(deleteUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("DELETE");

	}

	public static void updateProduto(Produto produto) throws IOException {
		String updateUrl = BASE_URL + "/" + produto.getId();
		URL url = new URL(updateUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("PUT");
		connection.setDoOutput(true);
		connection.setRequestProperty("Content-Type", "application/json");

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		String validadeFormatted = dateFormat.format(produto.getValidade());
		String dataFormatted = dateFormat.format(produto.getData());

		String json = "{" + "\"nome\": \"" + produto.getNome() + "\"," + "\"valor\": " + produto.getValor() + ","
				+ "\"validade\": \"" + validadeFormatted + "\"," + "\"quantidade\": " + produto.getQuantidade() + ","
				+ "\"observacao\": \"" + produto.getObservacao() + "\"," + "\"armazenamento\": \""
				+ produto.getArmazenamento() + "\"," + "\"data\": \"" + dataFormatted + "\"," + "\"codLote\": "
				+ produto.getCodLote() + "}";

		try (OutputStream os = connection.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8)) {
			osw.write(json);
			osw.flush();
		}

	}
}
