package gui;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class TelaUnidadeLoja extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JLabel lblUnidadeLoja;
	private JLabel lblClientes;
	private JTable table_2;

	public TelaUnidadeLoja(Funcionario_Gerente FG) {
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
		scrollPane.setBounds(54, 49, 675, 149);
		contentPane.add(scrollPane);

		table = new JTable();
		DefaultTableModel modelUnit = (DefaultTableModel) table.getModel();
		table.setModel(modelUnit);
		modelUnit.addColumn("Seq");
		modelUnit.addColumn("Quantidade de Funcionarios");
		modelUnit.addColumn("Telefone");
		for (int i = 0; i < f.listarLojas().length; i++) {
			modelUnit.addRow(new Object[] { f.listarLojas()[i].getSeq(), f.listarLojas()[i].getQtdFunc(),
					f.listarLojas()[i].getTelefone() });
		}
		scrollPane.setViewportView(table);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(64, 271, 295, 149);
		contentPane.add(scrollPane_1);

		table_1 = new JTable();
		DefaultTableModel modelClientePF = (DefaultTableModel) table_1.getModel();
		table_1.setModel(modelClientePF);
		modelClientePF.addColumn("Id");
		modelClientePF.addColumn("Nome");
		for (int i = 0; i < f.listarClientePF().length; i++) {
			modelClientePF.addRow(new Object[] { f.listarClientePF()[i].getId(), f.listarClientePF()[i].getNome() });
		}
		scrollPane_1.setViewportView(table_1);

		lblUnidadeLoja = new JLabel("Unidade Loja");
		lblUnidadeLoja.setBounds(351, 24, 80, 14);
		contentPane.add(lblUnidadeLoja);

		lblClientes = new JLabel("Clientes Fisicos");
		lblClientes.setBounds(171, 246, 80, 14);
		contentPane.add(lblClientes);

		JButton btnAtualizarClientes = new JButton("Atualizar Clientes");
		btnAtualizarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelClientePF.getDataVector().removeAllElements();
				revalidate();
				for (int i = 0; i < f.listarClientePF().length; i++) {
					modelClientePF.addRow(new Object[] { f.listarClientePF()[i].getId(), f.listarClientePF()[i].getNome() });
				}
			}
			
		});
		btnAtualizarClientes.setBackground(SystemColor.inactiveCaption);
		btnAtualizarClientes.setBounds(149, 431, 124, 23);
		contentPane.add(btnAtualizarClientes);

		JButton btnCadastrarClientes = new JButton("Cadastrar Cliente");
		btnCadastrarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroClientePF tela = new TelaCadastroClientePF(FG);
				dispose();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
				tela.setResizable(false);
			}
		});
		btnCadastrarClientes.setBackground(SystemColor.inactiveCaption);
		btnCadastrarClientes.setBounds(149, 465, 124, 23);
		contentPane.add(btnCadastrarClientes);

		JButton btnRemoverCliente = new JButton("Remover Cliente");
		btnRemoverCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(String.valueOf(table_1.getModel().getValueAt(table_1.getSelectedRow(), 0)));
				System.out.println(id);

				try {
					if (f.procurarClientePF(id) != null) {
						f.removerClientePF(f.procurarClientePF(id));
					} else {
						JOptionPane.showMessageDialog(null, "Este cliente não existe. Tente novamente.");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnRemoverCliente.setBackground(SystemColor.inactiveCaption);
		btnRemoverCliente.setBounds(149, 499, 124, 23);
		contentPane.add(btnRemoverCliente);

		JButton btnEditarCliente = new JButton("Editar Cliente");
		btnEditarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEditarClientePF tela;
				try {
					tela = new TelaEditarClientePF(FG, f.procurarClientePF(Integer.parseInt(String.valueOf(table_1.getModel().getValueAt(table_1.getSelectedRow(), 0)))));
					dispose();
					tela.setVisible(true);
					tela.setLocationRelativeTo(null);
					tela.setResizable(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnEditarCliente.setBackground(SystemColor.inactiveCaption);
		btnEditarCliente.setBounds(149, 528, 124, 23);
		contentPane.add(btnEditarCliente);

		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBackground(SystemColor.inactiveCaption);
		btnFiltrar.setBounds(347, 209, 89, 23);
		contentPane.add(btnFiltrar);

		JButton btnVoltar = new JButton("Voltar");
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
		btnVoltar.setBounds(10, 11, 89, 23);
		contentPane.add(btnVoltar);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(423, 271, 295, 149);
		contentPane.add(scrollPane_2);

		table_2 = new JTable();
		DefaultTableModel modelClientePJ = (DefaultTableModel) table_2.getModel();
		table_2.setModel(modelClientePJ);
		modelClientePJ.addColumn("Id");
		modelClientePJ.addColumn("Nome Fantasia");
		modelClientePJ.addColumn("Razao Social");
		for (int i = 0; i < f.listarClientePJ().length; i++) {
			modelClientePJ.addRow(new Object[] { f.listarClientePJ()[i].getId(),
					f.listarClientePJ()[i].getNomeFantasia(), f.listarClientePJ()[i].getRazaoSocial() });
		}
		scrollPane_2.setViewportView(table_2);

		JLabel lblClientesJuridicos = new JLabel("Clientes Juridicos");
		lblClientesJuridicos.setBounds(523, 246, 95, 14);
		contentPane.add(lblClientesJuridicos);

		JButton button = new JButton("Atualizar Clientes");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelClientePJ.getDataVector().removeAllElements();
				revalidate();
				for (int i = 0; i < f.listarClientePJ().length; i++) {
					modelClientePJ.addRow(new Object[] { f.listarClientePJ()[i].getId(),
							f.listarClientePJ()[i].getNomeFantasia(), f.listarClientePJ()[i].getRazaoSocial() });
				}
			}
			
		});
		button.setBackground(SystemColor.inactiveCaption);
		button.setBounds(508, 431, 124, 23);
		contentPane.add(button);

		JButton button_1 = new JButton("Cadastrar Cliente");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroClientePJ tela = new TelaCadastroClientePJ(FG);
				dispose();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
				tela.setResizable(false);
			}
		});
		button_1.setBackground(SystemColor.inactiveCaption);
		button_1.setBounds(508, 465, 124, 23);
		contentPane.add(button_1);

		JButton button_2 = new JButton("Remover Cliente");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(String.valueOf(table_2.getModel().getValueAt(table_2.getSelectedRow(), 0)));
				System.out.println(id);

				try {
					if (f.procurarClientePJ(id) != null) {
						f.removerClientePJ(f.procurarClientePJ(id));
					} else {
						JOptionPane.showMessageDialog(null, "Este cliente não existe. Tente novamente.");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button_2.setBackground(SystemColor.inactiveCaption);
		button_2.setBounds(508, 499, 124, 23);
		contentPane.add(button_2);

		JButton button_3 = new JButton("Editar Cliente");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEditarClientePJ tela;
				try {
					tela = new TelaEditarClientePJ(FG, f.procurarClientePJ(Integer.parseInt(String.valueOf(table_2.getModel().getValueAt(table_2.getSelectedRow(), 0)))));
					dispose();
					tela.setVisible(true);
					tela.setLocationRelativeTo(null);
					tela.setResizable(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		button_3.setBackground(SystemColor.inactiveCaption);
		button_3.setBounds(508, 528, 124, 23);
		contentPane.add(button_3);

	}
}
