package paquete;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Ventana_Identificarse extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    
    public static boolean pulsado = false;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Ventana_Identificarse frame = new Ventana_Identificarse();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Ventana_Identificarse() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 300);
        setTitle("IP Tracker");

        setLocationRelativeTo(null);
        setResizable(false);

        // Panel principal con diseño absoluto
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(null); // Layout absoluto
        setContentPane(contentPane);

        // Botón Iniciar sesión
        JButton btn_Sesion = new JButton("Iniciar sesión");
        btn_Sesion.setFont(new Font("Arial", Font.PLAIN, 15));
        btn_Sesion.setBounds(10, 108, 183, 30);
        contentPane.add(btn_Sesion);

        // Botón Crear cuenta
        JButton btn_Crear = new JButton("Crear cuenta");
        btn_Crear.setFont(new Font("Arial", Font.PLAIN, 15));
        btn_Crear.setBounds(10, 57, 183, 30);
        contentPane.add(btn_Crear);

        // Botón Continuar sin cuenta
        JButton btnSinCuenta = new JButton("Continuar sin cuenta");
        btnSinCuenta.setFont(new Font("Arial", Font.PLAIN, 15));
        btnSinCuenta.setBounds(10, 162, 183, 30);
        contentPane.add(btnSinCuenta);
       
        
        JLabel lblfondo = new JLabel("");
        lblfondo.setBounds(0, 0, 434, 261);
        lblfondo.setFont(new Font("Arial", Font.BOLD, 18));
        contentPane.add(lblfondo);
        contentPane.setLayout(null);
        ImageIcon icono2= new ImageIcon(Ventana_Identificarse.class.getResource("/img/fondoHacker.jpeg"));
        Image imagen2 = icono2.getImage().getScaledInstance( lblfondo.getWidth(),lblfondo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon iconoAjustado2 = new ImageIcon(imagen2);
        lblfondo.setIcon(iconoAjustado2);

        // Acciones de los botones
        btn_Sesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	pulsado = false;
                Ventana_IniciarSesion ventanaSesion = new Ventana_IniciarSesion();
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

        btnSinCuenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	pulsado = true;
                Ventana_IntroducirIP menuInicio = new Ventana_IntroducirIP();
                menuInicio.setVisible(true);
                dispose();
            }
        });
    }
}


//CON decorate se puede dejar fija