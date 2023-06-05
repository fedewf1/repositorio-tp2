package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

/* 
Se procede a la incorporacion de validacion de datos
*/
@Component
public class Sucursal {
	@NotEmpty(message="El nombre no puede estar vacio")
	private String nombre;
	
	@NotEmpty(message="La direccion no puede estar vacio")
	@Size(min=10, max=100, message="La direccion debe contener entre 10 y 100 caracteres")
	private String direccion;
	
	@NotBlank(message="Debe seleccionar una provincia")
	private String provincia;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull(message="La fecha no puede ser null")
	@Past(message="La fecha debe ser menor a la fecha actual")
	private LocalDate fechaInicio;
	
	@Email(message="Debe ingresar un email con formato valido")
	@NotEmpty(message="El email no puede ser vacio")
	private String email;
	
	@NotEmpty(message="El telefono no puede ser vacio")
	@Min(value=10, message="El valor minimo permitido es 10")
	@Max(value=20, message="El valor maximo permitido es 20")
	@Positive(message="Solo se permiten valores positivos")
	private String telefono;
	
	@Min(value=5, message="El valor minimo permitido es 5")
	@Max(value=30, message="El valor maximo permitido es 30")
	@Positive(message="Solo se permiten valores positivos")
	private int cantidadEmpleados;
	
	public Sucursal() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Sucursal(String nombre, String direccion, String provincia, LocalDate fechaInicio, String email,
			String telefono, int cantidadEmpleados) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.provincia = provincia;
		this.fechaInicio = fechaInicio;
		this.email = email;
		this.telefono = telefono;
		this.cantidadEmpleados = cantidadEmpleados;
	}

	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getCantidadEmpleados() {
		return cantidadEmpleados;
	}

	public void setCantidadEmpleados(int cantidadEmpleados) {
		this.cantidadEmpleados = cantidadEmpleados;
	}
}