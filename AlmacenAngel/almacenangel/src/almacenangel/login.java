package almacenangel;

import Conexion;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField usuario;
	private JPasswordField contra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usuario = new JTextField();
		usuario.setToolTipText("Usuario");
		usuario.setBounds(157, 76, 116, 22);
		contentPane.add(usuario);
		usuario.setColumns(10);
		
		contra = new JPasswordField();
		contra.setToolTipText("contra");
		contra.setHorizontalAlignment(SwingConstants.CENTER);
		contra.setBounds(164, 147, 109, 22);
		contentPane.add(contra);
		
		JButton ingresar = new JButton("Ingresar");
		ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user = usuario.getText();
				String cont = contra.getText();
				
			}
		});
		ingresar.setBounds(164, 202, 97, 25);
		contentPane.add(ingresar);
	}
}
