import java.io.Serializable;

public class Producto implements Serializable{
	private static final long serialVersionUID = 1L;
	String articulo;
	double precio;
	int existencias;
	
	public Producto(String articulo,double precio,int existencias) {
		this.articulo = articulo;
		this.precio = precio;
		this.existencias = existencias;
	}

	public String getArticulo() {
		return articulo;
	}

	@Override
	public String toString() {
		return "Producto [articulo = " + articulo + ", precio = " + precio + ", existencias = " + existencias + "]";
	}

	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getExistencias() {
		return existencias;
	}

	public void setExistencias(int existencias) {
		this.existencias = existencias;
	}
}
