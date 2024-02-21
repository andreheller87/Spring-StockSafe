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
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import controller.CadastroProdutoController;
import model.Produto;

public class CadastroProduto extends JFrame {

	private JPanel contentPane;
	private JTextField textID;
	private JTextField textDataFabricacao;
	private JTextField textValorProduto;
	private JTextField textValidade;
	private JTextField textObservacao;
	private JTextField textQuantidade;
	private JTextField textArmazenado;
	private JTextField textNome;
	private JLabel lblValidade_1;
	private JLabel lblValor_1;
	private JLabel lblArmazenado;
	private JLabel lblNome;
	private JTable table;
	private JTable tableProdutos;
	private final CadastroProdutoController contoller;
	private JTextField textLote;
	private JLabel lblCodLote;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroProduto frame = new CadastroProduto();
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
	public CadastroProduto() {
		contoller = new CadastroProdutoController(this);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 50, 1380, 680);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tableProdutos = new JTable();
		tableProdutos.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tableProdutos.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Cod ID", "Cod Lote", "Produto", "Valor Un", "Quantidade", "Valor Total",
						"Fabrica\u00E7\u00E3o", "Validade", "Validade (dias)", "Armazenado", "Observa\u00E7\u00E3o" }) {
			Class[] columnTypes = new Class[] { Integer.class, Object.class, String.class, Float.class, Integer.class,
					Object.class, Integer.class, Integer.class, Object.class, Object.class, Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableProdutos.getColumnModel().getColumn(0).setPreferredWidth(67);
		tableProdutos.getColumnModel().getColumn(4).setPreferredWidth(66);
		tableProdutos.getColumnModel().getColumn(6).setPreferredWidth(70);
		tableProdutos.getColumnModel().getColumn(7).setPreferredWidth(69);
		tableProdutos.getColumnModel().getColumn(8).setPreferredWidth(80);
		tableProdutos.getColumnModel().getColumn(9).setPreferredWidth(52);
		tableProdutos.getColumnModel().getColumn(10).setPreferredWidth(68);

		// Adicione a tabela a um JScrollPane
		JScrollPane scrollPane = new JScrollPane(tableProdutos);
		scrollPane.setBounds(0, 333, 1364, 308);
		contentPane.add(scrollPane);

		JLabel lblNewLabel = new JLabel("Data Fab:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(10, 87, 195, 35);
		contentPane.add(lblNewLabel);

		JLabel lblId = new JLabel("Cod Lote:");
		lblId.setForeground(new Color(0, 0, 0));
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblId.setBounds(10, 55, 102, 35);
		contentPane.add(lblId);
		
		
		
		textID = new JTextField();
		textID.setColumns(10);
		textID.setBounds(110, 62, 121, 26);
		contentPane.add(textID);
		textID.setEditable(false);
		    try {
				this.setTextID(Produto.proximoCodLote().toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		textDataFabricacao = new JTextField();
		textDataFabricacao.setColumns(10);
		textDataFabricacao.setBounds(110, 94, 121, 26);
		contentPane.add(textDataFabricacao);

		JLabel lblValor = new JLabel("Valor Unit:");
		lblValor.setForeground(new Color(0, 0, 0));
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblValor.setBounds(10, 207, 140, 35);
		contentPane.add(lblValor);

		textValorProduto = new JTextField();
		textValorProduto.setColumns(10);
		textValorProduto.setBounds(119, 215, 121, 25);
		contentPane.add(textValorProduto);

		JLabel lblValidade = new JLabel("Validade:");
		lblValidade.setForeground(new Color(0, 0, 0));
		lblValidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblValidade.setBounds(10, 120, 102, 35);
		contentPane.add(lblValidade);

		textValidade = new JTextField();
		textValidade.setColumns(10);
		textValidade.setBounds(110, 128, 121, 25);
		contentPane.add(textValidade);

		textObservacao = new JTextField();
		textObservacao.setColumns(10);
		textObservacao.setBounds(110, 166, 383, 26);
		contentPane.add(textObservacao);

		textQuantidade = new JTextField();
		textQuantidade.setColumns(10);
		textQuantidade.setBounds(372, 127, 121, 26);
		contentPane.add(textQuantidade);

		textArmazenado = new JTextField();
		textArmazenado.setColumns(10);
		textArmazenado.setBounds(372, 94, 121, 26);
		contentPane.add(textArmazenado);

		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(372, 62, 121, 26);
		contentPane.add(textNome);

		lblValidade_1 = new JLabel("Observação:");
		lblValidade_1.setForeground(new Color(0, 0, 0));
		lblValidade_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblValidade_1.setBounds(10, 166, 108, 35);
		contentPane.add(lblValidade_1);

		lblValor_1 = new JLabel("Quantidade:");
		lblValor_1.setForeground(new Color(0, 0, 0));
		lblValor_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblValor_1.setBounds(241, 120, 541, 35);
		contentPane.add(lblValor_1);

		lblArmazenado = new JLabel("Armazenamento:");
		lblArmazenado.setForeground(new Color(0, 0, 0));
		lblArmazenado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblArmazenado.setBounds(241, 87, 541, 35);
		contentPane.add(lblArmazenado);

		lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(0, 0, 0));
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(241, 55, 541, 35);
		contentPane.add(lblNome);

		JButton btnCadProduto = new JButton("Cadastro");
		btnCadProduto.setForeground(Color.WHITE);
		btnCadProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				    try {
						contoller.cadastrar();
					} catch (IllegalArgumentException | ParseException | IOException | URISyntaxException e1) {
						
						e1.printStackTrace();
					}
				    limparTela();
				    JOptionPane.showMessageDialog(btnCadProduto, "Produto cadastrado com sucesso!");
				
				
			}
		});
		btnCadProduto.setBackground(new Color(0, 0, 0));
		btnCadProduto.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCadProduto.setBounds(276, 211, 207, 26);
		contentPane.add(btnCadProduto);

		JLabel lblNewLabel_1 = new JLabel("Produto");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(126, 11, 174, 37);
		contentPane.add(lblNewLabel_1);

		JButton btnCancelarProduto = new JButton("Deletar");
		btnCancelarProduto.setForeground(Color.WHITE);
		btnCancelarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textLote.getText().isEmpty()) {
					Long cod = Long.valueOf(textLote.getText());

					contoller.deletarLote(cod);
				} else {

					JOptionPane.showMessageDialog(null, "Digite O Cod Lote Para Deletar");
				}
			}
		});
		btnCancelarProduto.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCancelarProduto.setBackground(Color.BLACK);
		btnCancelarProduto.setBounds(231, 294, 102, 28);
		contentPane.add(btnCancelarProduto);

		textLote = new JTextField();
		textLote.setColumns(10);
		textLote.setBounds(100, 297, 121, 26);
		contentPane.add(textLote);

		lblCodLote = new JLabel("Cod Lote:");
		lblCodLote.setForeground(Color.BLACK);
		lblCodLote.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCodLote.setBounds(10, 290, 102, 35);
		contentPane.add(lblCodLote);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2
				.setIcon(new ImageIcon(CadastroProduto.class.getResource("/View/imagens/telaDeCadastroProduto.jpeg")));
		lblNewLabel_2.setBounds(493, 0, 861, 336);
		contentPane.add(lblNewLabel_2);

		iniciar();
	}

	protected void limparTela() {
		 try {
				this.setTextID(Produto.proximoCodLote().toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		textArmazenado.setText("");
		textDataFabricacao.setText("");
		textNome.setText("");
		textObservacao.setText("");
		textValidade.setText("");
		textQuantidade.setText("");
		textValorProduto.setText("");
		
	}

	private void iniciar() {
		contoller.atualizaTabela();

	}

	public JTable getTableProdutos() {
		return tableProdutos;
	}

	public void setTableProdutos(JTable tableProdutos) {
		this.tableProdutos = tableProdutos;
	}

	public JTextField getTextID() {
		return textID;
	}
	public void setTextID(String text) {
	    this.textID.setText(text);
	}

	public void setTextID(JTextField textID) {
		this.textID = textID;
	}

	public JTextField getTextDataFabricacao() {
		return textDataFabricacao;
	}

	public void setTextDataFabricacao(JTextField textDataFabricacao) {
		this.textDataFabricacao = textDataFabricacao;
	}

	public JTextField getTextValorProduto() {
		return textValorProduto;
	}

	public void setTextValorProduto(JTextField textValorProduto) {
		this.textValorProduto = textValorProduto;
	}

	public JTextField getTextValidade() {
		return textValidade;
	}

	public void setTextValidade(JTextField textValidade) {
		this.textValidade = textValidade;
	}

	public JTextField getTextObservacao() {
		return textObservacao;
	}

	public void setTextObservacao(JTextField textObservacao) {
		this.textObservacao = textObservacao;
	}

	public JTextField getTextQuantidade() {
		return textQuantidade;
	}

	public void setTextQuantidade(JTextField textQuantidade) {
		this.textQuantidade = textQuantidade;
	}

	public JTextField getTextArmazenado() {
		return textArmazenado;
	}

	public void setTextArmazenado(JTextField textArmazenado) {
		this.textArmazenado = textArmazenado;
	}

	public JTextField getTextNome() {
		return textNome;
	}

	public void setTextNome(JTextField textNome) {
		this.textNome = textNome;
	}

	public JTextField getTextLote() {
		return textLote;
	}

	public void setTextLote(JTextField textLote) {
		this.textLote = textLote;
	}
}
