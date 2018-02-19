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
import beans.Fornecedor;
import beans.Funcionario_Gerente;

public class TelaCadastroFornecedor extends JFrame {

	private JPanel contentPane;
	private JTextField cnpj;
	private JTextField email;
	private JTextField rSocial;
	private JTextField endereco;
	private JTextField cidade;
	private JTextField estado;
	private JTextField telefone;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TelaCadastroFornecedor(Funcionario_Gerente FG) {
		IFachada f = Fachada.getInstance();
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

		cnpj = new JTextField();
		cnpj.setColumns(10);
		cnpj.setBounds(85, 11, 143, 20);
		contentPane.add(cnpj);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 58, 46, 14);
		contentPane.add(lblEmail);

		email = new JTextField();
		email.setColumns(10);
		email.setBounds(85, 55, 297, 20);
		contentPane.add(email);

		JLabel lblRazoSocial = new JLabel("Raz\u00E3o Social:");
		lblRazoSocial.setBounds(10, 102, 65, 14);
		contentPane.add(lblRazoSocial);

		rSocial = new JTextField();
		rSocial.setColumns(10);
		rSocial.setBounds(85, 99, 253, 20);
		contentPane.add(rSocial);

		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(10, 150, 65, 14);
		contentPane.add(lblEndereo);

		endereco = new JTextField();
		endereco.setColumns(10);
		endereco.setBounds(85, 144, 297, 20);
		contentPane.add(endereco);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 196, 46, 14);
		contentPane.add(lblCidade);

		cidade = new JTextField();
		cidade.setColumns(10);
		cidade.setBounds(85, 190, 143, 20);
		contentPane.add(cidade);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(10, 245, 46, 14);
		contentPane.add(lblEstado);

		estado = new JTextField();
		estado.setColumns(10);
		estado.setBounds(85, 239, 143, 20);
		contentPane.add(estado);

		telefone = new JTextField();
		telefone.setColumns(10);
		telefone.setBounds(85, 286, 143, 20);
		contentPane.add(telefone);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 292, 46, 14);
		contentPane.add(lblTelefone);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					f.cadastrarFornecedor(new Fornecedor(cnpj.getText(), email.getText(), rSocial.getText(), "37902028",
							Integer.parseInt(telefone.getText())));
					TelaGerente tela = new TelaGerente(FG);
					dispose();
					tela.setVisible(true);
					tela.setLocationRelativeTo(null);
					tela.setResizable(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(247, 332, 89, 23);
		contentPane.add(btnNewButton);
	}

}
