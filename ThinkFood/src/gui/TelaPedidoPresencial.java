package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Negocio.Fachada;
import Negocio.IFachada;
import beans.Pedido;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.awt.event.ActionEvent;

public class TelaPedidoPresencial extends JFrame {

	private JPanel contentPane;
	private JTextField Mesa;
	private JTextField ItemMenu;
	private JTextField Quantidade;

	/**
	 * Create the frame.
	 */
	public TelaPedidoPresencial() {
		IFachada fachada = Fachada.getInstance();
		setTitle("ThinkFood");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNumMesa = new JLabel("Num Mesa");
		lblNumMesa.setBounds(58, 55, 69, 14);
		contentPane.add(lblNumMesa);

		Mesa = new JTextField();
		Mesa.setBounds(137, 52, 178, 20);
		contentPane.add(Mesa);
		Mesa.setColumns(10);

		JLabel lblQuantidade = new JLabel("ID Item Menu");
		lblQuantidade.setBounds(58, 105, 69, 14);
		contentPane.add(lblQuantidade);

		ItemMenu = new JTextField();
		ItemMenu.setColumns(10);
		ItemMenu.setBounds(137, 102, 178, 20);
		contentPane.add(ItemMenu);

		JLabel label = new JLabel("Quantidade");
		label.setBounds(58, 153, 69, 14);
		contentPane.add(label);

		Quantidade = new JTextField();
		Quantidade.setColumns(10);
		Quantidade.setBounds(137, 150, 178, 20);
		contentPane.add(Quantidade);

		JButton btnCadastrarPedido = new JButton("Cadastrar Pedido");
		btnCadastrarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Time tempo = java.sql.Time.valueOf(java.time.LocalTime.now());
				Date data = java.sql.Date.valueOf(java.time.LocalDate.now());
				Pedido p = new Pedido(Integer.parseInt(ItemMenu.getText()), tempo, data, 0);
				try {
					fachada.cadastrarPedido(p);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCadastrarPedido.setBackground(SystemColor.inactiveCaption);
		btnCadastrarPedido.setBounds(139, 211, 115, 23);
		contentPane.add(btnCadastrarPedido);
	}

}
