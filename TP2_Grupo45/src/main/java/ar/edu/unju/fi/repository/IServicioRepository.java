package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Servicio;

@Repository
public interface IServicioRepository extends CrudRepository<Servicio,Long>{

	public List<Servicio> findByEstado(boolean estado);
	
	//Clase 12/6 - 1:20:00
	
	
	
}
