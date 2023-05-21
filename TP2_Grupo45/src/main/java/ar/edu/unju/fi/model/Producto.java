package ar.edu.unju.fi.model;


public class Producto {
    private String nombre;
    private int codigo;
    private double precio;
    private String categoria;
    private int descuento;
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
            double descuentoPorcentaje = descuento / 100.0;
            return precio - (precio * descuentoPorcentaje);
        } else {
            return precio;
        }
    }

	
}

