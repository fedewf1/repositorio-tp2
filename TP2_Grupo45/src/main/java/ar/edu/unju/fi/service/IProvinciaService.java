package ar.edu.unju.fi.service;

import java.util.List;


import ar.edu.unju.fi.entity.Provincia;
import ar.edu.unju.fi.entity.Servicio;
import ar.edu.unju.fi.entity.Sucursal;

public interface IProvinciaService {

	List<Provincia> getProvincias();
    Provincia getProvinciaById(Long id);
    void guardarProvincia(Provincia provincia);
    void actualizarProvincia(Provincia provinciaActualizada);
    void eliminarProvincia(Provincia provincia);

    Provincia getProvincia();
	Provincia obtenerProvinciaPorSucursal(Sucursal sucursal);
	
	
}
