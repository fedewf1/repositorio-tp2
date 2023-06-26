package ar.edu.unju.fi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.entity.Articulo;


public interface IHomeRepository extends CrudRepository<Articulo, Long> {
	
	//List<Categoria> getCategoria(List<Categoria> categoria1);
	/**
     * Busca y devuelve una lista de productos por estado.
     *
     * @param estado el estado del producto
     * @return una lista de productos que coinciden con el estado especificado
     */
	public List<Articulo> findByEstado (boolean estado);

	//List<Articulo> getArticulos();

	//List<Producto> getProductosPorCategoria(String categoria);
}
