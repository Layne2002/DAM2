package facil;

import java.util.concurrent.Semaphore;

public class Filosofo {
	private String nombre;

	public Filosofo(String nombre) {
		this.nombre = nombre;
	}

	public void comer(Semaphore semaforo) {
		try {
			while (true) {
				System.out.println(nombre + " está filosofando...");
				semaforo.acquire(2);/*
									 * System.out.println(nombre + " ha cogido 1 palillo"); semaforo.acquire();
									 */
				System.out.println("> " + nombre + " empieza a comer");
				Thread.sleep((int) (Math.random() * 4000) + 1500);
				System.out.println(nombre + " ha terminado de comer !");
				semaforo.release(2);
				Thread.sleep(1500);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	};

}
