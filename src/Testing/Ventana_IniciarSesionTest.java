package Testing;

import static org.junit.Assert.*;

import javax.swing.SwingUtilities;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import paquete.Ventana_IniciarSesion;

public class Ventana_IniciarSesionTest {

    private Ventana_IniciarSesion ventana;

    @Before
    public void setUp() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            ventana = new Ventana_IniciarSesion();
            ventana.setVisible(false); // Evita que se muestre la ventana durante los tests
        });
    }

    @After
    public void tearDown() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            ventana.dispose(); // Libera recursos de la ventana
        });
    }

    @Test
    public void testCamposInicialesEstanVacios() {
        assertEquals("", Ventana_IniciarSesion.txtNombre.getText());
        assertEquals("", new String(Ventana_IniciarSesion.txtPass.getPassword()));
    }

    @Test
    public void testEscribirEnCampos() {
        Ventana_IniciarSesion.txtNombre.setText("usuarioTest");
        Ventana_IniciarSesion.txtPass.setText("clave123");

        assertEquals("usuarioTest", Ventana_IniciarSesion.txtNombre.getText());
        assertEquals("clave123", new String(Ventana_IniciarSesion.txtPass.getPassword()));
    }

    @Test
    public void testAtrasPulsadoPorDefectoEsFalse() {
        assertFalse(Ventana_IniciarSesion.atrasPulsado);
    }
}
