package controller;

/**
 * 
 * 
 * @author André Heller
 */
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import View.TelaProduto;
import controller.Helper.ProdutoHelper;
import model.Produto;
import model.DAO.ProdutoDAO;

public class TelaProdutoControle {

	private final TelaProduto view;
	private final ProdutoHelper helper;
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public TelaProdutoControle(TelaProduto view) {
		this.view = view;
		this.helper = new ProdutoHelper(view);

	}

	public void atualizaTabela() {
		ProdutoDAO produto = new ProdutoDAO();
		ArrayList<Produto> produtos = produto.selectAll();

		helper.preencherTabela2(produtos);

	}

	public ArrayList<Produto> getProdutos() {
		ProdutoDAO produto = new ProdutoDAO();
		ArrayList<Produto> produtos = produto.selectAll();

		return produtos;

	}

	public void pesquisarProduto(String searchTerm) {

		ProdutoDAO produtoDao = new ProdutoDAO();
		ArrayList<Produto> produtos = produtoDao.selectAll();
		
	       

		ArrayList<Produto> searchResults = new ArrayList<>();
		ArrayList<Produto> searchResultsCod = new ArrayList<>();

		for (Produto produto : produtos) {

			if (produto.getNome().toLowerCase().contains(searchTerm.toLowerCase())
					|| produto.getArmazenamento().toLowerCase().equals(searchTerm.toLowerCase())
					|| produto.getObservacao().toLowerCase().contains(searchTerm.toLowerCase())) {
				searchResults.add(produto);

			} else {

				try {
					Date validadeDate2 = produto.getValidade();
					Date fabicacaoDate = produto.getData();
					String formattedValidade = dateFormat.format(validadeDate2);
					String formattedFabricacao = dateFormat.format(fabicacaoDate);
					if (formattedValidade.equals(searchTerm) || formattedFabricacao.equals(searchTerm)) {
						searchResults.add(produto);
					}
					int searchTermAsInt = Integer.parseInt(searchTerm);

					if (produto.diferencaEmDiasInt() <= searchTermAsInt) {
						searchResults.add(produto);
					}
					if (produto.getCodLote() == searchTermAsInt) {
						searchResultsCod.add(produto);
					}
					if (produto.getId() == searchTermAsInt) {
						searchResultsCod.add(produto);
					}

				} catch (NumberFormatException e) {

				}
			}
		}
		if (searchResultsCod.isEmpty()) {
			helper.preencherTabela2(searchResults);
		} else {
			helper.preencherTabela2(searchResultsCod);
		}

	}

}
