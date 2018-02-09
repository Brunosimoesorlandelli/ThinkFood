package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import Negocio.Fachada;
import Negocio.IFachada;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JPasswordField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastrar = new JMenu("Cadastrar");
		menuBar.add(mnCadastrar);
		
		JMenuItem mntmEntregador = new JMenuItem("Entregador");
		mnCadastrar.add(mntmEntregador);
		
		JMenuItem mntmGarom = new JMenuItem("Gar\u00E7om");
		mnCadastrar.add(mntmGarom);
		
		JMenuItem mntmSecretrio = new JMenuItem("Secret\u00E1rio");
		mnCadastrar.add(mntmSecretrio);
		
		JMenuItem mntmGerente = new JMenuItem("Gerente");
		mnCadastrar.add(mntmGerente);
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
				
			}
		});
		btnEntrar.setBounds(109, 100, 89, 23);
		contentPane.add(btnEntrar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(66, 69, 228, 20);
		contentPane.add(passwordField);
	}
}
