package ArbolBinario;

public class ArbolBinario {
	nodoArbol raiz;

	public ArbolBinario(){
		raiz=null;
	}


	public void agregarNodo(int dato){
		nodoArbol nuevo=new nodoArbol(dato);
		if(raiz==null){
			raiz=nuevo;
		}else{
			nodoArbol auxiliar=raiz;
			nodoArbol padre;
			while(true){
				padre=auxiliar;
				if(dato<auxiliar.dato){
					auxiliar=auxiliar.hijoIzq;
					if(auxiliar==null){
						padre.hijoIzq=nuevo;
						return;
					}
				}else{
					auxiliar=auxiliar.hijoDcho;
					if(auxiliar==null){
						padre.hijoDcho=nuevo;
						return;
					}

				}
			}

		}

	}
	//metodo para saber cuando el arbol esta vacio
	public boolean isEmpty(){
		return raiz==null;
	}
	
	//recorrido in orden
	public void inOrden(nodoArbol R){//R=raiz
		if(R!=null){
			inOrden(R.hijoIzq);
			System.out.print(" "+R.dato);
			inOrden(R.hijoDcho);
		}
		
	}
	
	//recorrido preOrden
	public void preOrden(nodoArbol R){//R=raiz
		if(R!=null){
			System.out.print(" "+R.dato);
			preOrden(R.hijoIzq);
			preOrden(R.hijoDcho);
		}
		
	}
	
	//recorrido postOrden
	public void postOrden(nodoArbol R){
		if(R!=null){
			postOrden(R.hijoIzq);
			postOrden(R.hijoDcho);
			System.out.print(" "+R.dato);
		}
		
	}
	
	//buscar un nodo
	public nodoArbol buscarNodo(int dat){//dat=dato que se quiere encontrar
		nodoArbol aux=raiz;
		while(aux.dato!=dat){
			if(dat<aux.dato){
				aux=aux.hijoIzq;
			}else{
				aux=aux.hijoDcho;
			}
			if(aux==null){//no se encontro dato
				return null;
			}
		}
		return aux;
	}

	//eliinar nodo
	public boolean eliminar(int dat){
		nodoArbol aux=raiz;
		nodoArbol padre=raiz;
		boolean esIzq=true;
		
		while(aux.dato!=dat){
			padre=aux;
			if(dat<aux.dato){
				esIzq=true;
				aux=aux.hijoIzq;
			}else{
				esIzq=false;
				aux=aux.hijoDcho;
			}
			if(aux==null){
				return false;//no encontro el dato en el arbol
			}
		}
		
		if(aux.hijoIzq==null && aux.hijoDcho==null){//el nodo es una hoja
			if(aux==raiz){
				raiz=null;
			}else if(esIzq){
				padre.hijoIzq=null;
			}else{
				padre.hijoDcho=null; 
			}
		}else if(aux.hijoDcho==null){
			if(aux==raiz){
				raiz=aux.hijoIzq;
			}else if(esIzq){
				padre.hijoIzq=aux.hijoIzq;
			}else{
				padre.hijoDcho=aux.hijoIzq; 
			}
		}else if(aux.hijoIzq==null){
			if(aux==raiz){
				raiz=aux.hijoDcho;
			}else if(esIzq){
				padre.hijoIzq=aux.hijoDcho;
			}else{
				padre.hijoDcho=aux.hijoIzq; 
			}
		}else{
			nodoArbol remplazo=obtenerNodoReemplazo(aux);
			if(aux==raiz){
				raiz=remplazo;
			}else if(esIzq){
				padre.hijoIzq=remplazo;
			}else{
				padre.hijoDcho=remplazo;
			}
			remplazo.hijoIzq=aux.hijoIzq;
		}
		return true;
	}
	
	public nodoArbol obtenerNodoReemplazo(nodoArbol nodoRem){
		nodoArbol reemplazarPadre=nodoRem;
		nodoArbol reemplazo=nodoRem;
		nodoArbol aux=nodoRem.hijoDcho;
		while(aux!=null){
			reemplazarPadre=reemplazo;
			reemplazo=aux;
			aux=aux.hijoIzq;
		} 
		if(reemplazo!=nodoRem.hijoDcho){
			reemplazarPadre.hijoIzq=reemplazo.hijoDcho;
			reemplazo.hijoDcho=nodoRem.hijoDcho;
		}
		
		return reemplazo;
	}
	
}
