package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Empleado;

@Repository
public interface IEmpleadoRepository extends CrudRepository<Empleado, Long> {

	public List<Empleado> findByEstado(boolean estado);

	List<Empleado> findByDiaDisponible(String dia);

    List<Empleado> findByDiaDisponibleAndEstado(String dia, boolean estado);
	

}
