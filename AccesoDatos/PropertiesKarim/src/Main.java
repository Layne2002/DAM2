import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Properties configuracion = new Properties();
		Scanner input = new Scanner(System.in);
		String valor, archivo, resultado;
		try {
			System.out.println("¿De qué archivo necesitas información?");
			archivo = input.nextLine();
			configuracion.load(new FileInputStream(archivo));

			System.out.println("¿Que propiedad necesitas saber?");
			valor = input.nextLine();

			resultado = configuracion.getProperty(valor);
			System.out.println("El resultado del valor preguntado es: " + resultado);
			input.close();
		} catch (IOException ex) {

			System.out.println("Archivo no encontrado");
		}

	}

}
