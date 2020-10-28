import java.util.LinkedList;
import java.util.Scanner;

class Nodo{
	private int dato;
	private Nodo nodoSiguiente;
	public Nodo() {}
	public Nodo(int dato) {
		this.dato = dato;
	}
	public int getDato() {
		return dato;
	}
	public void setDato(int dato) {
		this.dato = dato;
	}
	public Nodo getNodoSiguiente() {
		return nodoSiguiente;
	}
	public void setNodoSiguiente(Nodo nodoSiguiente) {
		this.nodoSiguiente = nodoSiguiente;
	}
	
	@Override
	public String toString() {
		return "Nodo [dato=" + dato + ", nodoSiguiente=" + nodoSiguiente + "]";
	}
	
}

/*
 * Operaciones Basicas para una lista Enlazada
 * 1- Creacion
 * 2- Agregar Elemento
 * 		2a Al incio------
 * 		2B Al final------
 * 		2c En un lugar Especifico
 * 3- Eliminar Elemento
 * 		3a Al incio-----
 * 		3B Al final-----
 * 		3c Elemento especifico
 * 4- Mostrar los elemntos (Recorrer)-----
 * 
 * 5- Buscar elemento
 * 6- Vaciar lista--------
 * 7- Mostrar Cantidad de elementos------
 * 
 */
class ListaEnlazada{
	Nodo nodoInicio;
	Nodo nodoFin;
	//1-> Crear
	public ListaEnlazada() {
		this.nodoInicio=this.nodoFin=null;
	}
	public boolean verificarVacia() {
		if(nodoInicio==null) {
			return true;
		}else {
			return false;
		}
	}
	//2-> Insetar/Agregar Elemento al inicio
	public void agregarElementoIncio(int dato) {
		Nodo nuevoNodo=new Nodo(dato);
		if(verificarVacia()) {
			nodoInicio=nodoFin=nuevoNodo;
		}else {
			nuevoNodo.setNodoSiguiente(nodoInicio);
			nodoInicio=nuevoNodo;
			//nodoInicio.setNodoSiguiente(nuevoNodo);//Al final jaja 
		}
	}
	public void agregarElementoFinal(int dato) {
		Nodo nuevoNodo=new Nodo(dato);
		nodoFin.setNodoSiguiente(nuevoNodo);
		nodoFin=nuevoNodo;
	}
	//3-> Eliminar Elemento
	public void eliminarElemntoInicial() {
		if(verificarVacia()) {
			System.out.println("No se puede eliminar lista Vacia");
		}else if(nodoInicio==nodoFin) {
			nodoInicio=nodoFin=null;
		}else {
			Nodo nodoAuxiliar=nodoInicio;
			System.out.println("Se elimino el dato: "+nodoAuxiliar.getDato());
			nodoInicio=nodoInicio.getNodoSiguiente();
			nodoAuxiliar=null;
		}
	}
	public void eliminarElemntoFinal() {
		if(verificarVacia()) {
			System.out.println("No se puede eliminar lista Vacia");
		}else if(nodoInicio==nodoFin) {
			nodoInicio=nodoFin=null;
		}else {
			Nodo nodoAuxiliar=nodoInicio;
			while(nodoAuxiliar.getNodoSiguiente()!=nodoFin) {
				nodoAuxiliar=nodoAuxiliar.getNodoSiguiente();
			}
			System.out.println("El dato eliminado es: "+nodoAuxiliar.getDato());
			nodoFin=nodoAuxiliar;
			nodoFin.setNodoSiguiente(null);
		}
	}
	public int eliminarDatoEspecifico(int dato) {
		if(verificarVacia()) {// Caso 1 esta vacia
			return -1;
		}else if (nodoInicio==nodoFin && nodoInicio.getDato()==dato){//Hay un solo dato
			Nodo nodoAux=nodoInicio;
			nodoInicio=nodoFin=null;
			return nodoAux.getDato();
		}else {// Caso 3 Hay mas de un nodo y el dato puede estar en alguna pocicion
			Nodo nodoAnterior,nodoSig;
			nodoAnterior=nodoInicio;
			nodoSig=nodoAnterior.getNodoSiguiente();
			while(nodoSig !=null && nodoSig.getDato()!=dato) {
				nodoAnterior = nodoAnterior.getNodoSiguiente();
				nodoSig=nodoSig.getNodoSiguiente();
			}
				if(nodoSig!=null && nodoSig.getDato()==dato ) {
					int n=nodoSig.getDato();
					nodoAnterior.setNodoSiguiente(nodoSig.getNodoSiguiente());
					nodoSig=nodoSig.getNodoSiguiente();
					return n;
				}else {
					return -2;
				}
		}
		
	}
	//4-> Mostrar Elementos
	public void mostrarElementos() {
		Nodo nodoActual=nodoInicio;
		while(nodoActual!=null) {
			System.out.print("["+nodoActual.getDato()+"] -->");
			nodoActual=nodoActual.getNodoSiguiente();
		}
		System.out.println();
	}
	//5-> Buscar elemento
	public boolean buscarElemento(int dato) {
		if(verificarVacia()) {// Caso 1 esta vacia
			return false;
		}else if (nodoInicio==nodoFin && nodoInicio.getDato()==dato){//Hay un solo dato
			Nodo nodoAux=nodoInicio;
			nodoInicio=nodoFin=null;
			return true;
		}else {// Caso 3 Hay mas de un nodo y el dato puede estar en alguna pocicion
			Nodo nodoAnterior,nodoSig;
			nodoAnterior=nodoInicio;
			nodoSig=nodoAnterior.getNodoSiguiente();
			while(nodoSig !=null && nodoSig.getDato()!=dato) {
				if(nodoInicio.getDato()==dato) {
					return true;
				}
				nodoAnterior = nodoAnterior.getNodoSiguiente();
				nodoSig=nodoSig.getNodoSiguiente();
			}
				if(nodoSig!=null && nodoSig.getDato()==dato) {
					nodoAnterior.setNodoSiguiente(nodoSig.getNodoSiguiente());
					nodoSig=nodoSig.getNodoSiguiente();
					return true;
				}else {
					return false;
				}
		}
	}
	//6-> Vaciar
	public void vaciarLista() {
		this.nodoInicio=this.nodoFin=null;
	}
	public void mostrarCantidadElementos() {
		Nodo nodoActual=nodoInicio;
		int cantidad=0;
		while(nodoActual!=null) {
			cantidad++;
			nodoActual=nodoActual.getNodoSiguiente();
		}
		System.out.println("La lista tiene: "+cantidad);
	}
}


public class PruebaListaEnlazada {

	public static void main(String[] args) {
		LinkedList<Integer> lc= new LinkedList<Integer>();
		Scanner entrada=new Scanner(System.in);
		int op=0;
		ListaEnlazada lista=new ListaEnlazada();
		do {
		System.out.println("Elige una opcion:");
		System.out.println("1- Verificar si la lista esta vacia");
		System.out.println("2- Insertar elemento");
		System.out.println("3- Eliminar elemento");
		System.out.println("4- Mostrar elementos");
		System.out.println("5- Vaciar lista");
		System.out.println("6- Cantidad de elementos");
		System.out.println("7- Buscar Elemento");
		System.out.println("8- Salir ");
		op=entrada.nextInt();
		switch (op) {
		case 1:
			System.out.println(lista.verificarVacia() ?"La lista esta vacia":"La lista no esta vacia");
			break;
		case 2:
			int dato=0;
			String op2="";
			do {
				entrada.nextLine();
				System.out.println("A) Insertar al inicio de la lista");
				System.out.println("B) Insertar al Final de la lista");
				System.out.println("C) Regresar al menu principal");
				op2=entrada.nextLine().toUpperCase();
				switch(op2) {
				case "A":
					System.out.print("Ingresa el dato: ");
					dato=entrada.nextInt(); System.out.println();
					lista.agregarElementoIncio(dato);
					break;
				case "B":
					System.out.print("Ingresa el dato: ");
					dato=entrada.nextInt(); System.out.println();
					lista.agregarElementoFinal(dato);
					break;
				case "C":
					System.out.println("Regresando al menu principal");
					break;
					default:
						System.out.println("Elige una opcion disponible");
						break;
				}
			}while(!(op2.equalsIgnoreCase("A") ||op2.equalsIgnoreCase("B") ||op2.equalsIgnoreCase("C") ));
			break;
		case 3:
			do {
				entrada.nextLine();
				System.out.println("A) Eliminar al inicio de la lista");
				System.out.println("B) Eliminar al Final de la lista");
				System.out.println("C) eliminar dato especifico");
				op2=entrada.nextLine().toUpperCase();
				switch(op2) {
				case "A":
					lista.eliminarElemntoInicial();
					break;
				case "B":
					lista.eliminarElemntoInicial();
					break;
				case "C":
					System.out.println("Ingresa el dato");
					int datoEliminar=entrada.nextInt();
					int num=lista.eliminarDatoEspecifico(datoEliminar);
					if(num==-1) {
						System.out.println("Lista vacia");
					}else {
						System.out.println(num==-2?" Dato no encontrado" :"Se elimino el dato "+num+" correctamente");
					}
					
					break;
					default:
						System.out.println("Elige una opcion disponible");
						break;
				}
			}while(!(op2.equalsIgnoreCase("A") ||op2.equalsIgnoreCase("B")||op2.equalsIgnoreCase("C")));
			break;
		case 4:
			lista.mostrarElementos();
			break;
		case 5:
			lista.vaciarLista();
			System.out.println("Se vacio la lista");
			break;
		case 6:
			lista.mostrarCantidadElementos();
			break;
		case 7:
			System.out.println("Ingresa el dato que deseas buscar");
			int d=entrada.nextInt();
			System.out.println(lista.buscarElemento(d)? "El dato: "+d+" si existe en la lista":"El dato no esta en la lista");
			break;
		case 8:
			System.out.println("Saliendo...");
			break;
		default:
			System.out.println("Error elige una opcion disponible en el menu");
			break;
		}
		
		}while(op!=8);
	}

}
