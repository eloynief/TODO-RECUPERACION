package ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
	

	//coleccion de producto
	static TreeSet<Producto> productos = new TreeSet<Producto>();
	
	
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		int opcion=1;
		Scanner sc=new Scanner(System.in);
		String nombre = "";
		double precio = 0;
		int caducar=0;
		String tipo="";
		Producto producto=null;
		
		String tipoProd="";
		
		
		lecturaFichero();
		
		
		while(opcion!=0) {
			//menu
			menuOpciones();
			
			opcion=sc.nextInt();
			
			switch (opcion) {
			//
			case 1:{
				añadirProducto(sc);
				
				
				
				break;
				
				
			}//c1
			
			case 2:{
				//recorre la colección hasta que se acaba
				for(Producto p: productos) {
					//imprime los productos directamente del treeset
					System.out.println(p);
					System.out.println();
				}
				//
				break;
			}//c2
			
			case 3:{
				System.out.println("introduce el nombre: ");
				nombre=sc.next();
				sc.nextLine();
				
				producto=new Producto(nombre);
				
				//si el producto existe, entonces se borra
				if(productos.remove(producto)) {
					System.out.println("El producto se ha eliminado correctamente.");
				}
				else {
					System.out.println("El producto no existe.");
				}
				
				break;
			}//c3
			
			
			//modificar producto
			case 4:{
				opcion = modificarProducto(opcion, sc);
				
				break;
			}//c4
			
			
			
			//guardar en el texto
			case 5:{
				
				//con esto podemos escribir en el archivo
				escrituraFichero();
				
			}//c5
			
			
			
			
			//salir
			case 0:{
				
				break;
			}//c0
			
				
			}//swotch
			
		}
		
		


		
	}
	
	
	
	private static int modificarProducto(int opcion, Scanner sc) {
		String nombre;
		double precio;
		int caducar;
		Producto producto;
		String tipoProd;
		System.out.println("introduce el nombre del producto a modificar: ");
		
		//
		nombre=sc.next();
		//crea objeto tipo producto del constructor de solo nombre
		producto=new Producto(nombre);
		
		//si está en la lista
		if(productos.contains(producto)) {
			for(Producto p: productos) {
				if(p.equals(producto)) {
					//
					menuModificar();
					
					System.out.println("Introduce la opción(1=Perecedero/2=No perecedero: ");
					opcion=sc.nextInt();
					
					switch(opcion){
						case 1:{
							System.out.println("Introduce el nombre nuevo: ");
							nombre=sc.next();
							sc.nextLine();
							p.setNombre(nombre); //sirve para reemplazar valores
							break;
							
						}//c1
						
						case 2:{
							System.out.println("Introduce el nuevo precio del producto: ");
							precio=sc.nextDouble();
							sc.nextLine();
							p.setPrecio(precio); //sirve para reemplazar valores
							break;
							
						}//c2
						
						case 3:{
							
							if(p instanceof Perecedero) { //ver si es de tipo perecedero
								Perecedero per=(Perecedero) p; //el objeto creado sera 
								System.out.println("Introduce los dias a caducar que tiene el producto ahora: ");
								caducar=sc.nextInt();
								sc.nextLine();
								
								per.setCaducar(caducar);
								
								
							}
							
							else if(p instanceof NoPerecedero) {
								NoPerecedero noper=(NoPerecedero) p; //el objeto creado sera 
								
								System.out.println("Introduce el tipo del producto no perecedero: ");
								tipoProd=sc.nextLine();
								sc.nextLine();
								
								
								noper.setTipo(tipoProd);
								
							}
							break;
							
						}//c3
						
						
						
						
					}//cierre de switch
					
				}//cierre de if de contains producto
			}//cierre de for
		}//cierre de if
		return opcion;
	}

	private static void añadirProducto(Scanner sc) {
		String nombre;
		double precio;
		int caducar;
		String tipo;
		Producto producto;
		String tipoProd;
		System.out.println("introduce el nombre: ");
		nombre=sc.next();
		sc.nextLine();
		
		System.out.println("introduce el precio: ");
		precio=sc.nextDouble();
		sc.nextLine();
		
		System.out.println("introduce el tipo: ");
		tipoProd=sc.nextLine();
		//
		
		//si el producto es perecedero
		if(tipoProd.equals("Perecedero")) {

			System.out.println("introduce dias caducar: ");
			//como es perecedero y tiene el elemento caducar de más
			caducar=sc.nextInt();
			sc.nextLine();
			//
			producto=new Perecedero(nombre,precio,caducar);
			
			//añade el producto
			productos.add(producto);
		}

		//si el producto no es perecedero
		else if(tipoProd.equals("No perecedero")) {

			System.out.println("introduce tipo: ");
			tipo=sc.next();
			sc.nextLine();
			
			//
			producto=new NoPerecedero(nombre,precio,tipo);
			
			//añade el producto
			productos.add(producto);
			
		}
		else {
			//si el tipo no es valido no se añade el producto
			System.out.println("Tipo no valido");
		}
	}
	
	/**
	 * 
	 */
	private static void lecturaFichero() {
		try {
			Producto prod=null;
			BufferedReader br = new BufferedReader(new FileReader("src\\ejercicio1\\Producto"));
			String linea=br.readLine();
			while(linea!=null) {//mientras que la linea tenga contenido dentro
				String[] datos=linea.split(";");//recoge cada dato de la linea que recoge las variables de los productos
				String nombre=datos[0];//recoge el nombre en la primera posicion
				double precio=Double.parseDouble(datos[1]);//
				
				try {//ocurre asi si es perecedero
					//si el producto es perecedero, captura los dias a caducar
					int caducar=Integer.parseInt(datos[2]);//dias a caducar
					prod= new Perecedero(nombre,precio,caducar);
				}catch(NumberFormatException e){//si no es perecedero, entonces captura esto
					String tipo =datos[2];
					
					prod=new NoPerecedero(nombre,precio,tipo);
				}finally {//finalmente se añade al producto
					productos.add(prod);
					
				}
				
				linea=br.readLine();//lee la siguiente linea	
			}
			
			br.close();
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	
		
		
		
		
	}//lectura fichero
	
	/**
	 * menu principal del programa
	 */
	private static void menuOpciones() {
		System.out.println("Bienvenido a los productos");
		System.out.println("1. Añadir producto.");
		System.out.println("2. Listar productos.");
		System.out.println("3. Eliminar producto.");
		System.out.println("4. Modificar producto.");
		System.out.println("5. Guardar en fichero.");
		System.out.println("0. Salir.");
		System.out.println();
		System.out.println("introduce la opcion: ");
	}

	
	private static void escrituraFichero() {
		
		
		try {
			BufferedWriter bw=new BufferedWriter(new FileWriter("src\\ejercicio1\\Producto"));
			//recorre la tabla
			for(Producto p: productos) {
			
				
				bw.write(p.getNombre()+";"+p.getPrecio()+";");
				
				
				//mirar si el producto es perecedero
				if(p instanceof Perecedero) {
					Perecedero per=(Perecedero) p; //el objeto creado sera 
					
					
					bw.write(String.valueOf(per.getCaducar()));
					
				}
				
				else if(p instanceof NoPerecedero) {
					NoPerecedero noper=(NoPerecedero) p; //el objeto creado sera 
					
					bw.write(noper.getTipo());
					
				}
				
				bw.newLine();
				bw.flush();
				
			}
			
			
			
			
		} catch (IOException e) {
			
			System.out.println("Error en la apertura del fichero");
			
			System.out.println(e.getMessage());
			
		}
	}

	private static void menuModificar() {
		System.out.println("introduce el dato del producto a modificar: ");
		System.out.println("1: Nombre");
		System.out.println("2: Precio");
		System.out.println("3: Tipo (Perecedero/No perecedero)");
	}//main method
	
}//class










/*
 *
 * 		//como se crea array producto
		String nombre = "";
		double precio = 0;

		
		Producto producto[]=new Producto([]) {
			(nombre,precio)
		};
*/