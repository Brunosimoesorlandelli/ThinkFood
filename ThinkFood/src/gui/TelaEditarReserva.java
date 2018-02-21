package gui;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
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
import beans.Funcionario_Secretario;
import beans.ReservaOficial;
import beans.StatusReserva;

public class TelaEditarReserva extends JFrame{
	private JPanel contentPane;
	private JTextField CPFFunc;
	private JTextField IdCliente;
	private JTextField HoraInicio;
	private JTextField HoraFim;
	private JTextField NumPessoas;
	private JTextField dataReservaField;


	public TelaEditarReserva(Funcionario_Secretario FS, ReservaOficial r) {
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
		CPFFunc.setText(r.getCpfFuncionario());
		CPFFunc.setBounds(290, 172, 268, 20);
		contentPane.add(CPFFunc);
		CPFFunc.setColumns(10);
		CPFFunc.setEnabled(false);

		JLabel lblCpfFuncion = new JLabel("CPF funcionario:");
		lblCpfFuncion.setBounds(194, 175, 86, 14);
		contentPane.add(lblCpfFuncion);

		JLabel lblIdCliente = new JLabel("ID cliente:");
		lblIdCliente.setBounds(194, 199, 86, 14);
		contentPane.add(lblIdCliente);

		IdCliente = new JTextField();
		IdCliente.setColumns(10);
		IdCliente.setBounds(290, 196, 268, 20);
		IdCliente.setText(String.valueOf(r.getIdCliente()));
		contentPane.add(IdCliente);

		JLabel lblDataReserva = new JLabel("Data Reserva:");
		lblDataReserva.setBounds(194, 328, 86, 14);
		contentPane.add(lblDataReserva);


		JComboBox status = new JComboBox();
		status.setBackground(SystemColor.inactiveCaption);
		status.setModel(new DefaultComboBoxModel(new String[] { "LIVRE", "OCUPADO", "RESERVADO", "RESERVA_EXPIRADA" }));
		status.setBounds(290, 297, 268, 20);
		status.setSelectedItem(r.getStatus());
		contentPane.add(status);

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
		HoraInicio.setText(String.valueOf(r.getHora_inicio()));
		contentPane.add(HoraInicio);

		HoraFim = new JTextField();
		HoraFim.setColumns(10);
		HoraFim.setBounds(290, 246, 268, 20);
		HoraFim.setText(String.valueOf(r.getHora_fim()));
		contentPane.add(HoraFim);

		JLabel lblNumPesooas = new JLabel("Num Pessoas:");
		lblNumPesooas.setBounds(194, 274, 86, 14);
		contentPane.add(lblNumPesooas);

		NumPessoas = new JTextField();
		NumPessoas.setColumns(10);
		NumPessoas.setBounds(290, 271, 268, 20);
		NumPessoas.setText(String.valueOf(r.getNum_pessoas()));
		contentPane.add(NumPessoas);

		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(194, 300, 86, 14);
		contentPane.add(lblStatus);
		

		dataReservaField = new JTextField();
		dataReservaField.setBounds(290, 325, 268, 20);
		dataReservaField.setColumns(10);
		dataReservaField.setText(String.valueOf(r.getDataReserva()));
		contentPane.add(dataReservaField);
		
		
		JButton btnFazerReserva = new JButton("Salvar");
		btnFazerReserva.setBackground(SystemColor.inactiveCaption);
		btnFazerReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ReservaOficial reserva = new ReservaOficial(fachada.listarReservaOficial().length, r.getHora_inicio(), r.getHora_fim(),
						StatusReserva.valueOf(String.valueOf(status.getSelectedItem())),
						Integer.parseInt(NumPessoas.getText()), CPFFunc.getText(), Integer.parseInt(IdCliente.getText()),
						r.getDataReserva(), r.getDataValidade());
				try {
					fachada.atualizarReservaOficial(reserva);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				TelaSecretario tela = new TelaSecretario(FS);
				dispose();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
				tela.setResizable(false);
			}
		});

		btnFazerReserva.setBounds(326, 376, 107, 23);
		contentPane.add(btnFazerReserva);
		
	}
	}


