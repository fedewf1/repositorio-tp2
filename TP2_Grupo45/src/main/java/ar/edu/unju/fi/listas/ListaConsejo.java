//package ar.edu.unju.fi.listas;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.stereotype.Component;
//
//import ar.edu.unju.fi.entify.Consejo;
//
//@Component
//public class ListaConsejo {
//
//	private List<Consejo> consejos;
//	private int nextId;
//
//	public ListaConsejo() {
//		consejos = new ArrayList<Consejo>();
//		nextId = 1;
//
//	}
//
//	public List<Consejo> getConsejos() {
//		return consejos;
//	}
//
//	public Consejo findConsejoById(Integer id) {
//		Consejo consejo = new Consejo();
//		for (Consejo cons : consejos) {
//			if (cons.getId() != null && cons.getId().equals(id)) {
//				return cons;
//			}
//		}
//		return consejo;
//	}
//
//	public void nuevoConsejo(Consejo consejo) {
//
//		if (consejos.isEmpty()) {
//			nextId = 1;
//		}
//		consejo.setId(nextId);
//		consejos.add(consejo);
//		nextId++;
//	}
//
//	public void eliminarConsejo(Long id) {
//
//		Consejo consejoAEliminar = null;
//		for (Consejo cons : consejos) {
//			if (cons.getId() != null && cons.getId() == id) {
//				consejoAEliminar = cons;
//				break;
//			}
//		}
//
//		if (consejoAEliminar != null) {
//			consejos.remove(consejoAEliminar);
//			actualizarId();
//		}
//	}
//
//	public void actualizarId() {
//		int nuevoId = 1;
//		List<Consejo> consejosActualizados = new ArrayList<>();
//
//		for (Consejo consejo : consejos) {
//			consejo.setId(nuevoId);
//			consejosActualizados.add(consejo);
//			nuevoId++;
//		}
//
//		consejos = consejosActualizados;
//	}
//
//	public void setConsejos(List<Consejo> consejos) {
//		this.consejos = consejos;
//	}
//
//}
