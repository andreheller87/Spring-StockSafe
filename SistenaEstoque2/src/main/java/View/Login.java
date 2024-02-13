package View;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.LoginController;
import model.DAO.BancoProdutoJSON;
import model.DAO.BancoUsuarioJSON;

/**
 * 
 * 
 * @author André Heller
 */
public class Login extends javax.swing.JFrame {

	private final LoginController controller;
	private String usuario;

	/**
	 * Creates new form Login up
	 */
	public Login() {
		initComponents();
		controller = new LoginController(this);

		BancoUsuarioJSON.lerUsuarios();
		try {
			BancoProdutoJSON.lerProdutos();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setSize(400, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jLabel4 = new javax.swing.JLabel();
		textUsuario = new javax.swing.JTextField();
		textSenha = new javax.swing.JPasswordField();
		btnEntrar = new javax.swing.JButton();
		jLabel5 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel2.setIcon(new ImageIcon(Login.class.getResource("/View/imagens/fundoPreto.png")));
		jLabel2.setForeground(new Color(0, 0, 0));
		jLabel2.setBackground(new Color(245, 245, 220));
		jLabel1 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jLabel4.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 22)); // NOI18N
		jLabel4.setForeground(new Color(255, 255, 255));
		jLabel4.setText("Senha");
		jLabel4.setToolTipText("");
		getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240));

		textUsuario.setToolTipText("");
		getContentPane().add(textUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 180, 30));

		textSenha.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				textSenhaActionPerformed(evt);
			}
		});
		getContentPane().add(textSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 180, 30));

		btnEntrar.setFont(new Font("Segoe UI", Font.BOLD, 22)); // NOI18N
		btnEntrar.setText("Entrar");
		btnEntrar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btnEntrarActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		getContentPane().add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340));

		jLabel5.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 22)); // NOI18N
		jLabel5.setForeground(new Color(255, 255, 255));
		jLabel5.setText("Usuario");
		getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150));

		jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
		jLabel3.setForeground(new Color(0, 0, 0));
		getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160));
		getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 100, 250, 320));
		jLabel1.setIcon(new ImageIcon(Login.class.getResource("/View/imagens/EstoqueLogin.jpg"))); // NOI18N
		getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 500));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void textSenhaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_textSenhaActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_textSenhaActionPerformed

	private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) throws IOException, URISyntaxException {// GEN-FIRST:event_btnEntrarActionPerformed
		if (!this.getTextUsuario().getText().isEmpty()) {
			this.setUsuario(this.getTextUsuario().getText());
		}

		this.controller.entrarNoSistema();
	}// GEN-LAST:event_btnEntrarActionPerformed

	/**
	 * @param Andre Heller
	 */
	public static void main(String args[]) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Login().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnEntrar;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JPasswordField textSenha;
	private javax.swing.JTextField textUsuario;
	// End of variables declaration//GEN-END:variables

	public void exibeMensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}

	public javax.swing.JPasswordField getTextSenha() {
		return textSenha;
	}

	public void setTextSenha(javax.swing.JPasswordField textSenha) {
		this.textSenha = textSenha;
	}

	public javax.swing.JTextField getTextUsuario() {
		return textUsuario;
	}

	public void setTextUsuario(javax.swing.JTextField textUsuario) {
		this.textUsuario = textUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
