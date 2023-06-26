package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Consejo;


public interface IConsejoService {
	
	List<Consejo> getConsejos();
    Consejo getConsejoById(Long id);
    void guardarConsejo(Consejo consejo);
    void actualizarConsejo(Consejo consejoActualizado);
    void eliminarConsejo(Consejo consjeo);
    Consejo getConsejoVacio();
    Consejo getConsejo();
}
