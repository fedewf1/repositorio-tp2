package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Sucursal;
import jakarta.validation.Valid;
/**
* Servicio: Sucursal
* @author joelrojas95
* @version 1.0 date: 10/06/23
*/
public interface ISucursalService {
    List<Sucursal> getSucursales();
    void guardarSucursal(@Valid Sucursal sucursal);
    void modificarSucursal(Sucursal sucursal);
    void eliminarSucursal(Sucursal sucursal);
    Sucursal buscarSucursalPorNombre(String nombre);
	Sucursal getSucursal();
}

