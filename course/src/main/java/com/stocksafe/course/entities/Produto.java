package com.stocksafe.course.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_product")
public class Produto implements Serializable {

	private static final long serialVersionUID = 101L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long CodLote;
	private String nome;
	private Float valor;
	private Date Data;
	private Date validade;
	private int quantidade;
	private String observacao;
	private String armazenamento;

	public Produto() {

	}

	public Produto(Long id, Long codLote, String nome, Float valor, Date data, Date validade, int quantidade,
			String observacao, String armazenamento) {
		super();
		this.id = id;
		CodLote = codLote;
		this.nome = nome;
		this.valor = valor;
		Data = data;
		this.validade = validade;
		this.quantidade = quantidade;
		this.observacao = observacao;
		this.armazenamento = armazenamento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodLote() {
		return CodLote;
	}

	public void setCodLote(Long codLote) {
		CodLote = codLote;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Date getData() {
		return Data;
	}

	public void setData(Date data) {
		Data = data;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getArmazenamento() {
		return armazenamento;
	}

	public void setArmazenamento(String armazenamento) {
		this.armazenamento = armazenamento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", CodLote=" + CodLote + ", nome=" + nome + ", valor=" + valor + ", Data=" + Data
				+ ", validade=" + validade + ", quantidade=" + quantidade + ", observacao=" + observacao
				+ ", armazenamento=" + armazenamento + "]";
	}
}
