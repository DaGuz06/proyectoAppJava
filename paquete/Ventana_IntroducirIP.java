	package paquete;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONObject;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;


import javax.swing.JTextArea;
import java.awt.Color;

public class Ventana_IntroducirIP extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public Ventana_IntroducirIP() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 365);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("GeoIpScan");

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Botones
		//Boton de historial
		JButton btnHistorial = new JButton("Historial");
		btnHistorial.setBounds(330, 274, 89, 23);
		if(Ventana_Idenificarse.pulsado == true) {
			btnHistorial.setVisible(false);
		}
		contentPane.add(btnHistorial);
		//Boton mostrar resultado
		JButton btnMostrar = new JButton("Mostrar resultado");
		btnMostrar.setBounds(168, 274, 152, 23);
		contentPane.add(btnMostrar);
		
		//Boton ir hacia atrás
		JButton btn_Atras = new JButton("Atrás");       
		btn_Atras.setBounds(69, 273, 89, 23);
		btn_Atras.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(btn_Atras);
		
		//LABELS
		//Label titulo
		JLabel lblTitulo = new JLabel("GeoIpScan");
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTitulo.setBounds(189, 11, 132, 41);
		contentPane.add(lblTitulo);
		//Label Introduzca la IP
		JLabel lblIntroduzca = new JLabel("Introduzca la IP:");
		lblIntroduzca.setFont(new Font("Arial", Font.PLAIN, 16));
		lblIntroduzca.setBounds(95, 66, 127, 14);
		contentPane.add(lblIntroduzca);
		
		//Campo de texto
		//Campo de ingresar IP
		JTextArea txtIngresar = new JTextArea();
		txtIngresar.setBackground(new Color(191, 191, 191));
		txtIngresar.setBounds(243, 63, 127, 22);
		contentPane.add(txtIngresar);
		
		JTextArea areaResultado = new JTextArea();
		areaResultado.setBackground(new Color(191, 191, 191));
		areaResultado.setBounds(69, 91, 350, 149);
		areaResultado.setMargin(new Insets(5, 10, 5, 5));
		contentPane.add(areaResultado);
		areaResultado.setEditable(false);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(112, 27, 46, 14);
		contentPane.add(lblNewLabel);
		
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

		            // Parsear JSON
		            JSONObject json = new JSONObject(contenido.toString());

		            String resultado = "";
		            resultado += "IP: " + json.optString("ip", "N/A") + "\n";
		            resultado += "Hostname: " + json.optString("hostname", "N/A") + "\n";
		            resultado += "Ciudad: " + json.optString("city", "N/A") + "\n";
		            resultado += "País: " + json.optString("country", "N/A") + "\n";
		            resultado += "Ubicación: " + json.optString("loc", "N/A") + "\n";
		            resultado += "Organización: " + json.optString("org", "N/A") + "\n";
		            resultado += "Zona horaria: " + json.optString("timezone", "N/A");
		            
		            String sentenciaSQL = "INSERT INTO tb_ip (`nombre_usuario`, `contrasena`) VALUES ('prueba', 'prueba')";

		            areaResultado.setText(resultado);

		        } catch (Exception ex) {
		            ex.printStackTrace();
		            areaResultado.setText("Error al obtener la info de la IP");
		        }
		    }
		});

		
		
	}
}
