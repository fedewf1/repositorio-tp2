package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.entity.Categoria;
import ar.edu.unju.fi.entity.Producto;

/**
 * Repositorio para acceder a la entidad Producto en la base de datos.
 * @author Federico Nicolas Burgos
 * @version 1.0.1
 */

public interface IProductoRepository extends CrudRepository<Producto,Long>{
	/**
     * Busca y devuelve una lista de productos por estado.
     *
     * @param estado el estado del producto
     * @return una lista de productos que coinciden con el estado especificado
     */
	public List<Producto> findByEstado (boolean estado);
	  /**
     * Busca y devuelve una lista de productos por categoría y estado.
     *
     * @param categoria la categoría del producto
     * @param estado    el estado del producto
     * @return una lista de productos que coinciden con la categoría y estado especificados
     */
	List<Producto> findByEstadoAndCategoria(boolean estado, String categoria);
	
}
