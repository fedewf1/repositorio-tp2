package ar.edu.unju.fi.entify;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Clase que representa la entidad Categoria.
 * @author Federico Nicolas Burgos
 * @version 1.0.1
 * 
 */
public class Categoria {
	private String nombre;
	private Long idCategoria;
	
	private List<Categoria> categori;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	 /**
     * Obtiene el nombre de la categoría.
     *
     * @return el nombre de la categoría
     */
	public String getNombre() {
		return nombre;
	}
	/**
     * Establece el nombre de la categoría.
     *
     * @param nombre el nombre de la categoría a establecer
     */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
     * Obtiene la lista de categorías.
     *
     * @return la lista de categorías
     */
	public Long getIdCategoria() {
		return idCategoria;
	}
	/**
     * Establece la lista de categorías.
     *
     * @param categori la lista de categorías a establecer
     */
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}
	
}
