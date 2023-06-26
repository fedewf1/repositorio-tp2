package ar.edu.unju.fi.entity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
//import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.util.List;

import org.springframework.stereotype.Component;




/**
 * Representa un producto en el sistema.
 * @author Federico Nicolas Burgos
 * @Version 1.0.5
 */
@Component
@Entity
@Table(name="productos")
public class Producto {
	/**
     * El nombre del producto.
     */
	
	// Validación del campo nombre
	@NotEmpty(message="el nombre no puede estar vacio.")
	@Size(min=5, max=100,message="El nombre del producto no puede ser inferior a 50 caracteres y mayor a 100.")
    @Column(name="produ_nombre", length=20, nullable=false)
	private String nombre;
	private int codigo;
    
	
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="produ_id")
    /**
     * El código del producto.
     */
    private Long id;
    
    // Validación del campo precio
	@Positive(message="El precio debe ser un valor positivo y no puede ser cero.")
	//@NotEmpty(message="el nombre no puede estar vacio.")
    @Column(name="produ_precio")
	/**
     * El precio del producto (sin descuento).
     */
	private double precio;
	
	// Validación del campo categoría
    @NotBlank(message="Debe seleccion una categoria.")
    @Column(name="produ_categoria", length=20, nullable=false)
    /**
     * La categoría del producto.
     */
    private String categoria;
    
    // Validación del campo descuento
    //@PositiveOrZero(message="El descuento debe ser un valor positivo")
    @Max(value=50, message="el descuento no puede ser mayor a 50")
    @NotNull(message = "El descuento no puede ser nulo")
    @Column(name="produ_descuento", length=20, nullable=false)
    /**
     * El descuento del producto.
     */
    private int descuento;
    
 // Validación del campo nombreImagen
    @NotBlank(message="Debe seleccion una imagen.")
    @Column(name="produ_imamen", length= 200, nullable=false)
    /**
     * El nombre de la imagen del producto. La imagen debe estar en la carpeta static, dado que no realiza
     * la subida del archivo.
     */
    private String nombreImagen;
    
    @Column(name="produ_estado")
    /**
     * El estado del producto. Esta variable es la que definira si se el producto sera visible o no en la
     * interfaz web.
     */
    private boolean estado;
    /**
     * La categoría a la cual pertenece el producto. Esta es una clase en la cual se intento con el material
     * brindado que tenga una relacion manytoone con producto.
     */
  //  private Categoria categori;
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
	private List<Categoria> catDisponible;
    
    /**
     * Constructor parametrizado.
     *
     * @param nombre       el nombre del producto
     * @param codigo       el código del producto
     * @param id           el ID del producto
     * @param precio       el precio del producto
     * @param categoria    la categoría del producto
     * @param descuento    el descuento del producto
     * @param nombreImagen el nombre de la imagen del producto
     * @param estado       el estado del producto
     */
    public Producto(String nombre, int codigo,long id, double precio, String categoria, int descuento, String nombreImagen, boolean estado) {
        this.nombre = nombre;
        this.id = id;
        this.precio = precio;
        this.categoria = categoria;
        this.descuento = descuento;
        this.nombreImagen = nombreImagen;
        this.estado=estado;
    }

    public Producto() {
    	super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	 /**
     * Obtiene el ID del producto.
     *
     * @return el ID del producto
     */
	public Long getId() {
		return id;
	}
	/**
     * Establece el ID del producto.
     *
     * @param id el ID del producto
     */
	public void setId(Long id) {
		this.id = id;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	// Métodos accesores (getters y setters)
    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getProdu_id() {
		return id;
	}
	
	public void setProdu_id(long id) {
		this.id = id;
	}
	/**
     * Obtiene el precio del producto.
     *
     * @return el precio del producto
     */
	public double getPrecio() {
		return precio;
	}
	/**
     * Establece el precio del producto.
     *
     * @param precio el precio del producto
     */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	
    public String getNombreImagen() {
		return nombreImagen;
	}

	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}

	/**
     * Calcula el descuento aplicado al precio del producto.
     *
     * @return el precio con el descuento aplicado
     */
    public double calcularDescuento() {
        if (descuento > 0 && descuento <= 50) {
            double descuentoPorcentaje = (double)descuento / 100;
            return precio - (precio * descuentoPorcentaje);
        } else {
        	//double descuentoPorcentaje = descuento / 100;
            return precio;
        }
    }
    /**
     * Obtiene la categoría del producto.
     *
     * @return la categoría del producto
     */

}

