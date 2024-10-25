
// Karim Zinnatullin
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String url = "jdbc:sqlite:basedatos.db";
		Connection conn = null;
		Scanner input = new Scanner(System.in);

		try {
			conn = DriverManager.getConnection(url);
			int opcion;
			System.out.println("Conexión establecida.");
			do {
				System.out.println("Que quieres hacer:\n1-Agregar a la agenda\n"
						+ "2-Consultar agenda\n \n3- Mostrar toda la Agenda\n0-Salir");
				opcion = input.nextInt();
				switch (opcion) {
				case 1: {
					agregarAgenda(input, conn);
					break;
				}
				case 2: {
					consultarAgenda(input, conn);
					break;
				}
				case 3: {
					mostrarTodo(conn);
					break;
				}
				case 0: {
					System.out.println("Hasta luego!");
					break;
				}
				default: {
					System.out.println("Elije una opción valida!");
					break;
				}
				}
				System.out.println("Dale a ENTER para continuar...");
				input.nextLine();

			} while (opcion != 0);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	private static void mostrarTodo(Connection conn) {
		String sql = "SELECT * FROM agenda";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				String telefono = rs.getString("telefono");
				String email = rs.getString("email");
				System.out.println("Nombre: " + nombre);
				System.out.println("Teléfono: " + telefono);
				System.out.println("Email: " + email);
				System.out.println("-------------");
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta: " + e.getMessage());
		}
	}

	private static void consultarAgenda(Scanner input, Connection conn) {
		System.out.println("Introduce el nombre del contacto que quieres consultar:");
		String nombre = input.next();

		String sql = "SELECT telefono, email FROM agenda WHERE nombre = ?";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, nombre);
			ResultSet rs = pstmt.executeQuery();

			// comprueba si se encuentra el contacto
			if (rs.next()) {
				String telefono = rs.getString("telefono");
				String email = rs.getString("email");
				System.out.println("Nombre: " + nombre);
				System.out.println("Teléfono: " + telefono);
				System.out.println("Email: " + email);
			} else {
				System.out.println("No se encontró el contacto: " + nombre);
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta: " + e.getMessage());
		}
	}

	public static void agregarAgenda(Scanner input, Connection conn) {
		System.out.println("Introduce el nombre:");
		String nombre = input.next();

		System.out.println("Introduce el teléfono (maximo 10 digitos):");
		String telefono = input.next();

		// Longitud maxima 10
		if (telefono.length() > 10) {
			System.out.println("El numero de telefono no puede tener más de 10 digitos.");
			return;
		}

		System.out.println("Introduce el email:");
		String email = input.next();

		String sql = "INSERT INTO agenda (nombre, telefono, email) VALUES (?, ?, ?)";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, nombre);
			pstmt.setString(2, telefono);
			pstmt.setString(3, email);
			pstmt.executeUpdate();
			System.out.println("Contacto agregado a la agenda.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
