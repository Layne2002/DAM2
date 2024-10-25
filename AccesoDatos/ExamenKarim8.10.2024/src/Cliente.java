// Karim Zinnatullin

public class Cliente {
	String nombre, email, city;
	int edad;

	public Cliente(String nombre, int edad, String email, String city) {

		this.nombre = nombre;
		this.email = email;
		this.city = city;
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Cliente [nombre = " + nombre + ", edad = " + edad + ", email = " + email + ", city = " + city + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

}
