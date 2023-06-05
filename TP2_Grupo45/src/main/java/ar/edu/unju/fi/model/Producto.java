package ar.edu.unju.fi.model;

public class Producto {
	// Atributos
		private String nombre;
	    private int codigo;
	    private double precio;
	    private String categoria;
	    private int descuento;

	    // Getters y setters
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
	    
	    // Constructor parametrizado
	    public Producto(String nombre, int codigo, double precio, String categoria, int descuento) {
	        this.nombre = nombre;
	        this.codigo = codigo;
	        this.precio = precio;
	        this.categoria = categoria;
	        this.descuento = descuento;
	    }

	    // Método para calcular el descuento y obtener el precio con descuento
	    public double calcularDescuento() {
	        if (descuento > 0 && descuento <= 50) {
	            double porcentajeDescuento = descuento / 100.0;
	            double descuentoAplicado = precio * porcentajeDescuento;
	            return precio - descuentoAplicado;
	        } else {
	            return precio;
	        }
	    }
	    
}
