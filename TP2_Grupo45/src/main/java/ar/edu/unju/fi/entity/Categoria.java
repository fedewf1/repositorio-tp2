package ar.edu.unju.fi.entity;

import java.util.List;
import org.springframework.stereotype.Component;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;


/**
 * Clase que representa la entidad Categoria. Se relaciona con productos a travez de un @OneToMany
 * @author Federico Nicolas Burgos
 * @version 1.0.2 07/07/2023
 *
 */
@Component
@Entity
@Table(name="categorias_productos")
public class Categoria {
	//@NotNull(message = "Debe elegir una categoria disponible")
	//@Column(name = "cat_Disponible")
	//@Size(min = 1)
	//@ElementCollection
	//private List<String> catDisponible;
	@Id
	@Column(name = "categoria_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategoria;
	
	@NotEmpty(message = "El nombre no puede quedar vacio")
	@Column(name = "nombre_categoria")
	private String nombreCategoria;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	private List<Producto> productos;
	
	
	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}


	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	//Constructor parametrizado
	/**
	 * @param idCategoria
	 * @param nombreCategoria
	 */
	public Categoria(Long idCategoria, String nombreCategoria) {
		super();
		this.idCategoria = idCategoria;
		this.nombreCategoria = nombreCategoria;
	}
	public Categoria() {
		super();
	}
}
