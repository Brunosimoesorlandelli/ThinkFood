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

public class TelaMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenu frame = new TelaMenu();
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
	public TelaMenu() {
		setTitle("ThinkFood");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenuItem mntmFuncionario = new JMenuItem("Funcionario");
		mnMenu.add(mntmFuncionario);
		
		JMenuItem mntmProduto = new JMenuItem("Produto");
		mnMenu.add(mntmProduto);
		
		JMenuItem mntmFornecedor = new JMenuItem("Fornecedor");
		mnMenu.add(mntmFornecedor);
		
		JMenuItem mntmReserva = new JMenuItem("Reserva");
		mnMenu.add(mntmReserva);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(10, 36, 185, 251);
		contentPane.add(textArea);
		
		JLabel lblUnidadeLoja = new JLabel("Unidade Loja");
		lblUnidadeLoja.setBounds(10, 11, 75, 14);
		contentPane.add(lblUnidadeLoja);
		
		JLabel lblEstoque = new JLabel("Estoque");
		lblEstoque.setBounds(728, 11, 46, 14);
		contentPane.add(lblEstoque);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		textArea_1.setEditable(false);
		textArea_1.setBounds(589, 36, 185, 251);
		contentPane.add(textArea_1);
	}
}
