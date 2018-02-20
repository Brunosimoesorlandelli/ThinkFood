package gui;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

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

public class TelaEditarFornecedor extends JFrame {

	
	private JPanel contentPane;
	private JTextField Email;
	private JTextField CEP;
	private JTextField fone;
	private JTextField RazaoSocial;


	public TelaEditarFornecedor(Funcionario_Gerente FG, Fornecedor fornecedor) {
		IFachada fachada = Fachada.getInstance();
		setTitle("ThinkFood");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 33, 46, 14);
		contentPane.add(lblEmail);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(10, 109, 303, 14);
		contentPane.add(lblCep);

		Email = new JTextField();
		Email.setBounds(66, 30, 247, 20);
		contentPane.add(Email);
		Email.setColumns(10);
		Email.setText(fornecedor.getEmail());

		CEP = new JTextField();
		CEP.setColumns(10);
		CEP.setBounds(66, 106, 247, 20);
		contentPane.add(CEP);
		CEP.setText(fornecedor.getCEP());

		JLabel lblFone = new JLabel("Fone");
		lblFone.setBounds(10, 255, 46, 14);
		contentPane.add(lblFone);

		fone = new JTextField();
		fone.setBounds(92, 252, 195, 20);
		contentPane.add(fone);
		fone.setColumns(10);
		fone.setText(String.valueOf(fornecedor.getFone()));

		JLabel lblRazaoSocial = new JLabel("Razao Social");
		lblRazaoSocial.setBounds(10, 186, 96, 14);
		contentPane.add(lblRazaoSocial);

		RazaoSocial = new JTextField();
		RazaoSocial.setColumns(10);
		RazaoSocial.setBounds(92, 183, 221, 20);
		contentPane.add(RazaoSocial);
		RazaoSocial.setText(fornecedor.getRazaoSocial());
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaGerente tela = new TelaGerente(FG);
				Date data = new Date(0, 00, 0000);
				
					Fornecedor forn = new Fornecedor( fornecedor.getCnpj(), Email.getText(),RazaoSocial.getText(),
							fornecedor.getCEP(), Integer.parseInt(fone.getText()));
					try {
						fachada.atualizarFornecedor(forn);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose();
					tela.setVisible(true);
					tela.setResizable(false);
					tela.setLocationRelativeTo(null);
					
			}
		});
		btnSalvar.setBounds(248, 329, 96, 23);
		contentPane.add(btnSalvar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaGerente tela = new TelaGerente(FG);
				dispose();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
				tela.setResizable(false);
			}
		});
		btnVoltar.setBounds(514, 330, 70, 20);
		contentPane.add(btnVoltar);
	}
	
}
