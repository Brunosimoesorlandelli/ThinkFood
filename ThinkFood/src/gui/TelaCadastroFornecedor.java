package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;

public class TelaCadastroFornecedor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroFornecedor frame = new TelaCadastroFornecedor();
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
	public TelaCadastroFornecedor() {
		setTitle("ThinkFood");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(10, 14, 46, 14);
		contentPane.add(lblCnpj);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(85, 11, 143, 20);
		contentPane.add(textField);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 58, 46, 14);
		contentPane.add(lblEmail);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(85, 55, 297, 20);
		contentPane.add(textField_1);
		
		JLabel lblRazoSocial = new JLabel("Raz\u00E3o Social:");
		lblRazoSocial.setBounds(10, 102, 65, 14);
		contentPane.add(lblRazoSocial);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(85, 99, 253, 20);
		contentPane.add(textField_2);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(10, 150, 65, 14);
		contentPane.add(lblEndereo);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(85, 144, 297, 20);
		contentPane.add(textField_3);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 196, 46, 14);
		contentPane.add(lblCidade);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(85, 190, 143, 20);
		contentPane.add(textField_4);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(10, 245, 46, 14);
		contentPane.add(lblEstado);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(85, 239, 143, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(85, 286, 143, 20);
		contentPane.add(textField_6);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 292, 46, 14);
		contentPane.add(lblTelefone);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBounds(247, 332, 89, 23);
		contentPane.add(btnNewButton);
	}

}
