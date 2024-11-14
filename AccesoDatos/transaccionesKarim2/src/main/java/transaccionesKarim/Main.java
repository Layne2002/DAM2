package transaccionesKarim;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Connection con = null;
        try {
            // Conectar a la BD y habilitar claves foráneas
            con = DriverManager.getConnection("jdbc:sqlite:transacciones.db");
            con.createStatement().execute("PRAGMA foreign_keys = ON");

            // Iniciar la transacción
            con.setAutoCommit(false);

            // 1. Registrar un nuevo pedido
            String insertPedido = "INSERT INTO pedidos (codped, fecha, codcli, direccion, codart, cantidad) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmtPedido = con.prepareStatement(insertPedido)) {
                stmtPedido.setInt(1, 1);
                stmtPedido.setDate(2, Date.valueOf(LocalDateTime.now().toLocalDate()));
                stmtPedido.setInt(3, 1001);  // Ejemplo de cliente
                stmtPedido.setString(4, "Calle Falsa 123");
                stmtPedido.setInt(5, 1);     // Ejemplo de codart
                stmtPedido.setInt(6, 10);    // Ejemplo de cantidad
                stmtPedido.executeUpdate();
            }

            // 2. Actualizar existencias en la tabla de artículos
            String updateArticulos = "UPDATE articulos SET existencias = existencias - ? WHERE codart = ?";
            try (PreparedStatement stmtArticulos = con.prepareStatement(updateArticulos)) {
                stmtArticulos.setInt(1, 10);
                stmtArticulos.setInt(2, 1);
                stmtArticulos.executeUpdate();
            }

            // 3. Registrar en la tabla de envíos
            String insertEnvio = "INSERT INTO envios (codped, codrider, terminado) VALUES (?, ?, NULL)";
            try (PreparedStatement stmtEnvios = con.prepareStatement(insertEnvio)) {
                stmtEnvios.setInt(1, 1);
                stmtEnvios.setInt(2, 1);  // Ejemplo de Rider asignado
                stmtEnvios.executeUpdate();
            }

            // Finalizar la transacción exitosamente
            con.commit();
            System.out.println("Transacción completada con éxito.");

            // Crear y ejecutar el hilo para notificar la entrega
            new Thread(() -> notificarEntrega(con, 1, 1)).start();

        } catch (SQLException e) {
            try {
                if (con != null) {
                    con.rollback();
                    System.out.println("Transacción fallida. Se ejecutó rollback.");
                }
            } catch (SQLException ex) {
                System.out.println("Error durante el rollback: " + ex.getMessage());
            }
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.setAutoCommit(true);
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para el hilo de entrega
    private static void notificarEntrega(Connection con, int codped, int codrider) {
        try {
            Thread.sleep(new Random().nextInt(5000) + 1000); // Tiempo aleatorio entre 1-6 segundos

            // Actualizar el pedido con la fecha y hora de entrega
            String updatePedido = "UPDATE pedidos SET fecha = ? WHERE codped = ?";
            try (PreparedStatement stmtPedido = con.prepareStatement(updatePedido)) {
                stmtPedido.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
                stmtPedido.setInt(2, codped);
                stmtPedido.executeUpdate();
            }

            // Marcar el rider como disponible
            String updateRider = "UPDATE riders SET disponible = ? WHERE codigo = ?";
            try (PreparedStatement stmtRider = con.prepareStatement(updateRider)) {
                stmtRider.setBoolean(1, true);
                stmtRider.setInt(2, codrider);
                stmtRider.executeUpdate();
            }

            System.out.println("Entrega notificada para el pedido " + codped);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
