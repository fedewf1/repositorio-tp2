package ar.edu.unju.fi.repository;

import java.util.List;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.entity.Consejo;


public interface IConsejoRepository extends CrudRepository<Consejo, Long> {

	public List<Consejo> findByEstado(boolean estado);


}
