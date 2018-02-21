package gui;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

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
import beans.Funcionario_Gerente;
import beans.ItemEstoque;

public class TelaEditarItemEstoque extends JFrame {

	private JPanel contentPane;
	private JTextField idEstoque;
	private JTextField lote;
	private JTextField DataEn;
	private JTextField DataVal;
	private JTextField quant;

	public TelaEditarItemEstoque(Funcionario_Gerente FG, ItemEstoque item) {
		IFachada f = Fachada.getInstance();
		setTitle("ThinkFood");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCdigoDoProduto = new JLabel("C\u00F3digo do Produto");
		lblCdigoDoProduto.setBounds(109, 101, 102, 14);
		contentPane.add(lblCdigoDoProduto);

		JComboBox comboBox = new JComboBox();
		DefaultComboBoxModel modelBox = (DefaultComboBoxModel) comboBox.getModel();
		comboBox.setModel(modelBox);
		for (int i = 0; i < f.listarItemEstoque().length; i++) {
			modelBox.addElement(f.listarItemEstoque()[i].getSeq());
		}
		comboBox.setBounds(320, 98, 354, 20);
		contentPane.add(comboBox);
		comboBox.setSelectedItem(item.getSeq());

		JLabel lblNewLabel = new JLabel("ID do Estoque");
		lblNewLabel.setBounds(109, 158, 102, 14);
		contentPane.add(lblNewLabel);

		idEstoque = new JTextField();
		idEstoque.setBounds(320, 155, 354, 20);
		contentPane.add(idEstoque);
		idEstoque.setColumns(10);
		idEstoque.setText(String.valueOf(item.getIdEstoque()));

		JLabel lblLote = new JLabel("Lote");
		lblLote.setBounds(109, 210, 102, 14);
		contentPane.add(lblLote);

		lote = new JTextField();
		lote.setBounds(320, 207, 354, 20);
		contentPane.add(lote);
		lote.setColumns(10);
		lote.setText(String.valueOf(item.getLote()));

		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(109, 264, 102, 14);
		contentPane.add(lblQuantidade);

		JLabel lblDataDeEntrada = new JLabel("Data de Entrada");
		lblDataDeEntrada.setBounds(109, 345, 102, 14);
		contentPane.add(lblDataDeEntrada);

		JLabel lblDataDeValidade = new JLabel("Data de Validade");
		lblDataDeValidade.setBounds(109, 392, 102, 14);
		contentPane.add(lblDataDeValidade);

		DataEn = new JTextField();
		DataEn.setBounds(320, 342, 354, 20);
		contentPane.add(DataEn);
		DataEn.setColumns(10);
		DataEn.setText(String.valueOf(item.getDataEntrada()));

		DataVal = new JTextField();
		DataVal.setColumns(10);
		DataVal.setBounds(320, 389, 354, 20);
		contentPane.add(DataVal);
		DataVal.setText(String.valueOf(item.getDataValidade()));

		JButton btnSalvar = new JButton("Salvar");
		Date dataEn = new Date(00, 00, 0200);
		Date dataVal = new Date(00, 03, 0200);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ItemEstoque p = new ItemEstoque(((Integer) comboBox.getSelectedItem()),
						Integer.parseInt(idEstoque.getText()), dataEn, Integer.parseInt(lote.getText()),
						Integer.parseInt(quant.getText()), dataVal);

				try {
					f.atualizarItemEstoque(p);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				TelaGerente tela = new TelaGerente(FG);
				tela.setVisible(true);
				tela.setResizable(false);
				tela.setLocationRelativeTo(null);
			}
		});
		btnSalvar.setBackground(SystemColor.inactiveCaption);
		btnSalvar.setBounds(283, 466, 218, 23);
		contentPane.add(btnSalvar);

		quant = new JTextField();
		quant.setColumns(10);
		quant.setBounds(320, 261, 354, 20);
		contentPane.add(quant);
	}
}
