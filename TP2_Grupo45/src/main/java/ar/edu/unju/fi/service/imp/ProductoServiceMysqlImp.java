package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Categoria;
import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.repository.IProductoRepository;
import ar.edu.unju.fi.service.IProductoService;


/**
 * Implementación del servicio de productos que utiliza MySQL como base de datos.
 *
 * @author freinicks
 * @version 1.0.2
 */
@Service("productoServiceMysql")
public class ProductoServiceMysqlImp implements IProductoService {
	@Autowired
	private IProductoRepository productoRepository;
	@Autowired
	private Producto producto;
	
	@Override
	public void save(Producto product) {
		
		product.setEstado(true);
		productoRepository.save(product);
		
	}
	
	
	
	/**
     * Obtiene una lista de todos los productos activos.
     *
     * @return una lista de productos activos
     */
	@Override
	public List<Producto> listar() {
		
		return productoRepository.findByEstado(true);
		
	}
	
	/**
     * Guarda un producto en la base de datos.
     *
     * @param producto el producto a guardar
     */
	@Override
	public void guardar(Producto producto) {
		
		producto.setEstado(true);
        productoRepository.save(producto);
		
	}
	
	
	/**
     * Cambia el estado de un producto especificado por su ID.
     * Al cambiarlo a false
     * @param id     el ID del producto a eliminar
     * @param estado el nuevo estado del producto
     */
	@Override
	public void eliminar(Long id, boolean esta){
		
		Optional<Producto> objetoOptional = productoRepository.findById(id);

        if (objetoOptional.isPresent()) {
        	Producto objeto = objetoOptional.get();
            objeto.setEstado(esta);
            productoRepository.save(objeto);
        } else {
            throw new IllegalArgumentException("El objeto con el ID " + id + " no existe.");
        }
    }
		
	/**
     * Elimina un producto de la base de datos por su ID.
     *
     * @param id el ID del producto a eliminar
     */	
	@Override
	public void delete(long id) {
		
		productoRepository.deleteById(id);
		
		
	}	
	
	/**
     * Obtiene un producto de la base de datos por su ID.
     *
     * @param id el ID del producto a buscar
     * @return un objeto Optional que contiene el producto encontrado, o vacío si no se encontró
     */
	@Override
	public Optional<Producto> listarId(Long id) {
		return productoRepository.findById(id);
		
	}
	@Override
	public List<Producto> getProductosPorCategoria(String categoria) {
        return productoRepository.findByEstadoAndCategoria(true, categoria);
    }
	
}
