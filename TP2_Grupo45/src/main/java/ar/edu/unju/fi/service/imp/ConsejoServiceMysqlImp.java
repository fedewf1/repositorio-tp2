package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Consejo;
import ar.edu.unju.fi.repository.IConsejoRepository;
import ar.edu.unju.fi.service.IConsejoService;

@Service("consejoServiceMysql")
public class ConsejoServiceMysqlImp implements IConsejoService {
	
	@Autowired
	private IConsejoRepository consejoRepository;
	
	@Autowired
	private Consejo consejo;
	
	
	

	@Override
	public List<Consejo> getConsejos() {
		return consejoRepository.findByEstado(true);
	}

	@Override
	public Consejo getConsejoById(Long id) {
	    consejo = consejoRepository.findById(id).orElse(null);
	    return consejo;
	}

	@Override
	public void guardarConsejo(Consejo consejo) {
		consejoRepository.save(consejo);
		
	}

	@Override
	public void actualizarConsejo(Consejo consejoActualizado) {
		 consejoRepository.save(consejoActualizado);
		
	}

	@Override
	public void eliminarConsejo(Consejo consjeo) {
		 consejoRepository.delete(consjeo);
		
	}

	@Override
	public Consejo getConsejo() {
		return consejo;
	}
	
	   @Override
	    public Consejo getConsejoVacio() {
	        return new Consejo(); 
	    }

}
