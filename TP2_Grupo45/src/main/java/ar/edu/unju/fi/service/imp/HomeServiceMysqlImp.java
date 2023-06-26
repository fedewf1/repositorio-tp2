package ar.edu.unju.fi.service.imp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Articulo;
import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.repository.IHomeRepository;
import ar.edu.unju.fi.service.IHomeService;
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;

@Service("homeServiceMysql")
public class HomeServiceMysqlImp implements IHomeService {
	

	
	
	
		
		@Autowired
		private IHomeRepository homeRepository;
		
		@Autowired
	    private Articulo articulo;

		@Override
		public List<Articulo> listar() {
			// TODO Auto-generated method stub
			return homeRepository.findByEstado(true);
		}

		@Override
		public void save( Articulo articulo) {
			articulo.setEstado(true);
			homeRepository.save(articulo);
			
		}

		
			
			
		
		//@Override
		//Este método devuelve la lista de artículos obtenida a través del campo listaArticulos. Dado que listaArticulos ha sido anotada con @Autowired, Spring se encargará de proporcionar la instancia correcta de ListaArticulos al invocar este método
		//public Articulo getArticulo() {
			// TODO Auto-generated method stub
		//	return articulo;
		//}
		//Este método devuelve la instancia de Articulo que ha sido inyectada a través del campo articulo. Spring se encargará de proporcionar la instancia correcta al invocar este método, gracias a la anotación @Autowired.
		//@Override
		//public Articulo getIndex() {
			// TODO Auto-generated method stub
		//	return articulo;
		//}
		//Implemta el Eliminar el artículo de la lista de artículos segun un codigo.
//		@Override
	//	public void eliminarArticulo(Integer codigo) {
			//for(Articulo arti:listaArticulos.getArticulos()) {
	   		//if(arti.getCodigo()==(codigo)) {
	    	//		listaArticulos.getArticulos().remove(arti);
	    //			break;
//	    			}
	    		
	    //     }
			
		//}


		// implementa el Buscar el artículo en la lista de artículos segun un codigo.
//		@Override
//		public Articulo buscarPorCodigo(Integer codigo) {
	//		//@Override
		 	// Busca el producto con el código dado en la lista de productos y lo retorna
			//public Producto buscarPorCodigo(Integer codigo) {
	//		Articulo articuloEncontrado = null;
		//	for(Articulo arti : listaArticulos.getArticulos()){
		//    	if(arti.getCodigo()==(codigo)) {
		  //  		articuloEncontrado = arti;
		    //		break;
	//		return articuloEncontrado;
		//    		}
		    //	}
		//		return articuloEncontrado;
			
	//	}

		//Guarda un nuevo articulo en la lista
	//	@Override
	//	public void guardarArticulo(@Valid Articulo articulo) {
			// TODO Auto-generated method stub
		//	listaArticulos.getArticulos().add(articulo);
//		}
		
	 	// Agrega el producto validado a la lista de productos en listaProductos
	//	@Override
//	 	public void guardar(@Valid Producto producto){
	 			 
	//	}
	    // El código itera sobre la lista de artículos y busca un artículo con un código coincidente.
	//	@Override
	//	public void modificarArticulo(Articulo articuloA) {
			// Iterar sobre la lista de artículos
		//	for(Articulo arti : listaArticulos.getArticulos()) {
				// Verificar si el código del artículo coincide con el código del artículo a modificar
	    	//	if(arti.getCodigo()== (articuloA.getCodigo())) {
	    			// Actualizar los atributos del artículo existente con los valores del artículo a modificar
	   		//	arti.setArticulo(articuloA.getArticulo());
	    	//		arti.setCodigo(articuloA.getCodigo());
	    	//		arti.setFechaArticulo(articuloA.getFechaArticulo());
	    			//arti.setFechaArticulo(articuloA.getFechaArticulo().format(formatter));
	//    		}
	    		
	 // homeRepository	}
	}


