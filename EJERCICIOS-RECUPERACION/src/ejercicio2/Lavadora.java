package ejercicio2;

public class Lavadora extends Electrodomestico {
	
	private int carga=5;
	
	
	public Lavadora() {
		super();
	}
	
	
	public Lavadora(int carga) {
		super();
		this.carga = carga;
	}
	
	public Lavadora(int codigo, double precio, int peso,int carga) {
		//el super directamente llama al constructor del padre y le pone los valores que estan en el constructor de lavadora
		super(codigo,precio,peso);
		this.carga=carga;
	}

	public Lavadora(int codigo, double precio, String color, char energia, int peso,int carga) {
		super(codigo,precio,color,energia,peso);
		this.peso = peso;
		this.carga=carga;
	}


	public int getCarga() {
		return carga;
	}


	public void setCarga(int carga) {
		this.carga = carga;
	}


	@Override
	public String toString() {
		return "Lavadora"+"/r" + "Código: "+carga + "/r"+"Precio base: "+precio+"/r"+"Color: "+color+
				" "+energia+" "+peso+" "+carga;
	}
	
	
	
	
	public void precioFinal() {
		if (carga>50) {
			precio=precio+50;
		}
	}
	
	
	
	
	
}
