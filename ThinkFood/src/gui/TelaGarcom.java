package gui;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Negocio.Fachada;
import Negocio.IFachada;
import beans.Funcionario_Garcon;
import javax.swing.JTable;

public class TelaGarcom extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public TelaGarcom(Funcionario_Garcon FG) {
		IFachada f = Fachada.getInstance();
		setTitle("ThinkFood");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 36, 687, 393);
		contentPane.add(scrollPane);

		table = new JTable();
		DefaultTableModel modelGar = (DefaultTableModel) table.getModel();
		table.setModel(modelGar);
		modelGar.addColumn("Mesa");
		modelGar.addColumn("Cpf Garcom");
		for (int i = 0; i < f.listarMesa().length; i++) {
			modelGar.addRow(new Object[] { f.listarMesa()[i].getNum(), f.listarMesa()[i].getCpfGarcom() });
		}
		scrollPane.setViewportView(table);

		JLabel lblPedidos = new JLabel("Pedidos Presenciais");
		lblPedidos.setBounds(342, 11, 110, 14);
		contentPane.add(lblPedidos);

		JButton btnNewButton = new JButton("Cadastrar Pedido");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPedidoPresencial tela = new TelaPedidoPresencial(FG);
				dispose();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
				tela.setResizable(false);
			}
		});
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.setBounds(316, 481, 164, 23);
		contentPane.add(btnNewButton);

		JButton btnAtualizarTabelaPedido = new JButton("Atualizar Tabela Pedido");
		btnAtualizarTabelaPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelGar.getDataVector().removeAllElements();
				revalidate();
				for (int i = 0; i < f.listarMesa().length; i++) {
					modelGar.addRow(new Object[] { f.listarMesa()[i].getNum(), f.listarMesa()[i].getCpfGarcom() });
				}
			}
		});
		btnAtualizarTabelaPedido.setBackground(SystemColor.inactiveCaption);
		btnAtualizarTabelaPedido.setBounds(316, 447, 164, 23);
		contentPane.add(btnAtualizarTabelaPedido);

		JButton btnRemoverpedido = new JButton("Remover Pedido");
		btnRemoverpedido.setBackground(SystemColor.inactiveCaption);
		btnRemoverpedido.setBounds(316, 515, 164, 23);
		contentPane.add(btnRemoverpedido);

		JButton btnEditarPedido = new JButton("Editar Pedido");
		btnEditarPedido.setBackground(SystemColor.inactiveCaption);
		btnEditarPedido.setBounds(316, 549, 164, 23);
		contentPane.add(btnEditarPedido);
	}
}
