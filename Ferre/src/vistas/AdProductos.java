package vistas;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
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
import objetos.Alert;
import sql.Delete;
import sql.Select;
import java.awt.Color;
import java.awt.Font;

public class AdProductos
  extends JFrame
{
  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JTable table;
  private JTextField textCedula;
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        try
        {
          AdProductos frame = new AdProductos();
          frame.setVisible(true);
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    });
  }
  
  public AdProductos(final String use, final String pas)
  {
	  Alert ale = new Alert();
		ale.Alertame();
  	setBackground(new Color(255, 255, 255));
	    setResizable(false);
	    setTitle("Ferrepinturas Jireth");
	    setIconImage(Toolkit.getDefaultToolkit().getImage("images\\paintcan_23907.png"));
    setDefaultCloseOperation(3);
    setBounds(100, 100, 895, 606);
    this.contentPane = new JPanel();
    contentPane.setBackground(new Color(255, 255, 255));
    this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(this.contentPane);
    this.contentPane.setLayout(null);
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(12, 201, 853, 277);
    this.contentPane.add(scrollPane);
    
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("Id");
    modelo.addColumn("nombre");
    modelo.addColumn("Descripcion");
    modelo.addColumn("cantidad");
    modelo.addColumn("Limite");
    modelo.addColumn("P. Compra");
    modelo.addColumn("P. Venta");
    modelo.addColumn("fecha");
    modelo.addColumn("Usuario");
    
    this.table = new JTable();
    table.setBackground(new Color(0, 191, 255));
    this.table.setModel(modelo);
    scrollPane.setViewportView(this.table);
    this.contentPane.setLayout(null);
    
    JButton btnAtras = new JButton("ATR\u00C1S");
    btnAtras.setFont(new Font("Tahoma", Font.BOLD, 13));
    btnAtras.setBackground(Color.ORANGE);
    btnAtras.setForeground(Color.BLACK);
    btnAtras.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        Admin nuevo = new Admin(use,pas);
        nuevo.setVisible(true);
        AdProductos.this.setVisible(false);
      }
    });
    btnAtras.setBounds(144, 491, 116, 51);
    this.contentPane.add(btnAtras);
    
    JButton btnEliminar = new JButton("ELIMINAR");
    btnEliminar.setBackground(Color.ORANGE);
    btnEliminar.setForeground(Color.BLACK);
    btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 13));
    btnEliminar.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        String ced = AdProductos.this.textCedula.getText();
        int cedu = Integer.parseInt(ced);
        Delete borrar = new Delete();
        try
        {
          borrar.EliminarProducto(cedu);
          Admin nuevo = new Admin(use,pas);
          nuevo.setVisible(true);
          AdProductos.this.setVisible(false);
        }
        catch (SQLException e)
        {
          e.printStackTrace();
        }
      }
    });
    btnEliminar.setBounds(266, 77, 116, 51);
    this.contentPane.add(btnEliminar);
    
    JButton btnActualizar = new JButton("ACTUALIZAR");
    btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 13));
    btnActualizar.setBackground(Color.ORANGE);
    btnActualizar.setForeground(Color.BLACK);
    btnActualizar.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        String ced = AdProductos.this.textCedula.getText();
        @SuppressWarnings("unused")
		int cedu = Integer.parseInt(ced);
        AdActuProductos ade = new AdActuProductos(cedu,use,pas);
        ade.setVisible(true);
        AdProductos.this.setVisible(false);
      }
    });
    btnActualizar.setBounds(419, 77, 116, 51);
    this.contentPane.add(btnActualizar);
    
    JLabel lblCedula = new JLabel("ID:");
    lblCedula.setFont(new Font("Times New Roman", Font.BOLD, 16));
    lblCedula.setBounds(44, 93, 33, 16);
    this.contentPane.add(lblCedula);
    
    this.textCedula = new JTextField();
    this.textCedula.setBounds(89, 84, 153, 37);
    this.contentPane.add(this.textCedula);
    this.textCedula.setColumns(10);
    
    JButton btnCrearNuevo = new JButton("CREAR");
    btnCrearNuevo.setFont(new Font("Tahoma", Font.BOLD, 13));
    btnCrearNuevo.setBackground(Color.ORANGE);
    btnCrearNuevo.setForeground(Color.BLACK);
    btnCrearNuevo.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        AdCrearProducto crear = new AdCrearProducto(use,pas);
        crear.setVisible(true);
        AdProductos.this.setVisible(false);
      }
    });
    btnCrearNuevo.setBounds(556, 491, 116, 51);
    this.contentPane.add(btnCrearNuevo);
    
    JLabel label = new JLabel("");
    label.setIcon(new ImageIcon("images/pro.jpg"));
    label.setBounds(599, 0, 259, 205);
    contentPane.add(label);
    
    Select he = new Select();
    ArrayList<Productos> ho = he.Productos();
    Iterator<Productos> nombreIterator = ho.iterator();
    int com = 0;
    int ven = 0;
    int ganan = 0;
    while (nombreIterator.hasNext())
    {
      Productos elemento = (Productos)nombreIterator.next();
      String[] datos = { Integer.toString(elemento.getId()), elemento.getNombres(), elemento.getDescripcion(), Integer.toString(elemento.getCantidad()), Integer.toString(elemento.getLimite()), Integer.toString(elemento.getPreciocompra()), Integer.toString(elemento.getPrecioventa()), elemento.getFechaproducto().toString(), Integer.toString(elemento.getUsuarios_idusuarios())};
      modelo.addRow(datos);
      com += elemento.getPreciocompra();
      ven += elemento.getPrecioventa();
    }
    ganan = ven - com;
    String[] datos1 = { "", "", "", "", "Total: ", Integer.toString(com), Integer.toString(ven), "Ganancia:", Integer.toString(ganan) };
    modelo.addRow(datos1);
  }

public AdProductos() {
	// TODO Auto-generated constructor stub
}
}
