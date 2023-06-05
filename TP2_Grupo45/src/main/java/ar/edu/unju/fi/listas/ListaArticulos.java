package ar.edu.unju.fi.listas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Articulo;

@Component
public class ListaArticulos {

	private List<Articulo> articulos;
	public ListaArticulos() {
		articulos = new ArrayList<Articulo>();
		// Inicialización de la lista de productos con valores predeterminados
		//                         nombre           ;codigo;precio;categoria;descuento; imagen;//,LocalDate.of(2020,10,10))
		articulos.add(new Articulo("Nuestro objetivo es proporcionar productos de alta calidad para satisfacer las necesidades de los dueños de mascotas y mejorar la calidad de vida de los animales. Esto incluye ofrecer una amplia variedad de alimentos para mascotas, desde alimentos secos hasta húmedos, así como juguetes, camas y otros accesorios.",68));
		articulos.add(new Articulo("Además, la empresa puede ofrecer servicios como consultas nutricionales para ayudar a los dueños de mascotas a elegir los mejores alimentos y productos para sus animales.",65));//,LocalDate.of(2022,10,10))
		articulos.add(new Articulo("El objetivo final es mejorar la salud y la felicidad de las mascotas, lo que a su vez aumenta la satisfacción de los clientes y la rentabilidad de la empresa.",61));//,LocalDate.of(2021,10,10))
		
	}
	// Método para obtener la lista de productos
			public List<Articulo> getArticulos() {
				// TODO Auto-generated method stub
				return articulos;
			}
			public void setArticulos(List<Articulo> articulos){
				this.articulos=articulos;
			}
			//public List<Integer> getCodigos() {
		     //   List<Integer> codigos = new ArrayList<>();
		      //  for (Articulo articulo : articulos) {
		       //     codigos.add(articulo.getCodigo());
		       // }
		        //return codigos;
		    //}
}