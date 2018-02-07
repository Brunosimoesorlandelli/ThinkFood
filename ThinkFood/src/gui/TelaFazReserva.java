package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class TelaFazReserva extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFazReserva frame = new TelaFazReserva();
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
	public TelaFazReserva() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(108, 11, 107, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCpfFuncion = new JLabel("CPF funcionario:");
		lblCpfFuncion.setBounds(12, 14, 86, 14);
		contentPane.add(lblCpfFuncion);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(12, 62, 86, 14);
		contentPane.add(lblNumero);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(108, 59, 107, 20);
		contentPane.add(textField_1);
		
		JLabel lblIdCliente = new JLabel("ID cliente:");
		lblIdCliente.setBounds(12, 108, 86, 14);
		contentPane.add(lblIdCliente);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(108, 105, 107, 20);
		contentPane.add(textField_2);
		
		JLabel lblDataReserva = new JLabel("Data Reserva:");
		lblDataReserva.setBounds(12, 156, 86, 14);
		contentPane.add(lblDataReserva);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(108, 153, 107, 20);
		contentPane.add(textField_3);
		
		JButton btnFazerReserva = new JButton("Fazer Reserva");
		btnFazerReserva.setBounds(184, 211, 107, 23);
		contentPane.add(btnFazerReserva);
	}

}
