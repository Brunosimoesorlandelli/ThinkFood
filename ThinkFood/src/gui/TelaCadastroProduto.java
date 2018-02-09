package gui;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Negocio.Fachada;
import Negocio.IFachada;
import beans.ItemMenu;

public class TelaCadastroProduto extends JFrame {

	private JPanel contentPane;
	private JTextField codigo;
	private JTextField desc;
	private JTextField preco;
	private JTextField nome;
	private JTextField detalhes;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TelaCadastroProduto() {
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
		
		codigo = new JTextField();
		codigo.setBounds(80, 110, 209, 20);
		contentPane.add(codigo);
		codigo.setColumns(10);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 113, 46, 14);
		contentPane.add(lblCdigo);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(10, 181, 60, 14);
		contentPane.add(lblDescrio);
		
		desc = new JTextField();
		desc.setColumns(10);
		desc.setBounds(80, 181, 494, 117);
		contentPane.add(desc);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					f.cadastrarItemMenu(new ItemMenu(Integer.parseInt(codigo.getText()), Double.parseDouble(preco.getText()), desc.getText(), detalhes.getText(), nome.getText()));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnCadastrar.setBounds(247, 328, 89, 23);
		contentPane.add(btnCadastrar);
		
		preco = new JTextField();
		preco.setBounds(355, 66, 209, 20);
		contentPane.add(preco);
		preco.setColumns(10);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setBounds(299, 69, 46, 14);
		contentPane.add(lblPreo);
		
		nome = new JTextField();
		nome.setBounds(80, 66, 209, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 69, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblDetalhes = new JLabel("Detalhes:");
		lblDetalhes.setBounds(299, 113, 46, 14);
		contentPane.add(lblDetalhes);
		
		detalhes = new JTextField();
		detalhes.setColumns(10);
		detalhes.setBounds(355, 110, 209, 47);
		contentPane.add(detalhes);
	}
}
