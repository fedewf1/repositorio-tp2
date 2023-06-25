package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entify.Producto;
import ar.edu.unju.fi.listas.ListaProductos;
import ar.edu.unju.fi.repository.IProductoRepository;
import ar.edu.unju.fi.service.IProductoService;
import java.util.Optional;
import jakarta.validation.Valid;

//@Service("productoServiceImp")
//public class ProductoServiceImp implements IProductoService{

	//@Autowired
	//private IProductoRepository produRepository; 
	//@Autowired
//	private ListaProductos listaProductos;

	//@Autowired
	//private Producto producto;

	//@Override
	// Retorna la lista de productos almacenada en listaProductos
//	public List<Producto> getProductos() {
		// TODO Auto-generated method stub
	//	List<Producto> productos=(List<Producto>) productoRepository.findAll();
	//	return productos;
		//return listaProductos.getProductos();
	//}
	
//	@Override
	// Retorna el objeto producto
//	public Producto getProducto() {
		// TODO Auto-generated method stub
//		return producto;
//	}

	
	//@Override
	// Agrega el producto a la lista de productos en listaProductos
 	//public void agregarProducto(Producto producto) {
	//	listaProductos.getProductos().add(producto);
//	}
// 	@Override
 	// Agrega el producto validado a la lista de productos en listaProductos
// 	public void guardar(@Valid Producto producto){
// 		listaProductos.getProductos().add(producto);
// 	}
 	//@Override
 	// Busca el producto con el código dado en la lista de productos y lo elimina
 	//public void eliminar(Integer codigo){
 	//	for(Producto produ:listaProductos.getProductos()) {
    	//	if(produ.getCodigo()==(codigo)) {
    		//	listaProductos.getProductos().remove(produ);
    			//break;
    		//	}
    	    
         //}
 	//}
// 	@Override
 	// Busca el producto con el mismo código en la lista de productos y modifica sus atributos
// 	public void modificar(Producto productoA) {
 //		for(Producto produ:listaProductos.getProductos()) {
  //  		if(produ.getCodigo()==(productoA.getCodigo())) {
   // 			produ.setCategoria(productoA.getNombre());
   // 			produ.setPrecio(productoA.getPrecio());
   // 			produ.setDescuento(productoA.getDescuento() );
   // 			produ.setNombreImagen(productoA.getNombreImagen());
   // 		}
   // 	}
 //	}
 //	@Override
 	// Busca el producto con el código dado en la lista de productos y lo retorna
//	public Producto buscarPorCodigo(long codigo) {
//		producto= productoRepository.findById(codigo).get();
// 		return producto;
 		//Producto productoEncontrado = null;
		//for(Producto produ : listaProductos.getProductos()){
    	//	if(produ.getCodigo()==(codigo)) {
    	//		productoEncontrado = produ;
    	//		break;
    	//	}
    	//}
		//return productoEncontrado;
//	}

//	@Override
//	public void eliminar(Producto producto) {
		// TODO Auto-generated method stub
		
//	}
//	@Override
//	public void getId(long Id) {
		
		// TODO Auto-generated method stub
		
		
//	}
	
//}
