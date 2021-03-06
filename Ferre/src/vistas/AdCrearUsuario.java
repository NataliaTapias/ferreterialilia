package vistas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import objetos.Alert;
import objetos.Usuarios;
import sql.Insertt;

public class AdCrearUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textCedula;
	private JTextField textDirec;
	private JTextField textCelular;
	private JTextField textEmergencia;
	private JTextField textCorreo;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdCrearUsuario frame = new AdCrearUsuario();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AdCrearUsuario(final String use, final String pas) {
		Alert ale = new Alert();
		ale.Alertame();
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\paintcan_23907.png"));
		setTitle("Ferrepinturas Jireth");
		setResizable(false);
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 595);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("images\\em1.png"));
		label_1.setBounds(10, 0, 106, 106);
		contentPane.add(label_1);
		
		JLabel lblRegistra = new JLabel("Registrar");
		lblRegistra.setForeground(new Color(153, 51, 153));
		lblRegistra.setBackground(new Color(153, 51, 153));
		lblRegistra.setFont(new Font("Vivaldi", Font.BOLD, 55));
		lblRegistra.setBounds(142, 23, 266, 69);
		contentPane.add(lblRegistra);
		
		JLabel lblNombre = new JLabel("NOMBRE:");
		lblNombre.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNombre.setBounds(26, 149, 77, 14);
		contentPane.add(lblNombre);
		
		JLabel lblCedula = new JLabel("CEDULA:");
		lblCedula.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCedula.setBounds(26, 231, 77, 14);
		contentPane.add(lblCedula);
		
		JLabel lblDireccion = new JLabel("DIRECCI?N:");
		lblDireccion.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDireccion.setBounds(26, 272, 114, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblCelular = new JLabel("CELULAR:");
		lblCelular.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCelular.setBounds(26, 315, 127, 14);
		contentPane.add(lblCelular);
		
		JLabel lblContactoDeEmergencia = new JLabel("CEL.EMERGENCIA:");
		lblContactoDeEmergencia.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblContactoDeEmergencia.setBounds(26, 437, 127, 14);
		contentPane.add(lblContactoDeEmergencia);
		
		JLabel lblTipo = new JLabel("TIPO:");
		lblTipo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTipo.setBounds(26, 189, 97, 14);
		contentPane.add(lblTipo);
		
		JLabel lblCargo = new JLabel("CORREO:");
		lblCargo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCargo.setBounds(26, 354, 77, 14);
		contentPane.add(lblCargo);
		
		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A:");
		lblContrasea.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblContrasea.setBounds(26, 397, 127, 14);
		contentPane.add(lblContrasea);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textNombre.setBounds(195, 146, 186, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textCedula = new JTextField();
		textCedula.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textCedula.setColumns(10);
		textCedula.setBounds(195, 228, 186, 20);
		contentPane.add(textCedula);
		
		textDirec = new JTextField();
		textDirec.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textDirec.setColumns(10);
		textDirec.setBounds(195, 269, 186, 20);
		contentPane.add(textDirec);
		
		textCelular = new JTextField();
		textCelular.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textCelular.setColumns(10);
		textCelular.setBounds(195, 312, 186, 20);
		contentPane.add(textCelular);
		
		textEmergencia = new JTextField();
		textEmergencia.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textEmergencia.setColumns(10);
		textEmergencia.setBounds(195, 434, 186, 20);
		contentPane.add(textEmergencia);
		
		textCorreo = new JTextField();
		textCorreo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textCorreo.setColumns(10);
		textCorreo.setBounds(195, 351, 186, 20);
		contentPane.add(textCorreo);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		passwordField.setColumns(10);
		passwordField.setBounds(195, 394, 186, 20);
		contentPane.add(passwordField);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Usuario"}));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox.setBounds(195, 186, 186, 20);
		contentPane.add(comboBox);
		
		JButton lblRegistrar = new JButton("REGISTRAR");
		lblRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre=textNombre.getText();
				String cedula=textCedula.getText();
				String direccion=textDirec.getText();
				String cel=textCelular.getText();
				String emer=textEmergencia.getText();
				String corr=textCorreo.getText();
				@SuppressWarnings("deprecation")
				String pass=passwordField.getText().toString();
				String tipo=(String) comboBox.getSelectedItem();
				if(tipo=="Admin"){
					tipo="AD";
				}else if(tipo=="Usuario"){
					tipo="US";
				}
				Date date = new Date();
				DateFormat hourdateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String creado= hourdateFormat.format(date);
				String actu= hourdateFormat.format(date);
				Usuarios nuevo=new Usuarios("",nombre, cedula, direccion, cel, emer, tipo, corr, pass, creado, actu);
				Insertt n=new Insertt();
				try {
					n.NuevoUsuario(nuevo);
					AdEmpleados atras=new AdEmpleados(use,pas);
					atras.setVisible(true);
					setVisible(false);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		lblRegistrar.setForeground(Color.WHITE);
		lblRegistrar.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblRegistrar.setBackground(new Color(102, 51, 153));
		lblRegistrar.setBounds(43, 483, 122, 48);
		contentPane.add(lblRegistrar);
		
		JButton btnAtrs = new JButton("ATRAS");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AdEmpleados atras=new AdEmpleados(use,pas);
				atras.setVisible(true);
				setVisible(false);
			}
		});
		btnAtrs.setBackground(new Color(102, 51, 153));
		btnAtrs.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnAtrs.setForeground(Color.WHITE);
		btnAtrs.setBounds(242, 483, 122, 48);
		contentPane.add(btnAtrs);
		
	}

	public AdCrearUsuario() {
		// TODO Auto-generated constructor stub
	}

}
