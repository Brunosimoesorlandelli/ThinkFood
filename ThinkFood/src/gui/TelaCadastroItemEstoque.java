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
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroItemEstoque extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public TelaCadastroItemEstoque() {
		IFachada f = Fachada.getInstance();
		setTitle("ThinkFood");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCdigoDoProduto = new JLabel("C\u00F3digo do Produto");
		lblCdigoDoProduto.setBounds(109, 101, 102, 14);
		contentPane.add(lblCdigoDoProduto);
		String[] produtos = new String[f.listarProduto().length];
		for (int i = 0; i < f.listarProduto().length; i++) {
			produtos[i] = String.valueOf(f.listarProduto()[i].getCodigo());
		}
		JComboBox comboBox = new JComboBox();
		DefaultComboBoxModel modelBox = (DefaultComboBoxModel) comboBox.getModel();
		comboBox.setModel(modelBox);
		for (int i = 0; i < f.listarEntregadores().length; i++) {
			modelBox.addElement(produtos[i]);
		}
		comboBox.setBounds(320, 98, 354, 20);
		contentPane.add(comboBox);

		JLabel lblNewLabel = new JLabel("ID do Estoque");
		lblNewLabel.setBounds(109, 158, 102, 14);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(320, 155, 354, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblLote = new JLabel("Lote");
		lblLote.setBounds(109, 210, 102, 14);
		contentPane.add(lblLote);

		textField_1 = new JTextField();
		textField_1.setBounds(320, 207, 354, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JSpinner Milhares = new JSpinner();
		Milhares.setBackground(SystemColor.inactiveCaption);
		Milhares.setBounds(256, 260, 34, 20);
		contentPane.add(Milhares);

		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(36, 263, 102, 14);
		contentPane.add(lblQuantidade);

		JLabel lblMilhares = new JLabel("Milhares");
		lblMilhares.setBounds(174, 263, 46, 14);
		contentPane.add(lblMilhares);

		JLabel lblCentenas = new JLabel("Centenas");
		lblCentenas.setBounds(326, 263, 46, 14);
		contentPane.add(lblCentenas);

		JSpinner Centenas = new JSpinner();
		Centenas.setBackground(SystemColor.inactiveCaption);
		Centenas.setBounds(408, 260, 34, 20);
		contentPane.add(Centenas);

		JLabel lblDezenas = new JLabel("Dezenas");
		lblDezenas.setBounds(478, 263, 46, 14);
		contentPane.add(lblDezenas);

		JSpinner Dezenas = new JSpinner();
		Dezenas.setBackground(SystemColor.inactiveCaption);
		Dezenas.setBounds(560, 260, 34, 20);
		contentPane.add(Dezenas);

		JLabel lblUnidades = new JLabel("Unidades");
		lblUnidades.setBounds(630, 263, 46, 14);
		contentPane.add(lblUnidades);

		JSpinner Unidades = new JSpinner();
		Unidades.setBackground(SystemColor.inactiveCaption);
		Unidades.setBounds(712, 260, 34, 20);
		contentPane.add(Unidades);

		JLabel lblDataDeEntrada = new JLabel("Data de Entrada");
		lblDataDeEntrada.setBounds(109, 345, 102, 14);
		contentPane.add(lblDataDeEntrada);

		JLabel lblDataDeValidade = new JLabel("Data de Validade");
		lblDataDeValidade.setBounds(109, 392, 102, 14);
		contentPane.add(lblDataDeValidade);

		textField_2 = new JTextField();
		textField_2.setBounds(320, 342, 354, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(320, 389, 354, 20);
		contentPane.add(textField_3);

		JButton btnCadastrarItemNo = new JButton("Cadastrar Item no Estoque");
		btnCadastrarItemNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnCadastrarItemNo.setBackground(SystemColor.inactiveCaption);
		btnCadastrarItemNo.setBounds(283, 466, 218, 23);
		contentPane.add(btnCadastrarItemNo);
	}
}
