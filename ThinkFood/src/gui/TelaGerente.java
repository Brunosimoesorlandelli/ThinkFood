package gui;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Negocio.Fachada;
import Negocio.IFachada;
import beans.Funcionario_Gerente;

public class TelaGerente extends JFrame {

	private JPanel contentPane;
	private static Connection connection;

	/**
	 * Create the frame.
	 */
	public TelaGerente(Funcionario_Gerente FG) {
		IFachada f = Fachada.getInstance();
		setResizable(false);
		setTitle("ThinkFood");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUnidadeLoja = new JLabel("Unidade Loja");
		lblUnidadeLoja.setBounds(146, 66, 96, 14);
		contentPane.add(lblUnidadeLoja);

		JLabel lblEstoque = new JLabel("Estoque");
		lblEstoque.setBounds(453, 66, 46, 14);
		contentPane.add(lblEstoque);

		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.setBounds(450, 229, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Remover");
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		btnNewButton_1.setBounds(549, 229, 89, 23);
		contentPane.add(btnNewButton_1);

		JLabel lblFuncionarios = new JLabel("Funcionarios");
		lblFuncionarios.setBounds(57, 302, 75, 14);
		contentPane.add(lblFuncionarios);

	

		JButton button_1 = new JButton("Adicionar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaCadastroFuncionario tela = new TelaCadastroFuncionario(FG);
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
				tela.setResizable(false);
			}
		});
		button_1.setBackground(SystemColor.inactiveCaption);
		button_1.setBounds(57, 466, 89, 23);
		contentPane.add(button_1);

		JLabel lblMenu = new JLabel("Cardapio");
		lblMenu.setBounds(552, 302, 62, 14);
		contentPane.add(lblMenu);

		JButton button_2 = new JButton("Adicionar");
		button_2.setBackground(SystemColor.inactiveCaption);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroItemMenu tela = new TelaCadastroItemMenu(FG);
				dispose();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
				tela.setResizable(false);
			}
		});
		button_2.setBounds(549, 466, 89, 23);
		contentPane.add(button_2);

		JButton button_3 = new JButton("Remover");
		button_3.setBackground(SystemColor.inactiveCaption);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_3.setBounds(648, 466, 89, 23);
		contentPane.add(button_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(552, 327, 185, 127);
		contentPane.add(scrollPane);

		JList cardapioLista = new JList();
		scrollPane.setViewportView(cardapioLista);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(57, 327, 185, 128);
		contentPane.add(scrollPane_3);

		JList funcionariosLista = new JList();
		String[] funcionarios = new String[f.listarFuncionarios().length];
		for (int j = 0; j < funcionarios.length; j++) {
			funcionarios[j] = f.listarFuncionarios()[j].getNome();
		}
		funcionariosLista.setListData(funcionarios);
		scrollPane_3.setViewportView(funcionariosLista);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(146, 91, 185, 128);
		contentPane.add(scrollPane_1);

		JList unidlojaList = new JList();
		String[] lojas = new String[f.listarLojas().length];
		for (int j = 0; j < lojas.length; j++) {
			lojas[j] = "Loja " + String.valueOf(f.listarLojas()[j].getSeq());
		}
		unidlojaList.setListData(lojas);
		scrollPane_1.setViewportView(unidlojaList);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(453, 90, 185, 128);
		contentPane.add(scrollPane_2);

		JList estoqueList = new JList();
		String[] estoque = new String[f.listarItemEstoque().length];
		for (int j = 0; j < estoque.length; j++) {
			estoque[j] = String.valueOf(f.listarItemEstoque()[j].getId());
		}

		estoqueList.setListData(estoque);
		scrollPane_2.setViewportView(estoqueList);

		JLabel lblFornecedores = new JLabel("Fornecedores");
		lblFornecedores.setBounds(302, 302, 89, 14);
		contentPane.add(lblFornecedores);

		JButton button_4 = new JButton("Remover");
		button_4.setBackground(SystemColor.inactiveCaption);
		button_4.setBounds(398, 466, 89, 23);
		contentPane.add(button_4);

		JButton button_5 = new JButton("Adicionar");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroFornecedor tela = new TelaCadastroFornecedor();
				dispose();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
				tela.setResizable(false);
			}
		});
		button_5.setBackground(SystemColor.inactiveCaption);
		button_5.setBounds(302, 466, 89, 23);
		contentPane.add(button_5);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(302, 327, 185, 128);
		contentPane.add(scrollPane_4);

		JList fornecedoresList = new JList();
		String[] fornecedores = new String[f.listarFornecedores().length];
		for (int j = 0; j < fornecedores.length; j++) {
			fornecedores[j] = f.listarFornecedores()[j].getEmail();
		}

		fornecedoresList.setListData(fornecedores);
		scrollPane_4.setViewportView(fornecedoresList);
		
		JButton FuncRemoverButton = new JButton("Remover");
		FuncRemoverButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int pos = funcionariosLista.getSelectedIndex();
			
				
			}
		});
		FuncRemoverButton.setBackground(SystemColor.inactiveCaption);
		FuncRemoverButton.setBounds(153, 466, 89, 23);
		contentPane.add(FuncRemoverButton);
	}
	
	
}
