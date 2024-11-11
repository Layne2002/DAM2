package principal;

public class Horno extends Thread {
	private final Tablero tablero;

	public Horno(Tablero tablero) {
		this.tablero = tablero;
	}

	@Override
	public void run() {
		try {
			while (true) {
				tablero.producirPizzas();
				Thread.sleep((int) (Math.random() * 1000) + 500);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

}
