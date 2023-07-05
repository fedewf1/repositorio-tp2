package ar.edu.unju.fi.service.imp;

//import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.repository.ISucursalRepository;
import ar.edu.unju.fi.service.ISucursalService;

/**
 * Se procede a añadir: SucursalServiceMysqlImp
 * 
 * @author joelrojas95
 * @version 1.0 date: 24/06/23
 */

@Service("sucursalServiceMysql")
public class SucursalServiceMysqlImp implements ISucursalService{

	@Autowired
	private ISucursalRepository sucursalRepository;

	@Autowired
	private Sucursal sucursal;
	

	@Override
	public List<Sucursal> getSucursales() {
		return sucursalRepository.findByEstado(true);
	}

	@Override
	public Sucursal getSucursalById(Long id) {
		return sucursalRepository.findById(id).get();
		
	}

	@Override
	public void guardarSucursal(Sucursal sucursal) {
		sucursalRepository.save(sucursal);

	}


	
	@Override
	public void actualizarSucursal(Sucursal sucursalActualizada) {
		sucursalRepository.save(sucursalActualizada);

	}

	@Override
	public void eliminarSucursal(Sucursal sucursal) {

		sucursal.setEstado(false);
		sucursalRepository.save(sucursal);

	}

	@Override
	public Sucursal getSucursal() {
			return sucursal;
		
	}
	
	   


}
