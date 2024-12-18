package Ejercicio;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Biblioteca {

	// Insertar un autor y un libro
	@SuppressWarnings("deprecation")
	public void insertarDatos(Session session) {
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
		session.save(autor); // Inserta en la tabla "autor"
		session.save(libro); // Inserta en la tabla "libro" con la relación id_autor

		// Confirmar la transacción
		tx.commit();

		/*
		 * Comparación con SQL: INSERT INTO autor (id, nombre, pais) VALUES (1, 'Gabriel
		 * García Márquez', 'Colombia'); INSERT INTO libro (id, isbn, titulo, precio,
		 * id_autor) VALUES (1, '978-3-16-148410-0', 'Cien años de soledad', 25.50, 1);
		 */
	}

	// Consultar un libro por su título
	public Libro consultarLibroPorTitulo(Session session, String titulo) {
		Query<Libro> query = session.createQuery("FROM Libro l WHERE l.titulo = :titulo", Libro.class);
		query.setParameter("titulo", titulo);
		Libro libro = query.uniqueResult();

		/*
		 * Comparación con SQL: SELECT * FROM libro WHERE titulo = 'Cien años de
		 * soledad';
		 */
		return libro;
	}

	// Actualizar el precio de un libro
	public void actualizarPrecio(Session session, String isbn, double nuevoPrecio) {
		Transaction tx = session.beginTransaction();

		Query query = session.createQuery("UPDATE Libro SET precio = :precio WHERE isbn = :isbn");
		query.setParameter("precio", nuevoPrecio);
		query.setParameter("isbn", isbn);

		int filasActualizadas = query.executeUpdate();
		tx.commit();

		/*
		 * Comparación con SQL: UPDATE libro SET precio = 30.00 WHERE isbn =
		 * '978-3-16-148410-0';
		 */
	}

	// Instrucción de agregación: calcular el precio promedio de los libros
	public double calcularPrecioPromedio(Session session) {
		Query<Double> query = session.createQuery("SELECT AVG(precio) FROM Libro", Double.class);
		double precioPromedio = query.uniqueResult();

		/*
		 * Comparación con SQL: SELECT AVG(precio) FROM libro;
		 */
		return precioPromedio;
	}

	// Ejemplo de JOIN: obtener los libros con su autor
	public List<Object[]> obtenerLibrosConAutores(Session session) {
		Query<Object[]> query = session.createQuery("SELECT l.titulo, l.precio, a.nombre FROM Libro l JOIN l.autor a",
				Object[].class);
		List<Object[]> resultados = query.list();

		/*
		 * Comparación con SQL: SELECT libro.titulo, libro.precio, autor.nombre FROM
		 * libro INNER JOIN autor ON libro.id_autor = autor.id;
		 */
		return resultados;
	}

	// Lazy vs. Eager: configuración y explicación
	public void ejemploCargaRelacionada(Session session, int idAutor) {
		Autor autor = session.get(Autor.class, idAutor); // Por defecto, suele ser LAZY
		/*
		 * En este caso, `autor.getLibros()` no carga automáticamente los libros
		 * asociados. Hibernate realiza una consulta adicional para obtener los libros.
		 * SELECT * FROM libro WHERE id_autor = :idAutor;
		 * 
		 * Si cambiamos a EAGER en la configuración de la entidad (por ejemplo, usando
		 * `@OneToMany(fetch = FetchType.EAGER)`), Hibernate cargará los libros
		 * asociados inmediatamente con una consulta JOIN.
		 * 
		 * Ventaja de LAZY: mejora el rendimiento cuando no necesitamos los datos
		 * relacionados. Desventaja de LAZY: puede causar problemas de rendimiento si se
		 * accede a datos relacionados de manera tardía en un contexto desconectado.
		 */
		List<Libro> libros = autor.getLibros(); // Se ejecutará la consulta adicional en LAZY
		System.out.println("Libros del autor: " + libros.size());
	}
}
