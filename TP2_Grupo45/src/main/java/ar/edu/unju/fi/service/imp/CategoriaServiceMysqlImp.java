package ar.edu.unju.fi.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.entity.Categoria;
import ar.edu.unju.fi.repository.ICategoriaRepository;
import ar.edu.unju.fi.service.ICategoriaService;


@Service("categoriaServiceMysql")
public class CategoriaServiceMysqlImp implements ICategoriaService{
	@Autowired
	private ICategoriaRepository icatReposi;
	
	@Autowired
	private Categoria categoria;
	@Override
	public List<Categoria> getCategorias(){
		Iterable<Categoria> iterable = icatReposi.findAll();
	    List<Categoria> categorias = new ArrayList<>();
	    iterable.forEach(categorias::add);
	    return categorias;
		
	}
	@Override
	public Categoria getCategoria() {
		return categoria;
	
	}
	
}
