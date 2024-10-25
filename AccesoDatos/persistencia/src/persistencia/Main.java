package persistencia;

import java.io.IOException;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		try {
			// he cambiado este metodo para que devuelva una lista
		 List<Vehiculo>lista = Vehiculo.cargarVehiculos();
		 lista.add(new Vehiculo("123-adb","Prius","Coche","toyota"));
			lista.add(new Vehiculo("333-dfg","leon","Coche","seat"));
			lista.add(new Vehiculo("123-234","x233","moto","motorolla"));
			lista.add(new Vehiculo("123-asd","tiburon","Coche","hyundai"));
			System.out.println("Imprimiendo todos los vehculos por pantalla");
			imprimirVehiculos(lista);
		}catch(IOException ex) {
			
		}
		

	}
	private static void imprimirVehiculos(List<Vehiculo> lista) {
		for(Vehiculo x:lista) {
			System.out.println(x.toString());
		}
	}

}
