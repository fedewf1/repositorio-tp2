package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Sucursal {
	private String nombreSucursal,direccion,telefono,horaLunesViernes,horaSabados;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private LocalDate fechaInicio;
    private int codigoSucursal;
    
    
	
	public String getNombreSucursal() {
		return nombreSucursal;
	}
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
	public int getCodigoSucursal() {
		return codigoSucursal;
	}
	public void setCodigoSucursal(int codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
	}
	
	
	
	
	public String getHoraLunesViernes() {
		return horaLunesViernes;
	}
	public void setHoraLunesViernes(String horaLunesViernes) {
		this.horaLunesViernes = horaLunesViernes;
	}
	public String getHoraSabados() {
		return horaSabados;
	}
	public void setHoraSabados(String horaSabados) {
		this.horaSabados = horaSabados;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Sucursal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Sucursal(String nombreSucursal, String direccion, String telefono, String horaLunesViernes,
			String horaSabados, int codigoSucursal) {
		super();
		this.nombreSucursal = nombreSucursal;
		this.direccion = direccion;
		this.telefono = telefono;
		//this.horarios = horarios;
		this.horaLunesViernes = horaLunesViernes;
		this.horaSabados = horaSabados;
		//this.fechaInicio = fechaInicio;
		this.codigoSucursal = codigoSucursal;
	}
	
	
}
