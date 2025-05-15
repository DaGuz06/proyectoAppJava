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
import java.sql.SQLException;

import javax.swing.JTextArea;
import javax.swing.JLabel;

public class VentanaCrearCuenta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField txtPass;

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
		setTitle("GeoIpScan");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Campos de texto
		//Campo de texto Usuario
		JTextArea txtNombre = new JTextArea();
		txtNombre.setBounds(212, 76, 105, 22);
		contentPane.add(txtNombre);
		//Campo de texto Contraseña
		txtPass = new JPasswordField();
		txtPass.setBounds(214, 121, 103, 20);
		contentPane.add(txtPass);
		
		//LABELS
		//Label campo usuario
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(76, 76, 89, 18);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		contentPane.add(lblNewLabel);
		//Label campo contraseña
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(76, 123, 89, 18);
		lblContrasea.setFont(new Font("Arial", Font.PLAIN, 16));
		contentPane.add(lblContrasea);
		//Label titulo Crear Cuenta
		JLabel lblCrearCuenta = new JLabel("Crear cuenta");
		lblCrearCuenta.setBounds(145, 21, 117, 25);
		lblCrearCuenta.setFont(new Font("Arial", Font.PLAIN, 20));
		contentPane.add(lblCrearCuenta);
		
		//BOTONES
		//Boton crear cuenta
		JButton btn_Crear = new JButton("Crear");
		btn_Crear.setBounds(159, 205, 89, 23);
		btn_Crear.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(btn_Crear);
		//Boton ir hacia atrás
		JButton btn_Atras = new JButton("Atrás");       
		btn_Atras.setBounds(159, 171, 89, 23);
		btn_Atras.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(btn_Atras);
		
		
		btn_Atras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Ventana_Idenificarse ventanaInicio = new Ventana_Idenificarse();
                ventanaInicio.setVisible(true);
                dispose();
            }
        });
		//Metodo para que cuando se pulse el boton "Crear" se meta los datos del usuario en la base de datos FUNCIONA
		btn_Crear.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 String usuario = txtNombre.getText();
				 String contrasena = txtPass.getText();
				 
				 //He comprobado que intercepta el campo de la contraseña y funciona
				 //System.out.print(usuario);
				 //System.out.print(contrasena);
				 //ingresa el nombre y contraseña que desee el usuario
				 
				 try {
			            ClaseConexion.conexion.conectar();
			            String SQL = "INSERT INTO tb_user (`nombre_usuario`, `contrasena`) VALUES ('"+usuario+"', '"+contrasena+"')";
			            ClaseConexion.conexion.ejecutarInsertDeleteUpdate(SQL);
			            ClaseConexion.conexion.desconectar();
				        
				    } catch (SQLException e1) {
				        e1.printStackTrace();
				    }
			 }
		 });
		
	}
}

