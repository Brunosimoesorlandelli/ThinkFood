package gui;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Negocio.Fachada;
import Negocio.IFachada;
import beans.Funcionario;
import beans.Funcionario_Gerente;

public class TelaGerente extends JFrame {

	private JPanel contentPane;

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
		lblUnidadeLoja.setBounds(10, 11, 75, 14);
		contentPane.add(lblUnidadeLoja);

		JLabel lblEstoque = new JLabel("Estoque");
		lblEstoque.setBounds(317, 11, 46, 14);
		contentPane.add(lblEstoque);

		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setBounds(314, 174, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Remover");
		btnNewButton_1.setBounds(413, 174, 89, 23);
		contentPane.add(btnNewButton_1);

		JLabel lblFuncionarios = new JLabel("Funcionarios");
		lblFuncionarios.setBounds(10, 247, 75, 14);
		contentPane.add(lblFuncionarios);

		JButton button = new JButton("Remover");
		button.setBounds(106, 411, 89, 23);
		contentPane.add(button);

		JButton button_1 = new JButton("Adicionar");
		button_1.setBounds(10, 411, 89, 23);
		contentPane.add(button_1);
		
		
		

		JLabel lblMenu = new JLabel("Cardapio");
		lblMenu.setBounds(317, 247, 46, 14);
		contentPane.add(lblMenu);

		JButton button_2 = new JButton("Adicionar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroProduto tela = new TelaCadastroProduto();
				dispose();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
				tela.setResizable(false);
			}
		});
		button_2.setBounds(314, 411, 89, 23);
		contentPane.add(button_2);

		JButton button_3 = new JButton("Remover");
		button_3.setBounds(413, 411, 89, 23);
		contentPane.add(button_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(317, 272, 185, 127);
		contentPane.add(scrollPane);
		
		JList cardapioLista = new JList();
		scrollPane.setViewportView(cardapioLista);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 272, 185, 128);
		contentPane.add(scrollPane_3);
		
		JList funcionariosLista = new JList();
		scrollPane_3.setViewportView(funcionariosLista);
		

		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 36, 185, 128);
		contentPane.add(scrollPane_1);
		
		JList unidlojaList = new JList();
		scrollPane_1.setViewportView(unidlojaList);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(317, 35, 185, 128);
		contentPane.add(scrollPane_2);
		
		JList estoqueList = new JList();
		scrollPane_2.setViewportView(estoqueList);
	}
}
