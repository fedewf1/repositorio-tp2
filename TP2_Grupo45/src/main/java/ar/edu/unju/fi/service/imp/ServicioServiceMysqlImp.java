package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return servicioRepository.findByEstado(true);
	}

	@Override
	public Servicio getServicioById(Long id) {
		return servicioRepository.findById(id).get();
		
	}

	@Override
	public void guardarServicio(Servicio servicio) {
		servicioRepository.save(servicio);

	}

	@Override
	public void actualizarServicio(Servicio servicioActualizado) {
		servicioRepository.save(servicioActualizado);

	}

	@Override
	public void eliminarServicio(Servicio servicio) {
		//Eliminación logica, no elimina de la tabla
		servicio.setEstado(false);
		servicioRepository.save(servicio);

	}

	@Override
	public Servicio getServicio() {
			return servicio;
		
	}

}
