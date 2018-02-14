package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Negocio.Fachada;
import Negocio.IFachada;
import beans.Funcionario;
import beans.Funcionario_Secretario;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class TelaSecretario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TelaSecretario(Funcionario_Secretario FS) {
		setTitle("ThinkFood");
		IFachada fachada = Fachada.getInstance();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 359);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPedidos = new JLabel("Pedidos");
		lblPedidos.setBounds(10, 43, 46, 14);
		contentPane.add(lblPedidos);

		JLabel lblReserva = new JLabel("Reserva");
		lblReserva.setBounds(344, 43, 46, 14);
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
		btnFazerReserva.setBounds(344, 215, 185, 23);
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
		btnCadastrarPedido.setBounds(10, 215, 185, 23);
		contentPane.add(btnCadastrarPedido);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(344, 68, 185, 132);
		contentPane.add(scrollPane);

		JList list_1 = new JList();
		scrollPane.setViewportView(list_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 68, 185, 132);
		contentPane.add(scrollPane_1);

		JList list = new JList();
		scrollPane_1.setViewportView(list);
	}
}
