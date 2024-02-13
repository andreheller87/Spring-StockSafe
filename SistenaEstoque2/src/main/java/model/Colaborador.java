package model;

/**
 * 
 * 
 * @author André Heller
 */
public class Colaborador {

	private int id;
	private String nome;
	private String cpf;
	private double salario;
	private int faltas;

	public Colaborador(int id, String nome, String cpf, double salario) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getFaltas() {
		return faltas;
	}

	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

	@Override
	public String toString() {
		return "Colaborador [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", salario=" + salario + ", faltas="
				+ faltas + "]";
	}

}
