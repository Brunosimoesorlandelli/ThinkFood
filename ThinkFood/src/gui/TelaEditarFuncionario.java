package gui;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

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
import beans.Funcionario;
import beans.Funcionario_Entregador;
import beans.Funcionario_Garcon;
import beans.Funcionario_Gerente;
import beans.Funcionario_Secretario;

public class TelaEditarFuncionario extends JFrame {

	
	private JPanel contentPane;
	private JTextField nome;
	private JTextField CEP;
	private JTextField Complemento;
	private JTextField Salario;
	private JTextField senha;
	private JTextField numero;


	public TelaEditarFuncionario(Funcionario_Gerente FG, Funcionario func) {
		IFachada fachada = Fachada.getInstance();
		setTitle("ThinkFood");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 33, 46, 14);
		contentPane.add(lblNome);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(10, 152, 303, 14);
		contentPane.add(lblCep);

		JLabel lblPontoDeReferencia = new JLabel("Complemento");
		lblPontoDeReferencia.setBounds(10, 192, 109, 14);
		contentPane.add(lblPontoDeReferencia);

		nome = new JTextField();
		nome.setBounds(66, 30, 247, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		nome.setText(func.getNome());

		CEP = new JTextField();
		CEP.setColumns(10);
		CEP.setBounds(66, 149, 247, 20);
		contentPane.add(CEP);
		CEP.setText(func.getCEP());

		Complemento = new JTextField();
		Complemento.setColumns(10);
		Complemento.setBounds(116, 189, 197, 20);
		contentPane.add(Complemento);
		Complemento.setText(func.getCompl());

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "Entregador", "Gar\u00E7om", "Secretario", "Gerente" }));
		comboBox.setBounds(81, 103, 128, 20);
		contentPane.add(comboBox);

		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(10, 106, 46, 14);
		contentPane.add(lblCargo);

		JLabel lblNewLabel_1 = new JLabel("Salario");
		lblNewLabel_1.setBounds(10, 70, 46, 14);
		contentPane.add(lblNewLabel_1);

		Salario = new JTextField();
		Salario.setBounds(66, 67, 247, 20);
		contentPane.add(Salario);
		Salario.setColumns(10);
		Salario.setText(String.valueOf(func.getSalario()));

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(36, 290, 46, 14);
		contentPane.add(lblSenha);

		senha = new JTextField();
		senha.setBounds(118, 287, 195, 20);
		contentPane.add(senha);
		senha.setColumns(10);
		senha.setText(func.getSenha());

		JLabel lblNumeroResidencia = new JLabel("Numero Residencia");
		lblNumeroResidencia.setBounds(10, 237, 96, 14);
		contentPane.add(lblNumeroResidencia);

		numero = new JTextField();
		numero.setColumns(10);
		numero.setBounds(116, 234, 197, 20);
		contentPane.add(numero);
		numero.setText(String.valueOf(func.getNumero()));
		
		JButton btnCadastrar = new JButton("Salvar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaGerente tela = new TelaGerente(FG);
				Date data = new Date(0, 00, 0000);
				switch (comboBox.getSelectedIndex()) {
				case 0:
					Funcionario_Entregador funcEn = new Funcionario_Entregador(nome.getText(), func.getCpf(), data,
							"37902028", Double.parseDouble(Salario.getText()), func.getSeq_loja(),
							Complemento.getText(), Integer.parseInt(numero.getText()), senha.getText());
					try {
						fachada.atualizarEntregador(funcEn);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					dispose();
					tela.setVisible(true);
					tela.setLocationRelativeTo(null);
					tela.setResizable(false);
					break;
				case 1:
					Funcionario_Garcon funcGa = new Funcionario_Garcon(nome.getText(), func.getCpf(), data, "67105072",
							Double.parseDouble(Salario.getText()), 1, Complemento.getText(),
							Integer.parseInt(numero.getText()), senha.getText());
					try {
						fachada.atualizarGarcon(funcGa);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose();
					tela.setVisible(true);
					tela.setLocationRelativeTo(null);
					tela.setResizable(false);
					break;
				case 2:
					Funcionario_Secretario funcSe = new Funcionario_Secretario(nome.getText(), func.getCpf(), data,
							"64215317", Double.parseDouble(Salario.getText()), 1, Complemento.getText(),
							Integer.parseInt(numero.getText()), senha.getText());
					try {
						fachada.atualizarSecretario(funcSe);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose();
					tela.setVisible(true);
					tela.setLocationRelativeTo(null);
					tela.setResizable(false);
					break;
				case 3:
					Funcionario_Gerente funcGe = new Funcionario_Gerente(nome.getText(), func.getCpf(), data,
							"38304274", Double.parseDouble(Salario.getText()), 1, Complemento.getText(),
							Integer.parseInt(numero.getText()), senha.getText());
					try {
						fachada.atualizarGerente(funcGe);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose();
					tela.setVisible(true);
					tela.setLocationRelativeTo(null);
					tela.setResizable(false);
					break;
				}
			}
		});
		btnCadastrar.setBounds(248, 329, 96, 23);
		contentPane.add(btnCadastrar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaGerente tela = new TelaGerente(FG);
				dispose();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
				tela.setResizable(false);
			}
		});
		btnVoltar.setBounds(514, 330, 70, 20);
		contentPane.add(btnVoltar);
	}
	
}
