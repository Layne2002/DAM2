// Karim Zinnatullin
class Incremento implements Runnable {
	private Contador contador;
	private int aumento;
	private String nombreHilo;

	public Incremento(Contador contador, int aumento, String nombreHilo) {
		this.contador = contador;
		this.aumento = aumento;
		this.nombreHilo = nombreHilo;
	}

	@Override
	public void run() {
		System.out.println(nombreHilo + " está incrementando el contador en " + aumento);
		contador.increment(aumento);
	}
}