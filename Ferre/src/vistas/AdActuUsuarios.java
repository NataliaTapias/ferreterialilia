package vistas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import objetos.Alert;
import objetos.Usuarios;
import sql.Select;
import sql.Update;

public class AdActuUsuarios extends JFrame {

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
	
	String id="";
	String nombres="";
	String cedula="";
	String direccion="";
	String telefono="";
	String contactoemergencia="";
	String correo="";
	String contra="";
	String creado="";
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdActuUsuarios frame = new AdActuUsuarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AdActuUsuarios(final String cedu, final String use, final String pas) {
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
		
		JLabel lblRegistra = new JLabel("Actualizar");
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
		
		Select he=new Select();
		ArrayList<Usuarios> ho=he.CedulaUsuarios(cedu);
		Iterator<Usuarios> nombreIterator = ho.iterator();
		while(nombreIterator.hasNext()){
			Usuarios elemento = nombreIterator.next();
			
			id=elemento.getId();
			nombres=elemento.getNombres();
			cedula=elemento.getCedula();
			direccion=elemento.getDireccion();
			telefono=elemento.getTel();
			contactoemergencia=elemento.getContemer();
			correo=elemento.getCorreo();
			contra=elemento.getContra();
			creado=elemento.getCreadoEn();
		}
		
		textNombre = new JTextField(nombres);
		textNombre.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textNombre.setBounds(195, 146, 186, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textCedula = new JTextField(cedula);
		textCedula.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textCedula.setColumns(10);
		textCedula.setBounds(195, 228, 186, 20);
		contentPane.add(textCedula);
		
		textDirec = new JTextField(direccion);
		textDirec.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textDirec.setColumns(10);
		textDirec.setBounds(195, 269, 186, 20);
		contentPane.add(textDirec);
		
		textCelular = new JTextField(telefono);
		textCelular.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textCelular.setColumns(10);
		textCelular.setBounds(195, 312, 186, 20);
		contentPane.add(textCelular);
		
		textEmergencia = new JTextField(contactoemergencia);
		textEmergencia.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textEmergencia.setColumns(10);
		textEmergencia.setBounds(195, 434, 186, 20);
		contentPane.add(textEmergencia);
		
		textCorreo = new JTextField(correo);
		textCorreo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textCorreo.setColumns(10);
		textCorreo.setBounds(195, 351, 186, 20);
		contentPane.add(textCorreo);
		
		passwordField = new JPasswordField(contra);
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		passwordField.setColumns(10);
		passwordField.setBounds(195, 394, 186, 20);
		contentPane.add(passwordField);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Usuario"}));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox.setBounds(195, 186, 186, 20);
		contentPane.add(comboBox);
		
		JButton btnCrear = new JButton("ACTUALIZAR");
		btnCrear.addActionListener(new ActionListener() {
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
				String actu= hourdateFormat.format(date);
				Usuarios nuevo=new Usuarios(id,nombre, cedula, direccion, cel, emer, tipo, corr, pass, creado, actu);
				Update n=new Update();
				try {
					n.ActuUsuario(nuevo);
					AdEmpleados atras=new AdEmpleados(use,pas);
					atras.setVisible(true);
					setVisible(false);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnCrear.setForeground(Color.WHITE);
		btnCrear.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnCrear.setBackground(new Color(102, 51, 153));
		btnCrear.setBounds(43, 483, 138, 48);
		contentPane.add(btnCrear);
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AdEmpleados atras=new AdEmpleados();
				atras.setVisible(true);
				setVisible(false);
			}
		});
		btnAtras.setBackground(new Color(102, 51, 153));
		btnAtras.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setBounds(242, 483, 139, 48);
		contentPane.add(btnAtras);
	}


	public AdActuUsuarios() {
		// TODO Auto-generated constructor stub
	}

}
