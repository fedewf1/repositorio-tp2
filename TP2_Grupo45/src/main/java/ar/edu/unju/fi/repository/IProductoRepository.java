package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.entity.Categoria;
import ar.edu.unju.fi.entity.Producto;

/**
 * Repositorio para acceder a la entidad Producto en la base de datos. En ella hay dos metodos, findByEstado y findByEstadoAndCategiria.
 * @author Federico Nicolas Burgos
 * @version 1.0.2 
 */

public interface IProductoRepository extends CrudRepository<Producto,Long>{
	
      
	//Busca y devuelve una lista de productos por estado.
	public List<Producto> findByEstado (boolean estado);
	
	
	//Busca y devuelve una lista de productos por categoría y estado.
	List<Producto> findByEstadoAndCategoria(boolean estado, String categoria);
	
}
