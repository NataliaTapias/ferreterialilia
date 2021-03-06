package vistas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import objetos.Alert;

public class Admin
  extends JFrame
{
  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        try
        {
          Admin frame = new Admin();
          frame.setVisible(true);
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    });
  }
  
  public Admin(final String use, final String pas)
  {
	  Alert ale = new Alert();
		ale.Alertame();
    setResizable(false);
    setTitle("Ferrepinturas Jireth");
    setIconImage(Toolkit.getDefaultToolkit().getImage("images\\paintcan_23907.png"));
    setDefaultCloseOperation(3);
    setBounds(100, 100, 373, 431);
    this.contentPane = new JPanel();
    this.contentPane.setBackground(new Color(255, 255, 255));
    this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(this.contentPane);
    this.contentPane.setLayout(null);
    
    JButton btnUsuario = new JButton("Empleados");
    btnUsuario.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        AdEmpleados nuevo = new AdEmpleados(use,pas);
        nuevo.setVisible(true);
        Admin.this.setVisible(false);
      }
    });
    btnUsuario.setForeground(new Color(255, 255, 255));
    btnUsuario.setBackground(new Color(255, 51, 102));
    btnUsuario.setFont(new Font("Times New Roman", 0, 15));
    btnUsuario.setBounds(120, 248, 135, 23);
    this.contentPane.add(btnUsuario);
    
    JButton btnGastos = new JButton("Historial");
    btnGastos.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        AdHistorial nuevo = new AdHistorial(use,pas);
        nuevo.setVisible(true);
        Admin.this.setVisible(false);
      }
    });
    btnGastos.setBackground(new Color(255, 255, 0));
    btnGastos.setFont(new Font("Times New Roman", 0, 15));
    btnGastos.setBounds(198, 292, 135, 23);
    this.contentPane.add(btnGastos);
    
    JButton btnProducto = new JButton("Productos");
    btnProducto.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        AdProductos ir = new AdProductos(use,pas);
        ir.setVisible(true);
        Admin.this.setVisible(false);
      }
    });
    btnProducto.setBackground(new Color(0, 204, 255));
    btnProducto.setFont(new Font("Times New Roman", 0, 15));
    btnProducto.setBounds(39, 291, 135, 23);
    this.contentPane.add(btnProducto);
    
    JButton btnCerrar = new JButton("Cerrar");
    btnCerrar.setForeground(Color.WHITE);
    btnCerrar.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		Login atras=new Login();
    		atras.setVisible(true);
    		setVisible(false);
    	}
    });
    btnCerrar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
    btnCerrar.setBackground(Color.MAGENTA);
    btnCerrar.setBounds(120, 341, 135, 23);
    contentPane.add(btnCerrar);
    
    JLabel lblBienvenido = new JLabel("Bienvenido");
    lblBienvenido.setForeground(Color.MAGENTA);
    lblBienvenido.setFont(new Font("Vivaldi", 1, 60));
    lblBienvenido.setBounds(22, 25, 333, 50);
    this.contentPane.add(lblBienvenido);
    
    JLabel lblNewLabel = new JLabel("Que deseas hacer hoy?");
    lblNewLabel.setFont(new Font("Times New Roman", 0, 20));
    lblNewLabel.setBounds(97, 193, 200, 50);
    this.contentPane.add(lblNewLabel);
    
    JLabel label = new JLabel("");
    label.setIcon(new ImageIcon("images\\bootloader_users_person_people_6080.png"));
    label.setBounds(110, 71, 128, 128);
    this.contentPane.add(label);
    
    JLabel lblNewLabel_1 = new JLabel("");
    lblNewLabel_1.setIcon(new ImageIcon("images\\3.jpg"));
    lblNewLabel_1.setBounds(-104, -32, 539, 753);
    this.contentPane.add(lblNewLabel_1);
    setLocationRelativeTo(null);
  }

public Admin() {
	// TODO Auto-generated constructor stub
}


}
