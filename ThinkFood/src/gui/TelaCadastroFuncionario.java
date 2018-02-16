package gui;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
import beans.Funcionario_Entregador;
import beans.Funcionario_Garcon;
import beans.Funcionario_Gerente;
import beans.Funcionario_Secretario;

public class TelaCadastroFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JTextField CPF;
	private JTextField Dt_Nasc;
	private JTextField CEP;
	private JTextField Complemento;
	private JTextField Salario;
	private JTextField seq_loja;
	private JTextField senha;
	private JTextField numero;

	/**
	 * Create the frame.
	 */
	public TelaCadastroFuncionario(Funcionario_Gerente FG) {
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

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 122, 46, 14);
		contentPane.add(lblCpf);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(10, 170, 96, 14);
		contentPane.add(lblDataDeNascimento);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(323, 122, 46, 14);
		contentPane.add(lblCep);

		JLabel lblPontoDeReferencia = new JLabel("Complemento");
		lblPontoDeReferencia.setBounds(10, 223, 109, 14);
		contentPane.add(lblPontoDeReferencia);

		nome = new JTextField();
		nome.setBounds(66, 30, 247, 20);
		contentPane.add(nome);
		nome.setColumns(10);

		CPF = new JTextField();
		CPF.setColumns(10);
		CPF.setBounds(66, 119, 247, 20);
		contentPane.add(CPF);

		Dt_Nasc = new JTextField();
		Dt_Nasc.setColumns(10);
		Dt_Nasc.setBounds(116, 167, 197, 20);
		contentPane.add(Dt_Nasc);

		CEP = new JTextField();
		CEP.setColumns(10);
		CEP.setBounds(379, 119, 195, 20);
		contentPane.add(CEP);

		Complemento = new JTextField();
		Complemento.setColumns(10);
		Complemento.setBounds(116, 220, 197, 20);
		contentPane.add(Complemento);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "Entregador", "Gar\u00E7om", "Secretario", "Gerente" }));
		comboBox.setBounds(379, 67, 128, 20);
		contentPane.add(comboBox);

		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(323, 70, 46, 14);
		contentPane.add(lblCargo);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaGerente tela = new TelaGerente(FG);
				Date data = new Date(1988, 03, 16);
				switch (comboBox.getSelectedIndex()) {
				case 0:
					Funcionario_Entregador funcEn = new Funcionario_Entregador(nome.getText(), CPF.getText(), data,
							"37902028", Double.parseDouble(Salario.getText()), 1,
							Complemento.getText(), Integer.parseInt(numero.getText()), senha.getText());
					try {
						fachada.cadastrarEntregador(funcEn);
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
					Funcionario_Garcon funcGa = new Funcionario_Garcon(nome.getText(), CPF.getText(), data, "67105072",
							Double.parseDouble(Salario.getText()), 1,
							Complemento.getText(), Integer.parseInt(numero.getText()), senha.getText());
					try {
						fachada.cadastrarGarcon(funcGa);
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
					Funcionario_Secretario funcSe = new Funcionario_Secretario(nome.getText(), CPF.getText(), data,
							"64215317", Double.parseDouble(Salario.getText()), 1,
							Complemento.getText(), Integer.parseInt(numero.getText()), senha.getText());
					try {
						fachada.cadastrarSecretario(funcSe);
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
					Funcionario_Gerente funcGe = new Funcionario_Gerente(nome.getText(), CPF.getText(), data,
							"38304274", Double.parseDouble(Salario.getText()), 1,
							Complemento.getText(), Integer.parseInt(numero.getText()), senha.getText());
					try {
						fachada.cadastrarGerente(funcGe);
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
		btnCadastrar.setBounds(247, 327, 89, 23);
		contentPane.add(btnCadastrar);

		JLabel lblNewLabel_1 = new JLabel("Salario");
		lblNewLabel_1.setBounds(10, 70, 46, 14);
		contentPane.add(lblNewLabel_1);

		Salario = new JTextField();
		Salario.setBounds(66, 67, 247, 20);
		contentPane.add(Salario);
		Salario.setColumns(10);

		JLabel lblSeqloja = new JLabel("Seq_Loja");
		lblSeqloja.setBounds(323, 170, 46, 14);
		contentPane.add(lblSeqloja);

		seq_loja = new JTextField();
		seq_loja.setBounds(379, 167, 195, 20);
		contentPane.add(seq_loja);
		seq_loja.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(323, 223, 46, 14);
		contentPane.add(lblSenha);

		senha = new JTextField();
		senha.setBounds(379, 220, 195, 20);
		contentPane.add(senha);
		senha.setColumns(10);

		JLabel lblNumeroResidencia = new JLabel("Numero Residencia");
		lblNumeroResidencia.setBounds(10, 266, 96, 14);
		contentPane.add(lblNumeroResidencia);

		numero = new JTextField();
		numero.setColumns(10);
		numero.setBounds(116, 263, 197, 20);
		contentPane.add(numero);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(514, 330, 70, 20);
		contentPane.add(btnVoltar);
	}
}
