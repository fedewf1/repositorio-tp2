package ar.edu.unju.fi.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * Representa un producto en el sistema.
 * @author Federico Nicolas Burgos
 * @Version 1.0.2 date: 25/06/2023
 */
@Component
@Entity
@Table(name="articulos")
public class Articulo {
	@NotBlank(message = "El artículo no puede estar vacío.")
	@Column(name="articulos_nombres", length=150, nullable=false)
	private String articulo;
	
	@NotNull(message = "El código no puede ser nulo.")
    @Positive(message = "El código debe ser un número positivo.")
	@Digits(integer = 2, fraction = 0, message = "El código debe ser un número de 4 dígitos")
	private int codigo;
	
	
	@NotNull(message = "La fecha no puede estar vacío.")
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@Column(name = "fecha_articulos")
	public LocalDate fechaArticulo;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="artic_id")
	/**
	* El código del articulo.
	*/
	private Long id;
	
	
	/**
     * El estado del producto. Esta variable es la que definira si se el producto sera visible o no en la
     * interfaz web.
     */
	@Column(name="artic_estado")
    private boolean estado;
	
	//metodos gettes y settes auto generados
	public String getArticulo() {
		return articulo;
	}
	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}
	public Integer getCodigo() {
		return codigo;
	} 
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public LocalDate getFechaArticulo() {
		return fechaArticulo;
	}
	public void setFechaArticulo(LocalDate fechaArticulo) {
		this.fechaArticulo = fechaArticulo;
	}
	public Articulo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	/*
	 * Contructor parametrizado
	 * @param articulo es el articulo que se muestra en el index
	 * @param codigo es el codigo del articulo, con el que es ingresado en la listaArticulos
	 * @param fechaArticulo es la fecha en la que el articulo fue creado
	 */
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public Articulo( String articulo, int codigo, LocalDate fechaArticulo, Long id, boolean estado) {
		
		
		super();
		this.articulo = articulo;
		this.codigo = codigo;
		this.fechaArticulo = fechaArticulo;
		this.id = id;
		this.estado = estado;
	}
	
	
	
}
