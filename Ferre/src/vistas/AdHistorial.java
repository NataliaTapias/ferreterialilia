package vistas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import objetos.Alert;
import javax.swing.ImageIcon;

public class AdHistorial
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
          AdHistorial frame = new AdHistorial();
          frame.setVisible(true);
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    });
  }
  
  public AdHistorial(final String use, final String pas)
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
    
    JButton btnUsuario = new JButton("Ganancias");
    btnUsuario.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        AdHistorialGanancias nuevo = new AdHistorialGanancias(use,pas);
        nuevo.setVisible(true);
        AdHistorial.this.setVisible(false);
      }
    });
    btnUsuario.setForeground(Color.BLACK);
    btnUsuario.setBackground(Color.GREEN);
    btnUsuario.setFont(new Font("Times New Roman", 0, 15));
    btnUsuario.setBounds(38, 211, 135, 23);
    this.contentPane.add(btnUsuario);
    
    JButton btnGastos = new JButton("Ventas");
    btnGastos.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
    	  AdHistorialVentas nuevo = new AdHistorialVentas(use,pas);
        nuevo.setVisible(true);
        setVisible(false);
      }
    });
    btnGastos.setBackground(new Color(255, 255, 0));
    btnGastos.setFont(new Font("Times New Roman", 0, 15));
    btnGastos.setBounds(197, 256, 135, 23);
    this.contentPane.add(btnGastos);
    
    JButton btnProducto = new JButton("Gastos");
    btnProducto.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
    	  AdHistorialGastos ir = new AdHistorialGastos(use,pas);
        ir.setVisible(true);
        AdHistorial.this.setVisible(false);
      }
    });
    btnProducto.setBackground(new Color(0, 204, 255));
    btnProducto.setFont(new Font("Times New Roman", 0, 15));
    btnProducto.setBounds(38, 255, 135, 23);
    this.contentPane.add(btnProducto);
    
    JButton btnCerrar = new JButton("Atras");
    btnCerrar.setForeground(Color.WHITE);
    btnCerrar.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		Admin atras=new Admin(use,pas);
    		atras.setVisible(true);
    		setVisible(false);
    	}
    });
    btnCerrar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
    btnCerrar.setBackground(Color.MAGENTA);
    btnCerrar.setBounds(119, 324, 135, 23);
    contentPane.add(btnCerrar);
    
    JButton btnInvercion = new JButton("Invercion");
    btnInvercion.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		AdHistorialInvercion atras=new AdHistorialInvercion(use,pas);
    		atras.setVisible(true);
    		setVisible(false);
    	}
    });
    btnInvercion.setForeground(Color.BLACK);
    btnInvercion.setFont(new Font("Times New Roman", Font.PLAIN, 15));
    btnInvercion.setBackground(new Color(255, 51, 102));
    btnInvercion.setBounds(197, 211, 135, 23);
    contentPane.add(btnInvercion);
    
    JLabel lblBienvenido = new JLabel("Historial");
    lblBienvenido.setForeground(Color.BLACK);
    lblBienvenido.setFont(new Font("Vivaldi", 1, 60));
    lblBienvenido.setBounds(50, 55, 282, 50);
    this.contentPane.add(lblBienvenido);
    
    JLabel lblNewLabel = new JLabel("Que Deseas Ver?");
    lblNewLabel.setFont(new Font("Times New Roman", 0, 20));
    lblNewLabel.setBounds(119, 148, 154, 50);
    this.contentPane.add(lblNewLabel);
    
    JLabel label = new JLabel("");
    label.setIcon(new ImageIcon("Images\\colores.png"));
    label.setBounds(0, 0, 367, 396);
    contentPane.add(label);
    
  }

public AdHistorial() {
	// TODO Auto-generated constructor stub
}


}
