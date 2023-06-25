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
import jakarta.validation.constraints.DecimalMin;
//import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name = "empleados")
public class Empleado {

	@Id
	@Column(name = "emp_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "El nombre no puede quedar vacio")
	@Column(name = "emp_nombre")
	private String nombre;
	@NotEmpty(message = "La dirección no puede quedar vacio")
	@Column(name = "emp_direccion")
	private String direccion;
	@NotEmpty(message = "El telefono no puede quedar vacio")
	@Column(name = "emp_telefono")
	private String telefono;

	@NotNull(message = "La tarifa no puede quedar vacia")
	@DecimalMin(value = "1.0", message = "La tarifa debe ser un número positivo")
	@Column(name = "emp_tarifa")
	private Float tarifa;

	@NotNull(message = "Debe elegir su dia disponible")
	@Column(name = "emp_diaDisponible")
	@Size(min = 1)
	@ElementCollection
	private List<String> diaDisponible;

//	private String nombreDeServicio;

	@Column(name = "emp_estado")
	private boolean estado = true;

	@NotNull(message = "Debe elegir su horario disponible")
	@Column(name = "horarioDisponible")
	@Size(min = 1)
	@ElementCollection
	private List<String> horarioDisponible;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "serv_id")
	private Servicio servicio;

	public Empleado() {
		super();
	}

	/**
	 * Constructor parametrizado
	 * 
	 * @param id                es el numero de id de un empleado
	 * @param nombre            es el nombre de un empleado
	 * @param direccion         es la direccion de un empleado
	 * @param telefono          es el telefono de un empleado
	 * @param tarifa            es lo que cobra un empleado
	 * @param diaDisponible     es el dia disponible de un empleado
	 * @param horarioDisponible es un rango horario disponible para un empleado
	 * 
	 */

	public Empleado(Long id, String nombre, String direccion, String telefono, Float tarifa, List<String> diaDisponible,
			List<String> horarioDisponible, Servicio servicio, boolean estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.tarifa = tarifa;
		this.diaDisponible = diaDisponible;
		this.horarioDisponible = horarioDisponible;
		this.servicio = servicio;
		this.estado = estado;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Float getTarifa() {
		return tarifa;
	}

	public void setTarifa(Float tarifa) {
		this.tarifa = tarifa;
	}

//	
//
//	public String getNombreDeServicio() {
//		return nombreDeServicio;
//	}
//
//
//	public void setNombreDeServicio(String nombreDeServicio) {
//		this.nombreDeServicio = nombreDeServicio;
//	}

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

	public List<String> getDiaDisponible() {
		return diaDisponible;
	}

	public void setDiaDisponible(List<String> diaDisponible) {
		this.diaDisponible = diaDisponible;
	}

	public List<String> getHorarioDisponible() {
		return horarioDisponible;
	}

	public void setHorarioDisponible(List<String> horarioDisponible) {
		this.horarioDisponible = horarioDisponible;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

}
