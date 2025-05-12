package paquete;

public class ClaseConexion {
	
	//se usa static para no estar creando instancias y que se pueda usar de forma global en toda la aplicacion
    public static ConexionPostgreSQL conexion = new ConexionPostgreSQL(
        /*usuario*/"neondb_owner",
        /*contraseña*/"npg_XfWl7CHkgc0j",
        /*nombre bbdd*/"neondb"
    );
}
