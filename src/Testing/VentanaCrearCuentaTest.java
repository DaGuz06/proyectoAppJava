package Testing;

import org.junit.Test;
import paquete.VentanaCrearCuenta;

import javax.swing.*;

import static org.junit.Assert.*;

public class VentanaCrearCuentaTest {

    @Test
    public void testVentanaNoEsNull() {
        VentanaCrearCuenta ventana = new VentanaCrearCuenta();
        assertNotNull("La ventana no debe ser null", ventana);
    }

    @Test
    public void testTituloVentana() {
        VentanaCrearCuenta ventana = new VentanaCrearCuenta();
        assertEquals("El título debe ser 'IP Tracker'", "IP Tracker", ventana.getTitle());
    }

    @Test
    public void testVentanaTieneContentPane() {
        VentanaCrearCuenta ventana = new VentanaCrearCuenta();
        assertNotNull("El contentPane no debe ser null", ventana.getContentPane());
    }

    @Test
    public void testVentanaEsInvisiblePorDefecto() {
        VentanaCrearCuenta ventana = new VentanaCrearCuenta();
        assertFalse("La ventana no debe ser visible por defecto", ventana.isVisible());
    }
}
