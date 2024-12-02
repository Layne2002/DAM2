// Karim Zinnatullin
// Este es el objeto pitufo

package pitufos;

import java.util.concurrent.Semaphore;

public class Pitufo {
	private String nombre;
	private static String[] platos = { "Fabada", "Pizza", " Lasaña", "Cachopo", " Sopa de agua del grifo de Madrid" };
	private static int contador = 0; // contador de cuantos pitufos hay comiendo

	public Pitufo(String nombre) {
		this.nombre = nombre;
	}

	// metodo que genera un plato aleatorio de la lista
	private static String getPlato() {
		int posicion = (int) (Math.random() * platos.length);
		String plato = platos[posicion];
		return plato;
	}

	// metodo de comer de los pitufos
	public void comer(Semaphore semaforo) {
		try {
			semaforo.acquire(1); // espera a que haya sitio libre
			contador++; // aumenta la cantidad de pitufos comiendo
			System.out.println("> " + nombre + " entra a comer. PITUFOS DENTRO: " + contador + " <");
			String plato1 = getPlato();
			Thread.sleep((int) (Math.random() * 2000) + 1000);
			System.out.println(nombre + " se zampa un plato de " + plato1);
			Thread.sleep((int) (Math.random() * 2000) + 1000);
			String plato2 = getPlato();
			System.out.println(nombre + " se zampa un plato de " + plato2);
			Thread.sleep(300);
			contador--; // disminuye en 1 la cantidad de pitufos comiendo, ya que este ha terminado
			System.err.println("--> " + nombre + " ha terminado de comer! PITUFOS DENTRO: " + contador);

			semaforo.release(1); // deja 1 hueco libre para otro pitufo

		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	};

}
