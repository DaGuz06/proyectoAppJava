package paquete;

public class ControlSesion {
	//Hay usuario logueado?
	public static boolean usuarioLogueado = false;
	//Guarda el nombre del usuario
	public static String nombreUsuario = null;
	
	public static void sesionIniciada(String usuario) {
		
		//PREGUNTAR A ANTONIO. DA ERROR DE QUE NO ES VISIBLE. SE QUE ES PRIVATE PERO NO LO PUEDO PONER EN PUBLIC
		//nombreUsuario = Ventana_IniciarSesion.txtNombre.getText();
		
		//No se si esto tiene sentido alguno pero lo dejo
		if(nombreUsuario != null){
			usuarioLogueado = true;
		}else {
			usuarioLogueado = false;
		}

	}
}
