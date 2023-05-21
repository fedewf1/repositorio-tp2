package ar.edu.unju.fi.listas;
import java.util.List;
import ar.edu.unju.fi.model.Producto;
import java.util.ArrayList;

public class ListaProductos {
	private List<Producto> productos;
	public ListaProductos() {
		productos = new ArrayList<Producto>();
		//nombre;codigo;precio;categoria;descuento;
		productos.add(new Producto("Dog Show", 6585, 5000, "Alimento Balanceado", 50));
		productos.add(new Producto("Pedigree", 6520, 9000, "Alimento Balanceado", 0));
		productos.add(new Producto("Ken-L Ration", 6500, 13000, "Alimento Balanceado", 20));
		productos.add(new Producto("Sieger Super Premium", 6785, 13300, "Alimento Balanceado", 0));
		
	}
	public List<Producto> getProductos() {
		// TODO Auto-generated method stub
		return productos;
	}
	public void setProductos(List<Producto> productos){
		this.productos=productos;
	}
	

}
