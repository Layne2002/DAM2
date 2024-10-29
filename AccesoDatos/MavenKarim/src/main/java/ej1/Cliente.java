package ej1;

public class Cliente {
	private int id;
	private String nombre;
	private String telefono;
	private double saldo;

	public Cliente(int codigo, String nombre, String telefono, double saldo) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.saldo = saldo;
	}

	public int getId() {
		return id;
	}

	public void setId(int codigo) {
		this.id = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Cliente [codigo= " + id + ", nombre= " + nombre + ", telefono= " + telefono + ", saldo= " + saldo
				+ "]";
	}

}
