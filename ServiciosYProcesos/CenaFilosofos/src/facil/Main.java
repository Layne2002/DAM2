package facil;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Main {
	private static final Semaphore semaforo = new Semaphore(5);

	public static void main(String[] args) {
		ArrayList<Filosofo> filosofos = new ArrayList<>();
		filosofos.add(new Filosofo("Aristóteles"));
		filosofos.add(new Filosofo("Nietzsche"));
		filosofos.add(new Filosofo("Sócrates"));
		filosofos.add(new Filosofo("Platón"));
		filosofos.add(new Filosofo("Descartes"));
		for (Filosofo f : filosofos) {
			new Thread(() -> f.comer(semaforo)).start();
		}
	}

}
