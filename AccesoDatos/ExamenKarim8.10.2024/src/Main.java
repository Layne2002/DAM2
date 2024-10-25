
// Karim Zinnatullin
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String rutaProyecto = System.getProperty("user.dir");

		Properties config = new Properties();

		try {
			// Configuracion de la ruta del fichero
			config.load(new FileInputStream("programa.conf"));
			String ruta = rutaProyecto + "\\" + config.getProperty("nombrefichero");

			// configuracion de los parametros
			int inicio = Integer.parseInt(config.getProperty("inicio"));
			int fin = Integer.parseInt(config.getProperty("fin"));
			int edadMin = Integer.parseInt(config.getProperty("edadmin"));
			int edadMax = Integer.parseInt(config.getProperty("edadmax"));

			// contador para contar en que linea está el lector
			int contador = 0;

			// Lista de los clientes que serán serializados
			List<Cliente> listaClientes = new ArrayList<>();

			File rutaFile = new File(ruta);
			Scanner lector = new Scanner(rutaFile);
			// se hace esto para que no lea la primera linea
			lector.nextLine();

			while (lector.hasNextLine()) {
				contador++;

				// se pone fuera del If porque sino el lector nunca avanza
				String linea = lector.nextLine();

				if (contador >= inicio && contador <= fin) {
					String[] datos = linea.split(",");
					String nombre = datos[0];
					int edad = Integer.parseInt(datos[1]);
					String email = datos[2];
					String city = datos[3];
					if (edad >= edadMin && edad <= edadMax) {
						Cliente x = new Cliente(nombre, edad, email, city);
						listaClientes.add(x);
						System.out.printf("%s\n", x.toString());
					}
				}

			}

			String rutaSer = rutaProyecto + "\\clienteBIN.dat";
			File fichero = new File(rutaSer);
			try (FileOutputStream stream = new FileOutputStream(fichero);
					DataOutputStream output = new DataOutputStream(stream)) {

				for (Cliente x : listaClientes) {
					output.writeUTF(x.getNombre());
					output.writeInt(x.getEdad());
					output.writeUTF(x.getEmail());
					output.writeUTF(x.getCity());
				}

				System.out.println("\nDatos grabados correctamente en clienteBIN.dat");

			} catch (IOException e) {
				e.printStackTrace();
			}
			lector.close();
			System.out.printf("Número de clientes serializados: %d\n", listaClientes.size());

		} catch (IOException ex) {

			System.out.println("Archivo no encontrado");
		}

	}

}
