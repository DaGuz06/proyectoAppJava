package paquete;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.json.JSONObject;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.swing.JTextArea;
import java.awt.Color;

public class Ventana_IntroducirIP extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    
    private String ipActual;
    private String hostnameActual;
    private String ciudadActual;
    private String paisActual;
    private String locActual;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ventana_IntroducirIP frame = new Ventana_IntroducirIP();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Ventana_IntroducirIP() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 503, 365);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setTitle("IP Tracker");

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        //Botones
        JButton btnHistorial = new JButton("Historial");
        btnHistorial.setBounds(330, 274, 89, 23);
        if(Ventana_Idenificarse.pulsado == true) {
            btnHistorial.setVisible(false);
        }
        contentPane.add(btnHistorial);
        
        JButton btnMostrar = new JButton("Mostrar resultado");
        btnMostrar.setBounds(168, 274, 152, 23);
        contentPane.add(btnMostrar);
        
        JButton btn_Atras = new JButton("Atrás");       
        btn_Atras.setBounds(69, 273, 89, 23);
        btn_Atras.setFont(new Font("Arial", Font.PLAIN, 14));
        contentPane.add(btn_Atras);
        
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(330, 63, 89, 24);
        if(Ventana_Idenificarse.pulsado == true) {
        	btnGuardar.setVisible(false);
        }
        contentPane.add(btnGuardar);
        
        //LABELS
        JLabel lblTitulo = new JLabel("IP Tracker");
        lblTitulo.setFont(new Font("Arial", Font.PLAIN, 20));
        lblTitulo.setBounds(189, 11, 132, 41);
        contentPane.add(lblTitulo);
        
        JLabel lblIntroduzca = new JLabel("Introduzca la IP:");
        lblIntroduzca.setFont(new Font("Arial", Font.PLAIN, 16));
        lblIntroduzca.setBounds(69, 66, 127, 14);
        contentPane.add(lblIntroduzca);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setBounds(112, 27, 46, 14);
        contentPane.add(lblNewLabel);
        
        //Campos de texto
        JTextArea txtIngresar = new JTextArea();
        txtIngresar.setBackground(new Color(191, 191, 191));
        txtIngresar.setBounds(189, 63, 127, 22);
        contentPane.add(txtIngresar);
        
        JTextArea areaResultado = new JTextArea();
        areaResultado.setBackground(new Color(191, 191, 191));
        areaResultado.setBounds(69, 91, 350, 149);
        areaResultado.setMargin(new Insets(5, 10, 5, 5));
        contentPane.add(areaResultado);
        areaResultado.setEditable(false);
        
        //METODOS
        btnHistorial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Ventana_Historial Ventana_Historial = new Ventana_Historial();
                Ventana_Historial.setVisible(true);
                dispose();
            } 
        });
        
        btn_Atras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Ventana_Idenificarse Ventana_Registrarse = new Ventana_Idenificarse();
                Ventana_Registrarse.setVisible(true);
                dispose();
            }
        });
        
        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ip = txtIngresar.getText();
                String urlStr = "https://ipinfo.io/" + ip + "/json";

                try {
                    URL url = new URL(urlStr);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("GET");

                    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    StringBuilder contenido = new StringBuilder();
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        contenido.append(inputLine);
                    }
                    in.close();
                    con.disconnect();

                    JSONObject json = new JSONObject(contenido.toString());
                    
                    ipActual = json.optString("ip", "N/A");
                    hostnameActual = json.optString("hostname", "N/A");
                    ciudadActual = json.optString("city", "N/A");
                    paisActual = json.optString("country", "N/A");
                    locActual = json.optString("loc", "N/A");

                    String resultado = "";
                    resultado += "IP: " + ipActual + "\n";
                    resultado += "Hostname: " + hostnameActual + "\n";
                    resultado += "Ciudad: " + ciudadActual + "\n";
                    resultado += "País: " + paisActual + "\n";
                    resultado += "Ubicación: " + locActual;

                    areaResultado.setText(resultado);

                } catch (Exception ex) {
                    ex.printStackTrace();
                    areaResultado.setText("Error al obtener la info de la IP");
                }
            }
        });
        
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = Ventana_IniciarSesion.txtNombre.getText();
                String contrasena = Ventana_IniciarSesion.txtPass.getText();
                
                try {
                    ClaseConexion.conexion.conectar();
                    
                    String consultaUsuario = "SELECT id FROM tb_user WHERE nombre_usuario = '"+usuario+"' AND contrasena = '"+contrasena+"'";
                    ResultSet rs = ClaseConexion.conexion.ejecutarSelect(consultaUsuario);
                    
                    int usuarioID = -1;
                    if(rs.next()) {
                        usuarioID = rs.getInt("id");
                    }
                    
                    String sentenciaSQL = "INSERT INTO historial_ips (`usuario_id`, `ip`, `hostname`, `ciudad`, `pais`, `coordenadas`) " +
                                       "VALUES ('"+usuarioID+"', '"+ipActual+"', '"+hostnameActual+"', '"+ciudadActual+"', '"+paisActual+"', '"+locActual+"')";
                    
                    ClaseConexion.conexion.ejecutarInsertDeleteUpdate(sentenciaSQL);
                    ClaseConexion.conexion.desconectar();
                    
                    JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
                    
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al guardar los datos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}