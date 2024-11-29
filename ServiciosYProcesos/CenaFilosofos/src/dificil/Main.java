package dificil;

import java.util.concurrent.Semaphore;

public class Main {
	public static final Semaphore[] palillos = new Semaphore[5];

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			palillos[i] = new Semaphore(1);
		}
		Filosofo[] filosofos = new Filosofo[5];
		filosofos[0] = new Filosofo("Aristóteles", 0, 1, palillos);
		filosofos[1] = new Filosofo("Nietzsche", 1, 2, palillos);
		filosofos[2] = new Filosofo("Sócrates", 2, 3, palillos);
		filosofos[3] = new Filosofo("Platón", 3, 4, palillos);
		filosofos[4] = new Filosofo("Descartes", 4, 0, palillos);
		for (Filosofo f : filosofos) {
			new Thread(() -> f.comer()).start();
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

	public void comer() {
		int contador = 0;
		try {
			for (int i = 0; i < 5; i++) {
				System.out.println(nombre + " está filosofando...");
				Thread.sleep(1000);

				palillos[palilloIzd].acquire();

				System.out.println(nombre + " ha cogido el palillo " + (palilloIzd+1));
				palillos[palilloDer].acquire();
				System.out.println("> " + nombre + " ha cogido el palillo " + (palilloDer+1));
				System.out.println(nombre + " está comiendo");
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
		System.out.println(nombre + " ha comido " + contador + " veces");
	};

}