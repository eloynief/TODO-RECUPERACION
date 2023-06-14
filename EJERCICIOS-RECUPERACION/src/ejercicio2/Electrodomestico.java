package ejercicio2;

public class Electrodomestico implements Comparable<Electrodomestico>{

	int codigo=0;
	double precio=100;
	
	enum colors {
		blanco, negro, rojo, azul, gris
	};//enum color
	
	enum consumo {
		A, B, C, D, E, F
	};//enum consumo
	
	colors color=colors.blanco;
	
	consumo energia=consumo.F;
	
	int peso=5;
	
	public Electrodomestico() {
		super();
	}
	
	public Electrodomestico(int codigo) {
		super();
		this.codigo = codigo;
	}
	
	public Electrodomestico(int codigo, double precio, int peso) {
		super();
		this.codigo = codigo;
		this.precio = precio;
		this.peso = peso;
	}
	
	public Electrodomestico(int codigo, double precio, String color, char energia, int peso) {
		super();
		this.codigo = codigo;
		this.precio = precio;
		comprobarColor(color);
		comprobarConsumoEnergetico(energia);
		this.peso = peso;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public colors getColor() {
		return color;
	}

	public void setColor(String color) {
		comprobarColor(color);
	}

	public consumo getEnergia() {
		return energia;
	}

	public void setEnergia(char energia) {
		comprobarConsumoEnergetico(energia);
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	
	public boolean equals(Object o) {
		boolean esIgual=false;
		Electrodomestico objeto=(Electrodomestico) o;
		//muestra 
		if(objeto.codigo==this.codigo) {//si los dos elementos son iguales	
			esIgual=true;
			
		}
		
		
		return esIgual;
		
	}
	
	
	
	@Override
	public String toString() {
		return "codigo:" + codigo + "\n precio:" + precio + ", color:" + color + ", energia:" + energia
				+ ", peso:" + peso;
	}
	
	
	public void comprobarConsumoEnergetico(char letra) {
		//manera sucia de hacerlo
		if(letra=='A') {
			energia=consumo.A;
		}
		else if(letra=='B') {
			energia=consumo.B;
		}
		else if(letra=='C') {
			energia=consumo.C;
		}
		else if(letra=='D') {
			energia=consumo.D;
		}
		else if(letra=='E') {
			energia=consumo.E;
		}
		else if(letra=='F') {
			energia=consumo.F;
		}
		else {
			System.out.println("Has introducido un consumo no valido, se usará el valor por defecto: "+energia);
		}
		
	}//cierre comprobar consumo
	
	
	public void comprobarColor(String color) {// ver si esto esta vbien o no
		
		if(color.equals("blanco")) {
			this.color=colors.blanco;
		}
		else if(color.equals("azul")) {
			this.color=colors.azul;
		}
		else if(color.equals("negro")) {
			this.color=colors.negro;
		}
		else if(color.equals("rojo")) {
			this.color=colors.rojo;
		}
		else if(color.equals("gris")) {
			this.color=colors.gris;
		}
		else {
			System.out.println("Has introucido un color no valido, se usará el color por defecto: "+this.color);
		}
	}
	
	
	public void precioFinal() {
		double pConsumo=0;
		double pPeso=0;
		
		if(energia==consumo.A) {
			pConsumo=100;
		}
		
		else if(energia==consumo.B) {
			pConsumo=80;
		}
		
		else if(energia==consumo.B) {
			pConsumo=50;
		}
		
		else if(energia==consumo.B) {
			pConsumo=30;
		}
		
		else if(energia==consumo.B) {
			pConsumo=10;
		}
		
		
		if(peso>0&&peso<=19) {
			pPeso=10;
		}
		
		else if(peso>19&&peso<=49) {
			pPeso=50;
		}
		
		else if(peso>49&&peso<=79) {
			pPeso=80;
		}
		
		else if(peso>79) {
			pPeso=100;
		}
		
		
		
		precio=pConsumo+pPeso;
		
	}

	//no se que hace ayuda
	@Override
	public int compareTo(Electrodomestico o) {
		int resultado=0;
		if(this.codigo<resultado) {
			resultado=-1;
		}
		
		else if(this.codigo>resultado) {
			resultado=1;
		}
		
		return resultado; 																																	//devuelve un numero positivo si es mayor o menor
	}
	
	
	
}
