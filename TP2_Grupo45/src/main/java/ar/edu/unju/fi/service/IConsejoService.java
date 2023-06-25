package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entify.Consejo;

public interface IConsejoService {
	
	List<Consejo> getConsejos();
	
	Consejo getConsejo();

	void nuevoConsejo(Consejo consejo);
	Consejo findConsejoById(Integer id);
	void actualizarId(Integer id);
	void consejoAEliminar(Integer id);
	void actualizarConsejo(Integer id, Consejo consejoModificado);
	
	void guardarConsejo(Consejo consejo);
	
}
