package paquete;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Ventana_Idenificarse extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    
    public static boolean pulsado = false;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Ventana_Idenificarse frame = new Ventana_Idenificarse();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Ventana_Idenificarse() {
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

        // Título
        JLabel lb_titulo = new JLabel("IP Tracker");
        lb_titulo.setForeground(new Color(255, 255, 255));
        lb_titulo.setFont(new Font("Arial", Font.PLAIN, 20));
        lb_titulo.setBounds(56, 26, 105, 30);
        contentPane.add(lb_titulo);

        // Botón Iniciar sesión
        JButton btn_Sesion = new JButton("Iniciar sesión");
        btn_Sesion.setFont(new Font("Arial", Font.PLAIN, 15));
        btn_Sesion.setBounds(10, 80, 190, 30);
        contentPane.add(btn_Sesion);

        // Botón Crear cuenta
        JButton btn_Crear = new JButton("Crear cuenta");
        btn_Crear.setFont(new Font("Arial", Font.PLAIN, 15));
        btn_Crear.setBounds(10, 121, 190, 30);
        contentPane.add(btn_Crear);

        // Botón Continuar sin cuenta
        JButton btnSinCuenta = new JButton("Continuar sin cuenta");
        btnSinCuenta.setFont(new Font("Arial", Font.PLAIN, 15));
        btnSinCuenta.setBounds(10, 162, 190, 30);
        contentPane.add(btnSinCuenta);
        
        JLabel imgFondo = new JLabel("");
        imgFondo.setIcon(new ImageIcon(Ventana_Idenificarse.class.getResource("/img/verticalBanner.jpg")));
        imgFondo.setBounds(-192, -84, 642, 448);
        contentPane.add(imgFondo);

        // Acciones de los botones
        btn_Sesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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