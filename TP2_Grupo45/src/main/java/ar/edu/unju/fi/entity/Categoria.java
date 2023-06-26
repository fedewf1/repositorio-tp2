package ar.edu.unju.fi.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Clase que representa la entidad Categoria.
 * @author Federico Nicolas Burgos
 * @version 1.0.1
 * 
 */
@Component
@Entity
@Table(name="categoria_productos")
public class Categoria {
	private String nombre;
	
	@NotNull(message = "Debe elegir una categoria disponible")
	@Column(name = "cat_Disponible")
	@Size(min = 1)
	@ElementCollection
	private List<String> catDisponible;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "produ_id")
	private Producto producto;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategoria;
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
