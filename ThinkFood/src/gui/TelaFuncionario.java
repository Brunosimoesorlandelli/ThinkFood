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

public class TelaFuncionario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public TelaFuncionario(Funcionario f) {
		IFachada fachada = Fachada.getInstance();
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
		btnFazerReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaReserva tela = new TelaReserva(f);
				dispose();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
				tela.setResizable(false);
			}
		});
		btnFazerReserva.setBounds(344, 183, 103, 23);
		contentPane.add(btnFazerReserva);
	}

}
