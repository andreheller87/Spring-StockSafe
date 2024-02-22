package controller;

/**
 * 
 * 
 * @author André Heller
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import View.TelaVenda;
import model.Produto;
import model.DAO.BancoProdutoJSON;
import model.DAO.ProdutoDAO;

public class TelaVendaControle {
	private final TelaVenda view;

//	private final ProdutoHelper helper;
	public TelaVendaControle(TelaVenda telaVenda) {
		this.view = telaVenda;
		// this.helper = new ProdutoHelper(view);
	}

	public ArrayList<Produto> getProdutos() {

		return null;
	}

	public void adicionarProdutoVenda(String codigoProduto, int quantidade) {
		Produto produto = obterProdutoPorCodigo(codigoProduto);
		if (produto != null) {
			int quantidadeDisponivel = produto.getQuantidade();

			if (quantidade <= quantidadeDisponivel) {
				adicionarProdutoNaTabela(produto, quantidade);

				view.getTxtDescProduto().setText("");
			} else {
				view.getTxtDescProduto().setText("Quantidade insuficiente. Disponível: " + quantidadeDisponivel);
			}
		} else {
			view.getTxtDescProduto().setText("Produto não encontrado");
		}
	}

	public void adicionarProdutoNaTabela(Produto produto, int quantidade) {
		DefaultTableModel model = (DefaultTableModel) view.getTableVenda().getModel();
		model.addRow(new Object[] { produto.getCodLote(), produto.getNome(), quantidade, produto.getValor(),
				quantidade * produto.getValor() });
	}

	public void atualizaTabela() {

	}

	public void concluirVenda(List<Produto> produtos) throws IOException, URISyntaxException {

		Date dataAtual = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String dataFormatada = dateFormat.format(dataAtual);

		double valorTotal = calcularValorTotal(produtos);

		JOptionPane.showMessageDialog(view, "Venda Concluída");

		salvarVendaEmArquivo(dataFormatada, produtos, valorTotal);
		ArrayList<Produto> produtobanco = (ArrayList<Produto>) BancoProdutoJSON.lerProdutos();
		ProdutoDAO dao = new ProdutoDAO();
		for (Produto produtob : produtobanco) {
			for (Produto produto : produtos) {
				if (produtob.getCodLote().equals(produto.getCodLote())) {
					produtob.setQuantidade(produtob.getQuantidade() - produto.getQuantidade());
					if (produtob.getQuantidade() == 0) {
						
						dao.delete(produtob);
					} else {
						
						dao.update(produtob);
					}
				}

			}
		}

	}

	private double calcularValorTotal(List<Produto> produtos) {
		double valorTotal = 0;
		for (Produto produto : produtos) {
			valorTotal += produto.getValor() * produto.getQuantidade();
		}
		return valorTotal;
	}

	private void salvarVendaEmArquivo(String dataVenda, List<Produto> produtos, double valorTotal) {
		String nomeArquivo = "vendas.txt";

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {

			writer.write("Data da Venda: " + dataVenda);
			writer.newLine();
			writer.write("Produtos:");
			writer.newLine();

			for (Produto produto : produtos) {
				writer.write("- " + produto.getNome() + ": R$" + produto.getValor());
				writer.newLine();
			}

			writer.write("Valor Total da Venda: R$" + String.format("%.2f", valorTotal));
			writer.newLine();
			writer.write("------------------------------");
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public Produto getProdutoPorNome(String produtoSelecionado) {

		return null;
	}

	public Produto obterProdutoPorCodigo(String codigoProduto) {
		ProdutoDAO produto = new ProdutoDAO();
		ArrayList<Produto> produtos = produto.selectAll();
		Produto p = null;
		try {
			for (Produto produto2 : produtos) {
				if (produto2.getCodLote() == Long.parseLong(codigoProduto)) {
					p = produto2;
				}
			}
		} catch (Exception e) {

		}
		return p;
	}

	public void limparTabela() {
		DefaultTableModel model = (DefaultTableModel) view.getTableVenda().getModel();
		model.setRowCount(0);
	view.getTextFieldTotal().setText("0.0");
	}

}
