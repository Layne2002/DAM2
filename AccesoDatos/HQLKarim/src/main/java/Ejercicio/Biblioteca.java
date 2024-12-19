// Karim Zinnatullin
package Ejercicio;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

public class Biblioteca {
	public static void main(String[] args) {
		// Configuración de Hibernate
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		// Crear una sesión
		Session session = factory.openSession();
		insertarDatos(session);
		consultarLibroPorTitulo(session, "Harry Potter");
		actualizarPrecio(session, "978-3-16-148410-0", 119.23);
		calcularPrecioPromedio(session);
		List<Object[]> libros = obtenerLibrosConAutores(session);
		for (Object o : libros) {
			System.out.println(o.toString());
		}
		ejemploCargaRelacionada(session, 2);

		// Cerrarla
		session.close();
		factory.close();

	}

	// Insertar un autor y un libro
	// @SuppressWarnings("deprecation")
	public static void insertarDatos(Session session) {
		Transaction tx = session.beginTransaction();

		// Crear un autor
		Autor autor = new Autor();
		autor.setNombre("Gabriel García Márquez");
		autor.setPais("Colombia");

		// Crear un libro asociado al autor
		Libro libro = new Libro();
		libro.setIsbn("978-3-16-148410-0");
		libro.setTitulo("Cien años de soledad");
		libro.setPrecio(25.50);
		libro.setAutor(autor);

		// Guardar en la sesión
		session.persist(autor); // Inserta en la tabla "autor"
		session.persist(libro); // Inserta en la tabla "libro" con la relación id_autor

		// Confirmar la transacción
		tx.commit();

	}

	// Consultar un libro por su título
	public static Libro consultarLibroPorTitulo(Session session, String titulo) {
		Query<Libro> query = session.createQuery("FROM Libro l WHERE l.titulo = :titulo", Libro.class);
		query.setParameter("titulo", titulo);
		Libro libro = query.uniqueResult();

		return libro;
	}

	// Actualizar el precio de un libro
	public static void actualizarPrecio(Session session, String isbn, double nuevoPrecio) {
		Transaction tx = session.beginTransaction();

		String hql = "UPDATE Libro SET precio = :precio WHERE isbn = :isbn";
		MutationQuery query = session.createMutationQuery(hql); // "Integer" para las filas afectadas
		query.setParameter("precio", nuevoPrecio);
		query.setParameter("isbn", isbn);

		int filasActualizadas = query.executeUpdate();
		System.out.println("Filas actualizadas: " + filasActualizadas);

		tx.commit();

	}

	// Instrucción de agregación: calcular el precio promedio de los libros
	public static double calcularPrecioPromedio(Session session) {
		Query<Double> query = session.createQuery("SELECT AVG(precio) FROM Libro", Double.class);
		double precioPromedio = query.uniqueResult();

		return precioPromedio;
	}

	// Ejemplo de JOIN: obtener los libros con su autor
	public static List<Object[]> obtenerLibrosConAutores(Session session) {
		Query<Object[]> query = session.createQuery("SELECT l.titulo, l.precio, a.nombre FROM Libro l JOIN l.autor a",
				Object[].class);
		List<Object[]> resultados = query.list();

		return resultados;
	}

	// Lazy vs. Eager: configuración y explicación
	public static void ejemploCargaRelacionada(Session session, int idAutor) {
		Autor autor = session.get(Autor.class, idAutor); // Por defecto, suele ser LAZY

		List<Libro> libros = autor.getLibros(); // Se ejecutará la consulta adicional en LAZY
		System.out.println("Libros del autor: " + libros.size());
	}
}
