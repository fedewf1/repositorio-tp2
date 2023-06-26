package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

import ar.edu.unju.fi.entity.Empleado;
import ar.edu.unju.fi.entity.Servicio;
import ar.edu.unju.fi.repository.IServicioRepository;
import ar.edu.unju.fi.service.IServicioService;

@Service("servicioServiceMysql")
public class ServicioServiceMysqlImp implements IServicioService {

	@Autowired
	private IServicioRepository servicioRepository;
	
	@Autowired
	private Servicio servicio;
	
	
	@Override
	public List<Servicio> getServicios() {
	    Iterable<Servicio> iterable = servicioRepository.findAll();
	    List<Servicio> servicios = new ArrayList<>();
	    iterable.forEach(servicios::add);
	    return servicios;
	}

	@Override
	public Servicio getServicioById(Long id) {
		return servicioRepository.findById(id).get();
		
	}

	@Override
	public void guardarServicio(Servicio servicio) {
		servicioRepository.save(servicio);

	}

	/**Modifica un servicio*/
	@Override
	public void actualizarServicio(Servicio servicioActualizado) {
		servicioRepository.save(servicioActualizado);

	}

	/**Eliminación logica*/
	@Override
	public void eliminarServicio(Servicio servicio) {
		
		//servicio.setEstado(false);
		servicioRepository.save(servicio);

	}

	@Override
	public Servicio getServicio() {
			return servicio;
		
	}

	@Override
	public Servicio obtenerServicioPorEmpleado(Empleado empleado) {
	    return servicioRepository.findByEmpleados(empleado);
	}

	

}
