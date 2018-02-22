package gui;

import java.awt.Color;
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
import beans.ClientePF;
import beans.Funcionario_Gerente;

public class TelaEditarClientePF extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public TelaEditarClientePF(Funcionario_Gerente FG) {
		IFachada f = Fachada.getInstance();
		setTitle("ThinkFood");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 49, 46, 14);
		contentPane.add(lblNome);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(10, 117, 106, 14);
		contentPane.add(lblDataDeNascimento);

		JButton btnCadastrar = new JButton("Salvar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textField_1.getText();
				Date data = new Date(00, 03, 0300);
				ClientePF p = new ClientePF(nome, data, 0);
				try {
					f.atualizarClientePF(p);
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
		btnCadastrar.setForeground(new Color(0, 0, 0));
		btnCadastrar.setBackground(SystemColor.inactiveCaption);
		btnCadastrar.setBounds(147, 211, 89, 23);
		contentPane.add(btnCadastrar);

		textField = new JTextField();
		textField.setBounds(126, 114, 248, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(66, 46, 308, 20);
		contentPane.add(textField_1);
	}
}
