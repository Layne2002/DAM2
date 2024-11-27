
// Karim Zinnatullin
// 25-11-2024
import java.sql.*;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("-----------------------------");
			System.out.println("Menú:");
			System.out.println("1. Alta de un viaje");
			System.out.println("2. Crear una reserva");
			System.out.println("3. Cancelar una reserva");
			System.out.println("0. Salir");
			System.out.print("Selecciona una opción: \n");
			opcion = input.nextInt();

			input.nextLine();

			switch (opcion) {
			case 1:
				altaViaje(input);
				break;
			case 2:
				crearReserva(input);
				break;
			case 3:
				cancelarReserva(input);
				break;
			case 0:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción no válida.");
			}
			System.out.println("Dale a ENTER para continuar....");
			input.nextLine();
		} while (opcion != 0);

		input.close();
	}

	// Metodo para cancelar una reserva
	private static void cancelarReserva(Scanner input) {
		System.out.println("Dime el id de la reserva:");
		int idReserva = input.nextInt();
		System.out.println("Dime el id del cliente:");
		int idcliente = input.nextInt();
		Viajes.cancelarReserva(idReserva, idcliente);
	}

	// metodo para crear una reserva nueva
	private static void crearReserva(Scanner input) {
		Date fecha = Date.valueOf(LocalDate.now());

		int plazas, idcliente, destino;

		System.out.println("Dime el id del destino:");
		destino = input.nextInt();
		input.nextLine();
		System.out.println("Dime el CODIGO del cliente:");
		idcliente = input.nextInt();
		System.out.println("Dime el numero de plazas para reservar:");
		plazas = input.nextInt();
		Viajes.crearReserva(idcliente, fecha, plazas, destino);
	}

	// metodo para crear un viaje nuevo
	private static void altaViaje(Scanner input) {
		System.out.println("Dime el dfestino del viaje:");
		String destino = input.nextLine();
		input.nextLine();
		System.out.println("Dime el número de plazas en total:");
		int totalPlazas = input.nextInt();
		Viajes.altaViaje(destino, totalPlazas);
	}
}
