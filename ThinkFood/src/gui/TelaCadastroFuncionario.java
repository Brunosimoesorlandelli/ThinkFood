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
		setBounds(100, 100, 600, 400);
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

		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(323, 122, 46, 14);
		contentPane.add(lblCep);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(323, 170, 46, 14);
		contentPane.add(lblCidade);

		JLabel lblNewLabel = new JLabel("Estado");
		lblNewLabel.setBounds(323, 220, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(323, 269, 46, 14);
		contentPane.add(lblBairro);

		JLabel lblPontoDeReferencia = new JLabel("Ponto de Referencia");
		lblPontoDeReferencia.setBounds(10, 223, 109, 14);
		contentPane.add(lblPontoDeReferencia);

		JLabel lblTipoLogradouro = new JLabel("Tipo Logradouro");
		lblTipoLogradouro.setBounds(10, 269, 89, 14);
		contentPane.add(lblTipoLogradouro);

		textField = new JTextField();
		textField.setBounds(66, 67, 247, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(66, 119, 247, 20);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(116, 167, 197, 20);
		contentPane.add(textField_2);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(379, 119, 195, 20);
		contentPane.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(379, 167, 195, 20);
		contentPane.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(379, 217, 195, 20);
		contentPane.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(379, 266, 195, 20);
		contentPane.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(116, 266, 197, 20);
		contentPane.add(textField_8);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(116, 220, 197, 20);
		contentPane.add(textField_9);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "Entregador", "Gar\u00E7om", "Secretario", "Gerente" }));
		comboBox.setBounds(379, 67, 128, 20);
		contentPane.add(comboBox);
		
		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(323, 70, 46, 14);
		contentPane.add(lblCargo);
	}
}
