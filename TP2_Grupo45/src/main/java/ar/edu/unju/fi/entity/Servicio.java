package ar.edu.unju.fi.entity;

import java.util.List;


import org.springframework.stereotype.Component;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * Representa un servicio ofrecido
 * @author Jonathan R. Mascareño
 * @version 1.0 date: 21/6/23
 */

@Component
public class Servicio {
	
	
	@NotEmpty(message = "El nombre no puede quedar vacio")
	private String nombre;
	@NotEmpty(message = "La dirección no puede quedar vacio")
	private String direccion;
	@NotEmpty(message = "El telefono no puede quedar vacio")
	private String telefono;
	
	@NotNull(message="Este campo debe tener un valor")
	@DecimalMin(value="1.0",message = "La tarifa debe ser un número positivo")
	private Float tarifa;
	@NotBlank(message = "Debe elegir el tipo de servicio")
	private String tipoDeServicio;

	@NotEmpty(message = "Debe elegir su dia disponible")
	private List<String> diaDisponible;
	@NotEmpty(message = "Debe elegir su horario disponible")
	private List<String> horarioDisponible;

	public Servicio() {
		super();
	}

	
	
	/**
	 * Constructor parametrizado
	 * @param nombre es el nombre del trabajador
	 * @param direccion  es la direccion del trabajador
	 * @param telefono es el telefono del trabajador
	 * @param tarifa es lo que cobrará el trabajador
	 * @param tipoDeServicio se refiere al tipo de servicio que ofrece el trabajador
	 *  @param  diaDisponible se refiere al dia de la semana disponible para el trabajador
	 *  @param  horarioDisponible se refiere a un rango de tiempo disponible para el trabajador
	 */
	
	
	public Servicio(String nombre, String direccion, String telefono, Float tarifa, String tipoDeServicio,
			List<String> diaDisponible, List<String> horarioDisponible) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.tarifa = tarifa;
		this.tipoDeServicio = tipoDeServicio;

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
		
}
