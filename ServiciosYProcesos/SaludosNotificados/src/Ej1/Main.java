//Karim Zinnatullin
package Ej1;

public class Main {

	public static void main(String[] args) {
		Personal empleado1 = new Personal("Pepe", "Que tal", false);
		Personal empleado2 = new Personal("José", "Como está", false);
		Personal empleado3 = new Personal("Pedro", "Muy buenas", false);
		Personal jefe = new Personal("JEFE", "Buenos días", true);

		empleado1.start();
		empleado2.start();
		empleado3.start();
		jefe.start();

	}

}
