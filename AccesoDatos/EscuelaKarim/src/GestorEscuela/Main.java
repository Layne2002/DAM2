// Karim Zinnatullin
package GestorEscuela;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {

	public static void main(String[] args) {
		//----------------------------------------
		//--Cambiar valores por los que se desea--
		//----------------------------------------
		
		// matricular un estudiante
		int idEstudiante = 1;
		int idCurso = 2;
		String fechaMatricula = "2024-01-01";
		String fechaInicio = "2024-01-10";
		String fechaFin = "2024-02-10";

		matricularEstudiante(idEstudiante, idCurso, Date.valueOf(fechaMatricula), Date.valueOf(fechaInicio),
				Date.valueOf(fechaFin));

		// Listar estudiantes en un curso
		int idCursoListar = 2;

		listarEstudiantesEnCurso(idCursoListar);

		// Dar de baja a un estudiante
		int idEstudianteBaja = 1;
		int idCursoBaja = 2;

		darBajaEstudiante(idEstudianteBaja, idCursoBaja);

		// Actualizar precio de un curso
		int idCursoActualizar = 2;
		double nuevoPrecio = 200.00;

		actualizarPrecioCurso(idCursoActualizar, nuevoPrecio);

		// Emitir recibo
		int idEstuainteRecibo = 1;

		emitirRecibo(idEstuainteRecibo);
	}

	public static void matricularEstudiante(int idEstudiante, int idCurso, Date fechaMatricula, Date fechaInicio,
			Date fechaFin) {
		String query = "INSERT INTO matriculas (id_estudiante, id_curso, fecha_matricula, fecha_inicio, fecha_fin) VALUES (?, ?, ?, ?, ?)";
		try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, idEstudiante);
			stmt.setInt(2, idCurso);
			stmt.setDate(3, fechaMatricula);
			stmt.setDate(4, fechaInicio);
			stmt.setDate(5, fechaFin);
			stmt.executeUpdate();
			System.out.println("Estudiante matriculado con éxito.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void listarEstudiantesEnCurso(int idCurso) {
		String query = "SELECT E.id_estudiante, E.nombre, E.correo FROM estudiantes E "
				+ "INNER JOIN matriculas M ON E.id_estudiante = M.id_estudiante " + "WHERE M.id_curso = ?";
		try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, idCurso);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id_estudiante") + ", Nombre: " + rs.getString("nombre")
						+ ", Correo: " + rs.getString("correo"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void darBajaEstudiante(int idEstudiante, int idCurso) {
		String query = "DELETE FROM matriculas WHERE id_estudiante = ? AND id_curso = ?";
		try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, idEstudiante);
			stmt.setInt(2, idCurso);
			stmt.executeUpdate();
			System.out.println("Estudiante dado de baja del curso.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void actualizarPrecioCurso(int idCurso, double nuevoPrecio) {
		String query = "UPDATE cursos SET precio = ? WHERE id_curso = ?";
		try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setDouble(1, nuevoPrecio);
			stmt.setInt(2, idCurso);
			stmt.executeUpdate();
			System.out.println("Precio del curso actualizado con éxito.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void emitirRecibo(int idEstudiante) {
		String query = "SELECT C.nombre, C.precio, M.fecha_inicio, M.fecha_fin "
				+ "FROM cursos C INNER JOIN matriculas M ON C.id_curso = M.id_curso " + "WHERE M.id_estudiante = ?";
		try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, idEstudiante);
			ResultSet rs = stmt.executeQuery();
			System.out.println("Recibo del Estudiante ID: " + idEstudiante);
			while (rs.next()) {
				System.out.println("Curso: " + rs.getString("nombre") + ", Precio: " + rs.getDouble("precio")
						+ ", Fecha Inicio: " + rs.getDate("fecha_inicio") + ", Fecha Fin: " + rs.getDate("fecha_fin"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
