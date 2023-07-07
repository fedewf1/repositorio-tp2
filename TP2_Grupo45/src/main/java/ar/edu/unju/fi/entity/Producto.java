package ar.edu.unju.fi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;




/**
 * Representa a la entidad producto en el sistema. Que se relaciona con la entidad Categoria atravez de un @ManyToOne
 * @author Federico Nicolas Burgos
 * @Version 1.0.5
 */
@Component
@Entity
@Table(name="productos")
public class Producto {

	// Validación del campo nombre
	@NotEmpty(message="el nombre no puede estar vacio.")
	@Size(min=5, max=50,message="El nombre no puede ser inferior a 5 caracteres y mayor a 50.")
    @Column(name="produ_nombre", length=20, nullable=false)
	private String nombre;
	private int codigo;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="produ_id")
    private Long id;
    
    // Validación del campo precio
	@NotNull(message = "El precio no puede quedar vacio")
	@DecimalMin(value = "1.0", message = "El precio debe ser un número positivo")
    @Column(name="produ_precio")
	private Double precio;
	
	// Validación del campo categoría
   // @NotBlank(message="Debe seleccion una categoria.")
   // @Column(name="produ_categoria", length=20, nullable=false)
    //private String categoria;
    
    // Validación del campo descuento
    //@PositiveOrZero(message="El descuento debe ser un valor positivo")
    @NotNull(message = "El descuento no puede ser nulo")
	//@NotNull(message = "El precio no puede quedar vacio")
	//@DecimalMin(value = "1.0", message = "El precio debe ser un número positivo")
    @Max(value=50, message="el descuento no puede ser mayor a 50")
	@Min(value=0, message="el descuento no puede ser menor a 0")
    @Column(name="produ_descuento", length=20, nullable=false)
    private Integer descuento;
    
 // Validación del campo nombreImagen
    @NotBlank(message="Debe seleccion una imagen.")
    @Column(name="produ_imamen", length= 200, nullable=false)
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
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="categoria_id")
    @NotNull(message = "Debes seleccionar una categoria")
    private Categoria categoria;
    //@ManyToOne(mappedBy = "producto", cascade = CascadeType.ALL)
	//private List<Categoria> catDisponible;
    
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

    public Producto(String nombre, int codigo,long id, Double precio, Categoria categoria, Integer descuento, String nombreImagen, boolean estado) {

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

    
    
    /*Métodos accesores (getters y setters) de la clase Producto*/
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Integer getDescuento() {
		return descuento;
	}

	public void setDescuento(Integer descuento) {
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

}

