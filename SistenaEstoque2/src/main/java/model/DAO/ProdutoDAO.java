
package model.DAO;

import java.io.IOException;
import java.net.URISyntaxException;
/**
 * 
 * 
 * @author André Heller
 */
import java.util.ArrayList;

import model.Produto;

/**
 *
 * @author Andre
 */
public class ProdutoDAO {

	/**
	 * Insere
	 */
	public void insert(Produto produto) {
		try {
			BancoProdutoJSON.inserirProduto(produto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Atualiza
	 * 
	 * @return
	 */
	public boolean update(Produto produto) {
		try {
			
			BancoProdutoJSON.updateProduto(produto);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean delete(Produto produto) {
	
			try {
				BancoProdutoJSON.deleteProduto(produto);
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return false;
	}

	public ArrayList<Produto> selectAll() {
		try {
			return (ArrayList<Produto>) BancoProdutoJSON.lerProdutos();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Produto selectPorNome(String nome) throws IOException, URISyntaxException {
		ArrayList<Produto> produtos = (ArrayList<Produto>) BancoProdutoJSON.lerProdutos();
		for (Produto produtoLista : produtos) {

			if (produtoLista.getNome().equals(nome)) {
				return produtoLista;
			}
		}
		return null;

	}



	public Produto selectPorLote(Long cod) {
		ArrayList<Produto> produtos;
		try {
			produtos = (ArrayList<Produto>) BancoProdutoJSON.lerProdutos();
			for (Produto produtoLista : produtos) {

				if (produtoLista.getCodLote().equals(cod)) {

					return produtoLista;
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return null;
	}
}