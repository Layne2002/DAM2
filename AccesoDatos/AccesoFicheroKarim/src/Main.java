import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String rutaProyecto = System.getProperty("user.dir");
		String ruta = rutaProyecto + "\\vehiculos.txt";
		boolean salir = false;

		List<Vehiculo> lista = new ArrayList<>();
		File rutaFile = new File(ruta);
		try {
			Scanner lector = new Scanner(rutaFile);
			while (lector.hasNextLine()) {
				String linea = lector.nextLine();
				String[] datos = linea.split(",");
				Vehiculo x = new Vehiculo(datos[0], datos[1], datos[2], datos[3], false);
				lista.add(x);
				System.out.printf("%s\n", x.toString());
			}
			lector.close();
			System.out.printf("Número de coches leidos: %d\n", lista.size());
		} catch (FileNotFoundException ex) {
			System.out.printf("Error, archivo vehiculos.txt no encontrado.");
		}
		do {
			System.out.println("Dale a enter para continuar.");
			input.nextLine();
			System.out.println("1.- Introducir un vehiculo 2.-Consultar vehiculo 0.- Salir");
			int opcion = input.nextInt();
			input.nextLine();
			switch (opcion) {
			case 1: {
				Vehiculo x = agregarVehiculo(input);
				if (x != null)
					lista.add(x);
				break;
			}
			case 2: {
				// Hay un vehiculo con matricula "ejemplo" para probar este apartado
				consultarVehiculo(input, lista);
				break;
			}
			case 0: {
				salir = true;
				break;
			}
			default: {
				System.out.println("Introduce una opción válida!");
				break;
			}
			}
		} while (salir == false);

	}

	private static void consultarVehiculo(Scanner input, List<Vehiculo> lista) {
		System.out.println("Introduce la matricula del vehiculo: ");
		String consulta = input.nextLine();
		Vehiculo x = consultaMatricula(consulta, lista);
		if (x == null) {
			System.out.println("No se ha encontrado un coche con esa matricula");
		} else {
			System.out.printf("%s\n", x.toString());
		}
	}

	private static Vehiculo agregarVehiculo(Scanner input) {
		System.out.println("Introduce la matricula del coche");
		String matricula = input.nextLine();
		System.out.println("Introduce el modelo");
		String modelo = input.nextLine();
		System.out.println("introduce la marca");
		String marca = input.nextLine();
		System.out.println("Introduce el tipo de vehiculo(COCHE, MOTO, BARCO, AIRE)");
		String tipo = input.nextLine();
		try {
			Vehiculo x = new Vehiculo(matricula, modelo, marca, tipo, true);
			System.out.printf("%s\n", x.toString());
			return x;
		} catch (IllegalArgumentException ex) {
			System.out.printf("%s\n", ex.getMessage());
		}
		return null;
	}

	private static Vehiculo consultaMatricula(String matricula, List<Vehiculo> lista) {
		Iterator<Vehiculo> x = lista.iterator();

		while (x.hasNext()) {
			Vehiculo vehiculo = x.next();
			if (vehiculo.getMatricula().matches(matricula)) {
				return vehiculo;
			}
		}
		return null;
	}

	public static List<Vehiculo> cargarVehiculos(String ruta) throws IOException {

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
