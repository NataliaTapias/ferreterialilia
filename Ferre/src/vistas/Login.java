package vistas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import objetos.Usuarios;
import sql.Select;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.placeholder.PlaceHolder;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setForeground(Color.BLACK);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\paintcan_23907.png"));
		setTitle("Ferrepinturas Jireth");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 650);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		user = new JTextField();
		user.setBounds(149, 404, 193, 27);
		contentPane.add(user);
		user.setColumns(10);
		@SuppressWarnings("unused")
		PlaceHolder header=new PlaceHolder(user,"NATALIA@GMAIL.COM");
		
		pass = new JPasswordField();
		pass.setBounds(149, 470, 193, 27);
		contentPane.add(pass);
		@SuppressWarnings("unused")
		PlaceHolder header1=new PlaceHolder(pass,"CONTRAE?A");
		
		JButton entrar = new JButton("Iniciar");
		entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String use=user.getText();
				@SuppressWarnings("deprecation")
				String pas=pass.getText().toString();
				
				Select verificar=new Select();
				Usuarios nuevo=verificar.Login(use, pas);
				if(use.equals(nuevo.getCorreo()) && pas.equals(nuevo.getContra()) && nuevo.getTipo().equals("AD")){
					Admin ad=new Admin(use,pas);
					ad.setVisible(true);
					setVisible(false);
				}else if(use.equals(nuevo.getCorreo()) && pas.equals(nuevo.getContra()) && nuevo.getTipo().equals("US")){
					
					Usuario us=new Usuario(use,pas);
					us.setVisible(true);
					setVisible(false);
				}else{
					JOptionPane.showMessageDialog(null, "Correo o Contrase?a incorrecto");
				}
				
			}
		});
		entrar.setForeground(Color.BLACK);
		entrar.setBackground(Color.CYAN);
		entrar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		entrar.setBounds(190, 546, 119, 27);
		contentPane.add(entrar);
		
		JLabel lblUsuario = new JLabel("U");
		lblUsuario.setForeground(new Color(102, 0, 102));
		lblUsuario.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblUsuario.setBounds(149, 380, 12, 27);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("C");
		lblContrasea.setForeground(new Color(153, 0, 102));
		lblContrasea.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblContrasea.setBounds(149, 442, 12, 36);
		contentPane.add(lblContrasea);
		
		JLabel lblS_1 = new JLabel("S");
		lblS_1.setForeground(new Color(51, 204, 204));
		lblS_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblS_1.setBounds(174, 380, 12, 27);
		contentPane.add(lblS_1);
		
		JLabel label_8 = new JLabel("U");
		label_8.setForeground(new Color(0, 51, 204));
		label_8.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_8.setBounds(209, 380, 12, 27);
		contentPane.add(label_8);
		
		JLabel lblA_1 = new JLabel("A");
		lblA_1.setForeground(new Color(102, 51, 0));
		lblA_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblA_1.setBounds(244, 380, 12, 27);
		contentPane.add(lblA_1);
		
		JLabel lblR_1 = new JLabel("R");
		lblR_1.setForeground(new Color(153, 0, 153));
		lblR_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblR_1.setBounds(273, 380, 12, 27);
		contentPane.add(lblR_1);
		
		JLabel lblI_1 = new JLabel("I");
		lblI_1.setForeground(new Color(51, 153, 51));
		lblI_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblI_1.setBounds(304, 380, 12, 27);
		contentPane.add(lblI_1);
		
		JLabel lblO = new JLabel("O");
		lblO.setForeground(new Color(255, 51, 0));
		lblO.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblO.setBounds(330, 380, 12, 27);
		contentPane.add(lblO);
		
		JLabel lblO_1 = new JLabel("O");
		lblO_1.setForeground(new Color(51, 0, 204));
		lblO_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblO_1.setBounds(171, 442, 12, 36);
		contentPane.add(lblO_1);
		
		JLabel lblN_1 = new JLabel("N");
		lblN_1.setForeground(new Color(255, 51, 0));
		lblN_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblN_1.setBounds(191, 442, 12, 36);
		contentPane.add(lblN_1);
		
		JLabel lblT_1 = new JLabel("T");
		lblT_1.setForeground(new Color(0, 255, 255));
		lblT_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblT_1.setBounds(209, 442, 12, 36);
		contentPane.add(lblT_1);
		
		JLabel lblR_2 = new JLabel("R");
		lblR_2.setForeground(new Color(0, 102, 0));
		lblR_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblR_2.setBounds(230, 442, 12, 36);
		contentPane.add(lblR_2);
		
		JLabel lblA_2 = new JLabel("A");
		lblA_2.setForeground(new Color(204, 204, 0));
		lblA_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblA_2.setBounds(252, 442, 12, 36);
		contentPane.add(lblA_2);
		
		JLabel lblS_2 = new JLabel("S");
		lblS_2.setForeground(new Color(204, 0, 204));
		lblS_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblS_2.setBounds(273, 442, 12, 36);
		contentPane.add(lblS_2);
		
		JLabel lblE_1 = new JLabel("E");
		lblE_1.setForeground(new Color(0, 204, 51));
		lblE_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblE_1.setBounds(286, 442, 12, 36);
		contentPane.add(lblE_1);
		
		JLabel label_9 = new JLabel("\u00D1");
		label_9.setForeground(new Color(204, 0, 51));
		label_9.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_9.setBounds(308, 442, 12, 36);
		contentPane.add(label_9);
		
		JLabel lblA_3 = new JLabel("A");
		lblA_3.setForeground(new Color(0, 204, 0));
		lblA_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblA_3.setBounds(330, 442, 12, 36);
		contentPane.add(lblA_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Images\\Recurso1.png"));
		lblNewLabel.setBounds(49, 23, 395, 60);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("Images\\graphics_painting_colors_color_graficos_1757.png"));
		lblNewLabel_1.setBounds(96, 86, 303, 281);
		contentPane.add(lblNewLabel_1);
		
	  
		
	}
}
