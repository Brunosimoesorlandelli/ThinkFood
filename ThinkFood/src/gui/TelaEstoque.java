package gui;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Negocio.Fachada;
import Negocio.IFachada;
import beans.Funcionario_Gerente;
import beans.Produto;

public class TelaEstoque extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
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
	private JScrollPane scrollPane_2;

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
		scrollPane.setBounds(240, 60, 241, 346);
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
		scrollPane_1.setBounds(523, 60, 227, 346);
		contentPane.add(scrollPane_1);

		table_1 = new JTable();
		DefaultTableModel modelTock = (DefaultTableModel) table_1.getModel();
		table_1.setModel(modelTock);
		modelTock.addColumn("Seq");
		modelTock.addColumn("Codigo");
		modelTock.addColumn("ID Estoque");
		modelTock.addColumn("Lote");
		modelTock.addColumn("Quantidade");
		for (int i = 0; i < f.listarItemEstoque().length; i++) {
			modelTock.addRow(new Object[] { f.listarItemEstoque()[i].getSeq(), f.listarItemEstoque()[i].getCodProduto(),
					f.listarItemEstoque()[i].getIdEstoque(), f.listarItemEstoque()[i].getLote(),
					f.listarItemEstoque()[i].getQtd() });
		}
		scrollPane_1.setViewportView(table_1);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(24, 60, 187, 346);
		contentPane.add(scrollPane_2);
		table_2 = new JTable();
		DefaultTableModel modelCateg = (DefaultTableModel) table_2.getModel();
		table_2.setModel(modelCateg);
		modelCateg.addColumn("Codigo");
		modelCateg.addColumn("Descricao");
		for (int i = 0; i < f.listarCategoria().length; i++) {
			modelCateg.addRow(new Object[] { f.listarCategoria()[i].getCodCateg(), f.listarCategoria()[i].getDescr() });
		}

		scrollPane_2.setViewportView(table_2);
		
		lblProdutos = new JLabel("Produtos");
		lblProdutos.setBounds(337, 35, 61, 14);
		contentPane.add(lblProdutos);

		lblItensDoEstoque = new JLabel("Itens do Estoque");
		lblItensDoEstoque.setBounds(603, 35, 119, 14);
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
		btnNewButton.setBounds(571, 450, 141, 23);
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
		btnRemoverItemDo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int seq = Integer.parseInt(String.valueOf(table_1.getModel().getValueAt(table_1.getSelectedRow(), 0)));
				System.out.println(seq);

				try {
					if (f.procurarItemEstoque(seq) != null) {
						f.removerItemEstoque(f.procurarItemEstoque(seq));
					} else {
						JOptionPane.showMessageDialog(null, "Este item não existe. Tente novamente.");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnRemoverItemDo.setBackground(SystemColor.inactiveCaption);
		btnRemoverItemDo.setBounds(571, 484, 141, 23);
		contentPane.add(btnRemoverItemDo);

		btnEditarItemEstoque = new JButton("Editar Item");
		btnEditarItemEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int seq = Integer.parseInt(String.valueOf(table_1.getModel().getValueAt(table_1.getSelectedRow(), 0)));

				try {
					TelaEditarItemEstoque tela = new TelaEditarItemEstoque(FG, f.procurarItemEstoque(seq));
					dispose();
					tela.setVisible(true);
					tela.setLocationRelativeTo(null);
					tela.setResizable(false);
				} catch (SQLException e1) {

					e1.printStackTrace();
				}

			}
		});
		btnEditarItemEstoque.setBackground(SystemColor.inactiveCaption);
		btnEditarItemEstoque.setBounds(571, 518, 141, 23);
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
		btnCadastrarProduto.setBounds(286, 450, 141, 23);
		contentPane.add(btnCadastrarProduto);

		btnRemoverProduto = new JButton("Remover Produto");
		btnRemoverProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int cod = Integer.parseInt(String.valueOf(table.getModel().getValueAt(table.getSelectedRow(), 0)));
				System.out.println(cod);

				try {
					if (f.procurarProduto(cod) != null) {
						f.removerProduto(f.procurarProduto(cod));
					} else {
						JOptionPane.showMessageDialog(null, "Este Codigo não existe. Tente novamente.");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnRemoverProduto.setBackground(SystemColor.inactiveCaption);
		btnRemoverProduto.setBounds(286, 484, 141, 23);
		contentPane.add(btnRemoverProduto);

		btnEditarProduto = new JButton("Editar Produto");
		btnEditarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Produto produto = null;
				int cod = Integer.parseInt(String.valueOf(table.getModel().getValueAt(table.getSelectedRow(), 0)));
				System.out.println(cod);
				for (int i = 0; i < f.listarProduto().length; i++) {
					if (f.listarProduto()[i].getCodigo() == cod)
						produto = f.listarProduto()[i];
				}

				try {

					if (f.procurarProduto(cod) != null) {
						TelaEditarProduto tela = new TelaEditarProduto(FG, produto);
						tela.setVisible(true);
						tela.setResizable(false);
						tela.setLocationRelativeTo(null);
					} else {
						JOptionPane.showMessageDialog(null, "Este codigo não existe. Tente novamente.");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEditarProduto.setBackground(SystemColor.inactiveCaption);
		btnEditarProduto.setBounds(286, 518, 141, 23);
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
		btnAtualizarItens.setBounds(571, 417, 141, 23);
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
		btnAtualizarProdutos.setBounds(286, 417, 141, 23);
		contentPane.add(btnAtualizarProdutos);
		
		JLabel lblCategoria = new JLabel("Categorias");
		lblCategoria.setBounds(87, 35, 70, 14);
		contentPane.add(lblCategoria);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelProd.getDataVector().removeAllElements();
				revalidate();
				for (int i = 0; i < f.listarProduto().length; i++) {
					if(f.listarProduto()[i].getCod_categ() == Integer.parseInt(String.valueOf(table_2.getModel().getValueAt(table_2.getSelectedRow(), 0)))) {
					modelProd.addRow(
							new Object[] { f.listarProduto()[i].getCodigo(), f.listarProduto()[i].getCnpj_fornecedor(),
									f.listarProduto()[i].getCod_categ(), f.listarProduto()[i].getUnidade() });
					}}
			}
		});
		btnFiltrar.setBounds(68, 417, 89, 23);
		contentPane.add(btnFiltrar);
		
		
	}
}
