
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ventaTickets implements Runnable {

	private int ticketsSolicitados;
	private String DB_Url;
	private String DB_User;
	private String DB_Password;

	public ventaTickets(int ticketsSolicitados, String DB_Url, String DB_User, String DB_Password) {
		this.ticketsSolicitados = ticketsSolicitados;
		this.DB_Url = DB_Url;
		this.DB_User = DB_User;
		this.DB_Password = DB_Password;
	}

	@Override
	public void run() {
		try (Connection con = DriverManager.getConnection(DB_Url, DB_User, DB_Password)) {
			con.setAutoCommit(false);

			PreparedStatement ps = con.prepareStatement("SELECT total_disponibles FROM tickets WHERE id = 1");
			ResultSet rs = ps.executeQuery();
			int disponibles = 0;

			if (rs.next()) {
				disponibles = rs.getInt("total_disponibles");
			}

			if (disponibles >= ticketsSolicitados) {
				int nuevoTotal = disponibles - ticketsSolicitados;

				PreparedStatement nuevoPs = con
						.prepareStatement("UPDATE tickets SET total_disponibles = ? WHERE id = 1");
				nuevoPs.setInt(1, nuevoTotal);
				nuevoPs.executeUpdate();

				con.commit();
				System.out.println(Thread.currentThread().getName() + " compró " + ticketsSolicitados + " tickets.");
			} else {
				System.out.println(
						Thread.currentThread().getName() + " no pudo comprar tickets; no suficientes disponibles.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
