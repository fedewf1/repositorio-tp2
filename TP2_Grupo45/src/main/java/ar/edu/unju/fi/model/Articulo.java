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
	//@DateTimeFormat(pattern="dd/MM/yyyy")
	//private LocalDate fechaInicio;
	
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
	//public LocalDate getFechaInicio() {
	//	return fechaInicio;
	//}
	//public void setFechaInicio(LocalDate fechaInicio) {
	//	this.fechaInicio = fechaInicio;
	//}
	public Articulo() {
		super();
		// TODO Auto-generated constructor stub
	}
	//, LocalDate fechaInicio
	public Articulo(String articulo, Integer codigo) {
		super();
		this.articulo = articulo;
		this.codigo = codigo;
	//	this.fechaInicio = fechaInicio;
	}
	
	
}
