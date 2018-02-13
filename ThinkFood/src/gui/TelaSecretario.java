package gui;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Negocio.Fachada;
import Negocio.IFachada;
import beans.FazReserva;
import beans.Funcionario_Secretario;
import beans.Reserva;

public class TelaSecretario extends JFrame {

	private JPanel contentPane;
	private JTextField CPFFunc;
	private JTextField IdCliente;
	private JTextField HoraInicio;
	private JTextField HoraFim;
	private JTextField NumPessoas;

	/**
	 * Create the frame.
	 */
	public TelaSecretario(Funcionario_Secretario FS) {
		setResizable(false);
		IFachada fachada = Fachada.getInstance();
		setTitle("ThinkFood");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		CPFFunc = new JTextField();
		CPFFunc.setBounds(290, 172, 268, 20);
		contentPane.add(CPFFunc);
		CPFFunc.setColumns(10);

		JLabel lblCpfFuncion = new JLabel("CPF funcionario:");
		lblCpfFuncion.setBounds(194, 175, 86, 14);
		contentPane.add(lblCpfFuncion);

		JLabel lblIdCliente = new JLabel("ID cliente:");
		lblIdCliente.setBounds(194, 199, 86, 14);
		contentPane.add(lblIdCliente);

		IdCliente = new JTextField();
		IdCliente.setColumns(10);
		IdCliente.setBounds(290, 196, 268, 20);
		contentPane.add(IdCliente);

		JLabel lblDataReserva = new JLabel("Data Reserva:");
		lblDataReserva.setBounds(194, 328, 86, 14);
		contentPane.add(lblDataReserva);

		JComboBox Dia = new JComboBox();
		Dia.setModel(new DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
				"28", "29", "30", "31" }));
		Dia.setBounds(331, 325, 61, 20);
		contentPane.add(Dia);

		JComboBox Mes = new JComboBox();
		Mes.setModel(new DefaultComboBoxModel(
				new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
		Mes.setBounds(443, 325, 61, 20);
		contentPane.add(Mes);

		JComboBox Ano = new JComboBox();
		Ano.setModel(new DefaultComboBoxModel(new String[] { "2030", "2029", "2028", "2027", "2026", "2025", "2024",
				"2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011",
				"2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000" }));
		Ano.setBounds(555, 325, 61, 20);
		contentPane.add(Ano);

		JComboBox status = new JComboBox();
		status.setModel(new DefaultComboBoxModel(new String[] { "LIVRE", "OCUPADO", "RESERVADO", "RESERVA_EXPIRADA" }));
		status.setBounds(290, 297, 268, 20);
		contentPane.add(status);

		JButton btnFazerReserva = new JButton("Fazer Reserva");
		btnFazerReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Reserva r = new Reserva(0, Time.valueOf(HoraInicio.getText()),
				// Time.valueOf(HoraFim.getText()), ,
				// Integer.parseInt(NumPessoas.getText()));
				// FazReserva fr = new FazReserva(cpfFunc, 0, idCliente, dtReserva, dtVal);
				// fachada.cadastrarReserva(r);
				// fachada.cadastrarFazReserva(fr);
			}
		});
		btnFazerReserva.setBounds(326, 356, 107, 23);
		contentPane.add(btnFazerReserva);

		JLabel lblDia = new JLabel("Dia:");
		lblDia.setBounds(290, 328, 31, 14);
		contentPane.add(lblDia);

		JLabel lblMs = new JLabel("M\u00EAs:");
		lblMs.setBounds(402, 328, 31, 14);
		contentPane.add(lblMs);

		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(514, 328, 31, 14);
		contentPane.add(lblAno);

		JLabel lblReserva = new JLabel("Reserva");
		lblReserva.setBounds(326, 118, 46, 14);
		contentPane.add(lblReserva);

		JLabel lblHoraInicio = new JLabel("Hora Inicio:");
		lblHoraInicio.setBounds(194, 224, 86, 14);
		contentPane.add(lblHoraInicio);

		JLabel lblHoraFim = new JLabel("Hora Fim:");
		lblHoraFim.setBounds(194, 249, 86, 14);
		contentPane.add(lblHoraFim);

		HoraInicio = new JTextField();
		HoraInicio.setColumns(10);
		HoraInicio.setBounds(290, 221, 268, 20);
		contentPane.add(HoraInicio);

		HoraFim = new JTextField();
		HoraFim.setColumns(10);
		HoraFim.setBounds(290, 246, 268, 20);
		contentPane.add(HoraFim);

		JLabel lblNumPesooas = new JLabel("Num Pessoas:");
		lblNumPesooas.setBounds(194, 274, 86, 14);
		contentPane.add(lblNumPesooas);

		NumPessoas = new JTextField();
		NumPessoas.setColumns(10);
		NumPessoas.setBounds(290, 271, 268, 20);
		contentPane.add(NumPessoas);

		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(194, 300, 86, 14);
		contentPane.add(lblStatus);
	}
}
