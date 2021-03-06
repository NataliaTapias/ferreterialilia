package vistas;

import com.toedter.calendar.JDateChooser;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
import objetos.Usuarios;
import objetos.Alert;
import sql.Insertt;
import sql.Select;
import java.awt.Font;
import javax.swing.ImageIcon;

public class AdCrearProducto
  extends JFrame
{
  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JTextField nombres;
  private JTextField pcompra;
  private JTextField pventa;
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        try
        {
          AdCrearProducto frame = new AdCrearProducto();
          frame.setVisible(true);
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    });
  }
  
public AdCrearProducto(final String use, final String pas)
  {
		Alert ale = new Alert();
		ale.Alertame();
	    setResizable(false);
	    setTitle("Ferrepinturas Jireth");
	    setIconImage(Toolkit.getDefaultToolkit().getImage("images\\paintcan_23907.png"));
    setDefaultCloseOperation(3);
    setBounds(100, 100, 767, 646);
    this.contentPane = new JPanel();
    contentPane.setBackground(Color.WHITE);
    this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(this.contentPane);
    this.contentPane.setLayout(null);
    
    JLabel lblCrearProducto = new JLabel("Crear Producto");
    lblCrearProducto.setForeground(Color.RED);
    lblCrearProducto.setFont(new Font("Dialog", Font.BOLD, 52));
    lblCrearProducto.setBounds(329, 25, 395, 78);
    this.contentPane.add(lblCrearProducto);
    
    JButton btnAtras = new JButton("ATRAS");
    btnAtras.setFont(new Font("Tahoma", Font.BOLD, 14));
    btnAtras.setForeground(Color.WHITE);
    btnAtras.setBackground(Color.RED);
    btnAtras.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        AdProductos volver = new AdProductos(use,pas);
        volver.setVisible(true);
        AdCrearProducto.this.setVisible(false);
      }
    });
    btnAtras.setBounds(240, 536, 116, 47);
    this.contentPane.add(btnAtras);
    
    JLabel lblNewLabel = new JLabel("Nombres:");
    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblNewLabel.setBounds(35, 153, 77, 16);
    this.contentPane.add(lblNewLabel);
    
    JLabel lblDescripcion = new JLabel("Descripcion:");
    lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblDescripcion.setBounds(82, 380, 109, 25);
    this.contentPane.add(lblDescripcion);
    
    JLabel lblPrecioDeCompra = new JLabel("Precio de compra:");
    lblPrecioDeCompra.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblPrecioDeCompra.setBounds(372, 143, 137, 16);
    this.contentPane.add(lblPrecioDeCompra);
    
    JLabel lblPrecioDeVenta = new JLabel("Precio de Venta:");
    lblPrecioDeVenta.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblPrecioDeVenta.setBounds(383, 199, 116, 16);
    this.contentPane.add(lblPrecioDeVenta);
    
    this.nombres = new JTextField();
    this.nombres.setBounds(131, 143, 159, 39);
    this.contentPane.add(this.nombres);
    this.nombres.setColumns(10);
    
    this.pcompra = new JTextField();
    this.pcompra.setBounds(519, 133, 159, 39);
    this.contentPane.add(this.pcompra);
    this.pcompra.setColumns(10);
    
    final JSpinner cantidad = new JSpinner();
    cantidad.setBounds(132, 247, 159, 39);
    this.contentPane.add(cantidad);
    
    this.pventa = new JTextField();
    this.pventa.setBounds(520, 189, 159, 39);
    this.contentPane.add(this.pventa);
    this.pventa.setColumns(10);
    
    final JTextArea descripcion = new JTextArea();
    Border border = BorderFactory.createLineBorder(Color.BLACK);
    descripcion.setBorder(border);
    descripcion.setBounds(203, 309, 462, 179);
    this.contentPane.add(descripcion);
    
    final JDateChooser fecha = new JDateChooser();
    fecha.setBounds(132, 195, 159, 39);
    this.contentPane.add(fecha);
    
    JLabel lblCantidad = new JLabel("Cantidad:");
    lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblCantidad.setBounds(35, 257, 74, 16);
    this.contentPane.add(lblCantidad);
    
    JLabel lblFecha = new JLabel("fecha:");
    lblFecha.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblFecha.setBounds(64, 206, 56, 16);
    this.contentPane.add(lblFecha);
    
    JLabel lblLimite = new JLabel("Limite:");
    lblLimite.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblLimite.setBounds(443, 247, 56, 16);
    this.contentPane.add(lblLimite);
    
    final JSpinner limite = new JSpinner();
    limite.setBounds(519, 247, 159, 39);
    this.contentPane.add(limite);
    
    JButton btnCrear = new JButton("CREAR");
    btnCrear.setFont(new Font("Tahoma", Font.BOLD, 14));
    btnCrear.setForeground(Color.WHITE);
    btnCrear.setBackground(Color.RED);
    btnCrear.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        String nom = AdCrearProducto.this.nombres.getText();
        String des = descripcion.getText();
        int pv = Integer.parseInt(AdCrearProducto.this.pventa.getText());
        int pc = Integer.parseInt(AdCrearProducto.this.pcompra.getText());
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
          Select verificar = new Select();
          Usuarios nuev = verificar.Login(use,pas);
          Productos produc = new Productos(0, nom, des, pc, pv, sqlStartDate, canti, limi, Integer.parseInt(nuev.getId()));
          Insertt nuevo = new Insertt();
          nuevo.NuevoProducto(produc);
        }
        catch (ParseException|SQLException e1)
        {
          e1.printStackTrace();
        }
      }
    });
    btnCrear.setBounds(429, 536, 109, 47);
    this.contentPane.add(btnCrear);
    
    JLabel label = new JLabel("");
    label.setIcon(new ImageIcon("Images\\5.jpg"));
    label.setBounds(2, 0, 308, 194);
    contentPane.add(label);
  }

public AdCrearProducto() {
	// TODO Auto-generated constructor stub
}
  
}
