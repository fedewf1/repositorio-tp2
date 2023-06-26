package ar.edu.unju.fi.listas;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Producto;

import java.util.ArrayList;
@Component
public class ListaProductos {
	private List<Producto> productos;
	//public ListaProductos() {
		//productos = new ArrayList<Producto>();
		// Inicialización de la lista de productos con valores predeterminados
		//                         nombre           ;codigo;precio;categoria;descuento; imagen;
	//	productos.add(new Producto("Buzo para perro",6585,6500,"Ropa",50,"/images/Buzo_para_perros.jpg"));
	//	productos.add(new Producto("Moises (con almohadón, plato y pelota)",6520,4500,"Camas y Colchones",0,"/images/moises_mascota.jpeg"));
	//	productos.add(new Producto("Mochila tipo burbuja (Pokemon)",6500,13000, "Mochilas, Bolsos y Transportadores",20,"/images/mochila_pokemon.jpg"));
	//	productos.add(new Producto("Set de paseo reforzado (modelo pitbull)",6785,13300,"Correas",10,"/images/set_paseo_pitbull.jpg"));
	//	productos.add(new Producto("Alimento para gatos, marca Whiskas",6785,11000,"Alimentos",5,"/images/whiskas.jpg"));
	//	productos.add(new Producto("Jaula gaiola para hamsters",6785,13500,"Jaulas,Casas,Peceras",0,"/images/gaiola_hamster.jpg"));
	//}
	// Método para obtener la lista de productos 
	public List<Producto> getProductos() {
		// TODO Auto-generated method stub
		return productos;
	}
	public void setProductos(List<Producto> productos){
		this.productos=productos;
	}
	
	// Calcular el descuento para cada producto
    
}
