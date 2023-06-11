package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.ArrayList;
public class ListaProvincia {
	
	private List<String> provincias;
	
	public ListaProvincia() {
		provincias = new ArrayList<String>();
		
		provincias.add("JUJUY");
		provincias.add("SALTA");
		provincias.add("CORDOBA");
		provincias.add("TUCUMÁN");
		provincias.add("BUENOS AIRES");
		provincias.add("SANTIAGO DEL ESTERO");
		provincias.add("SANTA FÉ");
		provincias.add("SANTA CRUZ");
		provincias.add("SAN LUIS");
		provincias.add("SAN JUAN");
	}
	
	public List<String> getProvincias(){
		return provincias;
	}
	
	public void setProvincias(List<String> provincias) {
		this.provincias = provincias;
	}
	
}
