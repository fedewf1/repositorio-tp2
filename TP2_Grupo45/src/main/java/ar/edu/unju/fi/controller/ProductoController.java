package ar.edu.unju.fi.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entify.Producto;
import ar.edu.unju.fi.repository.IProductoRepository;
import ar.edu.unju.fi.service.IProductoService;
//import ar.edu.unju.fi.service.imp.ProductoServiceImp;
import jakarta.validation.Valid;

/**
 * 
 * 
 * 
 * @author freinicks
 * Esto es el controlador de productos y posea todos los metodos que recibiran las peticiones de la vista.
 * @version 1.0.4
 *
 */
@Controller
@RequestMapping("/productos")
public class ProductoController {
	@Autowired
	//@Qualifier("productoServiceMysql")
	//private IProductoRepository productoRepository;
	private IProductoService iproduSer;
	
    //private Producto producto
    
    // Muestra la página con el listado de productos
    @GetMapping("/listado")
   // public String getListaProductoPage(Model model) {
    public String listar(Model model) {
    	List<Producto>productos=iproduSer.listar();
        model.addAttribute("productos", productos);
        return "productos";
    }
   
    // Muestra la página para agregar un nuevo producto
    @GetMapping("/nuevo")
    public String getNuevoProductoPage(Model model) {
    //	boolean edicion = false;
    	model.addAttribute("producto", new Producto());
   // 	model.addAttribute("edicion", edicion);
    	return "nuevo_producto";
    }
    
    // Guarda un nuevo producto en la lista
    @PostMapping("/guardar")
    public String getguardarProductoPage(@Valid @ModelAttribute("producto") Producto producto, BindingResult result) {
    	
    	//return "redirect:/productos/listado";
    	ModelAndView modelView = new ModelAndView("productos");
   	if(result.hasErrors()) {
    		modelView.setViewName("index");
   		modelView.addObject("producto", producto);
    		modelView=new ModelAndView("index");
    		//return modelView;
    		return "nuevo_producto";
    	}else {
    		
    		iproduSer.save(producto);
    //		productoRepository.save(producto);
        	//producto.setNombre("Collar antipulgas").
        	//modelView=new ModelAndView("nuevo_producto");
    		//modelView.addObject("productos", iproduSer.listar());
    		return "redirect:/productos/listado";
    	}
    	//return modelView;
    	
        
        
    }
    
    // Muestra la página para modificar un producto existente
    @GetMapping("/modificar/{id}")
   public String getModificarProductoPage(Model model, @PathVariable long id) {
    //	Producto productoEncontrado = productoRepository.findById(codigo);
    	//boolean edicion= true;
    	Optional<Producto>producto=iproduSer.listarId(id);
    	//decidir si quito este if.
  //  	if (productoEncontrado == null) {
  //          return "redirect:/productos/listado";
   //     }
    	model.addAttribute("producto", producto);
    	//model.addAttribute("edicion", edicion);

    	return"nuevo_producto";
    }
    
    // Guarda los cambios realizados en un producto existente
  //  @PostMapping("/modificar")
  //  public String modificaProducto(@ModelAttribute("producto")Producto producto) {
   // 	iproduSer.modificar(producto);
   // 	return "redirect:/productos/listado";
   // }
    
    
    @PostMapping("/guarda/{id}")
    public String getguardarPorId(@Valid @ModelAttribute("producto") Producto producto, BindingResult result,Model model, @PathVariable long id) {
    ModelAndView modelView = new ModelAndView("productos");
   	if(result.hasErrors()) {
    		modelView.setViewName("index");
   		modelView.addObject("producto", producto);
    		modelView=new ModelAndView("index");
    		//return modelView;
    		return "nuevo_producto";
    	}else {
    		
    		iproduSer.save(producto);
    //		productoRepository.save(producto);
        	//producto.setNombre("Collar antipulgas").
        	//modelView=new ModelAndView("nuevo_producto");
    		//modelView.addObject("productos", iproduSer.listar());
    		return "redirect:/productos/listado";
    	}
    }
    
    // Elimina un producto de la lista
     @GetMapping("/eliminar/{id}")
     public String eliminarProducto(@PathVariable(value="id") Long id) throws Exception {
     //Iterar sobre la lista de productos
    //	 Optional<Producto>producto=iproduSer.listarId(id);
    	 iproduSer.eliminar(id, false);
    	 //iproduSer.eliminar(id);
         return "redirect:/productos/listado";
    	 //Optional<Producto> product = iproduSer.findById(id);
	        
	      //  producto.setEstado(false);
	       // iproduSer.save(producto);
    	 //iproduSer.eliminar(id,producto);
    	// producto.setEstado(false);;
         //return "redirect:/productos/listado";
    }
}

