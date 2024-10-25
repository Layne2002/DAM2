
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Producto producto = new Producto("Macbook pro M1", 1299.99, 10);

		try (FileOutputStream fileOut = new FileOutputStream("producto.ser");
				ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

			objectOut.writeObject(producto);
			System.out.println("Producto serializado y guardado en producto.ser");

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		try (FileInputStream fileInput = new FileInputStream("producto.ser");
				ObjectInputStream objectinput = new ObjectInputStream(fileInput)) {

			Producto x = (Producto) objectinput.readObject();
			System.out.println("Producto deserializado: " + x);

		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		input.close();
	}

}