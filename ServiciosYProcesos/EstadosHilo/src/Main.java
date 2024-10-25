// Karim Zinnatullin
public class Main {
	public static void main(String[] args) {
		// Crear instancias de Raton
		Raton tinkyWinky = new Raton(20, "Tinky-Winky");
		Raton dipsy = new Raton(25, "Dipsy");
		Raton lala = new Raton(10, "Lala");
		Raton po = new Raton(30, "Po");

		// Crear hilos para cada ratón
		Thread threadTinkyWinky = new Thread(tinkyWinky);
		Thread threadDipsy = new Thread(dipsy);
		Thread threadLala = new Thread(lala);
		Thread threadPo = new Thread(po);

		// Imprimir el estado del hilo antes de empezar
		System.out.println("Estado inicial de Tinky-Winky: " + threadTinkyWinky.getState());

		// Iniciar el hilo tinkywinky
		threadTinkyWinky.start();

		// Bucle para imprimir los estados por los que pasa Tinky-Winky
		Thread.State estadoActual = threadTinkyWinky.getState();
		while (estadoActual != Thread.State.TERMINATED) {
			Thread.State nuevoEstado = threadTinkyWinky.getState();
			if (nuevoEstado != estadoActual) { // Evitar que el bucle imprima el mismo estado que antes
				System.out.println("Nuevo estado de Tinky-Winky: " + nuevoEstado);
				estadoActual = nuevoEstado;
			}
		}

		// Esperar a que los otros ratones terminen de comer
		threadDipsy.start();
		threadLala.start();
		threadPo.start();

		try {
			threadDipsy.join();
			threadLala.join();
			threadPo.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Todos los ratones han terminado de comer.");
	}
}
