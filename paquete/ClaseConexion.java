package paquete;

public class ClaseConexion {
	
	//se usa static para no estar creando instancias y que se pueda usar de forma global en toda la aplicacion
	//Guarda ya las credenciales de la base de datos junto a Usuario y contraseña
	
    public static ConexionMySQL conexion = new ConexionMySQL(
    
    	/*usuario*/"root",
        /*contraseña*/"",
        /*nombre bbdd*/"test"
    );
}
