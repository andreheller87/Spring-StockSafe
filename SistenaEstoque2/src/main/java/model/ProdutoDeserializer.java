package model;


import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class ProdutoDeserializer implements JsonDeserializer<Produto> {

    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    @Override
    public Produto deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        Long id = jsonObject.get("id").getAsLong();
        Long codLote = jsonObject.get("CodLote").getAsLong();
        String nome = jsonObject.get("nome").getAsString();
        Float valor = jsonObject.get("valor").getAsFloat();
        String data = jsonObject.get("Data").getAsString();
        String validade = jsonObject.get("validade").getAsString();
        int quantidade = jsonObject.get("quantidade").getAsInt();
		String armazenamento = jsonObject.get("armazenamento").getAsString();

		 Date dataDate;
		try {
			dataDate = formato.parse(data);
			Date validadeParsed = formato.parse(data); 
			 Produto produto = new Produto(id, codLote, nome, valor, dataDate, validadeParsed, quantidade, armazenamento);
	            return produto;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		 
            
           
        
    }
}
