package controller.Helper;

/**
 * 
 * 
 * @author André Heller
 */
import java.awt.Color;
import java.awt.Component;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import View.CadastroProduto;
import View.TelaProduto;
import model.Produto;

public class ProdutoHelper {
	private CadastroProduto view = null;
	private TelaProduto view2 = null;

	Float quantTotalEstoque = 0.00f;
	 private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
	    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public ProdutoHelper(CadastroProduto view) {

		this.view = view;

	}

	public ProdutoHelper(TelaProduto view2) {

		this.view2 = view2;

	}

	public void preencherTabela(ArrayList<Produto> produtos) {

		DefaultTableModel tableModel = (DefaultTableModel) view.getTableProdutos().getModel();
		tableModel.setNumRows(0);

		for (Produto produto : produtos) {
			String data, vali;

			tableModel.addRow(new Object[] { produto.getId(), produto.getCodLote(), produto.getNome(),
					produto.getValor(), produto.getQuantidade(), produto.getValorTotal(), dateFormat.format(produto.getData()),
					dateFormat.format(produto.getValidade()), produto.diferencaEmDiasInt(), produto.getArmazenamento(),
					produto.getObservacao() });
			quantTotalEstoque += produto.getValorTotal();

		}

	}

	public void preencherTabela2(ArrayList<Produto> produtos) {
		

		DefaultTableModel tableModel = (DefaultTableModel) view2.getTableProdutos().getModel();
		tableModel.setNumRows(0);

		JTable table = view2.getTableProdutos();
		table.setDefaultRenderer(Object.class, new CustomCellRenderer());

		for (Produto produto : produtos) {
			Object[] rowData = new Object[] { produto.getId(), produto.getCodLote(), produto.getNome(),
					produto.getValor(), produto.getQuantidade(), produto.getValorTotal(), dateFormat.format(produto.getData()),
					dateFormat.format(produto.getValidade()), produto.diferencaEmDiasInt(), produto.getArmazenamento(),
					produto.getObservacao() };

			tableModel.addRow(rowData);
		}

		table.repaint();
	}

	private class CustomCellRenderer extends DefaultTableCellRenderer {
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
					column);

			int dias = (int) table.getValueAt(row, table.getColumn("Validade (dias)").getModelIndex());
			if (dias <= 3) {
				rendererComponent.setBackground(Color.RED);
			} else if (dias <= 10) {
				rendererComponent.setBackground(Color.ORANGE);
			} else {
				rendererComponent.setBackground(Color.CYAN);
			}

			return rendererComponent;
		}
	}

	public Produto obterModelo() throws ParseException, IOException, URISyntaxException {
	    Long codBarra = Long.parseLong(view.getTextID().getText());
	    Date Data =dateFormat.parse(view.getTextDataFabricacao().getText()) ;
	    Float valor = Float.valueOf(view.getTextValorProduto().getText());
	    Date validade = dateFormat.parse(view.getTextValidade().getText());
	    String nome = view.getTextNome().getText();
	    String arm = view.getTextArmazenado().getText();
	    int quant = Integer.parseInt(view.getTextQuantidade().getText());
	    String Obs = view.getTextObservacao().getText();

	    Produto produto = new Produto();
	    produto.setId(codBarra);
	    produto.setNome(nome);
	    produto.setValor(valor);
	    produto.setQuantidade(quant);
	    produto.setArmazenamento(arm);
	    produto.setObservacao(Obs);
	    produto.setValidade(validade);
	    produto.setData(Data);
	    produto.setCodLote(codBarra);
			
	        return produto;
	    
	}


		


	public Float getQuantTotalEstoque() {
		return quantTotalEstoque;
	}

	public void setQuantTotalEstoque(Float quantTotalEstoque) {
		this.quantTotalEstoque = quantTotalEstoque;
	}

}
