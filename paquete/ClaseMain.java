package paquete;

import java.sql.SQLException;

import javax.swing.SwingUtilities;

public class ClaseMain {

	public static void main(String[] args) {
		
		
		//Se conecta a la base de datos y mustra por consola si fuciona o no
	    try {
	        
            ClaseConexion.conexion.conectar();
            System.out.println("Conexión exitosa!");
            ClaseConexion.conexion.desconectar();
            
            //DESCOMENTAR SI QUIERES PROBAR RAPIDO SI FUNCIONA
            /*ClaseConexion.conexion.conectar();
            String SQL = "INSERT INTO tb_usuarios (`user`, `password`) VALUES ('Lolo', 'admin')";
            ClaseConexion.conexion.ejecutarInsertDeleteUpdate(SQL);
            ClaseConexion.conexion.desconectar();*/
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	    //Lama a la ventana INICIO
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaInicio ventana = new VentanaInicio();
                ventana.setVisible(true);
            }
        });
        
        
        
	}

}
