package paquete;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ClaseInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClaseInicio frame = new ClaseInicio();
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
	public ClaseInicio() {
		setTitle("IPTracker");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton inicio = new JButton("INICIAR");
		inicio.setFont(new Font("Arial", Font.BOLD, 14));
		inicio.setBounds(158, 72, 117, 29);
		contentPane.add(inicio);
		
		JLabel bienvenido = new JLabel("Bienvenido a IPTracker");
		bienvenido.setFont(new Font("Arial", Font.BOLD, 20));
		bienvenido.setBounds(115, 31, 226, 16);
		contentPane.add(bienvenido);
		
		JLabel lblIcono = new JLabel("New label");
		lblIcono.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcono.setIcon(new ImageIcon(ClaseInicio.class.getResource("/img/fondo_inicio.jpg")));
		lblIcono.setBounds(-178, -183, 835, 647);
		contentPane.add(lblIcono);

		// Acción del botón para abrir Ventana_Idenificarse y cerrar esta ventana
		inicio.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				Ventana_Identificarse ventana = new Ventana_Identificarse();
				ventana.setVisible(true);
				dispose(); // Cierra la ventana actual
			}
		});
	}
}
