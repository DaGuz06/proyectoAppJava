package paquete;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

public class inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inicio frame = new inicio();
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
	public inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton inicio = new JButton("Inicio");
		inicio.setBounds(158, 168, 117, 29);
		contentPane.add(inicio);
		
		JLabel bienvenido = new JLabel("Bienvenido a IPTracker");
		bienvenido.setBounds(144, 30, 169, 16);
		contentPane.add(bienvenido);

		// Acción del botón para abrir Ventana_Idenificarse y cerrar esta ventana
		inicio.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				Ventana_Idenificarse ventana = new Ventana_Idenificarse();
				ventana.setVisible(true);
				dispose(); // Cierra la ventana actual
			}
		});
	}
}
