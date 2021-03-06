package vistas;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Usuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuario frame = new Usuario();
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
	public Usuario(final String use, final String pas) {
		setResizable(false);
	    setTitle("Ferrepinturas Jireth");
	    setIconImage(Toolkit.getDefaultToolkit().getImage("images\\paintcan_23907.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGastos = new JButton("Gastos");
		btnGastos.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnGastos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UsGastos ver=new UsGastos(use,pas);
				ver.setVisible(true);
				setVisible(false);
			}
		});
		btnGastos.setBounds(63, 122, 115, 51);
		contentPane.add(btnGastos);
		
		JButton btnFacturar = new JButton("Facturar");
		btnFacturar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnFacturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UsFacturar fac=new UsFacturar();
				fac.setVisible(true);
				setVisible(false);
				
			}
		});
		btnFacturar.setBounds(282, 122, 115, 51);
		contentPane.add(btnFacturar);
		
		JButton btnCerrar = new JButton("CERRAR");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login atras=new Login();
	    		atras.setVisible(true);
	    		setVisible(false);
				
			}
		});
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCerrar.setBounds(177, 256, 115, 51);
		contentPane.add(btnCerrar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\fabri\\Desktop\\Todo\\empresa\\ferreterialilia\\Ferre\\Images\\engranaje1.jpg"));
		label.setBounds(0, 0, 456, 389);
		contentPane.add(label);
	}

	public Usuario() {
		// TODO Auto-generated constructor stub
	}
}
