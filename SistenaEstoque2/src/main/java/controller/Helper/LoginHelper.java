package controller.Helper;

/**
 * 
 * 
 * @author André Heller
 */
import View.Login;
import model.Usuario;

public class LoginHelper {

	private final Login view;

	public LoginHelper(Login view) {
		this.view = view;
	}

	public Usuario obterModelo() {
		String nome = view.getTextUsuario().getText();
		String senha = view.getTextSenha().getText();
		Usuario modelo = new Usuario(0, nome, senha, 1);
		return modelo;

	}

	public void setarModelo(Usuario modelo) {
		String nome = modelo.getNome();
		String senha = modelo.getSenha();
		view.getTextUsuario().setText(nome);
		view.getTextSenha().setText(senha);

	}

	public void limparTela() {
		view.getTextUsuario().setText("");
		view.getTextSenha().setText("");
	}

}
