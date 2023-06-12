package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

/**
 * Representa una sucursal
 * 
 * @author joelrojas95
 * @version 1.0 date: 10/06/23
 */

// Se procede a la incorporacion de validacion de datos

@Component
public class Sucursal {
	@NotEmpty(message = "El nombre no puede estar vacio")
	private String nombreSucursal;

	@NotEmpty(message = "La direccion no puede estar vacio")
	@Size(min = 6, max = 100, message = "La direccion debe contener entre 6 y 100 caracteres")
	private String direccion;

	@NotEmpty(message = "Debe seleccionar una provincia")
	private String provincia;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "La fecha no puede ser null")
	@Past(message = "La fecha debe ser menor a la fecha actual")
	private LocalDate fechaInicio;

	@Email(message = "Debe ingresar un correo valido")
 @NotEmpty(message="El correo no puede quedar vacio")
//	@NotNull(message = "Este campo no puede quedar vacio")
	private String email;

	@NotEmpty(message = "El telefono no puede ser vacio")
	private String telefono;

	@Min(value = 5, message = "El valor minimo permitido es 5")
	@Max(value = 30, message = "El valor maximo permitido es 30")
	@Positive(message = "Solo se permiten valores positivos")
	private int cantidadEmpleados;

	@NotEmpty(message = "La fecha no puede estar vacio")
	private String horaLunesViernes;
	@NotEmpty(message = "La fecha no puede estar vacio")
	private String horaSabados;
	// @DateTimeFormat(pattern="dd/MM/yyyy")
	@NotNull(message = "El codigo no puede ser vacio")
	@Min(value = 1, message = "El valor minimo permitido es 1")
	private int codigoSucursal;

	// Getters and Setters

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCantidadEmpleados() {
		return cantidadEmpleados;
	}

	public void setCantidadEmpleados(int cantidadEmpleados) {
		this.cantidadEmpleados = cantidadEmpleados;
	}

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

	/**
	 * Constructor parametrizado
	 * 
	 * @param nombreSucursal   es el nombre de la sucursal
	 * @param direccion        es la direccion de la sucursal
	 * @param telefono         es el numero telefonico de la sucursal
	 * @param horaLunesViernes es el horario de los dias Lunes a Viernes
	 * @param horaSabados      es el horario de los dias Sabados
	 * @param codigoSucursal   es el codigo de la sucursal
	 */

	public Sucursal(String nombreSucursal, String direccion,String provincia,LocalDate fechaInicio, String telefono,
			int cantidadEmpleados, String horaLunesViernes, String horaSabados, int codigoSucursal,String email) {
		super();
		this.nombreSucursal = nombreSucursal;
		this.direccion = direccion;
		this.provincia = provincia;
		this.fechaInicio = fechaInicio;
		this.telefono = telefono;
		this.cantidadEmpleados = cantidadEmpleados;
		this.horaLunesViernes = horaLunesViernes;
		this.horaSabados = horaSabados;
		this.codigoSucursal = codigoSucursal;
		this.email = email;
	}

}
