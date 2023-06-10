package ar.edu.unju.fi.service;

import java.util.List;
import ar.edu.unju.fi.model.Producto;

public interface IProductoService {
	// Obtiene una lista de productos
	List<Producto> getProductos();
	// Obtiene un producto
	Producto getProducto();
	// Agrega un producto a la lista de productos
	void agregarProducto(Producto producto);
	// Guarda un producto en la lista de productos
	void guardar( Producto producto);
	// Elimina un producto de la lista de productos utilizando el código
	void eliminar(Integer codigo);
	// Modifica un producto en la lista de productos utilizando otro producto como referencia
	void modificar(Producto productoA);
	// Busca un producto en la lista de productos utilizando el código
	Producto buscarPorCodigo(Integer codigo);
	
}
