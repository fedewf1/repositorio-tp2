//package ar.edu.unju.fi.service.imp;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import ar.edu.unju.fi.entity.Servicio;
//import ar.edu.unju.fi.listas.ListaServicio;
//import ar.edu.unju.fi.service.IServicioService;
//
//
//@Service("servicioServiceImp")
//public class ServicioServiceImp implements IServicioService{
//	
//	@Autowired
//	private ListaServicio listaServicios;
//
//	@Autowired
//	private Servicio servicio;
//	
//	
//	@Override
//    public List<Servicio> getServicios() {
//		List<Servicio> servicios = (List<Servicio>) listaServicios.getServicios();
//		return servicios;
//    }
//
//	public Servicio getServicio() {
//		return servicio;
//	}
//	
//	
//    @Override
//    public Servicio getServicioById(Long id) {
//        for (Servicio servicio : listaServicios.getServicios()) {
//            if (servicio.getId().equals(id)) {
//                return servicio;
//            }
//        }
//        return null; // Si no se encuentra el servicio
//    }
//
//    @Override
//    public void guardarServicio(Servicio servicio) {
//        listaServicios.getServicios().add(servicio);
//    }
//
////    @Override
////    public void actualizarServicio(Servicio servicioActualizado) {
////        for (Servicio serv : listaServicios.getServicios()) {
////            if (serv.getNombre().equals(servicioActualizado.getNombre())) {
////                serv.setDireccion(servicioActualizado.getDireccion());
////                serv.setTelefono(servicioActualizado.getTelefono());
////                serv.setTarifa(servicioActualizado.getTarifa());
////                serv.setTipoDeServicio(servicioActualizado.getTipoDeServicio());
////                serv.setDiaDisponible(servicioActualizado.getDiaDisponible());
////                serv.setHorarioDisponible(servicioActualizado.getHorarioDisponible());
////                break;
////            }
////        }
////    }
//
//    @Override
//    public void eliminarServicio(Servicio servicio) {
//        for (Servicio serv : listaServicios.getServicios()) {
//            if (serv.getId().equals(serv.getId())){
//                listaServicios.getServicios().remove(serv);
//                break;
//            }
//        }
//    }
//
//}
