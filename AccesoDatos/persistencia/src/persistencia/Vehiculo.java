package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Vehiculo {
//matrícula, marca, modelo, tipo (Furgon, coche, moto,..)
	private final String matricula;
	private String modelo;
	private String tipo;
	private String marca;

	public Vehiculo(String matricula, String modelo, String tipo, String marca) {

		this.matricula = matricula;
		this.modelo = modelo;
		this.tipo = tipo;
		this.marca = marca;
		try {
		guardarVehiculo(this);
		}catch(IOException ex) {
			
		}
	}

	private void guardarVehiculo(Vehiculo x) throws IOException {
		String rutaProyecto = System.getProperty("user.dir");
		String ruta = rutaProyecto + "\\vehiculos.txt";

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta,true))) {
			writer.write(x.matricula + "," + x.marca + "," + x.modelo + "," + x.tipo);
			writer.newLine();
		}
	}

	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", modelo=" + modelo + ", tipo=" + tipo + ", marca=" + marca + "]";
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
			Vehiculo x = new Vehiculo(datos[0], datos[1], datos[2], datos[3]);
			lista.add(x);
			} else {
				throw new IOException("El archivo está vacío");
			}
			return lista;
		}
	}
}
