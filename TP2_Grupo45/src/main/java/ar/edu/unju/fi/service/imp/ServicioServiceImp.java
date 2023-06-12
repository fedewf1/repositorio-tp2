package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.ListaServicio;
//import ar.edu.unju.fi.model.Consejo;
import ar.edu.unju.fi.model.Servicio;
import ar.edu.unju.fi.service.IServicioService;


@Service
public class ServicioServiceImp implements IServicioService{
	
	@Autowired
	private ListaServicio listaServicios;

	@Autowired
	private Servicio servicio;
	
	
	@Override
    public List<Servicio> getServicios() {
		List<Servicio> servicios = (List<Servicio>) listaServicios.getServicios();
		return servicios;
    }

	public Servicio getServicio() {
		return servicio;
	}
	
	
    @Override
    public Servicio getServicioPorNombre(String nombre) {
        for (Servicio servicio : listaServicios.getServicios()) {
            if (servicio.getNombre().equals(nombre)) {
                return servicio;
            }
        }
        return null; // Si no se encuentra el servicio
    }

    @Override
    public void agregarServicio(Servicio servicio) {
        listaServicios.getServicios().add(servicio);
    }

    @Override
    public void actualizarServicio(Servicio servicioActualizado) {
        for (Servicio serv : listaServicios.getServicios()) {
            if (serv.getNombre().equals(servicioActualizado.getNombre())) {
                serv.setDireccion(servicioActualizado.getDireccion());
                serv.setTelefono(servicioActualizado.getTelefono());
                serv.setTarifa(servicioActualizado.getTarifa());
                serv.setTipoDeServicio(servicioActualizado.getTipoDeServicio());
                serv.setDiaDisponible(servicioActualizado.getDiaDisponible());
                serv.setHorarioDisponible(servicioActualizado.getHorarioDisponible());
                break;
            }
        }
    }

    @Override
    public void eliminarServicio(String nombre) {
        for (Servicio serv : listaServicios.getServicios()) {
            if (serv.getNombre().equals(nombre)) {
                listaServicios.getServicios().remove(serv);
                break;
            }
        }
    }

}
