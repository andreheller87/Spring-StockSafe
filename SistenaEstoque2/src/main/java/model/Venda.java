package model;

/**
 * 
 * 
 * @author André Heller
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Venda {

	private int id;
	private Produto[] produtos;
	private double valorTotal;
	private Date data;
	private String observacao;

	public Venda(int id, Produto[] produtos, double valorTotal, String data, String observacao) {
		super();
		this.id = id;
		this.produtos = produtos;
		this.valorTotal = valorTotal;
		try {
			this.data = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.observacao = observacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Produto[] getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto[] produtos) {
		this.produtos = produtos;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
