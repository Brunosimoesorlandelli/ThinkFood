package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Negocio.Fachada;
import Negocio.IFachada;
import beans.Funcionario_Entregador;
import beans.Funcionario_Garcon;
import beans.Funcionario_Gerente;
import beans.Funcionario_Secretario;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		IFachada fachada = Fachada.getInstance();
		setResizable(false);
		setBackground(Color.WHITE);
		setTitle("ThinkFood");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 200);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("CPF");
		lblNewLabel.setBounds(10, 47, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 72, 46, 14);
		contentPane.add(lblSenha);

		textField = new JTextField();
		textField.setBounds(66, 44, 228, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String senha = null;
				for (int i = 0; i < passwordField.getPassword().length; i++) {
					if (i > 0) {
						senha += Character.toString(passwordField.getPassword()[i]);
					} else {
						senha = Character.toString(passwordField.getPassword()[i]);
					}

				}

				try {
					if (fachada.logar(textField.getText()) instanceof Funcionario_Gerente) {
						TelaGerente tela = new TelaGerente((Funcionario_Gerente) fachada.logar(textField.getText()));
						dispose();
						tela.setVisible(true);
						tela.setLocationRelativeTo(null);
						tela.setResizable(false);

					} else if (fachada.logar(textField.getText()) instanceof Funcionario_Garcon) {
						TelaGarcom tela = new TelaGarcom((Funcionario_Garcon) fachada.logar(textField.getText()));
						dispose();
						tela.setVisible(true);
						tela.setLocationRelativeTo(null);
						tela.setResizable(false);

					} else if (fachada.logar(textField.getText()) instanceof Funcionario_Entregador) {

					} else if (fachada.logar(textField.getText()) instanceof Funcionario_Secretario) {
						TelaSecretario tela = new TelaSecretario(
								(Funcionario_Secretario) fachada.logar(textField.getText()));
						dispose();
						tela.setVisible(true);
						tela.setLocationRelativeTo(null);
						tela.setResizable(false);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnEntrar.setBounds(109, 100, 89, 23);
		contentPane.add(btnEntrar);

		passwordField = new JPasswordField();
		passwordField.setBounds(66, 69, 228, 20);
		contentPane.add(passwordField);
	}
}
