package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import ar.edu.unju.fi.model.Sucursal;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ListaSucursales {
	private List<Sucursal> sucursales;
	
	public ListaSucursales() {
		sucursales = new ArrayList<Sucursal>();
		// Inicialización de la lista de sucursales con valores predeterminados
		sucursales = new ArrayList<Sucursal>();
		sucursales.add(new Sucursal("Sucursal 1","Av. General Belgrano 391","3884569762","9:00am - 8:00pm","9:00am - 12:30pm",65));
		//LocalDate.of(2020,10,10),65)
		sucursales.add(new Sucursal("Sucursal 2","Av Forestal 330","3885225777","8:00am - 8:00pm","8:00am - 12:00pm",45));
		//,LocalDate.of(2021,11,10),45
		sucursales.add(new Sucursal("Sucursal 3","Av Irigoyen 234","3884669234","8:30am - 8:00pm","Cerrado",85));
		//,LocalDate.of(2023,01,11),85)
	
	}
	// Método para obtener la lista de productos
	public List<Sucursal> getSucursales() {
		return sucursales;
	}
	public void setSucursales(List<Sucursal> sucursales){
		this.sucursales=sucursales;
	}
    
}
