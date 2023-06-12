package ejercicio1;

public class Perecedero extends Producto {
	// variable que representa los dias a caducar
	private int caducar = 1;

	public Perecedero(String nombre, double precio) {
		super(nombre, precio);

	}

	public Perecedero(String nombre, double precio, int caducar) {
		super(nombre, precio);

		if (caducar > 0) {
			this.caducar = caducar;
		}
	}

	public int getCaducar() {
		return caducar;
	}

	public void setCaducar(int caducar) {
		this.caducar = caducar;
	}

	@Override
	public String toString() {
		
		return super.toString() + "caducar: " + caducar + "\n";
	}

	@Override
	public double calcular(int numeroPerecedero) {

		// (what should I change...)

		double valorFinal = super.calcular(numeroPerecedero);

		if (caducar == 1) {
			valorFinal = valorFinal / 4;
		} else if (caducar == 2) {
			valorFinal = valorFinal / 3;
		} else if (caducar == 3) {
			valorFinal = valorFinal / 2;
		}

		return valorFinal;
	}

}



//cosas inútiles:

/*
 * package ej3;
 * 
 * public class Perecedero extends Producto{ //variable que representa los dias
 * a cadu public int caducar=0;
 * 
 * 
 * public Perecedero(String nombre, double precio) { super(nombre, precio); //
 * TODO Auto-generated constructor stub }
 * 
 * 
 * public Perecedero(String nombre, double precio, int caducar) { super(nombre,
 * precio); this.caducar = caducar; }
 * 
 * 
 * public int getCaducar() { return caducar; }
 * 
 * 
 * public void setCaducar(int caducar) { this.caducar = caducar; }
 * 
 * 
 * @Override public String toString() { return "caducar: " + caducar + "\n"; }
 * 
 * @Override public double calcular(int numeroPerecedero) { // TODO
 * Auto-generated method stub
 * 
 * 
 * //(what should I change...)
 * 
 * double valorFinal=super.calcular(numeroPerecedero);
 * 
 * if (caducar==1) { valorFinal=valorFinal/4; } else if (caducar==2) {
 * valorFinal=valorFinal/3; } else if (caducar==3) { valorFinal=valorFinal/2; }
 * 
 * return valorFinal; }
 * 
 * 
 * }
 * 
 */
