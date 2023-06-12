package ejercicio1;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		int opcion=1;
		Scanner sc=new Scanner(System.in);
		//coleccion de producto
		TreeSet<Producto> productos = new TreeSet<Producto>();
		String nombre = "";
		double precio = 0;
		int caducar=0;
		String tipo="";
		Producto producto=null;
		
		String tipoProd="";
		
		while(opcion!=0) {
			//menu
			System.out.println("Bienvenido a los productos");
			System.out.println("1. Añadir producto.");
			System.out.println("2. Listar productos.");
			System.out.println("3. Eliminar producto.");
			System.out.println("4. Modificar producto.");
			System.out.println("5. Guardar en fichero.");
			System.out.println("0. Salir.");
			System.out.println();
			System.out.println("introduce la opcion: ");
			
			opcion=sc.nextInt();
			
			switch (opcion) {
			//
			case 1:{
				

				
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
							System.out.println("introduce el dato del producto a modificar: ");
							System.out.println("1: Nombre");
							System.out.println("2: Precio");
							System.out.println("3: Tipo (Perecedero/No perecedero)");
							
							switch(opcion){
								case 1:{
									System.out.println("Introduce el nombre nuevo: ");
									nombre=sc.next();
									sc.nextLine();
									p.setNombre(nombre); //sirve para reemplazar valores
									
									
								}//c1
								
								case 2:{
									System.out.println("Introduce el nuevo precio del producto: ");
									precio=sc.nextDouble();
									sc.nextLine();
									p.setPrecio(precio); //sirve para reemplazar valores
									
									
								}//c2
								
								case 3:{
									
									if(p instanceof Perecedero) { //ver si es de tipo perecedero
										System.out.println("Introduce los dias a caducar que tiene el producto ahora: ");
										Perecedero per=(Perecedero) p; //el objeto creado sera 
										caducar=sc.nextInt();
										sc.nextLine();
										
										((Perecedero) p).setCaducar(caducar);
										
										
									}
									
									if(p instanceof NoPerecedero) {
										System.out.println("Introduce el tipo del producto no perecedero: ");
										NoPerecedero noper=(NoPerecedero) p; //el objeto creado sera 
										tipoProd=sc.next();
										sc.nextLine();
										
									}
								}//c3
								
								
								
								
							}//cierre de switch
							
						}//cierre de if de contains producto
					}//cierre de for
				}//cierre de if
				
				break;
			}//c4
			
			
			
			//guardar en el texto
			case 5:{
				
				
				
				
				
			}//c5
			
			
			
			
			//salir
			case 0:{
				
				break;
			}//c0
			
				
			}//swotch
			
		}
		
		

		//como se crea array producto
		String nombre = "";
		double precio = 0;

		
		Producto producto[]=new Producto([]) {
			(nombre,precio)
		};
		
	}//main method
	
}//class
