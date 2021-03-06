package vistas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import objetos.Alert;
import objetos.Usuarios;
import sql.Delete;
import sql.Select;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class AdEmpleados extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textCedula;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdEmpleados frame = new AdEmpleados();
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
	public AdEmpleados(final String use, final String pas) {
		Alert ale = new Alert();
		ale.Alertame();
	    setResizable(false);
	    setTitle("Ferrepinturas Jireth");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 546);
		contentPane = new JPanel();
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\paintcan_23907.png"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("images\\em1.png"));
		label.setBounds(600, 5, 106, 106);
		contentPane.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 118, 853, 277);
		contentPane.add(scrollPane);
		
		DefaultTableModel modelo=new DefaultTableModel();
		modelo.addColumn("nombre");
		modelo.addColumn("cedula");
		modelo.addColumn("direccion");
		modelo.addColumn("tel");
		modelo.addColumn("contactoEmergencia");
		modelo.addColumn("tipo");
		modelo.addColumn("correo");
		modelo.addColumn("contra");
		modelo.addColumn("creadoEn");
		
		table = new JTable();
		table.setModel(modelo);
		table.setBackground(new Color(175, 238, 238));
		scrollPane.setViewportView(table);
		contentPane.setLayout(null);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin nuevo=new Admin(use,pas);
				nuevo.setVisible(true);
				setVisible(false);
			}
		});
		btnAtras.setBounds(144, 422, 116, 51);
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnAtras.setBackground(new Color(102, 51, 153));
		contentPane.add(btnAtras);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cedu=textCedula.getText();
				System.out.println(cedu);
				Delete borrar=new Delete();
				try {
					borrar.EliminarUsuario(cedu);
					Admin nuevo=new Admin(use,pas);
					nuevo.setVisible(true);
					setVisible(false);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnEliminar.setBounds(291, 45, 97, 32);
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnEliminar.setBackground(new Color(102, 51, 153));
		contentPane.add(btnEliminar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				String cedu=textCedula.getText();
				AdActuUsuarios ade=new AdActuUsuarios(cedu,use,pas);
				ade.setVisible(true);
				setVisible(false);
			}
		});
		btnActualizar.setBounds(444, 45, 97, 32);
		btnActualizar.setForeground(Color.WHITE);
		btnActualizar.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnActualizar.setBackground(new Color(102, 51, 153));
		contentPane.add(btnActualizar);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCedula.setBounds(12, 49, 56, 28);
		contentPane.add(lblCedula);
		
		textCedula = new JTextField();
		textCedula.setBounds(80, 46, 165, 31);
		contentPane.add(textCedula);
		textCedula.setColumns(10);
		
		JButton btnCrearNuevo = new JButton("Crear Usuario");
		btnCrearNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdCrearUsuario crear=new AdCrearUsuario(use,pas);
				crear.setVisible(true);
				setVisible(false);
			}
		});
		btnCrearNuevo.setBounds(556, 422, 146, 51);
		btnCrearNuevo.setForeground(Color.WHITE);
		btnCrearNuevo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnCrearNuevo.setBackground(new Color(102, 51, 153));
		contentPane.add(btnCrearNuevo);
		
		Select he=new Select();
		ArrayList<Usuarios> ho=he.usuarios();
		Iterator<Usuarios> nombreIterator = ho.iterator();
		
		while(nombreIterator.hasNext()){
			Usuarios elemento = nombreIterator.next();
			System.out.print(elemento.getNombres()+" / ");
			String[] datos = {elemento.getNombres(),elemento.getCedula(),elemento.getDireccion(),elemento.getTel(),elemento.getContemer(),elemento.getTipo(),elemento.getCorreo(),elemento.getContra(),elemento.getCreadoEn(),elemento.getActuEn()};
			modelo.addRow(datos);
			
		}
		
	}

	public AdEmpleados() {
		// TODO Auto-generated constructor stub
	}

}
