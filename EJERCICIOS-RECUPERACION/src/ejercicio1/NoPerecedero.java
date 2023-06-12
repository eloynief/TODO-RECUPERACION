package ejercicio1;

public class NoPerecedero extends Producto {

	private String tipo = "";

	/**
	 * 
	 * @param nombre muestra el nombre del producto
	 * @param precio del producto no perecedero


	/**
	 * 
	 * @param nombre
	 * @param precio

	 */
	public NoPerecedero(String nombre, double precio) {
		super(nombre, precio);

	}
	/**
	 * 
	 * @param nombre
	 * @param precio
	 * @param tipo
	 */
	public NoPerecedero(String nombre, double precio, String tipo) {
		super(nombre, precio);

		if (tipo != null && !tipo.isEmpty()) {
			this.tipo = tipo;
		}
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		
		if (tipo != null && !tipo.isEmpty()) {
			this.tipo = tipo;
		}
	}

	@Override
	public String toString() {
		return super.toString() + "tipo: " + tipo + "\n";
	}

}
