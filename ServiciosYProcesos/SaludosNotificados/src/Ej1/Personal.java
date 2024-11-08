package Ej1;

public class Personal extends Thread {
	public String nombre, saludo;
	public boolean jefe;
	private static final Object monitor = new Object();

	public Personal(String nombre, String saludo, boolean jefe) {
		super();
		this.nombre = nombre;
		this.saludo = saludo;
		this.jefe = jefe;
	}

	@Override
	public void run() {
		if (jefe) {
			saludarDelJefe();
		} else {

			esperarSaludo();

		}
	}

	private void esperarSaludo() {
		synchronized (monitor) {
			try {
				System.out.println(nombre + " llegó.");
				monitor.wait();

				System.out.println(nombre + "-: " + saludo + " jefe.");
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}

	private void saludarDelJefe() {
		synchronized (monitor) {
			String cadena = this.saludo;
			cadena = "****** JEFE-: " + cadena + "******";
			System.out.println(cadena);
			monitor.notifyAll();

		}
	}
}
