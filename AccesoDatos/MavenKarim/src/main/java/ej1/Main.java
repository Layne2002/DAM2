package ej1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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

		List<Cliente> listaClientes = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(dbUrl, dbUsuario, dbContraseña)) {
			String sql = "SELECT * FROM Clientes";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				int id = resultSet.getInt("codigo");
				String nombre = resultSet.getString("nombre");
				String telefono = resultSet.getString("telefono");
				double saldo = resultSet.getDouble("saldo");
				Cliente cliente = new Cliente(id, nombre, telefono, saldo);
				listaClientes.add(cliente);
			}

			for (Cliente cliente : listaClientes) {
				System.out.println(cliente.getNombre());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		input.close();
	}

	// Métodos para insertar, actualizar y eliminar clientes

}
