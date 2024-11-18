package ejercicio;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		// Crear un nuevo grupo
		Cantante nuevo = new Cantante("Queen",1970,"A Night at the Opera");
		session.save(nuevo);

		
		 
		Cantante cantante = session.get(Cantante.class, 1);
		System.out.println("Cantante: " + cantante.getNombreCantante());

		// Actualizar grupo
		cantante.setAlbum("Updated Album");
		session.update(cantante);

		// Borrar grupo
		session.delete(cantante);

		tx.commit();
		session.close();
		factory.close();

	}
}
