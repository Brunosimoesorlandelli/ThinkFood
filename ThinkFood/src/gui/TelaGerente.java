package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.JButton;

public class TelaGerente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaGerente frame = new TelaGerente();
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
	public TelaGerente() {
		setResizable(false);
		setTitle("ThinkFood");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(10, 36, 185, 127);
		contentPane.add(textArea);
		
		JLabel lblUnidadeLoja = new JLabel("Unidade Loja");
		lblUnidadeLoja.setBounds(10, 11, 75, 14);
		contentPane.add(lblUnidadeLoja);
		
		JLabel lblEstoque = new JLabel("Estoque");
		lblEstoque.setBounds(317, 11, 46, 14);
		contentPane.add(lblEstoque);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		textArea_1.setEditable(false);
		textArea_1.setBounds(317, 36, 185, 127);
		contentPane.add(textArea_1);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setBounds(314, 174, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remover");
		btnNewButton_1.setBounds(413, 174, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setLineWrap(true);
		textArea_2.setBounds(10, 272, 185, 127);
		contentPane.add(textArea_2);
		
		JLabel lblFuncionarios = new JLabel("Funcionarios");
		lblFuncionarios.setBounds(10, 247, 75, 14);
		contentPane.add(lblFuncionarios);
		
		JButton button = new JButton("Remover");
		button.setBounds(106, 411, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Adicionar");
		button_1.setBounds(10, 411, 89, 23);
		contentPane.add(button_1);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setLineWrap(true);
		textArea_3.setBounds(317, 272, 185, 127);
		contentPane.add(textArea_3);
		
		JLabel lblMenu = new JLabel("Cardapio");
		lblMenu.setBounds(317, 247, 46, 14);
		contentPane.add(lblMenu);
		
		JButton button_2 = new JButton("Adicionar");
		button_2.setBounds(314, 411, 89, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Remover");
		button_3.setBounds(413, 411, 89, 23);
		contentPane.add(button_3);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setLineWrap(true);
		textArea_4.setEditable(false);
		textArea_4.setBounds(599, 36, 185, 127);
		contentPane.add(textArea_4);
		
		JLabel label = new JLabel("Estoque");
		label.setBounds(599, 11, 46, 14);
		contentPane.add(label);
		
		JButton button_4 = new JButton("Adicionar");
		button_4.setBounds(599, 174, 89, 23);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("Remover");
		button_5.setBounds(695, 174, 89, 23);
		contentPane.add(button_5);
	}
}
