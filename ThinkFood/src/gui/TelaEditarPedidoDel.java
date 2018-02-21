package gui;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
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

public class TelaEditarPedidoDel extends JFrame {

	private JPanel contentPane;
	private JTextField Codigo;
	private JTextField Cep;
	private JTextField DataEn;
	private JTextField HoraSaida;

	public TelaEditarPedidoDel(Funcionario_Secretario FS, PedidoDelivery pedido) {
		IFachada f = Fachada.getInstance();
		setTitle("ThinkFood");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(109, 129, 102, 14);
		contentPane.add(lblStatus);

		
		JComboBox comboStatus = new JComboBox();
		DefaultComboBoxModel modelBox = (DefaultComboBoxModel) comboStatus.getModel();
		comboStatus.setModel(
				new DefaultComboBoxModel(new String[] { "ENTREGUE", "A_CAMINHO", "PREPARANDO", "CANCELADO" }));
		comboStatus.setBounds(320, 126, 354, 20);
		contentPane.add(comboStatus);
		comboStatus.setSelectedItem(pedido.getStatus());

		String[] pedidosEntregador = new String[f.listarEntregadores().length];
		for (int i = 0; i < f.listarEntregadores().length; i++) {
			pedidosEntregador[i] = String.valueOf(f.listarEntregadores()[i].getCpf());
		}
		
		JComboBox comboEntregador = new JComboBox();
		DefaultComboBoxModel modelEntregador = (DefaultComboBoxModel) comboEntregador.getModel();
		comboEntregador.setModel(modelEntregador);
		for (int i = 0; i < pedidosEntregador.length; i++) {
			modelEntregador.addElement(pedidosEntregador[i]);
		}
		comboEntregador.setBounds(320, 261, 354, 20);
		contentPane.add(comboEntregador);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(109, 69, 102, 14);
		contentPane.add(lblCodigo);

		Codigo = new JTextField();
		Codigo.setBounds(320, 66, 354, 20);
		contentPane.add(Codigo);
		Codigo.setColumns(10);
		Codigo.setText(String.valueOf(pedido.getNumero()));

		JLabel lblCep = new JLabel("Cep");
		lblCep.setBounds(109, 197, 102, 14);
		contentPane.add(lblCep);

		Cep = new JTextField();
		Cep.setBounds(320, 194, 354, 20);
		contentPane.add(Cep);
		Cep.setColumns(10);
		Cep.setText(String.valueOf(pedido.getCEP()));

		JLabel lblEntregador = new JLabel("Entregador");
		lblEntregador.setBounds(109, 264, 102, 14);
		contentPane.add(lblEntregador);

		JLabel lblDataEntrega = new JLabel("Data de Entrega");
		lblDataEntrega.setBounds(109, 345, 102, 14);
		contentPane.add(lblDataEntrega);

		JLabel lblHoraSaida = new JLabel("Hora Saida");
		lblHoraSaida.setBounds(109, 392, 102, 14);
		contentPane.add(lblHoraSaida);

		DataEn = new JTextField();
		DataEn.setBounds(320, 342, 354, 20);
		contentPane.add(DataEn);
		DataEn.setColumns(10);
		DataEn.setText(String.valueOf(pedido.getData()));

		HoraSaida = new JTextField();
		HoraSaida.setColumns(10);
		HoraSaida.setBounds(320, 389, 354, 20);
		contentPane.add(HoraSaida);
		HoraSaida.setText(String.valueOf(pedido.getHoraSaida()));

		JButton btnSalvar = new JButton("Salvar");
		Date dataEn = new Date(00, 00, 0317);
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PedidoDelivery p = new PedidoDelivery(pedido.getTaxa(),StatusDelivery.valueOf(String.valueOf(comboStatus.getSelectedItem())),
						Cep.getText(), Time.valueOf(HoraSaida.getText()), dataEn,
						Integer.parseInt(Codigo.getText()), pedido.getComplemento(), String.valueOf(comboEntregador.getSelectedItem()));

				try {
					f.atualizarPedidoDelivery(p);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				TelaSecretario tela = new TelaSecretario(FS);
				tela.setVisible(true);
				tela.setResizable(false);
				tela.setLocationRelativeTo(null);
			}
		});
		btnSalvar.setBackground(SystemColor.inactiveCaption);
		btnSalvar.setBounds(283, 466, 218, 23);
		contentPane.add(btnSalvar);
		
		
	}
	}


