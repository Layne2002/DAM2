// Karim Zinnatullin
package pitufos;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Main {
	private static final Semaphore semaforo = new Semaphore(3);

	public static void main(String[] args) {
		// array de nombres de pitufos, se puede agregar más, o aniquilar alguno si se
		// desea
		String nombres[] = { "Papá pitufo", "pitufina", "filósofo", "pintor", "Gruón", "bromista", "dormilón", "tímido",
				"bonachón", "romántico" };
		ArrayList<Pitufo> pitufos = new ArrayList<>(); // lista de objetos pitufo vacia
		for (int i = 0; i < nombres.length; i++) { // bucle que genera todos los pitufos con cada nombre de la lista de
													// nombres
			pitufos.add(new Pitufo(nombres[i]));
		}
		for (Pitufo p : pitufos) { // bucle que inicia cada pitufo que hay
			new Thread(() -> p.comer(semaforo)).start();
		}
	}

}