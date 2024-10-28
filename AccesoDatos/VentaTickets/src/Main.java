import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Introduce la IP de la base de datos \n");
		String dbIp = input.nextLine();
		System.out.print("Introduce el nombre de usuario de la base de datos: \n");
		String dbUsuario = input.nextLine();
		System.out.print("Introduce la contraseña de la base de datos: \n");
		String dbContraseña = input.nextLine();

		String dbUrl = "jdbc:mysql://" + dbIp + "/sistema_usuarios";

		final int inicialTickets = getTotalTickets(dbUrl, dbUsuario, dbContraseña);
		int totalVendidos;
		System.out.println("Total de tickets inicial: " + inicialTickets);

		// Crear y arrancar tres hilos de venta de tickets
		Thread comprador1 = new Thread(new ventaTickets(5, dbUrl, dbUsuario, dbContraseña));
		Thread comprador2 = new Thread(new ventaTickets(3, dbUrl, dbUsuario, dbContraseña));
		Thread comprador3 = new Thread(new ventaTickets(6, dbUrl, dbUsuario, dbContraseña));

		comprador1.start();
		comprador2.start();
		comprador3.start();

		// Esperar que los hilos terminen
		try {
			comprador1.join();
			comprador2.join();
			comprador3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		int totalDespuesVender = getTotalTickets(dbUrl, dbUsuario, dbContraseña);
		// Calcular el total de tickets vendidos y disponibles
		totalVendidos = inicialTickets - totalDespuesVender;

		// Imprimir resultados finales
		System.out.println("Total de tickets vendidos: " + totalVendidos);
		System.out.println("Total de tickets disponibles después de la venta: " + totalDespuesVender);
		input.close();
	}

	private static int getTotalTickets(String DB_URL, String DB_USER, String DB_PASSWORD) {
		int totalDisponibles = 0;
		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement stmt = conn.prepareStatement("SELECT total_disponibles FROM tickets WHERE id = 1")) {
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				totalDisponibles = rs.getInt("total_disponibles");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalDisponibles;
	}

}