package ar.edu.unju.fi.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.entify.Producto;
 
/**
 * Interfaz que define los métodos para el servicio de productos.
 * @author Federico Nicolas Burgos
 * @version 1.0.2
 */
public interface IProductoService {
	// Obtiene una lista de productos
	//public List<Producto> getProductos();
	//public Optional<Producto>listarId(long id);
	// Obtiene un producto
	//public Producto getProducto();
	// Agrega un producto a la lista de productos
	//public void agregarProducto(Producto producto);
	/**
     * Guarda un producto en la lista de productos.
     *
     * @param producto, es el producto a guardar
     */
	// Guarda un producto en la lista de productos
	public void guardar( Producto producto);
	
	/**
     * Elimina un producto de la lista de productos utilizando el código.
     *
     * @param id     el ID del producto a eliminar
     * @param estado el estado del producto a eliminar
     */
	public void eliminar(long id, boolean esta);
	//public void eliminar(Producto producto);
	//public void getId(long Id);
	
	// Modifica un producto en la lista de productos utilizando otro producto como referencia
	//public void modificar(Producto productoA);
	/**
     * Elimina un producto de la lista de productos utilizando el ID.
     *
     * @param id el ID del producto a eliminar
     */
	public void delete(long id);
//	Producto buscarPorCodigo(long codigo);
	/**
     * Obtiene una lista de todos los productos.
     *
     * @return una lista de productos
     */
	List<Producto> listar();
	/**
     * Guarda un producto en la base de datos y devuelve su ID.
     *
     * @param producto el producto a guardar
     * @return el ID del producto guardado
     */
	long save(Producto producto);
	/**
     * Obtiene un producto de la lista de productos por su ID.
     *
     * @param id el ID del producto a buscar
     * @return un objeto Optional que contiene el producto encontrado, o vacío si no se encontró
     */
	Optional<Producto> listarId(long id);
	
	/**
     * Guarda un producto en la base de datos utilizando su ID.
     *
     * @param id el ID del producto a guardar
     */
	public void saveId(long id);
	/**
     * Busca un producto en la base de datos por su ID.
     *
     * @param id el ID del producto a buscar
     * @return un objeto Optional que contiene el producto encontrado, o vacío si no se encontró
     */
	public Optional<Producto> findById(Long id);
	
	
}
