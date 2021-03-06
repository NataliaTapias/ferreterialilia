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

public class AdHistorialGastos
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
          AdHistorialGastos frame = new AdHistorialGastos();
          frame.setVisible(true);
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    });
  }
  
  public AdHistorialGastos(final String use, final String pas)
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
    
    JLabel lblHistorialDeGastos = new JLabel("Historial De");
    lblHistorialDeGastos.setForeground(new Color(0, 204, 102));
    lblHistorialDeGastos.setFont(new Font("Vivaldi", 1, 53));
    lblHistorialDeGastos.setBounds(29, 29, 334, 75);
    this.contentPane.add(lblHistorialDeGastos);
    
    JLabel lblGastos = new JLabel("Gastos");
    lblGastos.setForeground(new Color(0, 204, 102));
    lblGastos.setFont(new Font("Vivaldi", 1, 53));
    lblGastos.setBounds(86, 90, 199, 75);
    this.contentPane.add(lblGastos);
    
    JLabel label = new JLabel("");
    label.setIcon(new ImageIcon("images\\gastos1.jpg"));
    label.setBounds(600, 0, 259, 194);
    this.contentPane.add(label);
    
    JLabel lblCedula = new JLabel("De:");
    lblCedula.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblCedula.setBounds(12, 178, 33, 29);
    this.contentPane.add(lblCedula);
    
    final JDateChooser date1 = new JDateChooser();
    date1.setBounds(52, 178, 163, 29);
    this.contentPane.add(date1);
    
    JLabel lblA = new JLabel("A:");
    lblA.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblA.setBounds(227, 178, 19, 29);
    this.contentPane.add(lblA);
    
    final JDateChooser date2 = new JDateChooser();
    date2.setBounds(253, 178, 163, 29);
    this.contentPane.add(date2);
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(12, 258, 853, 277);
    this.contentPane.add(scrollPane);
    
    final DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("Quien");
    modelo.addColumn("Cuanto");
    modelo.addColumn("Porque");
    modelo.addColumn("Tipo");
    modelo.addColumn("Fecha");
    modelo.addColumn("Usuario");
    
    this.table = new JTable();
    this.table.setBackground(new Color(204, 255, 204));
    this.table.setModel(modelo);
    scrollPane.setViewportView(this.table);
    
    JButton button = new JButton("ATRAS");
    button.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        Admin nuevo = new Admin(use,pas);
        nuevo.setVisible(true);
        AdHistorialGastos.this.setVisible(false);
      }
    });
    button.setFont(new Font("Times New Roman", 0, 16));
    button.setBackground(new Color(51, 255, 102));
    button.setBounds(350, 550, 123, 50);
    this.contentPane.add(button);
    
    JButton btnEliminar = new JButton("Buscar");
    btnEliminar.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        int filas = AdHistorialGastos.this.table.getRowCount();
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
        ArrayList<Gastos> ho = he.gastosFech(fecha1,fecha2);
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
    btnEliminar.setBounds(451, 178, 123, 29);
    btnEliminar.setBackground(new Color(51, 255, 102));
    this.contentPane.add(btnEliminar);
  }

public AdHistorialGastos() {
	// TODO Auto-generated constructor stub
}
  
}
