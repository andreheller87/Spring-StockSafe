package View;

/**
 * 
 * 
 * @author André Heller
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

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

import controller.TelaVendaControle;
import model.Produto;

public class TelaVenda extends JFrame {

	private final TelaVendaControle controller;
	private JPanel contentPane;
	private JTable tableVenda;
	private JTextField txtCodigoLoteProduto;
	private JTextField textFieldTotal;
	private JTextField txtQuantidade;
	private JTextField txtDescProduto;
	private List<Produto> produtos = new ArrayList<>();
	private float valor = 0;
	private JTextField txtNomeProduto;
	private JTextField txtPreco;

	public TelaVenda() {
		controller = new TelaVendaControle(this);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 50, 1380, 680);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tableVenda = new JTable();
		tableVenda.setBorder(new LineBorder(new Color(102, 51, 102)));
		tableVenda.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tableVenda.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null } },
				new String[] { "Código", "Produto", "Quantidade", "Valor Unitário", "Subtotal" }) {
			Class[] columnTypes = new Class[] { Integer.class, String.class, Integer.class, Double.class,
					Double.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		JScrollPane scrollPane = new JScrollPane(tableVenda);
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 51, 102), null, null, null));
		scrollPane.setBounds(10, 239, 726, 350);
		contentPane.add(scrollPane);

		JLabel lblCarrinho = new JLabel("Carrinho de Compras");
		lblCarrinho.setForeground(new Color(102, 51, 102));
		lblCarrinho.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblCarrinho.setBounds(10, 199, 235, 29);
		contentPane.add(lblCarrinho);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);

		lblNewLabel.setBounds(920, 0, 434, 279);
		contentPane.add(lblNewLabel);

		txtCodigoLoteProduto = new JTextField();
		txtCodigoLoteProduto.setBounds(256, 4, 453, 31);
		contentPane.add(txtCodigoLoteProduto);
		txtCodigoLoteProduto.setColumns(10);

		JButton btnAdicionar = new JButton("Adicionar ao Carrinho");
		btnAdicionar.setBounds(490, 199, 219, 35);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String codigoProduto = txtCodigoLoteProduto.getText();

					int quantidadeDigitada = Integer.parseInt(txtQuantidade.getText());

					Produto produto = controller.obterProdutoPorCodigo(codigoProduto);

					if (produto != null) {
						int quantidadeDisponivel = produto.getQuantidade();

						for (Produto produto2 : produtos) {
							if (produto2.getId().equals(produto.getId())) {
								quantidadeDisponivel -= produto2.getQuantidade();
							}
						}
						if (quantidadeDigitada <= quantidadeDisponivel) {
							controller.adicionarProdutoVenda(codigoProduto, quantidadeDigitada);

							produto.setQuantidade(quantidadeDigitada);
							produtos.add(produto);

							apagarCampos();

							valor += produto.getValor() * quantidadeDigitada;

						} else {
							txtDescProduto.setText("Quantidade insuficiente. Disponível: " + quantidadeDisponivel);
						}
					} else if (txtNomeProduto.getText() != null && txtPreco.getText() != null
							&& txtQuantidade.getText() != null) {
						Produto p = new Produto();
						p.setId(1l);
						p.setNome(txtNomeProduto.getText());
						p.setValor(Float.parseFloat(txtPreco.getText()));
						p.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
						controller.adicionarProdutoNaTabela(p, quantidadeDigitada);
						produtos.add(p);
						apagarCampos();
						valor += p.getValor() * quantidadeDigitada;
					} else {
						txtDescProduto.setText("Produto não encontrado");
					}
					textFieldTotal.setText("R$ " + valor);
				} catch (Exception e1) {

				}
			}

			private void apagarCampos() {
				txtCodigoLoteProduto.setText("");
				txtQuantidade.setText("");
				txtDescProduto.setText("");
				txtPreco.setText("");
				txtNomeProduto.setText("");

			}
		});
		contentPane.add(btnAdicionar);

		textFieldTotal = new JTextField();
		textFieldTotal.setEditable(false);
		textFieldTotal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldTotal.setEnabled(false);
		textFieldTotal.setColumns(10);
		textFieldTotal.setBounds(196, 592, 235, 31);
		contentPane.add(textFieldTotal);

		JLabel lblTotalVenda = new JLabel("Total da Venda");
		lblTotalVenda.setForeground(new Color(102, 51, 102));
		lblTotalVenda.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTotalVenda.setBounds(10, 590, 207, 31);
		contentPane.add(lblTotalVenda);

		JButton btnConcluirVenda = new JButton("Concluir Venda");
		btnConcluirVenda.setBounds(456, 592, 200, 31);
		btnConcluirVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					controller.concluirVenda(produtos);
				} catch (IOException | URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				produtos.clear();
				controller.limparTabela();
				valor = 0;
			}
		});
		contentPane.add(btnConcluirVenda);

		JLabel lblLoteDoProduto = new JLabel("Lote do Produto");
		lblLoteDoProduto.setForeground(new Color(102, 51, 102));
		lblLoteDoProduto.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblLoteDoProduto.setBounds(10, 6, 235, 29);
		contentPane.add(lblLoteDoProduto);

		JLabel lblQuantidade = new JLabel("Nome:");
		lblQuantidade.setForeground(new Color(102, 51, 102));
		lblQuantidade.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblQuantidade.setBounds(10, 159, 116, 29);
		contentPane.add(lblQuantidade);

		txtQuantidade = new JTextField();
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(404, 155, 74, 31);
		contentPane.add(txtQuantidade);

		txtDescProduto = new JTextField();
		txtDescProduto.setHorizontalAlignment(SwingConstants.LEFT);
		txtDescProduto.setEditable(false);
		txtDescProduto.setFont(new Font("Times New Roman", Font.BOLD, 30));
		txtDescProduto.setEnabled(false);
		txtDescProduto.setColumns(10);
		txtDescProduto.setBounds(10, 46, 701, 77);
		contentPane.add(txtDescProduto);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(new Color(102, 153, 153));
		lblNewLabel_1.setBackground(new Color(204, 204, 204));
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setIcon(new ImageIcon(TelaVenda.class.getResource("/View/imagens/caixaVendedorStockSafe2.jpeg")));
		lblNewLabel_1.setBounds(735, 0, 629, 641);
		contentPane.add(lblNewLabel_1);

		txtNomeProduto = new JTextField();
		txtNomeProduto.setColumns(10);
		txtNomeProduto.setBounds(97, 159, 210, 31);
		contentPane.add(txtNomeProduto);

		JLabel lblNewLabel_2 = new JLabel("Produtos não cadastrados digite o nome do produto");
		lblNewLabel_2.setBounds(10, 137, 270, 14);
		contentPane.add(lblNewLabel_2);

		txtPreco = new JTextField();
		txtPreco.setColumns(10);
		txtPreco.setBounds(573, 151, 136, 31);
		contentPane.add(txtPreco);

		JLabel lblPreo = new JLabel("Preço:");
		lblPreo.setForeground(new Color(102, 51, 102));
		lblPreo.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblPreo.setBounds(490, 155, 116, 29);
		contentPane.add(lblPreo);

		JLabel lblQuantidade_1 = new JLabel("Quant:");
		lblQuantidade_1.setForeground(new Color(102, 51, 102));
		lblQuantidade_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblQuantidade_1.setBounds(317, 155, 116, 29);
		contentPane.add(lblQuantidade_1);

		txtCodigoLoteProduto.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

				updateDescription();
			}
		});

		iniciar();
	}

	private void updateDescription() {

		String codigoProduto = txtCodigoLoteProduto.getText();
		Produto produto = controller.obterProdutoPorCodigo(codigoProduto);
		String str = "";
		if (produto != null) {
			str = "Nome: " + produto.getNome() + " quant: " + produto.getQuantidade() + "\n" + "preço: "
					+ produto.getValor();
			txtDescProduto.setText(str);
			txtNomeProduto.setText(produto.getNome());
			txtQuantidade.setText("1");
			txtPreco.setText("" + produto.getValor());
		} else {

			txtDescProduto.setText("Produto não encontrado");
		}
	}

	private void iniciar() {
		controller.atualizaTabela();
	}

	public JTable getTableVenda() {
		return tableVenda;
	}

	public void setTableVenda(JTable tableVenda) {
		this.tableVenda = tableVenda;
	}

	public JTextField getTextFieldTotal() {
		return textFieldTotal;
	}

	public void setTextFieldTotal(JTextField textFieldTotal) {
		this.textFieldTotal = textFieldTotal;
	}

	public JTextField getTxtCodigoLoteProduto() {
		return txtCodigoLoteProduto;
	}

	public void setTxtCodigoLoteProduto(JTextField txtCodigoLoteProduto) {
		this.txtCodigoLoteProduto = txtCodigoLoteProduto;
	}

	public JTextField getTxtQuantidade() {
		return txtQuantidade;
	}

	public void setTxtQuantidade(JTextField txtQuantidade) {
		this.txtQuantidade = txtQuantidade;
	}

	public JTextField getTxtDescProduto() {
		return txtDescProduto;
	}

	public void setTxtDescProduto(JTextField txtDescProduto) {
		this.txtDescProduto = txtDescProduto;
	}

	public JTextField getTxtNomeProduto() {
		return txtNomeProduto;
	}

	public void setTxtNomeProduto(JTextField txtNomeProduto) {
		this.txtNomeProduto = txtNomeProduto;
	}

	public JTextField getTxtPreco() {
		return txtPreco;
	}

	public void setTxtPreco(JTextField txtPreco) {
		this.txtPreco = txtPreco;
	}

}
