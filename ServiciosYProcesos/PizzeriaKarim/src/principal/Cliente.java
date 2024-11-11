package principal;

class Cliente extends Thread {
	private final Tablero tablero;
	private final int idRepartidor;

	public Cliente(Tablero tablero, int idRepartidor) {
		this.tablero = tablero;
		this.idRepartidor = idRepartidor;
	}

	@Override
	public void run() {
		try {
			while (true) {
				tablero.retirarPizza(idRepartidor);
				Thread.sleep((int) (Math.random() * 1000) + 500);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
