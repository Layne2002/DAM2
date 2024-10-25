import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Vehiculo {
	public enum tipo {
		COCHE, MOTO, BARCO, AIRE
	}

	private final String matricula;
	private String modelo;
	private tipo tipoVehiculo;
	private String marca;

	public Vehiculo(String matricula, String modelo,  String marca,String tipo, boolean guardar) {
		tipo x = transformTipo(tipo);
		if (x != null) {
			if (guardar == true) {
				this.matricula = matricula;
				this.modelo = modelo;
				this.tipoVehiculo = x;
				this.marca = marca;
				try {
					guardarVehiculo(this);
				} catch (IOException ex) {

				}
			} else {
				this.matricula = matricula;
				this.modelo = modelo;
				this.tipoVehiculo = x;
				this.marca = marca;
			}
		} else {
			throw new IllegalArgumentException("No existe el tipo '" + tipo + "'");
		}
	}

	public static tipo transformTipo(String cadena) {
		cadena = cadena.toLowerCase();
		switch (cadena) {
		case ("coche"):
			return tipo.COCHE;

		case ("moto"):
			return tipo.MOTO;

		case ("barco"):
			return tipo.BARCO;

		case ("aire"):
			return tipo.AIRE;
		default:
			return null;
		}
	}

	private void guardarVehiculo(Vehiculo x) throws IOException {
		String rutaProyecto = System.getProperty("user.dir");
		String ruta = rutaProyecto + "\\vehiculos.txt";

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta, true))) {
			writer.append(x.matricula + "," + x.marca + "," + x.modelo + "," + x.tipoVehiculo);
			writer.newLine();
		}
	}

	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", modelo=" + modelo + ", tipo=" + tipoVehiculo + ", marca=" + marca + "]";
	}

	public String getMatricula() {
		return matricula;
	}

	// He cambiado este método para que devuelva una lista
	public static List<Vehiculo> cargarVehiculos() throws IOException {
		String rutaProyecto = System.getProperty("user.dir");
		String ruta = rutaProyecto + "\\vehiculos.txt";
		List<Vehiculo> lista = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
			String linea = reader.readLine();
			if (linea != null) {
				String[] datos = linea.split(",");
				Vehiculo x = new Vehiculo(datos[0], datos[1], datos[2], datos[3], false);
				lista.add(x);
			} else {
				throw new IOException("El archivo está vacío");
			}
			return lista;
		}
	}
}
