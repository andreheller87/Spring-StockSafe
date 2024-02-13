package controller;

/**
 * 
 * 
 * @author André Heller
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import View.CadastroProduto;
import View.CadastroUsuario;
import View.MenuPrincipal;
import View.TelaProduto;
import View.TelaVenda;
import model.Produto;
import model.DAO.BancoProdutoJSON;

public class MenuPrincipalController {

	private final MenuPrincipal wiew;
	private CadastroProduto cadastro = new CadastroProduto();
	private CadastroUsuario cadastroUsuario = new CadastroUsuario();
	private TelaProduto telaProduto = new TelaProduto();
	private TelaVenda telaVenda = new TelaVenda();

	public MenuPrincipalController(MenuPrincipal wiew) {

		this.wiew = wiew;
	}

	public void listaProdutosVencendo() throws IOException, URISyntaxException {
		BancoProdutoJSON banco = new BancoProdutoJSON();

		List<Produto> prod = banco.lerProdutos();
		List<Produto> venc = new ArrayList<>();
		for (Produto produto : prod) {
			if (produto.diferencaEmDiasInt() <= 10) {
				venc.add(produto);
			}

		}
		if (!venc.isEmpty()) {
			String str = "Itens a 10 dias ou menos para o Vencimento \n";
			for (Produto produto : venc) {
				str += "Codigo Lote: " + produto.getCodLote() + " Nome: " + produto.getNome() + " Vencimento: "
						+ produto.diferencaEmDiasInt() + " dias \n";
			}
			JOptionPane.showMessageDialog(wiew, str);
		}
	}

	public void navegarParaCadProduto() {

		cadastro.setVisible(true);
	}

	public void navegarParaCadUsuario() {

		cadastroUsuario.setVisible(true);

	}

	public void navegarParaTelaProduto() {

		telaProduto.setVisible(true);

	}

	public void navegarParaTelaVenda() {
		telaVenda.setVisible(true);

	}

	public List<String> buscarVendasPorData(String dataBusca) {
		List<String> vendasEncontradas = new ArrayList<>();
		String nomeArquivo = "vendas.txt";

		try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
			String linha;
			String vendaAtual = "";

			while ((linha = reader.readLine()) != null) {
				if (linha.startsWith("Data da Venda: ")) {
					if (!vendaAtual.isEmpty()) {

						if (vendaAtual.startsWith("Data da Venda: " + dataBusca)) {
							vendasEncontradas.add(vendaAtual);
						}
					}
					vendaAtual = linha + "\n"; //
				} else {
					vendaAtual += linha + "\n";
				}
			}

			if (!vendaAtual.isEmpty() && vendaAtual.startsWith("Data da Venda: " + dataBusca)) {
				vendasEncontradas.add(vendaAtual);
			}

		} catch (IOException e) {
			e.printStackTrace();

		}

		return vendasEncontradas;
	}

	public List<String> buscarVendas() {
	    List<String> vendasEncontradas = new ArrayList<>();
	    String nomeArquivo = "vendas.txt";

	    try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
	        String linha;
	        String vendaAtual = "";

	        while ((linha = reader.readLine()) != null) {
	            if (linha.startsWith("Data da Venda: ")) {
	                if (!vendaAtual.isEmpty()) {
	                    vendasEncontradas.add(vendaAtual);
	                }
	                vendaAtual = linha + "\n";
	            } else {
	                vendaAtual += linha + "\n";
	            }
	        }

	        if (!vendaAtual.isEmpty()) {
	            vendasEncontradas.add(vendaAtual);
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return vendasEncontradas;
	}


}
