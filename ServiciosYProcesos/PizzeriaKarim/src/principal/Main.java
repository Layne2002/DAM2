// Karim Zinnatullin
package principal;

public class Main {
	public static void main(String[] args) {
		Tablero tablero = new Tablero();

		Horno horno = new Horno(tablero);
		horno.start();

		Cliente cliente1 = new Cliente(tablero, 1);
		Cliente cliente2 = new Cliente(tablero, 2);
		Cliente cliente3 = new Cliente(tablero, 3);

		cliente1.start();
		cliente2.start();
		cliente3.start();

		try {
			horno.join();
			cliente1.join();
			cliente2.join();
			cliente3.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
