package ar.edu.unju.fi.service.imp;

import java.util.List;
//import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Empleado;
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

	/**
	 * Metodo que obtiene un empleado a traves de su id
	 * @param id es el numero de id de un empleado
	 * */
	
	@Override
	public Empleado getEmpleadoById(Long id) {
		return empleadoRepository.findById(id).get();
		
	}
	/**
	 *Metodo que guarda un empleado,  
	 * @param empleado es un empleado a guardar
	 * 
	 * */
	@Override
	public void guardarEmpleado(Empleado empleado) {
		empleadoRepository.save(empleado);

	}

	/**
	 *Metodo que modifica los datos de un empleado,  
	 * @param empleado es un empleado a modificar
	 * 
	 * */
	
	@Override
	public void actualizarEmpleado(Empleado empleadoActualizado) {
		empleadoRepository.save(empleadoActualizado);

	}
	/**
	 * Metodo que realiza la eliminación logica de un empleado
	 * @param estado es un atributo booleano que al ser cambiado a false dejará de mostrar un empleado 
	 * @param empleado es el empleado a modificar
	 * */

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
