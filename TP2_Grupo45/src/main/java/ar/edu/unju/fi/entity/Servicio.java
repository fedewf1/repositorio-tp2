package ar.edu.unju.fi.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

/**
 * Representa un servicio ofrecido
 * @author Jonathan R. Mascareño
 * @version 1.0 date: 21/6/23
 */

@Component
@Entity
@Table
public class Servicio {
	
	@Id
	@Column(name="serv_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	@NotEmpty(message = "El nombre no puede quedar vacio")
	@Column(name="serv_nombre")
	private String nombre;
	@NotEmpty(message = "La dirección no puede quedar vacio")
	@Column(name="serv_direccion")
	private String direccion;
	@NotEmpty(message = "El telefono no puede quedar vacio")
	@Column(name="serv_telefono")
	private String telefono;
	
	
	

	@NotNull(message = "La tarifa no puede quedar vacia")
	@DecimalMin(value="1.0",message = "La tarifa debe ser un número positivo")
	@Column(name="serv_tarifa")
	private Float tarifa;
	@NotBlank(message = "Debe elegir el tipo de servicio")
	@Column(name="serv_tipoDeServicio")
	private String tipoDeServicio;

	@NotNull(message = "Debe elegir su dia disponible")
	@Column(name = "serv_diaDisponible")
	private List<String> diaDisponible;
	@NotNull(message = "Debe elegir su horario disponible")
	@Column(name = "serv_horarioDisponible")
	private List<String> horarioDisponible;

	@Column(name="serv_estado")
	private boolean estado = true;
	
	public Servicio() {
		super();
	}

	
	
	/**
	 * Constructor parametrizado
	 * @param id es el numero de id de un trabajador
	 * @param nombre es el nombre del trabajador
	 * @param direccion  es la direccion del trabajador
	 * @param telefono es el telefono del trabajador
	 * @param tarifa es lo que cobrará el trabajador
	 * @param tipoDeServicio se refiere al tipo de servicio que ofrece el trabajador
	 *  @param  diaDisponible se refiere al dia de la semana disponible para el trabajador
	 *  @param  horarioDisponible se refiere a un rango de tiempo disponible para el trabajador
	 */
	
	
	public Servicio(String nombre, String direccion, String telefono, Float tarifa, String tipoDeServicio,
			List<String> diaDisponible, List<String> horarioDisponible, boolean estado) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.tarifa = tarifa;
		this.tipoDeServicio = tipoDeServicio;
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

	public String getTipoDeServicio() {
		return tipoDeServicio;
	}

	public void setTipoDeServicio(String tipoDeServicio) {
		this.tipoDeServicio = tipoDeServicio;
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



	public Long getId() {
		return id;
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
