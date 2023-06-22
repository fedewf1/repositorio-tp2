package ar.edu.unju.fi.entity;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
//import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import org.springframework.stereotype.Component;
@Component
public class Producto {
	// Validación del campo nombre
	@NotEmpty(message="el nombre no puede estar vacio.")
	@Size(min=5, max=100,message="El nombre del producto no puede ser inferior a 50 caracteres y mayor a 100.")
    private String nombre;
	
	// Validación del campo código
	//@Size(min=4, max=4,message="el codigo no puede tener mas ni menos de 4 digitos.")
    @Digits(integer = 4, fraction = 0, message = "El código debe ser un número de 4 dígitos")
    private int codigo;
    
    // Validación del campo precio
	@Positive(message="El precio debe ser un valor positivo y no puede ser cero.")
	//@NotEmpty(message="el nombre no puede estar vacio.")
    private double precio;
	
	// Validación del campo categoría
    @NotBlank(message="Debe seleccion una categoria.")
    private String categoria;
    
    // Validación del campo descuento
    //@PositiveOrZero(message="El descuento debe ser un valor positivo")
    @Max(value=50, message="el descuento no puede ser mayor a 50")
    @NotNull(message = "El descuento no puede ser nulo")
    private int descuento;
    
 // Validación del campo nombreImagen
    @NotBlank(message="Debe seleccion una imagen.")
    private String nombreImagen;

    // Constructor parametrizado
    
    public Producto(String nombre, int codigo, double precio, String categoria, int descuento, String nombreImagen) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.categoria = categoria;
        this.descuento = descuento;
        this.nombreImagen = nombreImagen;
    }

    public Producto() {
		
	}

	// Métodos accesores (getters y setters)
    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPrecio() {
		return precio;
	}

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

	// Método para calcular el descuento
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

