package ejercicio;

import jakarta.persistence.*;

@Entity
@Table(name = "cantantes")
public class Cantante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;

	public Cantante(String nombreCantante, int anio, String album) {

		this.nombreCantante = nombreCantante;
		this.anio = anio;
		this.album = album;
	}

	@Column(name = "nombre_cantante", nullable = false)
	private String nombreCantante;

	@Column(name = "anio", nullable = false)
	private int anio;

	@Column(name = "album", nullable = false)
	private String album;

	// Getters y setters
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombreCantante() {
		return nombreCantante;
	}

	public void setNombreCantante(String nombreCantante) {
		this.nombreCantante = nombreCantante;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}
}
