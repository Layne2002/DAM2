package Ejercicio;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Autor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	@Column(name = "nombre", nullable = false)
	private String nombre;
	@Column(name = "pais", nullable = false)
	private String pais;

	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // Cambiar a EAGER si es necesario
	private List<Libro> libros;

	public int getIdAutor() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<Libro> getLibros() {
		return libros;
	}

}
