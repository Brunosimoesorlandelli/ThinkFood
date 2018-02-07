package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Cursor;
import javax.swing.JSpinner;
import javax.swing.JButton;

public class TelaCadastroProduto extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroProduto frame = new TelaCadastroProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastroProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(80, 55, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 58, 46, 14);
		contentPane.add(lblCdigo);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(10, 116, 60, 14);
		contentPane.add(lblDescrio);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(80, 116, 210, 70);
		contentPane.add(textField_1);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(273, 197, 89, 23);
		contentPane.add(btnCadastrar);
		
		textField_2 = new JTextField();
		textField_2.setBounds(398, 11, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setBounds(342, 14, 46, 14);
		contentPane.add(lblPreo);
		
		textField_3 = new JTextField();
		textField_3.setBounds(80, 11, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 14, 46, 14);
		contentPane.add(lblNome);
	}
}
