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
		
		//Botones
		//Boton de historial
		JButton btnHistorial = new JButton("Historial");
		btnHistorial.setBounds(180, 174, 89, 23);
		contentPane.add(btnHistorial);
		//Boton mostrar resultado
		JButton btnMostrar = new JButton("Mostrar resultado");
		btnMostrar.setBounds(149, 140, 152, 23);
		contentPane.add(btnMostrar);
		
		//LABELS
		//Label titulo
		JLabel lblTitulo = new JLabel("IpInfo");
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTitulo.setBounds(195, 11, 50, 41);
		contentPane.add(lblTitulo);
		//Label Introduzca la IP
		JLabel lblIntroduzca = new JLabel("Introduzca la IP");
		lblIntroduzca.setFont(new Font("Arial", Font.PLAIN, 16));
		lblIntroduzca.setBounds(65, 93, 111, 14);
		contentPane.add(lblIntroduzca);
		
		//Campo de texto
		//Campo de ingresar IP
		JTextArea txtIngresar = new JTextArea();
		txtIngresar.setBounds(234, 88, 127, 22);
		contentPane.add(txtIngresar);
		
		
	}
}
