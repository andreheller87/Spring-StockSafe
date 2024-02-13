package model;

/**
 * 
 * 
 * @author André Heller
 */
import java.io.Serializable;

public class Usuario implements Serializable {

	private int id;
	private String nome;
	private String senha;
	private int nivelAcesso;
	private static int proximoId = 7;

	public Usuario(int id, String nome, String senha, int nivelAcesso) {
		super();
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.nivelAcesso = nivelAcesso;
	}

	public Usuario(String nome, String senha, int acesso) {
		super();
		this.id = proximoId++;
		this.nome = nome;
		this.senha = senha;
		this.nivelAcesso = acesso;

	}

	public int getNivelAcesso() {
		return nivelAcesso;
	}

	public void setNivelAcesso(int nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario{" + "id=" + id + ", nome='" + nome + '\'' + ", senha='" + senha + '\'' + '}';
	}

}
