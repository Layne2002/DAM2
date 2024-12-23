// Karim Zinnatullin
package ej1;

import java.util.concurrent.Semaphore;

public class BanyosSemaforo {

	private static final int NUM_BANOS = 3;
	private static final Semaphore semaforo = new Semaphore(NUM_BANOS);

	public static void main(String[] args) {
		while (true) {
			String persona = generarNombreAleatorio();

			new Thread(() -> {
				try {
					System.out.println(persona + " está esperando para entrar al baño.");
					semaforo.acquire();
					System.out.println(persona + " va al baño.");
					Thread.sleep((long) (Math.random() * 5000 + 1000));
					System.out.println(persona + " salió del baño.");
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				} finally {
					semaforo.release();
				}
			}).start();

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}

	private static String generarNombreAleatorio() {
		String[] nombres = { "Pepito", "Jaimito", "Luisito", "Anita", "Maria" };
		return nombres[(int) (Math.random() * nombres.length)];
	}
}
