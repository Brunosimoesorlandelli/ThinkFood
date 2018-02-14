package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaGarcom extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public TelaGarcom() {
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
		scrollPane.setBounds(185, 142, 424, 287);
		contentPane.add(scrollPane);

		JList list = new JList();
		scrollPane.setViewportView(list);

		JLabel lblPedidos = new JLabel("Pedidos");
		lblPedidos.setBounds(374, 106, 46, 14);
		contentPane.add(lblPedidos);

		JButton btnNewButton = new JButton("Cadastrar Pedido");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.setBounds(329, 470, 136, 23);
		contentPane.add(btnNewButton);
	}
}