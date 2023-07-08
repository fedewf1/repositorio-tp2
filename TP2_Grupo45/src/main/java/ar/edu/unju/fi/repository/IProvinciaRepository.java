package ar.edu.unju.fi.repository;



//import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import ar.edu.unju.fi.entity.Provincia;
import ar.edu.unju.fi.entity.Sucursal;

@Repository
public interface IProvinciaRepository extends CrudRepository<Provincia, Long> {
//	   @Query("SELECT p FROM Provincia p WHERE p.id = :id")
	   //List<Provincia> findAll();

	   Provincia findBySucursales(Sucursal sucursal);
}
