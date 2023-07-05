package ar.edu.unju.fi.entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
//import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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

/**
 * Se procede a añadir: Atributo estado en clase Sucursal Se agregan nuevas
 * anotaciones para referirnos al mapeo y poder indicar que la clase representa
 * una identidad que se transformara en una tabla de la BD
 * 
 * @author joelrojas95
 * @version 1.0 date: 24/06/23
 */

@Component
@Entity
@Table(name = "sucursales")
public class Sucursal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sucu_id")
	private Long id;

	@NotEmpty(message = "El nombre no puede estar vacio")
	@Column(name = "sucu_nombre")
	private String nombreSucursal;

	@NotEmpty(message = "La direccion no puede estar vacia")
	@Size(min = 6, max = 100, message = "La direccion debe contener entre 6 y 100 caracteres")
	@Column(name = "sucu_direccion")
	private String direccion;

	@ManyToOne(cascade = CascadeType.ALL)
	//@NotNull(message = "Debes elegir una provincia")
	@JoinColumn(name = "prov_id")
	@Valid
	private Provincia provincia;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "La fecha no puede ser nula")
	@Past(message = "La fecha debe ser menor a la fecha actual")
	@Column(name = "sucu_fecha_inicio")
	private LocalDate fechaInicio;

	@Email(message = "Debe ingresar un correo valido")
	@NotEmpty(message = "El correo no puede quedar vacio")
	@Column(name = "sucu_email")
	private String email;

	@NotEmpty(message = "El telefono no puede quedar vacio")
	@Column(name = "sucu_telefono")
	private String telefono;
	@NotNull(message = "La cantidad de empleados no puede quedar vacía")
	@Min(value = 5, message = "El valor minimo permitido es 5")
	@Max(value = 30, message = "El valor maximo permitido es 30")
	@Positive(message = "Solo se permiten valores positivos")
	@Column(name = "sucu_cantidad_empleados")
	private Integer cantidadEmpleados;

	@NotEmpty(message = "La fecha no puede estar vacio")
	@Column(name = "sucu_hora_lunes_viernes")
	private String horaLunesViernes;

	@NotEmpty(message = "La fecha no puede estar vacio")
	@Column(name = "sucu_hora_sabados")
	private String horaSabados;

	@NotNull(message = "El codigo no puede ser vacio")
	@Min(value = 1, message = "El valor minimo permitido es 1")
	@Column(name = "sucu_codigo_sucursal")
	private Integer codigoSucursal;

	@Column(name = "sucu_estado")
	private boolean estado = true;

	// Getters and Setters

	public String getEmail() {
		return email;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCantidadEmpleados() {
		return cantidadEmpleados;
	}

	public void setCantidadEmpleados(Integer cantidadEmpleados) {
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

	public Integer getCodigoSucursal() {
		return codigoSucursal;
	}

	public void setCodigoSucursal(Integer codigoSucursal) {
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

	public Long getId() {
		return id;
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



	public Sucursal(Long id, String nombreSucursal, String direccion, Provincia provincia, LocalDate fechaInicio,
			String email, String telefono, Integer cantidadEmpleados, String horaLunesViernes, String horaSabados,
			Integer codigoSucursal, boolean estado) {
		super();
		this.id = id;
		this.nombreSucursal = nombreSucursal;
		this.direccion = direccion;
		this.provincia = provincia;
		this.fechaInicio = fechaInicio;
		this.email = email;
		this.telefono = telefono;
		this.cantidadEmpleados = cantidadEmpleados;
		this.horaLunesViernes = horaLunesViernes;
		this.horaSabados = horaSabados;
		this.codigoSucursal = codigoSucursal;
		this.estado = estado;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
