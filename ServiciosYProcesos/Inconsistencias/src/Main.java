// Karim Zinnatullin
public class Main {
	public static void main(String[] args) {
		Contador contador = new Contador();

		for (int i = 0; i < 10; i++) {
			Thread hilo1 = new Thread(new Incremento(contador, 1, "Hilo 1"));
			Thread hilo2 = new Thread(new Incremento(contador, 3, "Hilo 2"));
			Thread hilo3 = new Thread(new Incremento(contador, 5, "Hilo 3"));
			hilo1.start();
			hilo2.start();
			hilo3.start();
			try {
				hilo1.join();
				hilo2.join();
				hilo3.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("El valor final del contador es: " + contador.getValor());
		System.out.println("El valor esperado del contador es: " + (10 * (1 + 3 + 5)));
	}
}