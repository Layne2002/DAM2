
// Karim Zinnatullin
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {

		if (args.length == 0) {
			System.out.println("Error: Falta el comando");
			return;
		}

		try {

			ProcessBuilder builder = new ProcessBuilder(args);

			Process proceso = builder.start();

			BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
			String linea;
			while ((linea = reader.readLine()) != null) {
				System.out.println(linea);
			}

			int salida = proceso.waitFor();

			System.out.println("Valor de salida: " + salida);
		} catch (IOException e) {

			System.err.println("Error al intentar ejecutar el comando: " + e.getMessage());
		} catch (InterruptedException e) {

			System.err.println("El proceso fue interrumpido: " + e.getMessage());
		}
	}
}
