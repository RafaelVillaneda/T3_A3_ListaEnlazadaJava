import java.util.LinkedList;

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
 * 		2a Al incio
 * 		2B Al final
 * 		2c En un lugar Especifico
 * 3- Eliminar Elemento
 * 		3a Al incio
 * 		3B Al final
 * 		3c En un lugar Especifico
 * 4- Mostrar los elemntos (Recorrer)
 * 
 * 5- Buscar elemnto
 * 6- Vaciar lista
 * 7- Mostrar Cantidad de elemntos
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
		
	}
	public void eliminarElemntoFinal() {
		
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
	
	//6-> Vaciar
	
	//-> 
}


public class PruebaListaEnlazada {

	public static void main(String[] args) {
		LinkedList<Integer> lc= new LinkedList<Integer>();
		ListaEnlazada lista=new ListaEnlazada();
		lista.agregarElementoIncio(7);
		lista.agregarElementoIncio(8);
		lista.agregarElementoIncio(9);
		lista.agregarElementoFinal(10);
		lista.mostrarElementos();
	}

}
