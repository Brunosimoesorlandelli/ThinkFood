package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;

public class TelaFuncionario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFuncionario frame = new TelaFuncionario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(10, 45, 185, 127);
		contentPane.add(textArea);
		
		JLabel lblPedidos = new JLabel("Pedidos");
		lblPedidos.setBounds(10, 11, 46, 14);
		contentPane.add(lblPedidos);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		textArea_1.setBounds(344, 45, 185, 127);
		contentPane.add(textArea_1);
		
		JLabel lblReserva = new JLabel("Reserva");
		lblReserva.setBounds(344, 11, 46, 14);
		contentPane.add(lblReserva);
		
		JButton btnFazerReserva = new JButton("Fazer Reserva");
		btnFazerReserva.setBounds(344, 183, 103, 23);
		contentPane.add(btnFazerReserva);
	}

}
