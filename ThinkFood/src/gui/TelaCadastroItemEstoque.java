package gui;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

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
import beans.ItemEstoque;

public class TelaCadastroItemEstoque extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public TelaCadastroItemEstoque(Funcionario_Gerente FG) {
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
		
		JComboBox comboBox = new JComboBox();
		DefaultComboBoxModel modelBox = (DefaultComboBoxModel) comboBox.getModel();
		comboBox.setModel(modelBox);
		for (int i = 0; i < f.listarItemEstoque().length; i++) {
			modelBox.addElement(f.listarItemEstoque()[i].getCodProduto());
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

		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(109, 264, 102, 14);
		contentPane.add(lblQuantidade);

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
		Date dataEn = new Date(00, 00, 0200);
		Date dataVal = new Date(00, 03, 0200);
		btnCadastrarItemNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ItemEstoque p = new ItemEstoque(21, ((Integer) comboBox.getSelectedItem()),
						Integer.parseInt(textField.getText()), dataEn, Integer.parseInt(textField_1.getText()),
						Integer.parseInt(textField_4.getText()), dataVal);
				try {
					f.cadastrarItemEstoque(p);
					dispose();
					TelaGerente tela = new TelaGerente(FG);
					tela.setVisible(true);
					tela.setResizable(false);
					tela.setLocationRelativeTo(null);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCadastrarItemNo.setBackground(SystemColor.inactiveCaption);
		btnCadastrarItemNo.setBounds(283, 466, 218, 23);
		contentPane.add(btnCadastrarItemNo);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(320, 261, 354, 20);
		contentPane.add(textField_4);
	}
}
