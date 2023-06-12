package ar.edu.unju.fi.listas;

import java.util.List;

import org.springframework.stereotype.Component;


import java.util.ArrayList;

@Component
public class ListaProvincia {

		private List<String> provincias;
	
		
		public ListaProvincia() {
			provincias = new ArrayList<String>();
			
			provincias.add("JUJUY");
			provincias.add("SALTA");
			provincias.add("SANTIAGO DEL ESTERO");
			provincias.add("TUCUMÁN");
			provincias.add("BUENOS AIRES");
			provincias.add("CORDOBA");
			provincias.add("SAN JUAN");
			
		}
	
		
		public List<String> getProvincias(){
			return provincias;
		}
	
		public void setProvincias(List<String> provincias) {
			this.provincias = provincias;
		}

		
}