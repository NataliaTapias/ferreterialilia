package vistas;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import objetos.Productos;
import objetos.Alert;
import sql.Select;

public class AdHistorialInvercion
  extends JFrame
{
  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JTable table;
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        try
        {
          AdHistorialInvercion frame = new AdHistorialInvercion();
          frame.setVisible(true);
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    });
  }
  
  public AdHistorialInvercion(final String use, final String pas)
  {
	  Alert ale = new Alert();
		ale.Alertame();
    setResizable(false);
    setIconImage(Toolkit.getDefaultToolkit().getImage("images/paintcan_23907.png"));
    setTitle("Ferrepinturas Jireth");
    setDefaultCloseOperation(3);
    setBounds(100, 100, 880, 680);
    this.contentPane = new JPanel();
    this.contentPane.setBackground(Color.WHITE);
    this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(this.contentPane);
    this.contentPane.setLayout(null);
    
    JLabel lblHistorialDeGastos = new JLabel("Historial De Invercion");
    lblHistorialDeGastos.setForeground(new Color(0, 102, 255));
    lblHistorialDeGastos.setFont(new Font("Vivaldi", 1, 53));
    lblHistorialDeGastos.setBounds(274, 13, 588, 75);
    this.contentPane.add(lblHistorialDeGastos);
    
    JLabel label = new JLabel("");
    label.setIcon(new ImageIcon("images\\guardar.jpg"));
    label.setBounds(12, 13, 280, 219);
    this.contentPane.add(label);
    
    JLabel lblCedula = new JLabel("DESDE:");
    lblCedula.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblCedula.setBounds(304, 125, 56, 22);
    this.contentPane.add(lblCedula);
    
    final JDateChooser date1 = new JDateChooser();
    date1.setBounds(363, 125, 163, 32);
    this.contentPane.add(date1);
    
    JLabel lblA = new JLabel("HASTA:");
    lblA.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblA.setBounds(538, 128, 56, 16);
    this.contentPane.add(lblA);
    
    final JDateChooser date2 = new JDateChooser();
    date2.setBounds(606, 124, 163, 33);
    this.contentPane.add(date2);
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(12, 258, 853, 277);
    this.contentPane.add(scrollPane);
    
    final DefaultTableModel modelo = new DefaultTableModel();
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
    this.table.setBackground(new Color(0, 204, 255));
    this.table.setModel(modelo);
    scrollPane.setViewportView(this.table);
    
    JButton button = new JButton("ATRAS");
    button.setForeground(Color.WHITE);
    button.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        Admin nuevo = new Admin(use,pas);
        nuevo.setVisible(true);
        AdHistorialInvercion.this.setVisible(false);
      }
    });
    button.setFont(new Font("Times New Roman", Font.BOLD, 16));
    button.setBackground(new Color(0, 102, 255));
    button.setBounds(350, 550, 123, 50);
    this.contentPane.add(button);
    
    JButton btnEliminar = new JButton("BUSCAR");
    btnEliminar.setForeground(Color.WHITE);
    btnEliminar.setFont(new Font("Times New Roman", Font.BOLD, 16));
    btnEliminar.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        int filas = AdHistorialInvercion.this.table.getRowCount();
        for (int i = 0; filas > i; i++) {
          modelo.removeRow(0);
        }
        int a??o1 = date1.getCalendar().get(1);
        int mes1 = date1.getCalendar().get(2) + 1;
        int dia1 = date1.getCalendar().get(5);
        
        int a??o2 = date2.getCalendar().get(1);
        int mes2 = date2.getCalendar().get(2) + 1;
        int dia2 = date2.getCalendar().get(5);
        
        String fecha1=Integer.toString(a??o1)+"-"+Integer.toString(mes1)+"-"+Integer.toString(dia1);
        String fecha2=Integer.toString(a??o2)+"-"+Integer.toString(mes2)+"-"+Integer.toString(dia2);
        
        Select he = new Select();
        ArrayList<Productos> ho = he.ProductosFech(fecha1, fecha2);
        Iterator<Productos> nombreIterator = ho.iterator();
        int total = 0;
        while (nombreIterator.hasNext())
        {
        	Productos elemento = (Productos)nombreIterator.next();
              String[] datos = { Integer.toString(elemento.getId()), elemento.getNombres(), elemento.getDescripcion(), Integer.toString(elemento.getCantidad()), Integer.toString(elemento.getLimite()), Integer.toString(elemento.getPreciocompra()), Integer.toString(elemento.getPrecioventa()), elemento.getFechaproducto().toString(), Integer.toString(elemento.getUsuarios_idusuarios())};
              modelo.addRow(datos);
              total += elemento.getPreciocompra();
        }
        String[] tol = { "Total:", Integer.toString(total) };
        modelo.addRow(tol);
      }
    });
    btnEliminar.setBounds(498, 180, 123, 52);
    btnEliminar.setBackground(new Color(0, 102, 255));
    this.contentPane.add(btnEliminar);
  }

public AdHistorialInvercion() {
	// TODO Auto-generated constructor stub
}
  
}
