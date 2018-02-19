package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Negocio.Fachada;
import Negocio.IFachada;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class TelaCadastroProduto extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroProduto frame = new TelaCadastroProduto();
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
	public TelaCadastroProduto() {
		IFachada f = Fachada.getInstance();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUnidade = new JLabel("Unidade");
		lblUnidade.setBounds(133, 100, 46, 14);
		contentPane.add(lblUnidade);

		textField = new JTextField();
		textField.setBounds(312, 97, 338, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(133, 299, 57, 14);
		contentPane.add(lblDescrio);

		textField_1 = new JTextField();
		textField_1.setBounds(312, 296, 339, 121);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblQuantidadeMinimaNo = new JLabel("Quantidade Minima no Estoque");
		lblQuantidadeMinimaNo.setBounds(133, 146, 162, 14);
		contentPane.add(lblQuantidadeMinimaNo);

		textField_2 = new JTextField();
		textField_2.setBounds(312, 143, 338, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setBounds(133, 196, 68, 14);
		contentPane.add(lblFornecedor);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(312, 193, 342, 20);
		DefaultComboBoxModel modelBox = (DefaultComboBoxModel) comboBox.getModel();
		comboBox.setModel(modelBox);
		for (int i = 0; i < f.listarProduto().length; i++) {
			modelBox.addElement(new Object[] { f.listarProduto()[i].getCod_categ() });
		}
		contentPane.add(comboBox);

		JLabel lblCodigoCategoria = new JLabel("Codigo Categoria");
		lblCodigoCategoria.setBounds(133, 250, 91, 14);
		contentPane.add(lblCodigoCategoria);

		textField_3 = new JTextField();
		textField_3.setBounds(312, 247, 338, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JButton btnCadastrarProduto = new JButton("Cadastrar Produto");
		btnCadastrarProduto.setBackground(SystemColor.inactiveCaption);
		btnCadastrarProduto.setBounds(331, 490, 121, 23);
		contentPane.add(btnCadastrarProduto);
	}
}
