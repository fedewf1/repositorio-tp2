package ar.edu.unju.fi.entify;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;


/**
 * Representa un producto ofrecido
 * @author Grupo45
 * @version 1.0 date: 8/6/23
 */



@Component
public class Consejo {

	@NotBlank(message="El titulo no puede quedar vacio")
	private String titulo;
	@NotBlank(message="El contenido no puede quedar vacio")
	private String contenido;
	@NotBlank(message="El autor no puede quedar vacio")
	private String autor;
	
	private Integer id;
	
	
	
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
	


	public Consejo(String titulo, String contenido, String autor,Integer id) {
		super();
		this.titulo = titulo;
		this.contenido = contenido;
		this.autor = autor;
		this.id = id;
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




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}


	
	
	
}
