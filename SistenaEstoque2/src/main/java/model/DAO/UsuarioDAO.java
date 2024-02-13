package model.DAO;

import java.util.ArrayList;

import model.Usuario;

/**
 * 
 * 
 * @author André Heller
 */
public class UsuarioDAO {

	public void insert(Usuario usuario) {
		ArrayList<Usuario> usuarios = BancoUsuarioJSON.lerUsuarios();
		usuarios.add(usuario);
		BancoUsuarioJSON.escreverUsuarios(usuarios);
	}

	public boolean update(Usuario usuario) {
		ArrayList<Usuario> usuarios = BancoUsuarioJSON.lerUsuarios();
		for (int i = 0; i < usuarios.size(); i++) {
			if (idSaoIguais(usuarios.get(i), usuario)) {
				usuarios.set(i, usuario);
				BancoUsuarioJSON.escreverUsuarios(usuarios);
				return true;
			}
		}
		return false;
	}

	public boolean delete(Usuario usuario) {
		ArrayList<Usuario> usuarios = BancoUsuarioJSON.lerUsuarios();
		for (Usuario usuarioLista : usuarios) {
			if (idSaoIguais(usuarioLista, usuario)) {
				usuarios.remove(usuarioLista);
				BancoUsuarioJSON.escreverUsuarios(usuarios);
				return true;
			}
		}
		return false;
	}

	public ArrayList<Usuario> selectAll() {
		return BancoUsuarioJSON.lerUsuarios();
	}

	public Usuario selectPorNomeESenha(Usuario usuario) {
		ArrayList<Usuario> usuarios = BancoUsuarioJSON.lerUsuarios();
		for (Usuario usuarioLista : usuarios) {
			if (nomeESenhaSaoIguais(usuarioLista, usuario)) {
				return usuarioLista;
			}
		}
		return null;
	}

	public Usuario selectPorNome(String nome) {
		ArrayList<Usuario> usuarios = BancoUsuarioJSON.lerUsuarios();
		for (Usuario usuarioLista : usuarios) {

			if (usuarioLista.getNome().equals(nome)) {
				return usuarioLista;
			}
		}
		return null;

	}

	private boolean nomeESenhaSaoIguais(Usuario usuario, Usuario usuarioAPesquisar) {
		return usuario.getNome().equals(usuarioAPesquisar.getNome())
				&& usuario.getSenha().equals(usuarioAPesquisar.getSenha());
	}

	private boolean idSaoIguais(Usuario usuario, Usuario usuarioAComparar) {
		return usuario.getId() == usuarioAComparar.getId();
	}

}
