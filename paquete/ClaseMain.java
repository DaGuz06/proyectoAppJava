package paquete;

import java.sql.SQLException;

import javax.swing.SwingUtilities;

public class ClaseMain {

	public static void main(String[] args) {
		
	    try {
	        ClaseConexion.conexion.conectar();
	        System.out.println("Conexión exitosa!");
	        ClaseConexion.conexion.desconectar();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaInicio ventana = new VentanaInicio();
                ventana.setVisible(true);
            }
        });
        
        

	}

}
