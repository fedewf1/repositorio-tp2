package ar.edu.unju.fi.listas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Sucursal;
 
@Component
public class ListaSucursales {
	
	private List<Sucursal> sucursales;
	
	public ListaSucursales() {
		
		// Inicialización de la lista de sucursales con valores predeterminados
		sucursales = new ArrayList<Sucursal>();
		
		
		sucursales.add(new Sucursal("Sucursal 1", "Av. General Belgrano 391","SALTA",LocalDate.of(2020,10,10),"4309784",15, "9:00am - 8:00pm","9:00am - 12:30pm",15,"sucursal1@gmail.com", false));		
//		sucursales.add(new Sucursal("Sucursal 2", "Av. Forestal 330",LocalDate.of(2017,10,10),"4309784",15, "9:00am - 8:00pm","Cerrado",10,"sucursal2@gmail.com"));
		

	
	}


	public List<Sucursal> getSucursales() {
		return sucursales;
	}



	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}
	
}
