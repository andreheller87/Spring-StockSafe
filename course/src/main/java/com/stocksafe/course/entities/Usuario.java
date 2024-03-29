package com.stocksafe.course.entities;

import java.io.Serializable;
import java.util.Objects;

import com.stocksafe.course.entities.enuns.UserNivel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="tb_user")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 100L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String senha;
	private Integer nivelAcesso;
	
	public Usuario() {
		
	}

	public Usuario(Long id, String nome, String senha, UserNivel nivelAcesso) {
		super();
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		setNivelAcesso(nivelAcesso);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public UserNivel getNivelAcesso() {
		return UserNivel.valueOf(nivelAcesso);
	}

	public void setNivelAcesso(UserNivel nivelAcesso) {
		if(nivelAcesso != null) {
		this.nivelAcesso = nivelAcesso.getNivel();
		}
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
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}

}
