package ar.edu.unju.fi.service;

import java.util.List;


import ar.edu.unju.fi.model.Servicio;

public interface IServicioService {

	List<Servicio> getServicios();
    Servicio getServicioPorNombre(String nombre);
    void agregarServicio(Servicio servicio);
    void actualizarServicio(Servicio servicioActualizado);
    void eliminarServicio(String nombre);
}
