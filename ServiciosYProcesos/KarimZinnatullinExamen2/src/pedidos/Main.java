// Karim Zinnatullin
package pedidos;

// En esta clase se inician los procesos
public class Main {

	public static void main(String[] args) {
		Cola cola = new Cola();

		Generador generador1 = new Generador(cola);
		
		Generador generador2 = new Generador(cola);
		

		Vaciador vaciador = new Vaciador(cola);
		generador1.start();
		generador2.start();
		vaciador.start();

		try {
			generador1.join();
			generador2.join();
			vaciador.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

}
