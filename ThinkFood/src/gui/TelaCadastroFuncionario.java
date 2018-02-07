package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.SystemColor;

public class TelaCadastroFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroFuncionario frame = new TelaCadastroFuncionario();
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
	public TelaCadastroFuncionario() {
		setTitle("ThinkFood");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 70, 46, 14);
		contentPane.add(lblNome);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 122, 46, 14);
		contentPane.add(lblCpf);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(10, 170, 96, 14);
		contentPane.add(lblDataDeNascimento);

		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(10, 215, 46, 14);
		contentPane.add(lblEndereo);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(10, 265, 46, 14);
		contentPane.add(lblCep);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(10, 312, 46, 14);
		contentPane.add(lblCidade);

		JLabel lblNewLabel = new JLabel("Estado");
		lblNewLabel.setBounds(10, 360, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(10, 404, 46, 14);
		contentPane.add(lblBairro);

		JLabel lblPontoDeReferencia = new JLabel("Ponto de Referencia");
		lblPontoDeReferencia.setBounds(10, 497, 109, 14);
		contentPane.add(lblPontoDeReferencia);

		JLabel lblTipoLogradouro = new JLabel("Tipo Logradouro");
		lblTipoLogradouro.setBounds(10, 450, 89, 14);
		contentPane.add(lblTipoLogradouro);

		textField = new JTextField();
		textField.setBounds(66, 67, 297, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(66, 119, 297, 20);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(116, 167, 247, 20);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(66, 215, 297, 20);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(66, 262, 297, 20);
		contentPane.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(66, 309, 297, 20);
		contentPane.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(66, 357, 297, 20);
		contentPane.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(66, 401, 297, 20);
		contentPane.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(116, 447, 247, 20);
		contentPane.add(textField_8);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(116, 494, 247, 20);
		contentPane.add(textField_9);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "Entregador", "Gar\u00E7om", "Secretario", "Gerente" }));
		comboBox.setBounds(483, 67, 128, 20);
		contentPane.add(comboBox);
	}
}
