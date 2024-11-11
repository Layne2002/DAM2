package principal;

import java.util.*;

class Tablero {
	private final int MAX_PIZZAS = 3;
	private List<String> tablero = new ArrayList<>(MAX_PIZZAS);
	private final Random random = new Random();
	private final List<String> nombresPizzas = Arrays.asList("Margarita", "Pepperoni", "Cuatro Quesos", "Carbonara",
			"Hawaiana");

	public synchronized void producirPizzas() {

		while (tablero.size() >= MAX_PIZZAS) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}

		for (int i = 0; i < 20; i++) {
			String pizza = nombresPizzas.get(random.nextInt(nombresPizzas.size()));
			if (tablero.size() < MAX_PIZZAS) {
				tablero.add(pizza);
				System.out.println("El horno acaba de producir una pizza: " + pizza);
				notifyAll();
			}
		}
	}

	public synchronized void retirarPizza(int idRepartidor) {

		while (tablero.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}

		String pizzaRetirada = tablero.remove(random.nextInt(tablero.size()));
		System.out.println("El repartidor " + idRepartidor + " retira una pizza: " + pizzaRetirada);

		notifyAll();
	}
}
