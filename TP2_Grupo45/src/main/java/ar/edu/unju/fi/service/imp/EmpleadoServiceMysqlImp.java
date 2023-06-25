package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entify.Empleado;
import ar.edu.unju.fi.repository.IEmpleadoRepository;
import ar.edu.unju.fi.service.IEmpleadoService;

@Service("empleadoServiceMysql")
public class EmpleadoServiceMysqlImp implements IEmpleadoService {

	@Autowired
	private IEmpleadoRepository empleadoRepository;
	
	@Autowired
	private Empleado empleado;
	
	
	@Override
	public List<Empleado> getEmpleados() {
		return empleadoRepository.findByEstado(true);
	}

	@Override
	public Empleado getEmpleadoById(Long id) {
		return empleadoRepository.findById(id).get();
		
	}

	@Override
	public void guardarEmpleado(Empleado empleado) {
		empleadoRepository.save(empleado);

	}

	@Override
	public void actualizarEmpleado(Empleado empleadoActualizado) {
		empleadoRepository.save(empleadoActualizado);

	}

	@Override
	public void eliminarEmpleado(Empleado empleado) {
		/**Eliminación logica, no elimina de la tabla*/
		empleado.setEstado(false);
		empleadoRepository.save(empleado);

	}

	@Override
	public Empleado getEmpleado() {
			return empleado;
		
	}
	
	   @Override
	    public List<Empleado> getEmpleadosPorDia(String dia) {
	        return empleadoRepository.findByDiaDisponible(dia);
	    }

	   

}
