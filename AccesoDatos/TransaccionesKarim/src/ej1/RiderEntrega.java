package ej1;

import java.sql.*;
import java.util.Random;

class RiderEntrega extends Thread {
	private String url;
	private String user;
	private String password;
	private int codPed;
	private int codRider;

	public RiderEntrega(String url, String user, String password, int codPed, int codRider) {
		this.url = url;
		this.user = user;
		this.password = password;
		this.codPed = codPed;
		this.codRider = codRider;
	}

	@Override
	public void run() {
		try (Connection hiloCon = DriverManager.getConnection(url, user, password)) {
			Thread.sleep(new Random().nextInt(5000));

			String actualizarPedido = "UPDATE pedidos SET Entregado = ? WHERE Codped = ?";
			try (PreparedStatement psEntregado = hiloCon.prepareStatement(actualizarPedido)) {
				psEntregado.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
				psEntregado.setInt(2, codPed);
				psEntregado.executeUpdate();
			}

			String actualizarDisponibilidadRider = "UPDATE riders SET Disponible = 'S' WHERE Codigo = ?";
			try (PreparedStatement psDisponible = hiloCon.prepareStatement(actualizarDisponibilidadRider)) {
				psDisponible.setInt(1, codRider);
				psDisponible.executeUpdate();
			}

			System.out.println("\nEntrega completada:");
			Main.mostrarDatosDespues(hiloCon, codPed, codRider);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
