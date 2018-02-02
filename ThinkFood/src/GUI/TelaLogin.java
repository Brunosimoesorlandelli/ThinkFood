package GUI;
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
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JPasswordField;

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
		
		JLabel lblNewLabel = new JLabel("Usu\u00E1rio");
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
		btnEntrar.setBounds(108, 128, 89, 23);
		contentPane.add(btnEntrar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(66, 69, 228, 20);
		contentPane.add(passwordField);
	}
}