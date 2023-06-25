package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entify.Empleado;
import ar.edu.unju.fi.entify.Servicio;

public interface IServicioService {

	List<Servicio> getServicios();
    Servicio getServicioById(Long id);
    void guardarServicio(Servicio servicio);
    void actualizarServicio(Servicio servicioActualizado);
    void eliminarServicio(Servicio servicio);

    Servicio getServicio();
	Servicio obtenerServicioPorEmpleado(Empleado empleado);
}
