package vistas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;	
import javax.swing.JTextField;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;

import objetos.Gastos;
import objetos.Usuarios;
import sql.Insertt;
import sql.Select;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class UsGastos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField quien;
	private JTextField cuanto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsGastos frame = new UsGastos();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public UsGastos(final String use, final String pas) {
		setResizable(false);
	    setTitle("Ferrepinturas Jireth");
	    setIconImage(Toolkit.getDefaultToolkit().getImage("images\\paintcan_23907.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 652);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		quien = new JTextField();
		quien.setBounds(107, 240, 202, 34);
		contentPane.add(quien);
		quien.setColumns(10);
		
		final JComboBox tipo = new JComboBox();
		tipo.setForeground(new Color(255, 102, 51));
		tipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		tipo.setModel(new DefaultComboBoxModel(new String[] {"gasto", "inversion"}));
		tipo.setBounds(433, 283, 116, 34);
		contentPane.add(tipo);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTipo.setBounds(365, 292, 56, 16);
		contentPane.add(lblTipo);
		
		JLabel lblNewLabel = new JLabel("Quien:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(39, 248, 56, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblRegistrarGasto = new JLabel("Registrar \r\n");
		lblRegistrarGasto.setForeground(new Color(255, 102, 51));
		lblRegistrarGasto.setFont(new Font("Dialog", Font.BOLD, 52));
		lblRegistrarGasto.setBounds(39, 46, 271, 95);
		contentPane.add(lblRegistrarGasto);
		
		final JDateChooser cuando = new JDateChooser();
		cuando.setBounds(108, 283, 201, 34);
		contentPane.add(cuando);
		
		JLabel lblCuando = new JLabel("Cuando:");
		lblCuando.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCuando.setBounds(39, 291, 81, 16);
		contentPane.add(lblCuando);
		
		JLabel lblPorque = new JLabel("Porque:");
		lblPorque.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPorque.setBounds(86, 424, 56, 16);
		contentPane.add(lblPorque);
		
		final JTextArea porque = new JTextArea();
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		porque.setBorder(border);
		porque.setBounds(179, 354, 318, 155);
		contentPane.add(porque);
		
		cuanto = new JTextField();
		cuanto.setColumns(10);
		cuanto.setBounds(433, 240, 116, 34);
		contentPane.add(cuanto);
		
		JLabel lblCuanto = new JLabel("Cuanto:");
		lblCuanto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCuanto.setBounds(365, 238, 56, 16);
		contentPane.add(lblCuanto);
		
		JButton btnNewButton = new JButton("ATRAS");
		btnNewButton.setBackground(new Color(255, 102, 51));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario atras=new Usuario(use,pas);
				atras.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(107, 555, 146, 49);
		contentPane.add(btnNewButton);
	
		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setBackground(new Color(255, 102, 51));
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a?o1=cuando.getCalendar().get(Calendar.YEAR);
			    int mes1=cuando.getCalendar().get(Calendar.MONTH)+1;
			    int dia1=cuando.getCalendar().get(Calendar.DAY_OF_MONTH);
			    String nom=quien.getText();
			    String por=porque.getText();
			    int pesos=Integer.parseInt(cuanto.getText());
			    String tip=(String) tipo.getSelectedItem();
			    String fech=Integer.toString(a?o1)+"-"+Integer.toString(mes1)+"-"+Integer.toString(dia1);
			    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			    java.util.Date date;
				try {
					date = formatter.parse(fech);
					java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());  
					Select verificar=new Select();
					Usuarios nuev=verificar.Login(use,pas);
					Gastos gasto=new Gastos(nom, pesos, por, tip, sqlStartDate,Integer.parseInt(nuev.getId()));
					Insertt nuevo=new Insertt();
					nuevo.NuevoGasto(gasto);
				} catch (ParseException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    
			}
		});
		btnRegistrar.setBounds(365, 555, 146, 49);
		contentPane.add(btnRegistrar);
		
		JLabel lblGasto = new JLabel("Gasto");
		lblGasto.setForeground(new Color(255, 102, 51));
		lblGasto.setBackground(new Color(255, 102, 51));
		lblGasto.setFont(new Font("Dialog", Font.BOLD, 52));
		lblGasto.setBounds(194, 98, 271, 95);
		contentPane.add(lblGasto);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Images\\gastos.jpg"));
		label.setBounds(399, -19, 202, 261);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("Images\\8.jpg"));
		label_1.setBounds(133, 386, 480, 231);
		contentPane.add(label_1);
		
	}

	public UsGastos() {
		// TODO Auto-generated constructor stub
	}
}
