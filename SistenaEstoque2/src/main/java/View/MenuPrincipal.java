/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

/**
 * 
 * 
 * @author André Heller
 */
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.MenuPrincipalController;
import model.Usuario;
import model.DAO.UsuarioDAO;

/**
 *
 * @author André Heller
 */
public class MenuPrincipal extends javax.swing.JFrame {

	public static Login login;

	private final MenuPrincipalController controller;

	/**
	 * Creates new form MenuPrincipal
	 * 
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	public MenuPrincipal(Login login) throws IOException, URISyntaxException {
		initComponents();
		this.controller = new MenuPrincipalController(this);
		this.login = login;
		this.controller.listaProdutosVencendo();

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenuBar1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuCadastro = new javax.swing.JMenu();
		menuCadastro.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuCadProduto = new JMenuItem();
		menuCadProduto.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuCadProduto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				controller.navegarParaCadProduto();
			}
		});
		menuCadUsuario = new javax.swing.JMenuItem();
		menuCadUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuCadUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				UsuarioDAO useDao = new UsuarioDAO();
				Usuario use = useDao.selectPorNome(login.getTextUsuario().getText());
				if (use.getNivelAcesso() == 1) {
					controller.navegarParaCadUsuario();
				} else {
					JOptionPane.showMessageDialog(null, "Usuario sem acesso");
				}
			}
		});
		menuProduto = new javax.swing.JMenu();
		menuProduto.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuProduto.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				controller.navegarParaTelaProduto();
			}
		});

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBackground(new java.awt.Color(153, 153, 153));

		jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagens/fundoCinza.png"))); // NOI18N
		jLabel1.setToolTipText("");

		menuCadastro.setText("Cadastro");

		menuCadProduto
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagens/icons/box-icon-19.png"))); // NOI18N
		menuCadProduto.setText("Produto");
		menuCadastro.add(menuCadProduto);

		menuCadUsuario.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/View/imagens/icons/users-icon-png-15.png"))); // NOI18N
		menuCadUsuario.setText("Colaborador");
		menuCadastro.add(menuCadUsuario);

		jMenuBar1.add(menuCadastro);

		menuProduto.setText("Produto");
		jMenuBar1.add(menuProduto);

		setJMenuBar(jMenuBar1);
		TelaVenda = new javax.swing.JMenu();
		TelaVenda.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.navegarParaTelaVenda();
			}
		});
		TelaVenda.setFont(new Font("Segoe UI", Font.PLAIN, 15));

		TelaVenda.setText("Venda");
		jMenuBar1.add(TelaVenda);

		menuCadastro_1 = new JMenu();
		menuCadastro_1.setText("Relatórios");
		menuCadastro_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		jMenuBar1.add(menuCadastro_1);

		menuCadProduto_1 = new JMenuItem();
		menuCadProduto_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				List<String> vendasEncontradas = controller.buscarVendas();

				imprimirNaTela(vendasEncontradas);

			}

		});
		menuCadProduto_1.setText("Vendas");
		menuCadProduto_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuCadastro_1.add(menuCadProduto_1);

		menuCadUsuario_1 = new JMenuItem();
		menuCadUsuario_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				String dataPesquisa = JOptionPane.showInputDialog(null, "Digite a data da pesquisa (dd/MM/yyyy):");

				if (dataPesquisa != null) {

					List<String> vendasEncontradas = controller.buscarVendasPorData(dataPesquisa);
					imprimirNaTela(vendasEncontradas);

				}
			}
		});
		menuCadUsuario_1.setText("Vendas por data");
		menuCadUsuario_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuCadastro_1.add(menuCadUsuario_1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				layout.createSequentialGroup()
						.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 1500, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(jLabel1, Alignment.TRAILING,
				GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE));
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	public void imprimirNaTela(List<String> vendasEncontradas) {
		if (vendasEncontradas.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nenhuma venda encontrada para a data especificada.");
		} else {
			JTextArea textArea = new JTextArea();
			textArea.setEditable(false);
			textArea.setLineWrap(true);
			textArea.setWrapStyleWord(true);

			for (String venda : vendasEncontradas) {
				textArea.append(venda + "\n");
			}

			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setPreferredSize(new java.awt.Dimension(800, 500)); // Ajustar a largura e altura conforme
																			// necessário

			JOptionPane.showMessageDialog(null, scrollPane, "Vendas encontradas", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new MenuPrincipal(login).setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel jLabel1;
	private javax.swing.JMenuBar jMenuBar1;
	private JMenuItem menuCadProduto;
	private javax.swing.JMenuItem menuCadUsuario;
	private javax.swing.JMenu menuCadastro;
	private javax.swing.JMenu TelaVenda;
	private javax.swing.JMenu menuProduto;
	private JMenu menuCadastro_1;
	private JMenuItem menuCadProduto_1;
	private JMenuItem menuCadUsuario_1;
}
