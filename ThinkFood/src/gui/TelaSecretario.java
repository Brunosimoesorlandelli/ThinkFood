package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Negocio.Fachada;
import Negocio.IFachada;
import beans.Funcionario;
import beans.Funcionario_Secretario;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTable;

public class TelaSecretario extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TelaSecretario(Funcionario_Secretario FS) {
		setTitle("ThinkFood");
		IFachada f = Fachada.getInstance();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPedidos = new JLabel("Pedidos Delivery");
		lblPedidos.setBounds(213, 43, 97, 14);
		contentPane.add(lblPedidos);

		JLabel lblReserva = new JLabel("Reserva");
		lblReserva.setBounds(523, 43, 46, 14);
		contentPane.add(lblReserva);

		JButton btnFazerReserva = new JButton("Cadastrar Reserva");
		btnFazerReserva.setBackground(SystemColor.inactiveCaption);
		btnFazerReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaReserva tela = new TelaReserva(FS);
				dispose();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
				tela.setResizable(false);
			}
		});
		btnFazerReserva.setBounds(461, 463, 185, 23);
		contentPane.add(btnFazerReserva);

		JButton btnCadastrarPedido = new JButton("Cadastrar Pedido");
		btnCadastrarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPedidoDel tela = new TelaPedidoDel(FS);
				dispose();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
				tela.setResizable(false);
			}
		});
		btnCadastrarPedido.setBackground(SystemColor.inactiveCaption);
		btnCadastrarPedido.setBounds(138, 463, 185, 23);
		contentPane.add(btnCadastrarPedido);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(54, 68, 310, 351);
		contentPane.add(scrollPane_1);

		table = new JTable();
		DefaultTableModel modelSec = (DefaultTableModel) table.getModel();
		table.setModel(modelSec);
		modelSec.addColumn("Id");
		modelSec.addColumn("Cpf_Entregador");
		modelSec.addColumn("Cep_Cliente");
		for (int i = 0; i < f.listarPedidoDelivery().length; i++) {
			try {
				modelSec.addRow(new Object[] { f.listarPedidoDelivery()[i].getNumero(), f.listarPedidoDelivery()[i].getCpfEntregador(),
						f.listarPedidoDelivery()[i].getCEP()});
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		scrollPane_1.setViewportView(table);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(418, 68, 310, 351);
		contentPane.add(scrollPane);

		table_1 = new JTable();
		scrollPane.setViewportView(table_1);

		JButton btnRemoverPedido = new JButton("Remover Pedido");
		btnRemoverPedido.setBackground(SystemColor.inactiveCaption);
		btnRemoverPedido.setBounds(138, 497, 185, 23);
		contentPane.add(btnRemoverPedido);

		JButton btnEditarPedido = new JButton("Editar Pedido");
		btnEditarPedido.setBackground(SystemColor.inactiveCaption);
		btnEditarPedido.setBounds(138, 528, 185, 23);
		contentPane.add(btnEditarPedido);

		JButton btnAtualizarTabela = new JButton("Atualizar Tabela Pedidos");
		btnAtualizarTabela.setBackground(SystemColor.inactiveCaption);
		btnAtualizarTabela.setBounds(138, 430, 185, 23);
		contentPane.add(btnAtualizarTabela);

		JButton btnRemoverReserva = new JButton("Remover Reserva");
		btnRemoverReserva.setBackground(SystemColor.inactiveCaption);
		btnRemoverReserva.setBounds(461, 497, 185, 23);
		contentPane.add(btnRemoverReserva);

		JButton btnEditarReserva = new JButton("Editar Reserva");
		btnEditarReserva.setBackground(SystemColor.inactiveCaption);
		btnEditarReserva.setBounds(461, 528, 185, 23);
		contentPane.add(btnEditarReserva);

		JButton btnAtualizarTabelaReserva = new JButton("Atualizar Tabela Reserva");
		btnAtualizarTabelaReserva.setBackground(SystemColor.inactiveCaption);
		btnAtualizarTabelaReserva.setBounds(461, 430, 185, 23);
		contentPane.add(btnAtualizarTabelaReserva);
	}
}
