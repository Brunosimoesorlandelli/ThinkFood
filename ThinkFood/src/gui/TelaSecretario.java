package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import beans.Funcionario_Secretario;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;

public class TelaSecretario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;

	/**
	 * Create the frame.
	 */
	public TelaSecretario(Funcionario_Secretario FS) {
		setTitle("ThinkFood");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(106, 104, 268, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblCpfFuncion = new JLabel("CPF funcionario:");
		lblCpfFuncion.setBounds(10, 107, 86, 14);
		contentPane.add(lblCpfFuncion);

		JLabel lblIdCliente = new JLabel("ID cliente:");
		lblIdCliente.setBounds(10, 167, 86, 14);
		contentPane.add(lblIdCliente);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(106, 164, 268, 20);
		contentPane.add(textField_2);

		JLabel lblDataReserva = new JLabel("Data Reserva:");
		lblDataReserva.setBounds(10, 228, 86, 14);
		contentPane.add(lblDataReserva);

		JButton btnFazerReserva = new JButton("Fazer Reserva");
		btnFazerReserva.setBounds(142, 256, 107, 23);
		contentPane.add(btnFazerReserva);

		JLabel lblDia = new JLabel("Dia:");
		lblDia.setBounds(106, 228, 31, 14);
		contentPane.add(lblDia);

		JLabel lblMs = new JLabel("M\u00EAs:");
		lblMs.setBounds(218, 228, 31, 14);
		contentPane.add(lblMs);

		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(330, 228, 31, 14);
		contentPane.add(lblAno);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
				"27", "28", "29", "30", "31" }));
		comboBox.setBounds(147, 225, 61, 20);
		contentPane.add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(
				new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
		comboBox_1.setBounds(259, 225, 61, 20);
		contentPane.add(comboBox_1);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "2030", "2029", "2028", "2027", "2026", "2025",
				"2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012",
				"2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000" }));
		comboBox_2.setBounds(371, 225, 61, 20);
		contentPane.add(comboBox_2);

		JLabel lblReserva = new JLabel("Reserva");
		lblReserva.setBounds(147, 11, 46, 14);
		contentPane.add(lblReserva);
	}
}