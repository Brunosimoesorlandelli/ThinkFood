package gui;

import java.awt.SystemColor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Negocio.Fachada;
import Negocio.IFachada;
import beans.Funcionario_Gerente;
import beans.Produto;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class TelaCadastroProduto extends JFrame {

	private JPanel contentPane;
	private JTextField unidade;
	private JTextField descr;
	private JTextField qtdMinStk;

	/**
	 * Create the frame.
	 */
	public TelaCadastroProduto(Funcionario_Gerente FG) {
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

		unidade = new JTextField();
		unidade.setBounds(312, 97, 338, 20);
		contentPane.add(unidade);
		unidade.setColumns(10);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(133, 299, 57, 14);
		contentPane.add(lblDescrio);

		descr = new JTextField();
		descr.setBounds(312, 296, 339, 121);
		contentPane.add(descr);
		descr.setColumns(10);

		JLabel lblQuantidadeMinimaNo = new JLabel("Quantidade Minima no Estoque");
		lblQuantidadeMinimaNo.setBounds(133, 146, 162, 14);
		contentPane.add(lblQuantidadeMinimaNo);

		qtdMinStk = new JTextField();
		qtdMinStk.setBounds(312, 143, 338, 20);
		contentPane.add(qtdMinStk);
		qtdMinStk.setColumns(10);

		JLabel lblCodCateg = new JLabel("Categoria");
		lblCodCateg.setBounds(133, 196, 68, 14);
		contentPane.add(lblCodCateg);

		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(312, 193, 342, 20);
		DefaultComboBoxModel modelBox = (DefaultComboBoxModel) comboBox.getModel();
		comboBox.setModel(modelBox);
		for (int i = 0; i < f.listarCategoria().length; i++) {
			modelBox.addElement(f.listarCategoria()[i].getCodCateg());
		}
		contentPane.add(comboBox);

		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setBounds(133, 250, 91, 14);
		contentPane.add(lblFornecedor);

		JButton btnCadastrarProduto = new JButton("Cadastrar Produto");
		btnCadastrarProduto.setBackground(SystemColor.inactiveCaption);
		btnCadastrarProduto.setBounds(331, 490, 121, 23);
		contentPane.add(btnCadastrarProduto);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(312, 247, 338, 20);
		
		DefaultComboBoxModel modelBox1 = (DefaultComboBoxModel) comboBox_1.getModel();
		comboBox_1.setModel(modelBox1);
		for (int i = 0; i < f.listarFornecedores().length; i++) {
			modelBox1.addElement(f.listarFornecedores()[i].getCnpj());
		}
		contentPane.add(comboBox_1);
	
	
	
	btnCadastrarProduto.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Produto p = new Produto(Integer.parseInt(unidade.getText()), descr.getText(),
					Integer.parseInt(qtdMinStk.getText()), String.valueOf(comboBox_1.getSelectedItem()),
					Integer.parseInt(String.valueOf(comboBox.getSelectedItem())));
			try {
				f.cadastrarProduto(p);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			TelaEstoque tela = new TelaEstoque(FG);
			dispose();
			tela.setVisible(true);
			tela.setLocationRelativeTo(null);
			tela.setResizable(false);
		}
	});
}}
