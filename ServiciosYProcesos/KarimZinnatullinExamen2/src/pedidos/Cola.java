// Karim Zinnatullin
package pedidos;

// Esta es la clase de la cola
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Cola {
	// una variable que controla que no haya mas de X pedidos en la cola a la vez
	// ya que no tiene sentido seguir generando tantos
	// AUMENTAR A SU VOLUNTAD
	private static final int MAX_PEDIDOS = 10;
	private static List<String> cola = new ArrayList<>(MAX_PEDIDOS);
	private final Random random = new Random();
	private static final List<String> articulos = Arrays.asList("iPhone", "MacBook", "Smart TV", "Roomba",
			"Amazon Alexa"); // nombres de articulos, se pueden agregar mas

	// metodo que genera un articulo con su codigo aleatorio
	private String generarArticulo() {
		String resultado = articulos.get(random.nextInt(articulos.size()));
		String codigo = String.valueOf(random.nextInt(10000));
		resultado = resultado.concat(" - ").concat(codigo);
		return resultado;
	}

	// metodo que produce pedidos
	public synchronized void producirPedido() {

		while (cola.size() >= MAX_PEDIDOS) { // esperar si hay demasiados pedidos
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}

		String articulo = generarArticulo();
		if (cola.size() < MAX_PEDIDOS) { // segunda comprobacion de que la cola no esté llena
			cola.add(articulo);
			System.out.println("Pedido nuevo! " + articulo + " Posición: " + cola.indexOf(articulo));
			notifyAll();
		}

	}

	// metodo que "completa" los pedidos
	public synchronized void retirarPedido() {

		while (cola.isEmpty()) { // esperar si la cola está vacía
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}

		String pedidoCompletado = cola.remove(0); // borra el pedido en primera posición
		String siguientePedido = cola.get(0); // una vez borrado, coge el pedido en siguiente posición
		System.out
				.println("> Se completa el pedido de: " + pedidoCompletado + ". Siguiente pedido: " + siguientePedido);

		notifyAll();
	}
}