package controller;

/**
 * 
 * 
 * @author André Heller
 */
import java.util.ArrayList;

import javax.swing.JOptionPane;

import View.CadastroUsuario;
import controller.Helper.UsuarioHelper;
import model.Usuario;
import model.DAO.UsuarioDAO;

public class CadastroUsuarioController {

	private final CadastroUsuario view;
	private final UsuarioHelper helper;

	public CadastroUsuarioController(CadastroUsuario view) {

		this.view = view;
		this.helper = new UsuarioHelper(view);
	}

	public void atualizaTabela() {
		UsuarioDAO usuario = new UsuarioDAO();
		ArrayList<Usuario> usuarios = usuario.selectAll();

		helper.preencherTabela(usuarios);
	}

	public void cadastrar() {
		Usuario usuario = helper.obterModelo();

		UsuarioDAO usuario2 = new UsuarioDAO();
		ArrayList<Usuario> usuarios = usuario2.selectAll();

		boolean igual = false;
		for (Usuario usuario3 : usuarios) {
			if (usuario.getNome().equals(usuario3.getNome())) {

				igual = true;
				JOptionPane.showInternalMessageDialog(null, "Usuario ou ID Já está Cadastrado");
			}
		}
		if (!igual) {
			int idtroca = 0;
			for (Usuario usuario3 : usuarios) {
				if (usuario3.getId() >= idtroca) {
					idtroca = usuario3.getId() + 1;
				}

			}
			usuario.setId(idtroca);
			new UsuarioDAO().insert(usuario);
			atualizaTabela();
			helper.limparTela();
		}

	}

	public void deletarUsuario() {
		String nome = view.getTextNome().getText();

		UsuarioDAO useDAO = new UsuarioDAO();
		Usuario use = useDAO.selectPorNome(nome);

		if (use != null) {

			useDAO.delete(use);
		}
		atualizaTabela();
		helper.limparTela();

	}

}
