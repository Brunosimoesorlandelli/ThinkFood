package gui;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Negocio.Fachada;
import Negocio.IFachada;
import beans.Fornecedor;
import beans.Funcionario;
import beans.Funcionario_Gerente;

public class TelaGerente extends JFrame {

	private JPanel contentPane;
	private static Connection connection;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Create the frame.
	 */
	public TelaGerente(Funcionario_Gerente FG) {
		IFachada f = Fachada.getInstance();
		setTitle("ThinkFood");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 800);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnGerenciamentoDeProduto = new JMenu("Gerenciamento de Produto e Estoque");
		menuBar.add(mnGerenciamentoDeProduto);

		JMenuItem mntmGerenciar = new JMenuItem("Gerenciar");
		mntmGerenciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaEstoque tela = new TelaEstoque(FG);
				dispose();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
				tela.setResizable(false);
			}
		});
		mnGerenciamentoDeProduto.add(mntmGerenciar);

		JMenu mnGerenciamentoDeLojas = new JMenu("Gerenciamento de Clientes");
		menuBar.add(mnGerenciamentoDeLojas);

		JMenuItem mntmGerenciar_2 = new JMenuItem("Gerenciar");
		mntmGerenciar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaUnidadeLoja tela = new TelaUnidadeLoja(FG);
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
				tela.setResizable(false);
			}
		});
		mnGerenciamentoDeLojas.add(mntmGerenciar_2);

		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblFuncionarios = new JLabel("Funcionarios");
		lblFuncionarios.setBounds(281, 4, 75, 14);
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
		button_1.setBounds(276, 648, 89, 23);
		contentPane.add(button_1);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(135, 31, 301, 572);
		contentPane.add(scrollPane_3);
		table_1 = new JTable();
		DefaultTableModel modelFunc = (DefaultTableModel) table_1.getModel();
		table_1.setModel(modelFunc);
		modelFunc.addColumn("Nome");
		modelFunc.addColumn("Cpf");
		modelFunc.addColumn("SeqLoja");
		for (int i = 0; i < f.listarFuncionarios().length; i++) {
			modelFunc.addRow(new Object[] { f.listarFuncionarios()[i].getNome(), f.listarFuncionarios()[i].getCpf(),
					f.listarFuncionarios()[i].getSeq_loja() });
		}
		scrollPane_3.setViewportView(table_1);

		JLabel lblFornecedores = new JLabel("Fornecedores");
		lblFornecedores.setBounds(637, 4, 89, 14);
		contentPane.add(lblFornecedores);

		JButton button_4 = new JButton("Remover");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = String.valueOf(table_1.getModel().getValueAt(table_1.getSelectedRow(), 1));
				System.out.println(cpf);
				try {
					if (f.procurarEntregador(cpf) != null) {
						f.removerEntregador(f.procurarEntregador(cpf));
					} else if (f.procurarGarcom(cpf) != null) {
						f.removerGarcon(f.procurarGarcom(cpf));
					} else if (f.procurarGerente(cpf) != null) {
						f.removerGerente(f.procurarGerente(cpf));
					} else if (f.procurarSecretario(cpf) != null) {
						f.removerSecretario(f.procurarSecretario(cpf));
					} else {
						JOptionPane.showMessageDialog(null, "Este CPF não existe. Tente novamente.");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button_4.setBackground(SystemColor.inactiveCaption);
		button_4.setBounds(276, 673, 89, 23);
		contentPane.add(button_4);

		JButton button_5 = new JButton("Adicionar");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroFornecedor tela = new TelaCadastroFornecedor(FG);
				dispose();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
				tela.setResizable(false);
			}
		});
		button_5.setBackground(SystemColor.inactiveCaption);
		button_5.setBounds(641, 648, 89, 23);
		contentPane.add(button_5);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(571, 31, 301, 572);
		contentPane.add(scrollPane_4);

		table_2 = new JTable();
		scrollPane_4.setViewportView(table_2);
		DefaultTableModel modelFornece = (DefaultTableModel) table_2.getModel();
		table_2.setModel(modelFornece);
		modelFornece.addColumn("Email");
		modelFornece.addColumn("Cnpj");
		modelFornece.addColumn("Fone");
		for (int i = 0; i < f.listarFornecedores().length; i++) {
			modelFornece.addRow(new Object[] { f.listarFornecedores()[i].getEmail(),
					f.listarFornecedores()[i].getCnpj(), f.listarFornecedores()[i].getFone() });
		}

		JButton button = new JButton("Editar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Funcionario funcionario = null;
				String cpf = String.valueOf(table_1.getModel().getValueAt(table_1.getSelectedRow(), 1));
				System.out.println(cpf);
				for (int i = 0; i < f.listarFuncionarios().length; i++) {
					if (f.listarFuncionarios()[i].getCpf().equals(cpf))
						funcionario = f.listarFuncionarios()[i];
				}

				try {

					if (f.procurarEntregador(cpf) != null) {
						TelaEditarFuncionario tela = new TelaEditarFuncionario(FG, funcionario);
						tela.setVisible(true);
						tela.setResizable(false);
						tela.setLocationRelativeTo(null);
					} else if (f.procurarGarcom(cpf) != null) {
						TelaEditarFuncionario tela = new TelaEditarFuncionario(FG, funcionario);
						tela.setVisible(true);
						tela.setResizable(false);
						tela.setLocationRelativeTo(null);
					} else if (f.procurarGerente(cpf) != null) {
						TelaEditarFuncionario tela = new TelaEditarFuncionario(FG, funcionario);
						tela.setVisible(true);
						tela.setResizable(false);
						tela.setLocationRelativeTo(null);
					} else if (f.procurarSecretario(cpf) != null) {
						TelaEditarFuncionario tela = new TelaEditarFuncionario(FG, funcionario);
						tela.setVisible(true);
						tela.setResizable(false);
						tela.setLocationRelativeTo(null);
					} else {
						JOptionPane.showMessageDialog(null, "Este CPF não existe. Tente novamente.");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		button.setBackground(SystemColor.inactiveCaption);
		button.setBounds(276, 697, 89, 23);
		contentPane.add(button);

		JButton button_2 = new JButton("Editar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Fornecedor fornecedor = null;
				String cnpj = String.valueOf(table_2.getModel().getValueAt(table_2.getSelectedRow(), 1));
				System.out.println(cnpj);
				for (int i = 0; i < f.listarFornecedores().length; i++) {
					if (f.listarFornecedores()[i].getCnpj().equals(cnpj))
						fornecedor = f.listarFornecedores()[i];
				}

				try {

					if (f.procurarFornecedor(cnpj) != null) {
						TelaEditarFornecedor tela = new TelaEditarFornecedor(FG, fornecedor);
						tela.setVisible(true);
						tela.setResizable(false);
						tela.setLocationRelativeTo(null);
					} else {
						JOptionPane.showMessageDialog(null, "Este CNPJ não existe. Tente novamente.");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button_2.setBackground(SystemColor.inactiveCaption);
		button_2.setBounds(641, 697, 89, 23);
		contentPane.add(button_2);

		JButton button_3 = new JButton("Remover");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cnpj = String.valueOf(table_2.getModel().getValueAt(table_2.getSelectedRow(), 1));
				System.out.println(cnpj);

				try {
					if (f.procurarFornecedor(cnpj) != null) {
						f.removerFornecedor(f.procurarFornecedor(cnpj));
					} else {
						JOptionPane.showMessageDialog(null, "Este CNPJ não existe. Tente novamente.");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button_3.setBackground(SystemColor.inactiveCaption);
		button_3.setBounds(641, 673, 89, 23);
		contentPane.add(button_3);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				TelaLogin tela = new TelaLogin();
				tela.setVisible(true);
				tela.setResizable(false);
				tela.setLocationRelativeTo(null);

			}
		});
		btnVoltar.setBackground(SystemColor.inactiveCaption);
		btnVoltar.setBounds(0, 0, 89, 23);
		contentPane.add(btnVoltar);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelFunc.getDataVector().removeAllElements();
				revalidate();
				for (int i = 0; i < f.listarFuncionarios().length; i++) {
					modelFunc.addRow(new Object[] { f.listarFuncionarios()[i].getNome(),
							f.listarFuncionarios()[i].getCpf(), f.listarFuncionarios()[i].getSeq_loja() });
				}
			}
		});
		btnAtualizar.setBackground(SystemColor.inactiveCaption);
		btnAtualizar.setBounds(276, 612, 89, 23);
		contentPane.add(btnAtualizar);

		JButton button_8 = new JButton("Atualizar");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelFornece.getDataVector().removeAllElements();
				revalidate();
				for (int i = 0; i < f.listarFornecedores().length; i++) {
					modelFornece.addRow(new Object[] { f.listarFornecedores()[i].getEmail(),
							f.listarFornecedores()[i].getCnpj(), f.listarFornecedores()[i].getFone() });
				}
			}
		});
		button_8.setBackground(SystemColor.inactiveCaption);
		button_8.setBounds(641, 611, 89, 23);
		contentPane.add(button_8);
	}
}
