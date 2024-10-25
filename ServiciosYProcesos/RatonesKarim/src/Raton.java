// Karim Zinnatullin
public class Raton implements Runnable{
	
	int tiempoComer;
	String nombre;
	
	public Raton(int tiempo, String nombre) {
		super();
		this.tiempoComer = tiempo;
		this.nombre = nombre;
	}
	
	public void comer() {
		try {
	        long startTime = System.currentTimeMillis(); 
			System.out.println(nombre + " está comiendo...");
			Thread.sleep(100*tiempoComer);
			System.out.println(nombre + " ha terminado de comer!");
			long endTime = System.currentTimeMillis(); 

			// en milisegundos
	        long timeTaken = endTime - startTime;
	        
	        // en segundos
	        long segundos = timeTaken / 1000;

	        System.out.println(nombre + " ha tardado " + segundos + " segundos en comer.\n");
		}catch (Exception e) {
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		comer();
	}
}
