package ar.edu.unju.fi.entity;

import java.util.List;

import org.springframework.stereotype.Component;


import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

import jakarta.validation.constraints.NotBlank;



/**
 * Representa un producto ofrecido
 * @author Jonathan R. Mascareño
 * @version 1.0 date: 21/6/23
 */


@Component
@Entity
@Table(name = "consejos")
public class Consejo {

	@Id
	@Column(name = "cons_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	
	@NotBlank(message="El titulo no puede quedar vacio")
	@Column(name = "cons_titulo")
	private String titulo;
	@NotBlank(message="El contenido no puede quedar vacio")
	@Column(name = "cons_contenido")
	private String contenido;
	@NotBlank(message="El autor no puede quedar vacio")
	@Column(name = "cons_autor")
	private String autor;
	
	@Column(name = "cons_estado")
	private boolean estado = true;
	
	@ElementCollection
	 private List<Consejo> consejos;

	
	
	public Consejo() {
		super();
	}

	/**
	 * Constructor parametrizado
	 * @param titulo es el titulo del consejo
	 * @param contenido es el contenido que tendrá el consejo
	 * @param autor es el autor del consejo
	 * @param id es el numero de id que se asigna a cada consejo
	 * 
	 */
	


	public Consejo(String titulo, String contenido, String autor,Long id, boolean estado) {
		super();
		this.titulo = titulo;
		this.contenido = contenido;
		this.autor = autor;
		this.id = id;
		this.estado = estado;
	}




	public String getTitulo() {
		return titulo;
	}




	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}




	public String getContenido() {
		return contenido;
	}




	public void setContenido(String contenido) {
		this.contenido = contenido;
	}




	public String getAutor() {
		return autor;
	}




	public void setAutor(String autor) {
		this.autor = autor;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}

	public List<Consejo> getConsejos() {
		return consejos;
	}

	public void setConsejos(List<Consejo> consejos) {
		this.consejos = consejos;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	
	
	
}
