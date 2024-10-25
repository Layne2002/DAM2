
// Karim Zinnatullin
import java.sql.*;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int opcion;

		System.out.print("Introduce la IP de la base de datos: ");
		String dbIp = input.nextLine();
		System.out.print("Introduce el nombre de usuario de la base de datos: ");
		String dbUsuario = input.nextLine();
		System.out.print("Introduce la contraseña de la base de datos: ");
		String dbContraseña = input.nextLine();

		String dbUrl = "jdbc:mysql://" + dbIp + "/sistema_usuarios";

		try (Connection conn = DriverManager.getConnection(dbUrl, dbUsuario, dbContraseña)) {
			do {
				System.out.println("Menú:");
				System.out.println("1. Alta de usuario");
				System.out.println("2. Entrada de usuario");
				System.out.println("3. Listado de entradas");
				System.out.println("4. Salir");
				System.out.print("Selecciona una opción: ");
				opcion = input.nextInt();

				input.nextLine();

				switch (opcion) {
				case 1:
					altaUsuario(input, conn);
					break;
				case 2:
					entradaUsuario(input, conn);
					break;
				case 3:
					listadoEntradas(input, conn);
					break;
				case 4:
					System.out.println("Saliendo...");
					break;
				default:
					System.out.println("Opción no válida.");
				}
			} while (opcion != 4);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		input.close();
	}

	public static void altaUsuario(Scanner input, Connection conn) {
		System.out.print("Nombre de login: ");
		String nombrelogin = input.nextLine();

		try {
			String checkConsulta = "SELECT * FROM usuarios WHERE nombrelogin = ?";
			PreparedStatement checkStmt = conn.prepareStatement(checkConsulta);
			checkStmt.setString(1, nombrelogin);
			ResultSet rs = checkStmt.executeQuery();

			if (rs.next()) {
				System.out.println("El nombre de login ya está en uso.");
			} else {
				System.out.println("Alta de usuario:");
				System.out.print("Contraseña: ");
				String contrasena = input.nextLine();
				System.out.print("Nombre completo: ");
				String nombrecompleto = input.nextLine();

				String insercion = "INSERT INTO usuarios (nombrelogin, contrasena, nombrecompleto) VALUES (?, ?, ?)";
				PreparedStatement insertStmt = conn.prepareStatement(insercion);
				insertStmt.setString(1, nombrelogin);
				insertStmt.setString(2, contrasena);
				insertStmt.setString(3, nombrecompleto);
				insertStmt.executeUpdate();

				System.out.println("Usuario registrado con éxito.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void entradaUsuario(Scanner input, Connection conn) {
		System.out.print("Nombre de login: ");
		String nombrelogin = input.nextLine();
		System.out.print("Contraseña: ");
		String contrasena = input.nextLine();

		try {
			String consulta = "SELECT * FROM usuarios WHERE nombrelogin = ? AND contrasena = ?";
			PreparedStatement stmt = conn.prepareStatement(consulta);
			stmt.setString(1, nombrelogin);
			stmt.setString(2, contrasena);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				int codusuario = rs.getInt("coduser");
				String insercion = "INSERT INTO entradas (codusuario, hora_ultima_entrada) VALUES (?, ?)";
				PreparedStatement insertStmt = conn.prepareStatement(insercion);
				insertStmt.setInt(1, codusuario);
				insertStmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
				insertStmt.executeUpdate();

				System.out.println("Entrada registrada con éxito.");
			} else {
				System.out.println("Contraseña incorrecta.");

				try (FileWriter writer = new FileWriter("errores.txt", true)) {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					String timestamp = LocalDateTime.now().format(formatter);
					writer.write("Error de login - Usuario: " + nombrelogin + " - Fecha/Hora: " + timestamp + "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void listadoEntradas(Scanner input, Connection conn) {
		System.out.print("Nombre de login: ");
		String nombrelogin = input.nextLine();

		try {
			String consulta = "SELECT e.hora_ultima_entrada FROM entradas e "
					+ "JOIN usuarios u ON e.codusuario = u.coduser WHERE u.nombrelogin = ?";
			PreparedStatement stmt = conn.prepareStatement(consulta);
			stmt.setString(1, nombrelogin);
			ResultSet rs = stmt.executeQuery();

			System.out.println("Entradas registradas para " + nombrelogin + ":");
			while (rs.next()) {
				System.out.println(rs.getTimestamp("hora_ultima_entrada"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
