package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.entity.Empleado;

public interface IEmpleadoRepository extends CrudRepository<Empleado, Long> {

	public List<Empleado> findByEstado(boolean estado);

	List<Empleado> findByDiaDisponible(String dia);

}
