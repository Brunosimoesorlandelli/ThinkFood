package gui;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

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
import beans.PedidoDelivery;
import beans.StatusDelivery;

public class TelaPedidoDel extends JFrame {

	private JPanel contentPane;
	private JTextField cep;
	private JTextField dtSaida;
	private JTextField hrSaida;
	private JTextField Complemento;

	/**
	 * Create the frame.
	 */
	public TelaPedidoDel(Funcionario_Secretario FS) {
		IFachada f = Fachada.getInstance();
		setTitle("ThinkFood");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(94, 29, 46, 14);
		contentPane.add(lblCep);

		cep = new JTextField();
		cep.setBounds(160, 26, 361, 20);
		contentPane.add(cep);
		cep.setColumns(10);

		JLabel lblDataSaida = new JLabel("Data Saida");
		lblDataSaida.setBounds(94, 70, 64, 14);
		contentPane.add(lblDataSaida);

		JLabel lblHoraSaida = new JLabel("Hora Saida");
		lblHoraSaida.setBounds(94, 112, 64, 14);
		contentPane.add(lblHoraSaida);

		dtSaida = new JTextField();
		dtSaida.setColumns(10);
		dtSaida.setBounds(160, 67, 361, 20);
		contentPane.add(dtSaida);

		hrSaida = new JTextField();
		hrSaida.setColumns(10);
		hrSaida.setBounds(160, 109, 361, 20);
		contentPane.add(hrSaida);

		JLabel lblCpfEntregador = new JLabel("Cpf Entregador");
		lblCpfEntregador.setBounds(94, 155, 86, 14);
		contentPane.add(lblCpfEntregador);

		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(94, 236, 72, 14);
		contentPane.add(lblComplemento);

		Complemento = new JTextField();
		Complemento.setBounds(190, 236, 331, 67);
		contentPane.add(Complemento);
		Complemento.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "ENTREGUE", "A_CAMINHO", "PREPARANDO", "CANCELADO" }));
		comboBox.setBounds(190, 192, 331, 20);
		contentPane.add(comboBox);

		String[] entregadoresCombo = new String[f.listarEntregadores().length];
		for (int i = 0; i < entregadoresCombo.length; i++) {
			entregadoresCombo[i] = f.listarEntregadores()[i].getCpf();
		}
		JComboBox comboBox_1 = new JComboBox();
		DefaultComboBoxModel modelBox = (DefaultComboBoxModel) comboBox_1.getModel();
		comboBox_1.setModel(modelBox);
		for (int i = 0; i < f.listarEntregadores().length; i++) {
			try {
				modelBox.addElement(entregadoresCombo[i]);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		comboBox_1.setBounds(189, 152, 332, 20);
		contentPane.add(comboBox_1);

		List<Integer> codigos = new ArrayList<Integer>();
		for (int i = 0; i < f.listarPedidoDelivery().length; i++) {
			codigos.add(f.listarPedidoDelivery()[i].getNumero());
		}

		Date dataSaida = new Date(03, 00, 0317);
		Time horaSaida = new Time(10, 20, 11);

		JButton btnCadastrarPedido = new JButton("Cadastrar Pedido");
		btnCadastrarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PedidoDelivery p = new PedidoDelivery(20,
						StatusDelivery.valueOf(String.valueOf(comboBox.getSelectedItem())), cep.getText(), horaSaida,
						dataSaida, codigos.get(codigos.size() - 1) + 1, Complemento.getText(),
						String.valueOf(comboBox_1.getSelectedItem()));

				try {
					f.cadastrarPedidoDel(p);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				TelaSecretario tela = new TelaSecretario(FS);
				dispose();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
				tela.setResizable(false);
			}
		});
		btnCadastrarPedido.setBackground(SystemColor.inactiveCaption);
		btnCadastrarPedido.setBounds(239, 338, 115, 23);
		contentPane.add(btnCadastrarPedido);

		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(94, 195, 86, 14);
		contentPane.add(lblStatus);

	}
}
