package vistas;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import objetos.Productos;
import sql.Select;

public class UsFacturar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table1;
	private JTextField idnom;
	private JTextField textField;
	private JTextField a?ad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsFacturar frame = new UsFacturar();
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
	public UsFacturar() {
		setResizable(false);
	    setTitle("Ferrepinturas Jireth");
	    setIconImage(Toolkit.getDefaultToolkit().getImage("images\\paintcan_23907.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1137, 623);	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 93, 440, 277);
		contentPane.add(scrollPane);
		
		final DefaultTableModel modelo=new DefaultTableModel();
		modelo.addColumn("Id");
		modelo.addColumn("nombre");
		modelo.addColumn("Descripcion");
		modelo.addColumn("P. Venta");
		
		table = new JTable();
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		contentPane.setLayout(null);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Usuario nuevo=new Usuario();
				nuevo.setVisible(true);
				setVisible(false);
			}
		});
		btnAtras.setBounds(25, 498, 116, 51);
		contentPane.add(btnAtras);
		
		JButton btnActualizar = new JButton("Buscar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int filas=table.getRowCount();
	            for (int i = 0;filas>i; i++) {
	                modelo.removeRow(0);
	            }
				String ced=idnom.getText();
				if(ced.equals("")) {
					Select he=new Select();
					ArrayList<Productos> ho=he.Productos();
					Iterator<Productos> nombreIterator = ho.iterator();
					
					while(nombreIterator.hasNext()){
						Productos elemento = nombreIterator.next();
						String[] datos = {Integer.toString(elemento.getId()),elemento.getNombres(),elemento.getDescripcion(),Integer.toString(elemento.getPrecioventa())};
						modelo.addRow(datos);
						
					}
				}
				int id=0;
				boolean n=false;
				Select buscar=new Select();
	            try{
	                id=Integer.parseInt(ced);
	                n =true;
	            }catch(NumberFormatException e){
	                n =false;
	            }
	            if (n== true) {
					ArrayList<Productos> ho=buscar.idProductos(id);
					Iterator<Productos> nombreIterator = ho.iterator();
					
					while(nombreIterator.hasNext()){
						Productos elemento = nombreIterator.next();
						String[] datos = {Integer.toString(elemento.getId()),elemento.getNombres(),elemento.getDescripcion(),Integer.toString(elemento.getPrecioventa())};
						modelo.addRow(datos);
						
					}
					
				}else {
					ArrayList<Productos> ho=buscar.nomProductos(ced);
					Iterator<Productos> nombreIterator = ho.iterator();
					
					while(nombreIterator.hasNext()){
						Productos elemento = nombreIterator.next();
						String[] datos = {Integer.toString(elemento.getId()),elemento.getNombres(),elemento.getDescripcion(),Integer.toString(elemento.getPrecioventa())};
						modelo.addRow(datos);
						
					}
				}
	            
			}
		});
		btnActualizar.setBounds(355, 44, 97, 25);
		contentPane.add(btnActualizar);
		
		JLabel lblCedula = new JLabel("ID o Nombre:");
		lblCedula.setBounds(60, 48, 116, 16);
		contentPane.add(lblCedula);
		
		idnom = new JTextField();
		idnom.setBounds(188, 45, 116, 22);
		contentPane.add(idnom);
		idnom.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(597, 93, 440, 277);
		contentPane.add(scrollPane_1);
		
		final DefaultTableModel modelo1=new DefaultTableModel();
		modelo1.addColumn("Id");
		modelo1.addColumn("nombre");
		modelo1.addColumn("Descripcion");
		modelo1.addColumn("P. Venta");
		
		table1 = new JTable();
		table1.setModel(modelo1);
		scrollPane_1.setViewportView(table1);
		contentPane.setLayout(null);
		
		JButton btnCrearNuevo = new JButton("A\u00F1adir");
		btnCrearNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a?adir= a?ad.getText();
				int id=0;
				boolean n=false;
				Select buscar=new Select();
	            try{
	                id=Integer.parseInt(a?adir);
	                n =true;
	            }catch(NumberFormatException e){
	                n =false;
	            }
	            if (n== true) {
					ArrayList<Productos> ho=buscar.idProductos(id);
					Iterator<Productos> nombreIterator = ho.iterator();
					
					while(nombreIterator.hasNext()){
						Productos elemento = nombreIterator.next();
						String[] datos = {Integer.toString(elemento.getId()),elemento.getNombres(),elemento.getDescripcion(),Integer.toString(elemento.getPrecioventa())};
						modelo1.addRow(datos);
						
					}
					
				}else {
					ArrayList<Productos> ho=buscar.nomProductos(a?adir);
					Iterator<Productos> nombreIterator = ho.iterator();
					
					while(nombreIterator.hasNext()){
						Productos elemento = nombreIterator.next();
						String[] datos = {Integer.toString(elemento.getId()),elemento.getNombres(),elemento.getDescripcion(),Integer.toString(elemento.getPrecioventa())};
						modelo1.addRow(datos);
						
					}
				}
				
			}
		});
		btnCrearNuevo.setBounds(265, 422, 116, 51);
		contentPane.add(btnCrearNuevo);
		
		JButton btnFacturar = new JButton("Facturar");
		btnFacturar.setBounds(775, 422, 116, 51);
		contentPane.add(btnFacturar);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(683, 49, 116, 22);
		contentPane.add(textField);
		
		JLabel label = new JLabel("ID");
		label.setBounds(618, 48, 56, 16);
		contentPane.add(label);
		
		JButton btnSacar = new JButton("Sacar");
		btnSacar.setBounds(834, 47, 97, 25);
		contentPane.add(btnSacar);
		
		a?ad = new JTextField();
		a?ad.setColumns(10);
		a?ad.setBounds(336, 383, 116, 22);
		contentPane.add(a?ad);
		
		JLabel label_1 = new JLabel("ID o Nombre:");
		label_1.setBounds(189, 386, 116, 16);
		contentPane.add(label_1);
		
		Select he=new Select();
		ArrayList<Productos> ho=he.Productos();
		Iterator<Productos> nombreIterator = ho.iterator();
		
		while(nombreIterator.hasNext()){
			Productos elemento = nombreIterator.next();
			String[] datos = {Integer.toString(elemento.getId()),elemento.getNombres(),elemento.getDescripcion(),Integer.toString(elemento.getPrecioventa())};
			modelo.addRow(datos);
			
		}
		
	}
}
