package ar.edu.unju.fi.repository;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.entity.Empleado;
import ar.edu.unju.fi.entity.Servicio;

public interface IServicioRepository extends CrudRepository<Servicio, Long> {

	Servicio findByEmpleados(Empleado empleado);

//	public List<Servicio> findByEstado(boolean estado);

}
