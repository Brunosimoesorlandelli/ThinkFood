package gui;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Negocio.Fachada;
import Negocio.IFachada;
import beans.ClientePJ;
import beans.Funcionario_Gerente;

public class TelaEditarClientePJ extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public TelaEditarClientePJ(Funcionario_Gerente FG, ClientePJ cliente) {
		IFachada f = Fachada.getInstance();
		setTitle("ThinkFood");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRazaoSocial = new JLabel("Razao Social");
		lblRazaoSocial.setBounds(10, 92, 68, 14);
		contentPane.add(lblRazaoSocial);

		JLabel lblNomeFantasia = new JLabel("Nome Fantasia");
		lblNomeFantasia.setBounds(10, 39, 82, 14);
		contentPane.add(lblNomeFantasia);

		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setBounds(10, 145, 46, 14);
		contentPane.add(lblCnpj);
		
		textField = new JTextField();
		textField.setBounds(102, 36, 272, 20);
		textField.setColumns(10);
		textField.setText(cliente.getNomeFantasia());
		contentPane.add(textField);
		

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(88, 89, 286, 20);
		textField_1.setText(cliente.getRazaoSocial());
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(66, 142, 308, 20);
		textField_2.setText(cliente.getCnpj());
		contentPane.add(textField_2);

		JButton btnCadastrar = new JButton("Salvar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cnpj = textField_2.getText();
				String rSocial = textField_1.getText();
				String nFanta = textField.getText();

				ClientePJ p = new ClientePJ(cliente.getId(), cnpj, rSocial, nFanta);
				try {
					f.atualizarClientePJ(p);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				TelaUnidadeLoja tela = new TelaUnidadeLoja(FG);
				dispose();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
				tela.setResizable(false);
			}
		});
		btnCadastrar.setBackground(SystemColor.inactiveCaption);
		btnCadastrar.setBounds(147, 198, 89, 23);
		contentPane.add(btnCadastrar);

	}

}
