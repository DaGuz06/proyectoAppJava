package paquete;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;

public class MenuInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuInicio frame = new MenuInicio();
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
	public MenuInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGuardar = new JButton("Historial");
		btnGuardar.setBounds(180, 174, 89, 23);
		contentPane.add(btnGuardar);
		
		JLabel lblNewLabel = new JLabel("IpInfo");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(195, 11, 50, 41);
		contentPane.add(lblNewLabel);
		
		JTextArea txtIngresar = new JTextArea();
		txtIngresar.setBounds(234, 88, 127, 22);
		contentPane.add(txtIngresar);
		
		JLabel lblNewLabel_1 = new JLabel("Introduzca la IP");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(65, 93, 111, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnContinuar = new JButton("Mostrar resultado");
		btnContinuar.setBounds(163, 136, 117, 23);
		contentPane.add(btnContinuar);
	}
}
