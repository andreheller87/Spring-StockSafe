package View;

/**
 * 
 * 
 * @author André Heller
 */
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.CadastroUsuarioController;

public class CadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textNivel;
	private JTextField textNome;
	private JTextField textSenha;
	private JTable table;
	private JTable tableUsuario;
	private final CadastroUsuarioController contoller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroUsuario frame = new CadastroUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroUsuario() {
		contoller = new CadastroUsuarioController(this);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 50, 1380, 680);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tableUsuario = new JTable();
		tableUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tableUsuario.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Nome", "Senha", "Nivel Acesso" }) {
					Class[] columnTypes = new Class[] { Integer.class, Object.class, Object.class, Object.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
		tableUsuario.getColumnModel().getColumn(0).setPreferredWidth(66);
		tableUsuario.getColumnModel().getColumn(1).setPreferredWidth(277);
		tableUsuario.getColumnModel().getColumn(1).setMinWidth(1);
		tableUsuario.getColumnModel().getColumn(2).setPreferredWidth(197);
		tableUsuario.getColumnModel().getColumn(3).setPreferredWidth(82);

		// Adicione a tabela a um JScrollPane
		JScrollPane scrollPane = new JScrollPane(tableUsuario);
		scrollPane.setBounds(0, 329, 1013, 301);
		contentPane.add(scrollPane);

		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(10, 127, 102, 35);
		contentPane.add(lblNewLabel);

		JLabel lblId = new JLabel("Nivel:");
		lblId.setForeground(new Color(0, 0, 0));
		lblId.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblId.setBounds(10, 66, 102, 35);
		contentPane.add(lblId);

		textNivel = new JTextField();
		textNivel.setBounds(88, 70, 226, 35);
		contentPane.add(textNivel);
		textNivel.setColumns(10);

		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(88, 127, 226, 35);
		contentPane.add(textNome);

		JLabel lblValor = new JLabel("Senha:");
		lblValor.setForeground(new Color(0, 0, 0));
		lblValor.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblValor.setBounds(10, 191, 102, 35);
		contentPane.add(lblValor);

		textSenha = new JTextField();
		textSenha.setColumns(10);
		textSenha.setBounds(88, 179, 226, 35);
		contentPane.add(textSenha);

		JButton btnCadUsuario = new JButton("Cadastra");
		btnCadUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!textNome.getText().isEmpty() && !textSenha.getText().isEmpty() && !textNivel.getText().isEmpty()) {
					contoller.cadastrar();
				} else {
					JOptionPane.showInternalMessageDialog(null, "Campo  Nome, Senha e nivel não pode estar vazia");
				}
			}
		});
		btnCadUsuario.setForeground(new Color(0, 0, 0));
		btnCadUsuario.setBackground(new Color(0, 0, 0));
		btnCadUsuario.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCadUsuario.setBounds(10, 237, 306, 35);
		contentPane.add(btnCadUsuario);

		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(88, 11, 174, 37);
		contentPane.add(lblNewLabel_1);

		JButton btnCancelarUsuario = new JButton("Deletar");
		btnCancelarUsuario.setForeground(new Color(0, 0, 0));
		btnCancelarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textNome.getText().isEmpty()) {

					contoller.deletarUsuario();

				} else {
					JOptionPane.showInternalMessageDialog(null, "Campo Nome não pode estar vazia");
				}

			}
		});
		btnCancelarUsuario.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCancelarUsuario.setBackground(new Color(0, 0, 0));
		btnCancelarUsuario.setBounds(10, 283, 304, 35);
		contentPane.add(btnCancelarUsuario);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/View/imagens/Usuario2.jpeg")));
		lblNewLabel_2.setBounds(347, 0, 1047, 630);
		contentPane.add(lblNewLabel_2);

		iniciar();
	}

	private void iniciar() {
		contoller.atualizaTabela();

	}

	public JTable getTableUsuario() {
		return tableUsuario;
	}

	public void setTableUsuario(JTable tableUsuario) {
		this.tableUsuario = tableUsuario;
	}

	public JTextField getTextNivel() {
		return textNivel;
	}

	public void setTextNivel(JTextField textNivel) {
		this.textNivel = textNivel;
	}

	public JTextField getTextNome() {
		return textNome;
	}

	public void setTextNome(JTextField textNome) {
		this.textNome = textNome;
	}

	public JTextField getTextSenha() {
		return textSenha;
	}

	public void setTextSenha(JTextField textSenha) {
		this.textSenha = textSenha;
	}
}
