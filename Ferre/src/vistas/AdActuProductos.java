package vistas;

import com.toedter.calendar.JDateChooser;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import objetos.Productos;
import objetos.Alert;
import sql.Select;
import sql.Update;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class AdActuProductos
  extends JFrame
{
  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JTextField nombres;
  private JTextField pcompra;
  private JTextField pventa;
  int idd = 0;
  String nombre = null;
  String descripcio = null;
  String compra = null;
  int cantida = 0;
  int limit = 0;
  String venta = null;
  java.sql.Date fech = null;
  int usuario = 0;
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        try
        {
          AdActuProductos frame = new AdActuProductos();
          frame.setVisible(true);
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    });
  }
  
  public AdActuProductos(final int id,final String use, final String pas)
  {
		Alert ale = new Alert();
	    ale.Alertame();
	    setResizable(false);
	    setTitle("Ferrepinturas Jireth");
	    setIconImage(Toolkit.getDefaultToolkit().getImage("images\\paintcan_23907.png"));
    setDefaultCloseOperation(3);
    setBounds(100, 100, 754, 647);
    this.contentPane = new JPanel();
    contentPane.setBackground(Color.WHITE);
    this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(this.contentPane);
    this.contentPane.setLayout(null);
    
    Select he = new Select();
    ArrayList<Productos> ho = he.idProductos(id);
    Iterator<Productos> nombreIterator = ho.iterator();
    while (nombreIterator.hasNext())
    {
      Productos elemento = (Productos)nombreIterator.next();
      this.idd = elemento.getId();
      this.nombre = elemento.getNombres();
      this.descripcio = elemento.getDescripcion();
      this.compra = Integer.toString(elemento.getPreciocompra());
      this.cantida = elemento.getCantidad();
      this.limit = elemento.getLimite();
      this.venta = Integer.toString(elemento.getPrecioventa());
      this.fech = elemento.getFechaproducto();
      this.usuario = elemento.getUsuarios_idusuarios();
    }
    JLabel lblCrearProducto = new JLabel("Actualizar Producto");
    lblCrearProducto.setForeground(Color.RED);
    lblCrearProducto.setBackground(Color.BLACK);
    lblCrearProducto.setFont(new Font("Dialog", Font.BOLD, 52));
    lblCrearProducto.setBounds(221, 53, 499, 83);
    this.contentPane.add(lblCrearProducto);
    
    JButton btnAtras = new JButton("ATRAS");
    btnAtras.setForeground(Color.WHITE);
    btnAtras.setBackground(Color.RED);
    btnAtras.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        AdProductos volver = new AdProductos(use,pas);
        volver.setVisible(true);
        AdActuProductos.this.setVisible(false);
      }
    });
    btnAtras.setBounds(221, 552, 116, 47);
    this.contentPane.add(btnAtras);
    
    JLabel lblNewLabel = new JLabel("Nombres:");
    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblNewLabel.setBounds(37, 168, 86, 39);
    this.contentPane.add(lblNewLabel);
    
    JLabel lblDescripcion = new JLabel("Descripcion:");
    lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblDescripcion.setBounds(42, 404, 109, 16);
    this.contentPane.add(lblDescripcion);
    
    JLabel lblPrecioDeCompra = new JLabel("Precio de compra:");
    lblPrecioDeCompra.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblPrecioDeCompra.setBounds(350, 162, 133, 39);
    this.contentPane.add(lblPrecioDeCompra);
    
    JLabel lblPrecioDeVenta = new JLabel("Precio de Venta:");
    lblPrecioDeVenta.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblPrecioDeVenta.setBounds(360, 215, 123, 39);
    this.contentPane.add(lblPrecioDeVenta);
    
    this.nombres = new JTextField(this.nombre);
    this.nombres.setBounds(150, 168, 159, 39);
    this.contentPane.add(this.nombres);
    this.nombres.setColumns(10);
    
    this.pcompra = new JTextField(this.compra);
    this.pcompra.setBounds(494, 163, 159, 39);
    this.contentPane.add(this.pcompra);
    this.pcompra.setColumns(10);
    
    final JSpinner cantidad = new JSpinner();
    cantidad.setValue(Integer.valueOf(this.cantida));
    cantidad.setBounds(150, 272, 159, 39);
    this.contentPane.add(cantidad);
    
    this.pventa = new JTextField(this.venta);
    this.pventa.setBounds(494, 215, 159, 39);
    this.contentPane.add(this.pventa);
    this.pventa.setColumns(10);
    
    final JTextArea descripcion = new JTextArea();
    Border border = BorderFactory.createLineBorder(Color.BLACK);
    descripcion.setBorder(border);
    descripcion.setText(this.descripcio);
    descripcion.setBounds(163, 324, 462, 179);
    this.contentPane.add(descripcion);
    
    final JDateChooser fecha = new JDateChooser();
    fecha.setDate(this.fech);
    fecha.setBounds(150, 220, 159, 39);
    this.contentPane.add(fecha);
    
    JLabel lblCantidad = new JLabel("Cantidad:");
    lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblCantidad.setBounds(37, 272, 72, 39);
    this.contentPane.add(lblCantidad);
    
    JLabel lblFecha = new JLabel("fecha:");
    lblFecha.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblFecha.setBounds(37, 225, 86, 34);
    this.contentPane.add(lblFecha);
    
    JLabel lblLimite = new JLabel("Limite:");
    lblLimite.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblLimite.setBounds(425, 267, 56, 39);
    this.contentPane.add(lblLimite);
    
    final JSpinner limite = new JSpinner();
    limite.setValue(Integer.valueOf(this.limit));
    limite.setBounds(494, 267, 159, 39);
    this.contentPane.add(limite);
    
    JButton btnCrear = new JButton("ACTUALIZAR");
    btnCrear.setBackground(Color.RED);
    btnCrear.setForeground(Color.WHITE);
    btnCrear.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        String nom = AdActuProductos.this.nombres.getText();
        String des = descripcion.getText();
        int pv = Integer.parseInt(AdActuProductos.this.pventa.getText());
        int pc = Integer.parseInt(AdActuProductos.this.pcompra.getText());
        int limi = ((Integer)limite.getValue()).intValue();
        int canti = ((Integer)cantidad.getValue()).intValue();
        int a??o1 = fecha.getCalendar().get(1);
        int mes1 = fecha.getCalendar().get(2) + 1;
        int dia1 = fecha.getCalendar().get(5);
        String fech = Integer.toString(a??o1) + "-" + Integer.toString(mes1) + "-" + Integer.toString(dia1);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try
        {
          java.util.Date date = formatter.parse(fech);
          java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
          Productos produc = new Productos(AdActuProductos.this.idd, nom, des, pc, pv, sqlStartDate, canti, limi, AdActuProductos.this.usuario);
          Update actuali = new Update();
          actuali.ActuProducto(produc);
        }
        catch (ParseException|SQLException e1)
        {
          e1.printStackTrace();
        }
      }
    });
    btnCrear.setBounds(410, 552, 116, 47);
    this.contentPane.add(btnCrear);
    
    JLabel lblNewLabel_1 = new JLabel("");
    lblNewLabel_1.setIcon(new ImageIcon("Images\\editar.jpg"));
    lblNewLabel_1.setBounds(-57, -23, 319, 188);
    contentPane.add(lblNewLabel_1);
  }

public AdActuProductos() {
	// TODO Auto-generated constructor stub
}
}
