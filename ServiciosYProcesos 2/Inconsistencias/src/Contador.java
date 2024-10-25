// Karim Zinnatullin
public class Contador {
	private int valor = 0;

	// Metodo para obtener el valor del contador
	public int getValor() {
		return valor;
	}

	// Metodo para incrementar el contador
	public void increment(int tiempo) {
		int temp = valor;
		temp += tiempo;

		// Simulando un pequeño retraso para aumentar las perdidas
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		valor = temp;
	}
}
