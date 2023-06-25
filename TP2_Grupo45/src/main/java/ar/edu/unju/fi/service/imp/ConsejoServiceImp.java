//package ar.edu.unju.fi.service.imp;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import ar.edu.unju.fi.entify.Consejo;
//import ar.edu.unju.fi.listas.ListaConsejo;
//import ar.edu.unju.fi.service.IConsejoService;
//
//
//
//@Service
//public class ConsejoServiceImp implements IConsejoService {
//	
//	@Autowired
//	private ListaConsejo listaConsejos;
//
//	@Autowired
//	private Consejo consejo;
//
//	@Override
//	public void nuevoConsejo(Consejo consejo) {
//		listaConsejos.nuevoConsejo(consejo);
//	}
//
//	@Override
//	public List<Consejo> getConsejos() {
//		List<Consejo> consejos = (List<Consejo>) listaConsejos.getConsejos();
//		return consejos;
//	}
//
//	public Consejo getConsejo() {
//		return consejo;
//	}
//
//	@Override
//	public Consejo findConsejoById(Integer id) {
//		return listaConsejos.findConsejoById(id);
//
//	}
//
//	@Override
//	public void guardarConsejo(Consejo consejo) {
//	    listaConsejos.nuevoConsejo(consejo);
//	}
//
//	@Override
//	public void actualizarId(Integer id) {
//		listaConsejos.actualizarId();
//
//	}
//
//	@Override
//	public void consejoAEliminar(Integer id) {
//		listaConsejos.eliminarConsejo(id);
//
//	}
//
//	@Override
//	public void actualizarConsejo(Integer id, Consejo consejoModificado) {
//		Consejo consejoExistente = findConsejoById(id);
//		consejoExistente.setTitulo(consejoModificado.getTitulo());
//		consejoExistente.setAutor(consejoModificado.getAutor());
//		consejoExistente.setContenido(consejoModificado.getContenido());
//	}
//
//}
