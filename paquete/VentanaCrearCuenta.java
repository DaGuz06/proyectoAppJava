package paquete;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JLabel;

public class VentanaCrearCuenta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCrearCuenta frame = new VentanaCrearCuenta();
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
	public VentanaCrearCuenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_Atras = new JButton("Atrás");       
		btn_Atras.setFont(new Font("Arial", Font.PLAIN, 14));
		btn_Atras.setBounds(159, 171, 89, 23);
		contentPane.add(btn_Atras);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(212, 76, 105, 22);
		contentPane.add(textArea);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(214, 121, 103, 20);
		contentPane.add(passwordField_1);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(99, 79, 54, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setFont(new Font("Arial", Font.PLAIN, 16));
		lblContrasea.setBounds(99, 124, 81, 14);
		contentPane.add(lblContrasea);
		
		JLabel lblCrearCuenta = new JLabel("Crear cuenta");
		lblCrearCuenta.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCrearCuenta.setBounds(145, 21, 117, 25);
		contentPane.add(lblCrearCuenta);
		
		JButton btn_Crear = new JButton("Crear");
		btn_Crear.setFont(new Font("Arial", Font.PLAIN, 14));
		btn_Crear.setBounds(159, 205, 89, 23);
		contentPane.add(btn_Crear);
		
		
		btn_Atras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaInicio ventanaInicio = new VentanaInicio();
                ventanaInicio.setVisible(true);
                dispose();
            }
        });
		
	}
}
