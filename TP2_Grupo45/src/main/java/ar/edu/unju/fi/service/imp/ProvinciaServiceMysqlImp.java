package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;


import ar.edu.unju.fi.entity.Provincia;
import ar.edu.unju.fi.entity.Servicio;
import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.repository.IProvinciaRepository;

import ar.edu.unju.fi.service.IProvinciaService;


@Service("provinciaServiceMysql")
public class ProvinciaServiceMysqlImp implements IProvinciaService {

	@Autowired
	private IProvinciaRepository provinciaRepository;
	
	@Autowired
	private Provincia provincia;
	
	
	@Override
	public List<Provincia> getProvincias() {
	    Iterable<Provincia> iterable = provinciaRepository.findAll();
	    List<Provincia> provincias = new ArrayList<>();
	    iterable.forEach(provincias::add);
	    return provincias;
	}

	@Override
	public Provincia getProvinciaById(Long id) {
		return provinciaRepository.findById(id).get();
		
	}

	@Override
	public void guardarProvincia(Provincia provincia) {
		provinciaRepository.save(provincia);

	}

	/**Modifica un servicio*/
	@Override
	public void actualizarProvincia(Provincia provinciaActualizada) {
		provinciaRepository.save(provinciaActualizada);

	}

	/**Eliminación logica*/
	@Override
	public void eliminarProvincia(Provincia provincia) {
		
		//servicio.setEstado(false);
		provinciaRepository.save(provincia);

	}

	@Override
	public Provincia getProvincia() {
			return provincia;
		
	}

	@Override
	public Provincia obtenerProvinciaPorSucursal(Sucursal sucursal) {
	    return provinciaRepository.findBySucursales(sucursal);
	}

	

}
