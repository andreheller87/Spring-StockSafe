package controller;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * 
 * 
 * @author André Heller
 */
import View.Login;
import View.MenuPrincipal;
import controller.Helper.LoginHelper;
import model.Usuario;
import model.DAO.UsuarioDAO;

public class LoginController {

	private final Login view;
	private LoginHelper helper;

	public LoginController(Login view) {
		this.view = view;
		this.helper = new LoginHelper(view);
	}

	public void entrarNoSistema() throws IOException, URISyntaxException {
		Usuario usuario = helper.obterModelo();

		UsuarioDAO usuarioDao = new UsuarioDAO();
		Usuario usuarioAutenticado = usuarioDao.selectPorNomeESenha(usuario);

		if (usuarioAutenticado != null) {
			MenuPrincipal menu = new MenuPrincipal(view);
			menu.setVisible(true);
			view.dispose();
		} else {
			view.exibeMensagem("Usuario ou senha invalido");
		}

	}

}
