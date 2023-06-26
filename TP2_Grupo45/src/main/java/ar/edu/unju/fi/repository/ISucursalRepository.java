package ar.edu.unju.fi.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Sucursal;

/**
 * Se procede a añadir: ISucursalRepository
 * 
 * @author joelrojas95
 * @version 1.0 date: 24/06/23
 */

@Repository
public interface ISucursalRepository extends CrudRepository<Sucursal,Long> {

	public List<Sucursal> findByEstado(boolean estado);
	
	//Mostrar las sucursales que están entre una fechaInicio y fechaFin:
	//public List<Sucursal> findByFechaInicioBetween(LocalDate fechaInicio, LocalDate fechaFin);

}