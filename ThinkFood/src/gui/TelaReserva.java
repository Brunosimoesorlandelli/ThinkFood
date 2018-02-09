package gui;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Time;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Negocio.Fachada;
import Negocio.IFachada;
import beans.Funcionario;
import beans.Reserva;
import beans.StatusReserva;

public class TelaReserva extends JFrame {

	private JPanel contentPane;
	private JTextField seq;
	private JTextField numPessoas;
	private JTextField preco;
	private JTextField nome;
	private JTextField detalhes;
	private JTextField horaInicio;
	private JLabel lblDataIncio;
	private JTextField horaFim;
	private JLabel lblHoraFim;
	private JLabel lblStatus;
	private JButton cadastrarReservaButton;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public TelaReserva(Funcionario func) {
		IFachada f = Fachada.getInstance();
		setBackground(SystemColor.inactiveCaption);
		setTitle("ThinkFood");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		seq = new JTextField();
		seq.setBounds(79, 40, 209, 20);
		contentPane.add(seq);
		seq.setColumns(10);
		
		JLabel lblCdigo = new JLabel("Seq:");
		lblCdigo.setBounds(31, 43, 46, 14);
		contentPane.add(lblCdigo);
		
		JLabel lblDescrio = new JLabel("Numero de Pessoas:");
		lblDescrio.setBounds(10, 139, 106, 14);
		contentPane.add(lblDescrio);
		
		numPessoas = new JTextField();
		numPessoas.setColumns(10);
		numPessoas.setBounds(126, 136, 86, 20);
		contentPane.add(numPessoas);
		
		horaInicio = new JTextField();
		horaInicio.setColumns(10);
		horaInicio.setBounds(79, 84, 209, 20);
		contentPane.add(horaInicio);
		
		lblDataIncio = new JLabel("Hora In\u00EDcio:");
		lblDataIncio.setBounds(10, 87, 67, 14);
		contentPane.add(lblDataIncio);
		
		horaFim = new JTextField();
		horaFim.setColumns(10);
		horaFim.setBounds(365, 84, 209, 20);
		contentPane.add(horaFim);
		
		lblHoraFim = new JLabel("Hora Fim:");
		lblHoraFim.setBounds(317, 87, 46, 14);
		contentPane.add(lblHoraFim);
		
		lblStatus = new JLabel("Status:");
		lblStatus.setBounds(317, 139, 46, 14);
		contentPane.add(lblStatus);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(365, 136, 126, 20);
		contentPane.add(comboBox);
		StatusReserva status = null;
		comboBox.addItem(status.LIVRE);
		comboBox.addItem(status.OCUPADO);
		comboBox.addItem(status.RESERVA_EXPIRADA);
		comboBox.addItem(status.RESERVADO);
		
		cadastrarReservaButton = new JButton("Cadastrar Reserva");
		cadastrarReservaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			switch (comboBox.getSelectedIndex()) {
			case 0:
				try {
					f.cadastrarReserva(new Reserva(Integer.parseInt(seq.getText()), Time.valueOf(horaInicio.getText()), Time.valueOf(horaFim.getText()), StatusReserva.LIVRE, Integer.parseInt(numPessoas.getText())));
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				break;

			case 1:
				try {
					f.cadastrarReserva(new Reserva(Integer.parseInt(seq.getText()), Time.valueOf(horaInicio.getText()), Time.valueOf(horaFim.getText()), StatusReserva.OCUPADO, Integer.parseInt(numPessoas.getText())));
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				break;
				
			case 2:
				try {
					f.cadastrarReserva(new Reserva(Integer.parseInt(seq.getText()), Time.valueOf(horaInicio.getText()), Time.valueOf(horaFim.getText()), StatusReserva.RESERVA_EXPIRADA, Integer.parseInt(numPessoas.getText())));
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				break;
				
			case 3:
				try {
					f.cadastrarReserva(new Reserva(Integer.parseInt(seq.getText()), Time.valueOf(horaInicio.getText()), Time.valueOf(horaFim.getText()), StatusReserva.RESERVADO, Integer.parseInt(numPessoas.getText())));
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				break;
			default:
				break;
			}
			
			TelaFuncionario tela = new TelaFuncionario(func);
			dispose();
			tela.setVisible(true);
			tela.setLocationRelativeTo(null);
			tela.setResizable(false);
			
			}
		});
		cadastrarReservaButton.setBounds(240, 233, 156, 33);
		contentPane.add(cadastrarReservaButton);
	}
}
