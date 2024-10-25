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
        
        tinkyWinky.comer();
		dipsy.comer();
		lala.comer();
		po.comer();
		
        // Iniciar los hilos
        threadTinkyWinky.start();
        threadDipsy.start();
        threadLala.start();
        threadPo.start();
        
        // Esperar a que todos los hilos terminen
        try {
            threadTinkyWinky.join();
            threadDipsy.join();
            threadLala.join();
            threadPo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Todos los ratones han terminado de comer.");
    }

}
