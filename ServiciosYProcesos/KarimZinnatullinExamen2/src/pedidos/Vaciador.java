// Karim Zinnatullin
package pedidos;

// Este objeto "completa" pedidos continuamente
public class Vaciador extends Thread {
	private final Cola cola;

	public Vaciador(Cola cola) {
		this.cola = cola;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(300); // para que la cola tenga tiempo de inicializarse con al menos 1 pedido
			while (true) {
				cola.retirarPedido();
				// pequeño retraso entre completaciones
				Thread.sleep((int) (Math.random() * 1000) + 1000);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
