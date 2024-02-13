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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controller.TelaProdutoControle;
import model.Produto;

public class TelaProduto extends JFrame {

	private final TelaProdutoControle contoller;
	private JPanel contentPane;
	private JTable tableProdutos;
	private JTextField textField_2;
	private JTextField textData1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProduto frame = new TelaProduto();
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
	public TelaProduto() {
		contoller = new TelaProdutoControle(this);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 50, 1380, 680);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tableProdutos = new JTable();
		tableProdutos.setBorder(new LineBorder(new Color(102, 51, 102)));
		tableProdutos.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tableProdutos.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null, null, null, null }, },
				new String[] { "Cod Barras", "Cod Lote", "Produto", "Valor Un", "Quantidade", "Valor Total",
						"Fabrica\u00E7\u00E3o", "Validade", "Validade (dias)", "Armazenado", "Observa\u00E7\u00E3o" }) {
			Class[] columnTypes = new Class[] { Integer.class, Object.class, String.class, Float.class, Integer.class,
					Object.class, Integer.class, Integer.class, Object.class, Object.class, Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableProdutos.getColumnModel().getColumn(0).setPreferredWidth(50);
		tableProdutos.getColumnModel().getColumn(1).setPreferredWidth(110);
		tableProdutos.getColumnModel().getColumn(2).setPreferredWidth(178);
		tableProdutos.getColumnModel().getColumn(3).setPreferredWidth(67);
		tableProdutos.getColumnModel().getColumn(4).setPreferredWidth(66);
		tableProdutos.getColumnModel().getColumn(6).setPreferredWidth(70);
		tableProdutos.getColumnModel().getColumn(7).setPreferredWidth(69);
		tableProdutos.getColumnModel().getColumn(8).setPreferredWidth(50);
		tableProdutos.getColumnModel().getColumn(9).setPreferredWidth(50);
		tableProdutos.getColumnModel().getColumn(10).setPreferredWidth(68);

		JScrollPane scrollPane = new JScrollPane(tableProdutos);
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 51, 102), null, null, null));
		scrollPane.setBounds(0, 345, 1354, 296);
		contentPane.add(scrollPane);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon(TelaProduto.class.getResource("/View/imagens/estoque3.jpeg")));
		lblNewLabel.setBounds(356, 11, 1027, 345);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("");
		btnNewButton
				.setIcon(new ImageIcon(TelaProduto.class.getResource("/View/imagens/icons/lupa-de-pesquisa20x20.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchTerm = textData1.getText();

				contoller.pesquisarProduto(searchTerm);

			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton.setBounds(223, 72, 43, 31);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("Busca");
		lblNewLabel_1.setForeground(new Color(102, 51, 102));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(42, 30, 84, 31);
		contentPane.add(lblNewLabel_1);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(42, 201, 194, 31);

		contentPane.add(textField_2);

		JLabel lblNewLabel_1_1 = new JLabel("Total do Estoque");
		lblNewLabel_1_1.setForeground(new Color(102, 51, 102));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(42, 143, 207, 31);
		contentPane.add(lblNewLabel_1_1);

		textData1 = new JTextField();
		textData1.setColumns(10);
		textData1.setBounds(42, 72, 182, 31);
		contentPane.add(textData1);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				setValorTotal(0);
				iniciar();
			}
		});

		// Adiciona um WindowListener para detectar quando a janela é ativada
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				setValorTotal(0);
				iniciar();
			}
		});
		setValorTotal(0);
		iniciar();
	}

	private void setValorTotal(double valor) {
		ArrayList<Produto> produtos = contoller.getProdutos();

		for (Produto produto : produtos) {
			valor += produto.getQuantidade() * produto.getValor();

			textField_2.setText(String.format("%.2f", valor));
		}

	}

	public void iniciar() {
		contoller.atualizaTabela();

	}

	public JTable getTableProdutos() {
		return tableProdutos;
	}

	public void setTableProdutos(JTable tableProdutos) {
		this.tableProdutos = tableProdutos;
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}

	public JTextField getTextData1() {
		return textData1;
	}

	public void setTextData1(JTextField textData1) {
		this.textData1 = textData1;
	}
}
