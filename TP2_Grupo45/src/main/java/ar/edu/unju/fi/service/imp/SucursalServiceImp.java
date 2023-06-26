package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.listas.ListaSucursales;
import ar.edu.unju.fi.service.ISucursalService;
//import jakarta.validation.Valid;

/**
 * Clase de Sucursal que implementa los metodos definidos en la interfaz IsucursalService
 * @author joelrojas95
 * @version 1.0 date: 10/06/23
 */

/**
 * Se procede a modificar los parametros, adaptando a lo requerido en el practico 7
 * 
 * @author joelrojas95
 * @version 1.0 date: 24/06/23
 */

@Service("sucursalServiceImp")
public class SucursalServiceImp implements ISucursalService {
	
	@Autowired
	private ListaSucursales listaSucursales;
	
	@Autowired
	private Sucursal sucursal;

	// Lista de sucursales
	@Override
	public List<Sucursal> getSucursales() {
		return listaSucursales.getSucursales();
	}
	
	@Override
	public Sucursal getSucursal() {
		return sucursal;
	}
	
	
	//guarda una nueva sucursal
	@Override
	public void guardarSucursal(Sucursal sucursal) {
		listaSucursales.getSucursales().add(sucursal);
		
	}
		
	//modificacion de los datos de la sucursal
	@Override
	public void modificarSucursal(Sucursal sucursal) {
		 
		for(Sucursal sucu : listaSucursales.getSucursales()) {
    		if(sucu.getCodigoSucursal()==(sucursal.getCodigoSucursal())) {
    			sucu.setNombreSucursal(sucursal.getNombreSucursal());
    			sucu.setDireccion(sucursal.getDireccion());
    			sucu.setTelefono(sucursal.getTelefono());
    			sucu.setHoraLunesViernes(sucursal.getHoraLunesViernes());
    			sucu.setHoraSabados(sucursal.getHoraSabados());
    			sucu.setFechaInicio(sucursal.getFechaInicio());
    			sucu.setCantidadEmpleados(sucursal.getCantidadEmpleados());
    			sucu.setEmail(sucursal.getEmail());
    			sucu.setProvincia(sucursal.getProvincia());
    			//sucu.setHoraLunesViernes(sucursal.getHoraLunesViernes());
    			  break;
    		}
    	}
		 
	}
	   
	//elimina una sucursal
	@Override
	public void eliminarSucursal(Sucursal sucursal) {
		for(Sucursal sucu:listaSucursales.getSucursales()) {
			
	  		 if (sucu.getId().equals(sucu.getId())){
	                listaSucursales.getSucursales().remove(sucu);
	                break;
	            }
	       }
		
	}

	//busca una sucursal por nombre
	@Override
	public Sucursal buscarSucursalPorCodigo(Long id) {
		 for (Sucursal sucursal: listaSucursales.getSucursales()) {
	            if (sucursal.getId().equals(id)){
	                return sucursal;
	            }
	        }
	        return null; // Si no se encuentra el servicio
	}

}

