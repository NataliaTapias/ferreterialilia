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
import objetos.Gastos;
import objetos.Alert;
import sql.Select;

public class AdHistorialGanancias
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
          AdHistorialGanancias frame = new AdHistorialGanancias();
          frame.setVisible(true);
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    });
  }
  
  public AdHistorialGanancias(final String use, final String pas)
  {
	Alert ale = new Alert();
	ale.Alertame();
    setResizable(false);
    setIconImage(Toolkit.getDefaultToolkit().getImage("images/paintcan_23907.png"));
    setTitle("Ferrepinturas Jireth");
    setDefaultCloseOperation(3);
    setBounds(100, 100, 886, 657);
    this.contentPane = new JPanel();
    this.contentPane.setBackground(Color.WHITE);
    this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(this.contentPane);
    this.contentPane.setLayout(null);
    
    JLabel lblHistorialDeGastos = new JLabel("Historial De Ganancias");
    lblHistorialDeGastos.setForeground(new Color(220, 20, 60));
    lblHistorialDeGastos.setFont(new Font("Vivaldi", 1, 53));
    lblHistorialDeGastos.setBounds(288, 13, 574, 75);
    this.contentPane.add(lblHistorialDeGastos);
    
    JLabel label = new JLabel("");
    label.setIcon(new ImageIcon("images\\ganancias.jpg"));
    label.setBounds(12, 13, 259, 194);
    this.contentPane.add(label);
    
    JLabel lblCedula = new JLabel("DESDE:");
    lblCedula.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblCedula.setBounds(298, 122, 56, 35);
    this.contentPane.add(lblCedula);
    
    final JDateChooser date1 = new JDateChooser();
    date1.setBounds(361, 122, 163, 35);
    this.contentPane.add(date1);
    
    JLabel lblA = new JLabel("HASTA:");
    lblA.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblA.setBounds(536, 122, 56, 35);
    this.contentPane.add(lblA);
    
    final JDateChooser date2 = new JDateChooser();
    date2.setBounds(592, 124, 163, 35);
    this.contentPane.add(date2);
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(12, 258, 853, 277);
    this.contentPane.add(scrollPane);
    
    final DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("fecha,");
    modelo.addColumn("T.P.Compra");
    modelo.addColumn("Total");
    modelo.addColumn("Subtotal");
    modelo.addColumn("Iva");
    
    this.table = new JTable();
    this.table.setBackground(new Color(220, 20, 60));
    this.table.setModel(modelo);
    scrollPane.setViewportView(this.table);
    
    JButton btnAtras = new JButton("ATRAS");
    btnAtras.setForeground(new Color(255, 255, 255));
    btnAtras.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        Admin nuevo = new Admin(use,pas);
        nuevo.setVisible(true);
        AdHistorialGanancias.this.setVisible(false);
      }
    });
    btnAtras.setFont(new Font("Times New Roman", 0, 16));
    btnAtras.setBackground(new Color(220, 20, 60));
    btnAtras.setBounds(350, 550, 123, 50);
    this.contentPane.add(btnAtras);
    
    JButton btnEliminar = new JButton("Buscar");
    btnEliminar.setForeground(new Color(255, 255, 255));
    btnEliminar.addActionListener(new ActionListener()
    {
      @SuppressWarnings("unused")
	public void actionPerformed(ActionEvent arg0)
      {
        int filas = AdHistorialGanancias.this.table.getRowCount();
        for (int i = 0; filas > i; i++) {
          modelo.removeRow(0);
        }
        int a??o1 = date1.getCalendar().get(1);
        int mes1 = date1.getCalendar().get(2) + 1;
        int dia1 = date1.getCalendar().get(5);
        
		int a??o2 = date2.getCalendar().get(1);
        int mes2 = date2.getCalendar().get(2) + 1;
        int dia2 = date2.getCalendar().get(5);
        
        Select he = new Select();
        ArrayList<Gastos> ho = he.gastos();
        Iterator<Gastos> nombreIterator = ho.iterator();
        int total = 0;
        while (nombreIterator.hasNext())
        {
          Gastos elemento = (Gastos)nombreIterator.next();
         
                  String cuan = Integer.toString(elemento.getCuanto());
                  String usuario = Integer.toString(elemento.getUsuarios_idusuarios());
                  String[] datos = { elemento.getQuien(), cuan, elemento.getPorque(), elemento.getTipo(), elemento.getFecha().toString(), usuario };
                  modelo.addRow(datos);
                  total += elemento.getCuanto();
               
 
        }
        String[] tol = { "Total:", Integer.toString(total) };
        modelo.addRow(tol);
      }
    });
    btnEliminar.setBounds(765, 124, 97, 35);
    btnEliminar.setBackground(new Color(220, 20, 60));
    this.contentPane.add(btnEliminar);
  }

public AdHistorialGanancias() {
	// TODO Auto-generated constructor stub
}

  
}
