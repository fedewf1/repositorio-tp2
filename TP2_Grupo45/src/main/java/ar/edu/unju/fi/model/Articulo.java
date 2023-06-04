package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class Articulo {
	
	private String articulo;
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
