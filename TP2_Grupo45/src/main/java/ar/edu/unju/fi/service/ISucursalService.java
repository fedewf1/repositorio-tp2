package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Sucursal;

/**
* Servicio: Sucursal
* @author joelrojas95
* @version 1.0 date: 10/06/23
*/
/**
 * Se procede a modificar los parametros, adaptando a lo requerido en el practico 7
 * 
 * @author joelrojas95
 * @version 1.0 date: 24/06/23
 */

public interface ISucursalService {
	
    List<Sucursal> getSucursales();
    
    void guardarSucursal( Sucursal sucursal);
    
    void modificarSucursal(Sucursal sucursalA);
    
    //void eliminarSucursal(Integer codigoSucursal);
    void eliminarSucursal(Sucursal sucursal);
    //Sucursal buscarSucursalPorCodigo(Integer codigoSucursal);
	Sucursal getSucursal();
	
	Sucursal buscarSucursalPorCodigo(Long id);
}

