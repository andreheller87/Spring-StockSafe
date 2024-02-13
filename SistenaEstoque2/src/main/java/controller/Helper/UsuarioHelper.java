package controller.Helper;

/**
 * 
 * 
 * @author André Heller
 */
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import View.CadastroUsuario;
import model.Usuario;

public class UsuarioHelper {
	private final CadastroUsuario view;

	public UsuarioHelper(CadastroUsuario view) {
		this.view = view;
	}

	public void preencherTabela(ArrayList<Usuario> usuarios) {
		DefaultTableModel tableModel = (DefaultTableModel) view.getTableUsuario().getModel();
		tableModel.setNumRows(0);

		for (Usuario use : usuarios) {
			tableModel.addRow(new Object[] { use.getId(), use.getNome(), use.getSenha(), use.getNivelAcesso() });
		}
	}

	public Usuario obterModelo() {
		int acesso = Integer.parseInt(view.getTextNivel().getText());
		String nome = view.getTextNome().getText();
		String senha = view.getTextSenha().getText();
		Usuario usuario = new Usuario(nome, senha, acesso);
		return usuario;

	}

	public void limparTela() {
		view.getTextNivel().setText("");
		view.getTextNome().setText("");
		view.getTextSenha().setText("");
	}

}
