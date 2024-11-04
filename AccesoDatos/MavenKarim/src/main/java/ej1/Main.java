// Karim Zinnatullin
package ej1;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Introduce la IP de la base de datos: ");
		String dbIp = input.nextLine();
		System.out.print("Introduce el nombre de usuario de la base de datos: ");
		String dbUsuario = input.nextLine();
		System.out.print("Introduce la contraseña de la base de datos: ");
		String dbContraseña = input.nextLine();
		String dbUrl = "jdbc:mysql://" + dbIp + "/reparaciones";
		System.out.println("Dale a ENTER...");
		input.nextLine();

		try {
			Connection conn = DriverManager.getConnection(dbUrl, dbUsuario, dbContraseña);
			int opcion;
			do {
				System.out.println("--------------------------------------");
				System.out.println("Que deseas hacer:");
				System.out.println("1-Mostrar todos los clientes");
				System.out.println("2-Alta de cliente");
				System.out.println("3-consultar cliente y sus incidencias");
				System.out.println("4-Actualizar cliente");
				System.out.println("5-Nueva incidencia");
				System.out.println("6-Borrar un cliente");
				System.out.println("0-Salir");
				opcion = input.nextInt();
				input.nextLine();
				switch (opcion) {
				case 1:
					mostrarClientes(conn);
					break;
				case 2:
					altaCliente(conn, input);
					break;
				case 3:
					consultaCliente(conn, input);
					break;
				case 4:
					actualizarCliente(conn, input);
					break;
				case 5:
					agregarIncidencia(conn, input);
					break;
				case 6:
					borrarCliente(conn, input);
					break;
				case 0:
					System.out.println("Hasta luego!");
					conn.close();
					break;
				default:
					System.out.println("Error: opción incoherente.");
					break;
				}
				if (opcion != 0) {
					System.out.println("Dale a ENTER para continuar...");
					input.nextLine();
				}
			} while (opcion != 0);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		input.close();
	}

	public static void borrarCliente(Connection conn, Scanner input) {
		System.out.println("Dime el nombre completo del cliente que deseas borrar:");
		String nombre = input.nextLine();
		input.nextLine();
		// borrado de las incidencias del cliente
		String sqlDeleteIncidencias = "DELETE FROM Ordenes WHERE codigo_cliente = (SELECT codigo FROM Clientes WHERE nombre = ?)";
		// borrado del cliente en si
		String sqlDeleteCliente = "DELETE FROM Clientes WHERE nombre = ?";

		try {
			conn.setAutoCommit(false);

			// Eliminar las incidencias
			try (PreparedStatement pstmtDeleteIncidencias = conn.prepareStatement(sqlDeleteIncidencias)) {
				pstmtDeleteIncidencias.setString(1, nombre);
				int filasBorradasIncidencias = pstmtDeleteIncidencias.executeUpdate();
				System.out.println("Incidencias: " + filasBorradasIncidencias);
			}

			// Eliminar el cliente
			try (PreparedStatement pstmtDeleteCliente = conn.prepareStatement(sqlDeleteCliente)) {
				pstmtDeleteCliente.setString(1, nombre);
				int filasBorradasCliente = pstmtDeleteCliente.executeUpdate();

				if (filasBorradasCliente > 0) {
					System.out.println("Cliente preparado para borrarse.");
				} else {
					System.out.println("No se encontró ningún cliente con el nombre: " + nombre);
				}
			}

			// Confirmar la transacción
			System.out.println("Seguro que quieres borrarlo? 1-SI 0-NO");
			int confirmar = input.nextInt();
			if (confirmar == 1) {
				conn.commit();
				System.out.println("Cliente " + nombre + " borrado con éxito");
			} else {
				conn.rollback();
				System.out.println("Canelado el borrado de " + nombre);
			}
		} catch (SQLException e) {
			try {
				// Revertir los cambios en caso de error
				conn.rollback();
				System.out.println("Error al borrar el cliente. Se han revertido los cambios.");
			} catch (SQLException rollbackEx) {
				rollbackEx.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				// Restaurar el autocommit
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void mostrarClientes(Connection conn) {
		System.out.println("Mostrando todos los clientes:");
		String sql = "SELECT * FROM Clientes";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("--------");
				System.out.println("Código: " + rs.getString("codigo"));
				System.out.println("Nombre: " + rs.getString("nombre"));
				System.out.println("Teléfono: " + rs.getString("telefono"));
				System.out.println("Saldo: " + rs.getFloat("saldo"));
			}
			System.out.println("------------------------");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void actualizarCliente(Connection conn, Scanner input) {
		System.out.println("Dime el nombre completo del cliente que deseas actualizar:");
		String nombre = input.nextLine();
		String sql1 = "SELECT * FROM Clientes WHERE nombre = ?";

		try (PreparedStatement pstmt1 = conn.prepareStatement(sql1)) {
			pstmt1.setString(1, nombre);
			ResultSet rs1 = pstmt1.executeQuery();

			if (rs1.next()) {
				// Muestra los datos actuales del cliente
				System.out.println("Cliente encontrado:");
				System.out.println("Código: " + rs1.getString("codigo"));
				System.out.println("Nombre: " + rs1.getString("nombre"));
				System.out.println("Teléfono: " + rs1.getString("telefono"));
				System.out.println("Saldo: " + rs1.getFloat("saldo"));
				System.out.println("--------------------------");

				// Solicitar nuevos datos
				System.out.println("Dime el nuevo teléfono del cliente:");
				String nuevoTelefono = input.nextLine();

				System.out.println("Dime el nuevo saldo del cliente:");
				double nuevoSaldo = input.nextDouble();
				input.nextLine();

				String sql2 = "UPDATE Clientes SET telefono = ?, saldo = ? WHERE nombre = ?";

				try (PreparedStatement pstmt2 = conn.prepareStatement(sql2)) {
					pstmt2.setString(1, nuevoTelefono);
					pstmt2.setDouble(2, nuevoSaldo);
					pstmt2.setString(3, nombre);

					int filasActualizadas = pstmt2.executeUpdate();

					if (filasActualizadas > 0) {
						System.out.println("Datos del cliente actualizados con éxito.");
					} else {
						System.out.println("No se encontró ningún cliente con el nombre: " + nombre);
					}
				} catch (SQLException e) {
					System.out.println("Error al actualizar los datos del cliente.");
					e.printStackTrace();
				}
			} else {
				System.out.println("No se encontró ningún cliente con el nombre: " + nombre);
			}
		} catch (SQLException e) {
			System.out.println("Error al consultar el cliente.");
			e.printStackTrace();
		}
	}

	public static void consultaCliente(Connection conn, Scanner input) {
		System.out.println("Dime el nombre completo del cliente:");
		String nombre = input.nextLine();

		String sqlCliente = "SELECT * FROM Clientes WHERE nombre = ?";
		String sqlIncidencias = "SELECT * FROM Ordenes WHERE codigo_cliente = (SELECT codigo FROM Clientes WHERE nombre = ?)";

		try (PreparedStatement pstmtCliente = conn.prepareStatement(sqlCliente)) {
			pstmtCliente.setString(1, nombre);
			ResultSet rsCliente = pstmtCliente.executeQuery();

			if (rsCliente.next()) {
				// Mostrar datos del cliente
				System.out.println("Cliente encontrado:");
				System.out.println("Código: " + rsCliente.getString("codigo"));
				System.out.println("Nombre: " + rsCliente.getString("nombre"));
				System.out.println("Teléfono: " + rsCliente.getString("telefono"));
				System.out.println("Saldo: " + rsCliente.getFloat("saldo"));
				System.out.println("--------------------------");

				// Consultar incidencias del cliente
				try (PreparedStatement pstmtIncidencias = conn.prepareStatement(sqlIncidencias)) {
					pstmtIncidencias.setString(1, nombre);
					ResultSet rsIncidencias = pstmtIncidencias.executeQuery();

					if (rsIncidencias.next()) {
						// Mostrar las incidencias
						System.out.println("Incidencias del cliente:");
						do {
							System.out.println("Código Incidencia: " + rsIncidencias.getInt("codigo_incidencia"));
							System.out.println("Asunto: " + rsIncidencias.getString("asunto"));
							System.out.println("Descripción: " + rsIncidencias.getString("descripcion"));
							System.out.println("Fecha Apertura: " + rsIncidencias.getDate("fecha_apertura"));
							System.out.println("Fecha Cierre: " + rsIncidencias.getDate("fecha_cierre"));
							System.out.println("Importe: " + rsIncidencias.getBigDecimal("importe"));
							System.out.println("--------------------------");
						} while (rsIncidencias.next());
					} else {
						System.out.println("No hay incidencias registradas para este cliente.");
					}
				}
			} else {
				System.out.println("No se encontró ningún cliente con el nombre: " + nombre);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void altaCliente(Connection conn, Scanner input) {
		// pidiendo datos del cliente
		System.out.println("Dime el nombre completo del cliente:");
		String nombre = input.nextLine();
		System.out.println("Dime el teléfono del cliente:");
		String telefono = input.nextLine();
		input.nextLine();
		System.out.println("Dime el saldo actual del cliente:");
		float saldo = input.nextFloat();

		String sql = "INSERT INTO Clientes (nombre, telefono,saldo) VALUES (?, ?, ?)";
		// dandolo de alta
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, nombre);
			pstmt.setString(2, telefono);
			pstmt.setFloat(3, saldo);
			pstmt.executeUpdate();
			System.out.println("Cliente agregado: " + nombre);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void agregarIncidencia(Connection conn, Scanner input) {
		System.out.println("Dale a ENTER...");
		input.nextLine();
		// pidiendo datos
		System.out.println("Dime el código de la incidencia:");
		int codigoIncidencia = input.nextInt();
		System.out.println("Dime el código de cliente");
		int codigoCliente = input.nextInt();
		input.nextLine();
		System.out.println("Describe brevemente el asunto de la incidencia:");
		String asunto = input.nextLine();
		System.out.println("Ahora, la descripción:");
		String descripcion = input.nextLine();
		input.nextLine();

		// pidiendo la fecha de apertura
		System.out.println("Fecha de APERTURA, año:");
		int anyoApertura = input.nextInt();
		System.out.println("Fecha de APERTURA, mes:");
		int mesApertura = input.nextInt();
		System.out.println("Fecha de APERTURA, dia:");
		int diaApertura = input.nextInt();
		LocalDate localFechaApertura = LocalDate.of(anyoApertura, mesApertura, diaApertura);
		Date fechaApertura = Date.valueOf(localFechaApertura);

		// pidiendo la fecha de cierre
		System.out.println("Fecha de CIERRE, año:");
		int anyoCierre = input.nextInt();
		System.out.println("Fecha de CIERRE, mes:");
		int mesCierre = input.nextInt();
		System.out.println("Fecha de CIERRE, dia:");
		int diaCierre = input.nextInt();
		input.nextLine();
		LocalDate localFechaCierre = LocalDate.of(anyoCierre, mesCierre, diaCierre);
		Date fechaCierre = Date.valueOf(localFechaCierre);

		// pidiendo el importe
		System.out.println("Cual es el importe a pagar?");
		double importe = input.nextDouble();
		String sql = "INSERT INTO Ordenes (codigo_incidencia, codigo_cliente, asunto, descripcion, fecha_apertura, fecha_cierre, importe) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, codigoIncidencia);
			pstmt.setInt(2, codigoCliente);
			pstmt.setString(3, asunto);
			pstmt.setString(4, descripcion);
			pstmt.setDate(5, fechaApertura);
			pstmt.setDate(6, fechaCierre);
			pstmt.setDouble(7, importe);
			pstmt.executeUpdate();
			System.out.println("Incidencia agregada: " + asunto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
