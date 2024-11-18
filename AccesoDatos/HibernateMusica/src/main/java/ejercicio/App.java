// Karim Zinnatullin
package ejercicio;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int opcion;
		do {
			System.out.println("-----------------------------------------");
			System.out.println("Elije una opción:");
			System.out.println("1-Crear un album nuevo");
			System.out.println("2-Consultar un cantante y sus albumes");
			System.out.println("3-Actualizar el nombre de un cantante");
			System.out.println("4-Borrar un cantante y todos sus albumes");
			System.out.println("0-Salir");
			opcion = input.nextInt();
			input.nextLine();
			switch (opcion) {
			case 1: {
				crearAlbum(input);
				break;
			}
			case 2: {
				consultarCantante(input);
				break;
			}
			case 3: {
				actualizarNombreCantante(input);
				break;
			}
			case 4: {
				borrarCantante(input);
				break;
			}
			case 0: {
				System.out.println("Hasta luego!");
				break;
			}
			default: {
				System.out.println("Error. Opcion no valida.");
				break;
			}
			}
		} while (opcion != 0);
	}

	@SuppressWarnings("deprecation")
	private static void borrarCantante(Scanner input) {
		System.out.println("Dime el nombre del cantante a borrar:");
		String nombre = input.nextLine();

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();

			Cantante cantante = session.createQuery("from Cantante where nombreCantante = :nombre", Cantante.class)
					.setParameter("nombre", nombre).uniqueResult();

			if (cantante != null) {
				session.delete(cantante);
				session.getTransaction().commit();
				System.out.println("Cantante borrado con éxito.");
			} else {
				System.out.println("Cantante no encontrado.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	private static void actualizarNombreCantante(Scanner input) {
		System.out.println("Dime el nombre del cantante a actualizar:");
		String nombreViejo = input.nextLine();
		System.out.println("Dime el nuevo nombre del cantante:");
		String nuevoNombre = input.nextLine();

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			session.beginTransaction();

			Cantante cantante = session.createQuery("from Cantante where nombreCantante = :nombre", Cantante.class)
					.setParameter("nombre", nombreViejo).uniqueResult();

			if (cantante != null) {
				cantante.setNombreCantante(nuevoNombre);
				session.update(cantante);
				session.getTransaction().commit();
				System.out.println("Nombre actualizado con éxito.");
			} else {
				System.out.println("Cantante no encontrado.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void consultarCantante(Scanner input) {
		System.out.println("Dime el nombre del cantante a consultar:");
		String nombre = input.nextLine();

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			List<Cantante> Lista = session.createQuery("from Cantante where nombreCantante = :nombre", Cantante.class)
					.setParameter("nombre", nombre).list();
			System.out.println("Álbumes de "+nombre);
			Lista.forEach(b -> {
				System.out.println("Album : " + b.getAlbum() + " Año: " + b.getAnio());
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void crearAlbum(Scanner input) {
		System.out.println("Dime el nombre del cantante:");
		String nombre = input.nextLine();
		System.out.println("Dime el nombre del álbum:");
		String album = input.nextLine();
		input.nextLine();
		System.out.println("Dime el año del album:");
		int anio = input.nextInt();
		Cantante nuevo = new Cantante(nombre, anio, album);
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the book objects
			session.persist(nuevo);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
}
