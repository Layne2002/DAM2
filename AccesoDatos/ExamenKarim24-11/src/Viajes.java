
// Karim Zinnatullin
// 25-11-2024
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Viajes {
	// datos de la conexión a la base de datos
	private static String dbUsuario = "root";
	private static String dbContraseña = "karim2002";
	private static String dbUrl = "jdbc:mysql://localhost/examenjdbc";

	// metodo que cuenta las plazas libres que hay en un viaje.
	// si el viaje no existe, devolverá un -1
	public static int plazasLibres(String destino) {
		int resultado = -1;
		try (Connection conn = DriverManager.getConnection(dbUrl, dbUsuario, dbContraseña)) {
			String consulta = "SELECT idviajes,totalplazas FROM viajes WHERE destino = ?";
			PreparedStatement ejecucion = conn.prepareStatement(consulta);
			ejecucion.setString(1, destino);
			ResultSet rs = ejecucion.executeQuery();

			// Si el viaje existe, seguimos
			if (rs.next()) {
				int idViaje = rs.getInt("idviajes");
				int totalPlazas = rs.getInt("totalplazas");

				// Hace un sumatorio de las plazas reservadas para ese viaje.
				// NO cuenta las plazas en estado "Esperando" o "Cancelado"
				consulta = "SELECT sum(plazas) as plazasReservadas FROM reservas WHERE numviaje = ?"
						+ " and estado = 'A'";
				ejecucion = conn.prepareStatement(consulta);
				ejecucion.setInt(1, idViaje);
				rs = ejecucion.executeQuery();
				if (rs.next()) {
					// Calculo de las plazas libres
					int plazasReservadas = rs.getInt("plazasReservadas");
					resultado = totalPlazas - plazasReservadas;

				}
			}
			// Devuelve el resultado calculado
			return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// devuelve un -1 si no se hizo nada
		return resultado;
	}

	// Metodo para crear un viaje
	public static void altaViaje(String destino, int totalPlazas) {
		try (Connection conn = DriverManager.getConnection(dbUrl, dbUsuario, dbContraseña)) {

			// Comprobando que el viaje no exista ya
			String sql1 = "SELECT * FROM viajes WHERE destino = ?";
			PreparedStatement ejecucion = conn.prepareStatement(sql1);
			ejecucion.setString(1, destino);
			ResultSet rs = ejecucion.executeQuery();
			if (rs.next()) {
				System.out.println("El destino " + destino + " ya existe, no se ha vuelto a crear");
			} else {
				// Una vez comprobado que no exista, se crea
				String sql2 = "INSERT INTO viajes ( destino, totalplazas) VALUES ( ?, ?)";
				PreparedStatement insert = conn.prepareStatement(sql2);
				insert.setString(1, destino);
				insert.setInt(2, totalPlazas);
				insert.executeUpdate();
				System.out.println("Viaje registrado con éxito.");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Metodo para crear una reserva nueva
	public static void crearReserva(int idcliente, Date fecha, int plazas, int idViaje) {
		try (Connection conn = DriverManager.getConnection(dbUrl, dbUsuario, dbContraseña)) {
			// Selecciona el nombre del viaje para usar el metodo de plazasLibres
			String sql1 = "SELECT destino FROM viajes WHERE idviajes = ?";
			PreparedStatement ejecucion = conn.prepareStatement(sql1);
			ejecucion.setInt(1, idViaje);
			ResultSet rs = ejecucion.executeQuery();
			if (rs.next()) {
				String destino = rs.getString("destino");
				// Calcula las plazas libres
				int plazasLibres = plazasLibres(destino);
				System.out.println("Plazas disponibles: " + plazasLibres);
				String estado;
				// Si hay plazas suficientes, asigna "Adjudicado", si no, "En espera"
				if (plazas < plazasLibres)
					estado = "A";
				else
					estado = "E";
				String sql2 = "INSERT INTO reservas ( idcliente,fecha,plazas,estado,numviaje) VALUES (?,?,?,?,?)";
				PreparedStatement insercion = conn.prepareStatement(sql2);
				insercion.setInt(1, idcliente);
				insercion.setDate(2, fecha);
				insercion.setInt(3, plazas);
				insercion.setString(4, estado);
				insercion.setInt(5, idViaje);
				insercion.executeUpdate();
				// Comprueba si se ha adjudicado o se ha quedado en espera
				if (estado.equals("A")) {
					System.out.println("Reserva adjudicada con éxito!");
				} else {
					System.out.println("Plazas insuficientes, reserva creada y a la espera!");
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// metodo para cancelar una reserva
	public static void cancelarReserva(int idReserva, int idcliente) {
		try (Connection conn = DriverManager.getConnection(dbUrl, dbUsuario, dbContraseña)) {
			// Llama al prodecimiento de la base de datos
			// (Código del procedimiento incluido en el proyecto)
			String sql = "{CALL cancelarReserva(?, ?)}";

			try (CallableStatement procedimiento = conn.prepareCall(sql)) {
				procedimiento.setInt(1, idReserva);
				procedimiento.setInt(2, idcliente);
				procedimiento.execute();
				System.out.println("Reserva cancelada exitosamente!");

			} catch (SQLException e) {
				System.out.println("Error al cancelar la reserva del cliente.");
				e.printStackTrace();
			}

		} catch (SQLException e) {
			System.out.println("Error al cancelar la reserva del cliente.");
			e.printStackTrace();
		}

	}
}
