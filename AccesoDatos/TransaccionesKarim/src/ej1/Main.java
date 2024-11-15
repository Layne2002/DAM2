package ej1;

import java.sql.*;

public class Main {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/transacciones";
		String user = "root";
		String password = "karim2002";
		int codPed = 5;
		int codCli = 101;
		String direccion = "Calle Ejemplo 123";
		int codArt = 1;
		int cantidad = 5;
		int codRider = 2;

		try (Connection con = DriverManager.getConnection(url, user, password)) {
			con.setAutoCommit(false);

			mostrarDatosAntes(con, codPed, codRider);

			String insertarPedido = "INSERT INTO pedidos (Codped, Fecha, Codcli, Direccion, Codart, Cantidad) VALUES (?, ?, ?, ?, ?, ?)";
			try (PreparedStatement psPedido = con.prepareStatement(insertarPedido)) {
				psPedido.setInt(1, codPed);
				psPedido.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
				psPedido.setInt(3, codCli);
				psPedido.setString(4, direccion);
				psPedido.setInt(5, codArt);
				psPedido.setInt(6, cantidad);
				psPedido.executeUpdate();
			}

			String actualizarArticulo = "UPDATE articulos SET Existencias = Existencias - ? WHERE Codart = ?";
			try (PreparedStatement psArticulo = con.prepareStatement(actualizarArticulo)) {
				psArticulo.setInt(1, cantidad);
				psArticulo.setInt(2, codArt);
				psArticulo.executeUpdate();
			}

			String insertarEnvio = "INSERT INTO envios (Codped, Codrider, Terminado) VALUES (?, ?, ?)";
			try (PreparedStatement psEnvio = con.prepareStatement(insertarEnvio)) {
				psEnvio.setInt(1, codPed);
				psEnvio.setInt(2, codRider);
				psEnvio.setTimestamp(3, null);
				psEnvio.executeUpdate();
			}

			String actualizarRider = "UPDATE riders SET Disponible = 'N' WHERE Codigo = ?";
			try (PreparedStatement psRider = con.prepareStatement(actualizarRider)) {
				psRider.setInt(1, codRider);
				psRider.executeUpdate();
			}

			con.commit();
			System.out.println("Transacción completada exitosamente.");

			mostrarDatosDespues(con, codPed, codRider);

			RiderEntrega hiloEntrega = new RiderEntrega(url, user, password, codPed, codRider);
			hiloEntrega.start();

		} catch (Exception e) {
			e.printStackTrace();
			try (Connection con = DriverManager.getConnection(url, user, password)) {
				con.setAutoCommit(false);
				if (con != null) {
					con.rollback();
					System.out.println("Transacción deshecha (rollback).");
				}
			} catch (Exception rollbackEx) {
				rollbackEx.printStackTrace();
			}
		}
	}

	public static void mostrarDatosAntes(Connection con, int codPed, int codRider) throws SQLException {
		System.out.println("Datos antes de la transacción:");

		String consultaPedido = "SELECT * FROM pedidos WHERE Codped = ?";
		try (PreparedStatement psPedido = con.prepareStatement(consultaPedido)) {
			psPedido.setInt(1, codPed);
			try (ResultSet rsPedido = psPedido.executeQuery()) {
				while (rsPedido.next()) {
					System.out.println("Pedido: " + rsPedido.getInt("Codped") + ", Fecha: "
							+ rsPedido.getTimestamp("Fecha") + ", Codcli: " + rsPedido.getInt("Codcli")
							+ ", Direccion: " + rsPedido.getString("Direccion"));
				}
			}
		}

		String consultaRider = "SELECT * FROM riders WHERE Codigo = ?";
		try (PreparedStatement psRider = con.prepareStatement(consultaRider)) {
			psRider.setInt(1, codRider);
			try (ResultSet rsRider = psRider.executeQuery()) {
				while (rsRider.next()) {
					System.out.println("Rider: " + rsRider.getInt("Codigo") + ", Nombre: " + rsRider.getString("Nombre")
							+ ", Disponible: " + rsRider.getString("Disponible"));
				}
			}
		}
	}

	public static void mostrarDatosDespues(Connection con, int codPed, int codRider) throws SQLException {
		System.out.println("\nDatos después de la transacción:");

		String consultaPedido = "SELECT * FROM pedidos WHERE Codped = ?";
		try (PreparedStatement psPedido = con.prepareStatement(consultaPedido)) {
			psPedido.setInt(1, codPed);
			try (ResultSet rsPedido = psPedido.executeQuery()) {
				while (rsPedido.next()) {
					System.out.println("Pedido: " + rsPedido.getInt("Codped") + ", Fecha: "
							+ rsPedido.getTimestamp("Fecha") + ", Codcli: " + rsPedido.getInt("Codcli")
							+ ", Direccion: " + rsPedido.getString("Direccion") + ", Entregado: "
							+ rsPedido.getTimestamp("Entregado"));
				}
			}
		}

		String consultaRider = "SELECT * FROM riders WHERE Codigo = ?";
		try (PreparedStatement psRider = con.prepareStatement(consultaRider)) {
			psRider.setInt(1, codRider);
			try (ResultSet rsRider = psRider.executeQuery()) {
				while (rsRider.next()) {
					System.out.println("Rider: " + rsRider.getInt("Codigo") + ", Nombre: " + rsRider.getString("Nombre")
							+ ", Disponible: " + rsRider.getString("Disponible"));
				}
			}
		}
	}
}
