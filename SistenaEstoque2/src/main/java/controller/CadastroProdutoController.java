package controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
/**
 * 
 * 
 * @author André Heller
 */
import java.util.ArrayList;

import View.CadastroProduto;
import controller.Helper.ProdutoHelper;
import model.Produto;
import model.DAO.ProdutoDAO;

public class CadastroProdutoController {

	private final CadastroProduto view;
	private final ProdutoHelper helper;

	public CadastroProdutoController(CadastroProduto view) {

		this.view = view;
		this.helper = new ProdutoHelper(view);
	}

	public void atualizaTabela() {
		ProdutoDAO produto = new ProdutoDAO();
		ArrayList<Produto> produtos = produto.selectAll();

		helper.preencherTabela(produtos);
	}

	public void cadastrar() throws ParseException, IOException, URISyntaxException {
		Produto produto;
		
			produto = helper.obterModelo();
			new ProdutoDAO().insert(produto);
			atualizaTabela();
		

		

	}

	public void deletarLote(Long codigo) {
		Long cod = codigo;

		ProdutoDAO prodDAO = new ProdutoDAO();
		Produto prod = prodDAO.selectPorLote(cod);

		if (prod != null) {

			prodDAO.delete(prod);
		}
		atualizaTabela();

	}

}
