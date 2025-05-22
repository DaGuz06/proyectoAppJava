package paquete;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ventana_Historial extends JFrame {

    private JPanel contentPane;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Ventana_Historial frame = new Ventana_Historial();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Ventana_Historial() {
    	setResizable(false);
        setTitle("IPTracker");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 10));

        // Título
        JLabel lblTitulo = new JLabel("Historial de Búsquedas");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblTitulo, BorderLayout.NORTH);

        // Tabla para mostrar los datos
        table = new JTable();
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25);
        
        // Modelo de tabla sin celdas editables
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setModel(model);
        
        // Columnas de la tabla
        model.addColumn("ID");
        model.addColumn("IP");
        model.addColumn("Hostname");
        model.addColumn("Ciudad");
        model.addColumn("País");
        model.addColumn("Coordenadas");
        model.addColumn("Fecha");

        JScrollPane scrollPane = new JScrollPane(table);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(e -> cargarHistorial());
        panelBotones.add(btnActualizar);
        
        JButton btnEliminar = new JButton("Eliminar seleccionado");
        btnEliminar.addActionListener(e -> eliminarRegistro());
        panelBotones.add(btnEliminar);
        
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> {
            Ventana_IntroducirIP ventana = new Ventana_IntroducirIP();
            ventana.setVisible(true);
            dispose();
        });
        panelBotones.add(btnVolver);

        contentPane.add(panelBotones, BorderLayout.SOUTH);

        // Cargar datos al iniciar
        cargarHistorial();
    }

    private void cargarHistorial() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Limpiar tabla
        
        try {
            ClaseConexion.conexion.conectar();
            
            // Obtener ID del usuario logueado
            String usuario = Ventana_IniciarSesion.txtNombre.getText();
            String consultaUsuario = "SELECT id FROM tb_user WHERE nombre_usuario = '" + usuario + "'";
            ResultSet rsUsuario = ClaseConexion.conexion.ejecutarSelect(consultaUsuario);
            
            if (rsUsuario.next()) {
                int usuarioID = rsUsuario.getInt("id");
                
                // Consulta para obtener el historial del usuario
                String consulta = "SELECT * FROM historial_ips WHERE usuario_id = " + usuarioID + " ORDER BY fecha DESC";
                ResultSet rs = ClaseConexion.conexion.ejecutarSelect(consulta);
                
                while (rs.next()) {
                    model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("ip"),
                        rs.getString("hostname"),
                        rs.getString("ciudad"),
                        rs.getString("pais"),
                        rs.getString("coordenadas"),
                        rs.getTimestamp("fecha")
                    });
                }
            }
            
            ClaseConexion.conexion.desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar el historial", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarRegistro() {
        int filaSeleccionada = table.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un registro para eliminar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(
            this, 
            "¿Está seguro de eliminar este registro?", 
            "Confirmar eliminación", 
            JOptionPane.YES_NO_OPTION
        );

        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                int id = (int) table.getValueAt(filaSeleccionada, 0);
                String consulta = "DELETE FROM historial_ips WHERE id = " + id;
                
                ClaseConexion.conexion.conectar();
                ClaseConexion.conexion.ejecutarInsertDeleteUpdate(consulta);
                ClaseConexion.conexion.desconectar();
                
                cargarHistorial(); // Refrescar la tabla
                JOptionPane.showMessageDialog(this, "Registro eliminado correctamente");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al eliminar el registro", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}