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
            
            //DESCOMENTAR SI QUIERES PROBAR RAPIDO SI FUNCIONA la insercion de datos en la BBDD
            /*ClaseConexion.conexion.conectar();
            String SQL = "INSERT INTO tb_user (`nombre_usuario`, `contrasena`) VALUES ('prueba', 'prueba')";
            ClaseConexion.conexion.ejecutarInsertDeleteUpdate(SQL);
            ClaseConexion.conexion.desconectar();*/
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	    //Llama a la ventana INICIO
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ClaseInicio ventana = new ClaseInicio();
                ventana.setVisible(true);
            }
        });
        
        
        
	}

}