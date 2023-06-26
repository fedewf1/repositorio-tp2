package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Categoria;

public interface ICategoriaService {
	List<Categoria> getCategoria(String dia);
}
