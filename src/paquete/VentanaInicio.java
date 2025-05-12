package paquete;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaInicio extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio frame = new VentanaInicio();
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
	public VentanaInicio() {
		setDefaultCloseOperation(VentanaInicio.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_titulo = new JLabel("IPinfo Crawler");
		lb_titulo.setFont(new Font("Arial", Font.PLAIN, 17));
		lb_titulo.setBounds(171, 11, 104, 63);
		contentPane.add(lb_titulo);
		
		JButton btn_Sesion = new JButton("Iniciar sesión");
		btn_Sesion.setFont(new Font("Arial", Font.PLAIN, 15));
		btn_Sesion.setBounds(60, 89, 123, 23);
		contentPane.add(btn_Sesion);
		
		JButton btn_Crear = new JButton("Crear cuenta");
		btn_Crear.setFont(new Font("Arial", Font.PLAIN, 15));
		btn_Crear.setBounds(257, 89, 123, 23);
		contentPane.add(btn_Crear);
		
		JButton btn_Sesion_1 = new JButton("Continuar sin cuenta");
		btn_Sesion_1.setFont(new Font("Arial", Font.PLAIN, 15));
		btn_Sesion_1.setBounds(138, 153, 174, 23);
		contentPane.add(btn_Sesion_1);
		
		 btn_Sesion.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                VentanaSesion ventanaSesion = new VentanaSesion();
	                ventanaSesion.setVisible(true);
	                dispose();
	            }
	        });
		 
		 btn_Crear.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                VentanaCrearCuenta ventanaCrearCuenta = new VentanaCrearCuenta();
	                ventanaCrearCuenta.setVisible(true);
	                dispose();
	            }
	        });
		 
		 
		
		
	}
}
