package paquete;

import java.sql.SQLException;

import javax.swing.SwingUtilities;

public class ClaseMain {

	public static void main(String[] args) {
		
        ConexionMySQL conexion = new ConexionMySQL("sql8776140", "eWvluFRBBa", "sql8776140");
        
        try {
            conexion.conectar();
            System.out.println("Conexión exitosa!");
            conexion.desconectar();
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
