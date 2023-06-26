package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Articulo;
import ar.edu.unju.fi.entity.Producto;
import jakarta.validation.Valid;

/** 
 * @author federico nicolas burgos grupo 45
 * @category Interfaz
 * @version 1.0.1 date: 11/6/23
 */
public interface IHomeService {
			// Obtiene una lista de productos
			//List<Articulo> getArticulos();
			// devolver un objeto de tipo Articulo
		//	Articulo getIndex();
			//Este método declara un método llamado getArticulo() que también debe devolver un objeto de tipo Articulo
			//Articulo getArticulo();
			List<Articulo> listar();
			// Guarda un producto en la lista de productos
	//		void guardarArticulo( Articulo articulo);
	//		// Elimina un producto de la lista de productos utilizando el código
	//		void eliminarArticulo(Integer codigo);
			// Modifica un producto en la lista de productos utilizando otro producto como referencia
	//		void modificarArticulo(Articulo articuloA);
			// Busca un producto en la lista de productos utilizando el código
	//		Articulo buscarPorCodigo(Integer codigo);
	//		void guardar(@Valid Producto producto);

			void save(Articulo articulo);
}
