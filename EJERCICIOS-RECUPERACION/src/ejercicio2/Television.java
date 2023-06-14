package ejercicio2;

public class Television extends Electrodomestico{
	int resolucion=20;
	boolean sintonizador=false;
	
	public Television(int codigo) {
		super(codigo);
	}

	public Television(int codigo,double precio,int peso) {
		super(codigo,precio,peso);
	}

	public Television(int codigo, double precio, String color, char energia,int peso,int resolucion, boolean sintonizador) {
		super(codigo,precio,color,energia,peso);
		this.resolucion = resolucion;
		this.sintonizador = sintonizador;
	}
	
	
	
	
	
	
}
