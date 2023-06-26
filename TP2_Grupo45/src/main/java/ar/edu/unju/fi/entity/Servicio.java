package ar.edu.unju.fi.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
//import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import org.springframework.stereotype.Component;
//import jakarta.validation.constraints.DecimalMin;
//import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

/**
 * Representa un servicio ofrecido
 * 
 * @author Jonathan R. Mascareño
 * @version 1.0 date: 21/6/23
 */

@Component
@Entity
@Table(name = "servicios")
public class Servicio {

	@Id
	@Column(name = "serv_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "El nombre no puede quedar vacio")
	@Column(name = "serv_nombre")
	private String nombreDeServicio;

//	@Column(name = "serv_estado")
//	private boolean estado = true;

	@OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL)
	private List<Empleado> empleados;

	public Servicio() {
		super();
	}

	/**
	 * Constructor parametrizado
	 * 
	 * @param id               es el numero de id de un trabajador
	 * @param nombreDeServicio es el nombre de un servicio determinado
	 * @param estado           es el estado de un servicio en valor true or false
	 * 
	 */

	public Servicio(Long id, String nombreDeServicio) {
		super();
		this.id = id;
		this.nombreDeServicio = nombreDeServicio;
//		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreDeServicio() {
		return nombreDeServicio;
	}

	public void setNombreDeServicio(String nombreDeServicio) {
		this.nombreDeServicio = nombreDeServicio;
	}

//	public boolean isEstado() {
//		return estado;
//	}
//
//	public void setEstado(boolean estado) {
//		this.estado = estado;
//	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

}
