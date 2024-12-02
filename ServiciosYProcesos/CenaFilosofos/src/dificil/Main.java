package dificil;

import java.util.concurrent.Semaphore;

public class Main {
	public static final Semaphore[] palillos = new Semaphore[5];
	public static final int VECES_COMER = 5; // cuantas veces debe comer cada filosofo

	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {
			palillos[i] = new Semaphore(1);
		}
		Filosofo[] filosofos = new Filosofo[5];
		filosofos[0] = new Filosofo("Huao Piao", 0, 1, palillos);
		filosofos[1] = new Filosofo("Bin Xilling", 1, 2, palillos);
		filosofos[2] = new Filosofo("Meido in chaina telcelo", 2, 3, palillos);
		filosofos[3] = new Filosofo("中国哲学家", 3, 4, palillos);
		filosofos[4] = new Filosofo("BAZAR ALIMENTACIÓN JIN HUE PAIO BAO", 4, 0, palillos);
		for (Filosofo f : filosofos) {
			new Thread(() -> f.comer(VECES_COMER)).start();
		}
	}

}

class Filosofo {
	private String nombre;
	private int palilloDer, palilloIzd;
	private Semaphore[] palillos;

	public Filosofo(String nombre, int palilloIzd, int palilloDer, Semaphore[] palillos) {
		this.nombre = nombre;
		this.palilloDer = palilloDer;
		this.palilloIzd = palilloIzd;
		this.palillos = palillos;
	}

	public void comer(int veces) {

		int contador = 0;
		try {
			for (int i = 0; i < veces; i++) { // este bucle es para que cada filosofo coma 5 veces
				System.out.println(nombre + " está filosofando...");
				if (this.palilloDer == 0 && this.palilloIzd == 4) { // el quinto filosofo espera un poco mas para
																	// empezar a comer, evitando el deadlock
					Thread.sleep(3000);
				} else {
					Thread.sleep(1000);
				}
				palillos[palilloIzd].acquire();

				System.out.println(nombre + " ha cogido el palillo " + (palilloIzd + 1));
				palillos[palilloDer].acquire();
				System.out.println(nombre + " ha cogido el palillo " + (palilloDer + 1));
				System.out.println("> " + nombre + " está comiendo");
				Thread.sleep(3000);

				palillos[palilloIzd].release();
				palillos[palilloDer].release();
				System.out.println(nombre + " ha terminado de comer !");

				Thread.sleep(1000);
				contador++;
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.err.println("--> " + nombre + " ha comido " + contador + " veces");
	};

}