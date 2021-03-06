package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import objetos.Productos;
import sql.Select;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class Alerta extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alerta frame = new Alerta();
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
	public Alerta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 77, 853, 277);
		contentPane.add(scrollPane);
		
		DefaultTableModel modelo=new DefaultTableModel();
		modelo.addColumn("Id");
		modelo.addColumn("nombre");
		modelo.addColumn("Descripcion");
		modelo.addColumn("cantidad");
		modelo.addColumn("Limite");
		modelo.addColumn("P. Compra");
		modelo.addColumn("P. Venta");
		modelo.addColumn("fecha");
		modelo.addColumn("Usuario");
		
		table = new JTable();
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		contentPane.setLayout(null);
		
		Select he=new Select();
		ArrayList<Productos> ho=he.Productos();
		Iterator<Productos> nombreIterator = ho.iterator();
		while(nombreIterator.hasNext()){
			Productos elemento = nombreIterator.next();
			int cantida=elemento.getCantidad();
			int limit=elemento.getLimite();
			if(cantida<=limit) {
				String[] datos = {Integer.toString(elemento.getId()),elemento.getNombres(),elemento.getDescripcion(),Integer.toString(elemento.getCantidad()),Integer.toString(elemento.getLimite()),Integer.toString(elemento.getPreciocompra()),Integer.toString(elemento.getPrecioventa()),elemento.getFechaproducto().toString(),Integer.toString(elemento.getId())};
				modelo.addRow(datos);
			}
		}
		
		
		JLabel lblAlProducto = new JLabel("Estos Son Los Productos Que Estan Por Acabarsen");
		lblAlProducto.setBounds(280, 13, 304, 39);
		contentPane.add(lblAlProducto);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnAceptar.setBounds(374, 413, 95, 39);
		contentPane.add(btnAceptar);
	}
}
