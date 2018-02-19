package gui;

import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Negocio.Fachada;
import Negocio.IFachada;
import beans.Funcionario_Gerente;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaEstoque extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JLabel lblProdutos;
	private JLabel lblItensDoEstoque;
	private JButton btnNewButton;
	private JButton btnVoltar;
	private JButton btnRemoverItemDo;
	private JButton btnEditarItemEstoque;
	private JButton btnCadastrarProduto;
	private JButton btnRemoverProduto;
	private JButton btnEditarProduto;
	private JButton btnAtualizarItens;
	private JButton btnAtualizarProdutos;

	public TelaEstoque(Funcionario_Gerente FG) {
		IFachada f = Fachada.getInstance();
		setTitle("ThinkFood");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 60, 312, 346);
		contentPane.add(scrollPane);

		table = new JTable();
		DefaultTableModel modelProd = (DefaultTableModel) table.getModel();
		table.setModel(modelProd);
		modelProd.addColumn("Codigo");
		modelProd.addColumn("CNPJ Fornecedor");
		modelProd.addColumn("Cod Categoria");
		modelProd.addColumn("Unidade");
		for (int i = 0; i < f.listarProduto().length; i++) {
			modelProd.addRow(new Object[] { f.listarProduto()[i].getCodigo(), f.listarProduto()[i].getCnpj_fornecedor(),
					f.listarProduto()[i].getCod_categ(), f.listarProduto()[i].getUnidade() });
		}
		scrollPane.setViewportView(table);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(418, 60, 312, 346);
		contentPane.add(scrollPane_1);

		table_1 = new JTable();
		DefaultTableModel modelTock = (DefaultTableModel) table_1.getModel();
		table_1.setModel(modelTock);
		modelTock.addColumn("Codigo");
		modelTock.addColumn("ID Estoque");
		modelTock.addColumn("Lote");
		modelTock.addColumn("Quantidade");
		for (int i = 0; i < f.listarItemEstoque().length; i++) {
			modelTock.addRow(
					new Object[] { f.listarItemEstoque()[i].getCodProduto(), f.listarItemEstoque()[i].getIdEstoque(),
							f.listarItemEstoque()[i].getLote(), f.listarItemEstoque()[i].getQtd() });
		}
		scrollPane_1.setViewportView(table_1);

		lblProdutos = new JLabel("Produtos");
		lblProdutos.setBounds(215, 35, 46, 14);
		contentPane.add(lblProdutos);

		lblItensDoEstoque = new JLabel("Itens do Estoque");
		lblItensDoEstoque.setBounds(476, 35, 91, 14);
		contentPane.add(lblItensDoEstoque);

		btnNewButton = new JButton("Cadastrar Item");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroItemEstoque tela = new TelaCadastroItemEstoque(FG);
				dispose();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
				tela.setResizable(false);
			}
		});
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.setBounds(475, 450, 141, 23);
		contentPane.add(btnNewButton);

		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaGerente tela = new TelaGerente(FG);
				dispose();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
				tela.setResizable(false);
			}
		});
		btnVoltar.setBackground(SystemColor.inactiveCaption);
		btnVoltar.setBounds(0, 0, 89, 23);
		contentPane.add(btnVoltar);

		btnRemoverItemDo = new JButton("Remover Item");
		btnRemoverItemDo.setBackground(SystemColor.inactiveCaption);
		btnRemoverItemDo.setBounds(475, 484, 141, 23);
		contentPane.add(btnRemoverItemDo);

		btnEditarItemEstoque = new JButton("Editar Item");
		btnEditarItemEstoque.setBackground(SystemColor.inactiveCaption);
		btnEditarItemEstoque.setBounds(475, 518, 141, 23);
		contentPane.add(btnEditarItemEstoque);

		btnCadastrarProduto = new JButton("Cadastrar Produto");
		btnCadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroProduto tela = new TelaCadastroProduto(FG);
				dispose();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
				tela.setResizable(false);
			}
		});
		btnCadastrarProduto.setBackground(SystemColor.inactiveCaption);
		btnCadastrarProduto.setBounds(167, 450, 141, 23);
		contentPane.add(btnCadastrarProduto);

		btnRemoverProduto = new JButton("Remover Produto");
		btnRemoverProduto.setBackground(SystemColor.inactiveCaption);
		btnRemoverProduto.setBounds(167, 484, 141, 23);
		contentPane.add(btnRemoverProduto);

		btnEditarProduto = new JButton("Editar Produto");
		btnEditarProduto.setBackground(SystemColor.inactiveCaption);
		btnEditarProduto.setBounds(167, 518, 141, 23);
		contentPane.add(btnEditarProduto);

		btnAtualizarItens = new JButton("Atualizar Itens");
		btnAtualizarItens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelTock.getDataVector().removeAllElements();
				revalidate();
				for (int i = 0; i < f.listarItemEstoque().length; i++) {
					modelTock.addRow(new Object[] { f.listarItemEstoque()[i].getCodProduto(),
							f.listarItemEstoque()[i].getIdEstoque(), f.listarItemEstoque()[i].getLote(),
							f.listarItemEstoque()[i].getQtd() });
				}
			}
		});
		btnAtualizarItens.setBackground(SystemColor.inactiveCaption);
		btnAtualizarItens.setBounds(475, 417, 141, 23);
		contentPane.add(btnAtualizarItens);

		btnAtualizarProdutos = new JButton("Atualizar Produtos");
		btnAtualizarProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelProd.getDataVector().removeAllElements();
				revalidate();
				for (int i = 0; i < f.listarProduto().length; i++) {
					modelProd.addRow(
							new Object[] { f.listarProduto()[i].getCodigo(), f.listarProduto()[i].getCnpj_fornecedor(),
									f.listarProduto()[i].getCod_categ(), f.listarProduto()[i].getUnidade() });
				}
			}
		});
		btnAtualizarProdutos.setBackground(SystemColor.inactiveCaption);
		btnAtualizarProdutos.setBounds(167, 417, 141, 23);
		contentPane.add(btnAtualizarProdutos);
	}

}
