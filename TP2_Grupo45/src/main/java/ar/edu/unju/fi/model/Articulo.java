package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Component
public class Articulo {
	@NotBlank(message = "El artículo no puede estar vacío.")
	private String articulo;
	@NotNull(message = "El código no puede ser nulo.")
    @Positive(message = "El código debe ser un número positivo.")
	@Digits(integer = 2, fraction = 0, message = "El código debe ser un número de 4 dígitos")
	private int codigo;
	@NotNull(message = "El artículo no puede estar vacío.")
	@DateTimeFormat(pattern="yyyy/MM/dd")
	public LocalDate fechaArticulo;
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
	
	public Articulo(String articulo, Integer codigo, LocalDate fechaArticulo) {
		super();
		this.articulo = articulo;
		this.codigo = codigo;
		this.fechaArticulo = fechaArticulo;
	}
	
	
}
