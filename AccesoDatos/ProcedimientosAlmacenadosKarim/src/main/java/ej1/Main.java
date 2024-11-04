package ej1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Introduce la IP de la base de datos:");
		String dbIp = input.nextLine();
		System.out.print("Introduce el nombre de usuario de la base de datos: ");
		String dbUsuario = input.nextLine();
		System.out.print("Introduce la contraseña de la base de datos: ");
		String dbContraseña = input.nextLine();
		String dbUrl = "jdbc:mysql://" + dbIp + "/sistema_usuarios";
		System.out.println("Dale a ENTER...");
		input.nextLine();
		try {
			Connection conn = DriverManager.getConnection(dbUrl, dbUsuario, dbContraseña);
			System.out.println("Quieres dar de alta un usuario? 1-SI 0-NO");
			int altaUsuario = input.nextInt();
			input.nextLine();
			if (altaUsuario == 1) {
				System.out.println("Dime el nombre de usuario nuevo: ");
				String nombreLogin = input.nextLine();
				System.out.println("Dime la contraseña para el usuario:");
				String contrasena = input.nextLine();
				System.out.println("Dime el nombre completo del usuario:");
				String nombreCompleto = input.nextLine();
				insertarUsuario(conn, nombreLogin, contrasena, nombreCompleto);
			}
			System.out.println("Dale a ENTER para continuar...");
			input.nextLine();
			System.out.println("Quieres contar las entradas de usuario? 1-SI 0-NO");
			int contarEntradas = input.nextInt();
			input.nextLine();
			if (contarEntradas == 1) {
				mostrarUsuarios(conn);
				System.out.println("Dime el nombreLogin del usuario del que quieres consultar entradas:");
				String nombre = input.nextLine();
				int entradas = contarEntradasUsuario(conn, nombre);
				System.out.println("El usuario " + nombre + " ha entrado " + entradas + " veces.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		input.close();
	}

	public static void mostrarUsuarios(Connection conn) {
		System.out.println("MOSTRANDO TODOS LOS USUARIOS:");
		String sql = "SELECT nombreLogin FROM usuarios";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("--------");
				System.out.println("NombreLogin: " + rs.getString("nombreLogin"));
			}
			System.out.println("------------------------");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static int contarEntradasUsuario(Connection conn, String nombreLogin) {
		String sql = "{CALL ContarEntradasUsuario(?, ?)}";
		int numeroEntradas = 0;

		try (CallableStatement cstmt = conn.prepareCall(sql)) {
			cstmt.setString(1, nombreLogin);
			cstmt.registerOutParameter(2, Types.INTEGER);
			cstmt.execute();
			numeroEntradas = cstmt.getInt(2);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return numeroEntradas;
	}

	public static void insertarUsuario(Connection conn, String nombreLogin, String contrasena, String nombreCompleto) {
		String sql = "{CALL InsertarUsuario(?, ?, ?)}";

		try (CallableStatement cstmt = conn.prepareCall(sql)) {
			cstmt.setString(1, nombreLogin);
			cstmt.setString(2, contrasena);
			cstmt.setString(3, nombreCompleto);
			cstmt.execute();
			System.out.println("Usuario agregado exitosamente.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
