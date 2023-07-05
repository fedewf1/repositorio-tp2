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
    Sucursal getSucursalById(Long id);
    void guardarSucursal(Sucursal sucursal);
    void actualizarSucursal(Sucursal sucursalActualizada);
    void eliminarSucursal(Sucursal sucursal);

    Sucursal getSucursal();
	
	
}

