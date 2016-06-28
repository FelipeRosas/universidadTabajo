package ArbolBinario;

import javax.swing.JOptionPane;

public class mainArbol {

	public static void main(String[] args) {
		int opcion=0,dato;
		ArbolBinario arbolito = new ArbolBinario();
		
		do{
			opcion=Integer.parseInt(JOptionPane.showInputDialog(null,
					"1.-agregar nodo\n2.-buscar nodo\n3.-recorrido inOrden\n"
					+"4.-recorrido preOrden\n5recorrido postOrden\n6.-Eliminar nodo\n7.-salir"));
			
			switch(opcion){
			case 1:
					dato=Integer.parseInt(JOptionPane.showInputDialog(null,"ingresa un dato al arbol"));
					arbolito.agregarNodo(dato);
				break;
			case 2:
					dato=Integer.parseInt(JOptionPane.showInputDialog(null,"ingresa el dato que quieres buscar"));
					if(arbolito.isEmpty()){
						JOptionPane.showMessageDialog(null,"EL arbol esta vacio");
					}else{
						dato=Integer.parseInt(JOptionPane.showInputDialog(null,"ingresa el dato que quieres buscar"));
					}
				break;
			case 3:
				arbolito.inOrden(arbolito.raiz);
				System.out.println();
				break;
			case 4:
				arbolito.preOrden(arbolito.raiz);
				System.out.println();
				break;
			case 5:
				arbolito.postOrden(arbolito.raiz);
				System.out.println();
				break;
			case 6:
				dato=Integer.parseInt(JOptionPane.showInputDialog(null,"ingresa un dato a eliminar"));
				if(arbolito.eliminar(dato)){
					JOptionPane.showMessageDialog(null,"daato eliminado");
				}else{
					JOptionPane.showMessageDialog(null,"daato no esta en el arbol");	
				}
				
				break;
			case 7:
				JOptionPane.showMessageDialog(null,"programa finalizado");
				break;
				default:
					JOptionPane.showMessageDialog(null,"opcionIncorrecta");
				break;
			}
			
		}while(opcion!=7);

	}

}
