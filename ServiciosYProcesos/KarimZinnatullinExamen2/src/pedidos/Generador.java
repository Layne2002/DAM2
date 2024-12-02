// Karim Zinnatullin
package pedidos;

// Este objeto genera pedidos nuevos continuamente
public class Generador extends Thread {
	private final Cola cola;

	public Generador(Cola tablero) {
		this.cola = tablero;
	}

	@Override
	public void run() {
		try {
			while (true) {
				cola.producirPedido();
				// espera un pequeño tiempo aleatorio entre cada pedido generado
				Thread.sleep((int) (Math.random() * 1000) + 500);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

}