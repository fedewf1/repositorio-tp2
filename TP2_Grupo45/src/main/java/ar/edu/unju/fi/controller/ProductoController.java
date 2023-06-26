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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Categoria;
import ar.edu.unju.fi.entity.Empleado;
import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.repository.IProductoRepository;
import ar.edu.unju.fi.service.ICategoriaService;
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
	@Qualifier("productoServiceMysql")
	private IProductoService iproduSer;
	
	//@Autowired
	//private ICategoriaService icatGoria;
	
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
    
    
    /**@GetMapping("/empleados")
    public String mostrarListaServicios(@RequestParam(value = "categoria", required = false) String categoria, Model model) {
        List<Categoria> categoria1;
        	categoria1 = icatGoria.getCategoria(categoria);
        

        return "productos";
    }*/
    @GetMapping("/listado/{categoria}")
    public String getProductosPorCategoria(Model model,@PathVariable String categoria) {
    	//String Categoria="Cuidado";
    	List<Producto>productos=iproduSer.getProductosPorCategoria(categoria);
    	model.addAttribute("productos", productos);
        return "productos";
    }
    //
    
    // Guarda un nuevo producto en la lista
    @PostMapping("/guardar")
    public String getguardarProductoPage(@Valid @ModelAttribute("producto") Producto producto, BindingResult result) {
    	
    	
    	ModelAndView modelView = new ModelAndView("productos");
    	if(result.hasErrors()) {
    		modelView.setViewName("index");
   		modelView.addObject("producto", producto);
    		modelView=new ModelAndView("index");
    		//return modelView;
    		return "nuevo_producto";
    	}else {  		
    		iproduSer.save(producto); 
    		return "redirect:/productos/listado";
    	}    
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
    
    
    @PostMapping("/guarda/{id}")
    public String getguardarPorId(@Valid @ModelAttribute("producto") Producto producto, BindingResult result,Model model, @PathVariable long id) {
    ModelAndView modelView = new ModelAndView("productos");
   	if(result.hasErrors()) {
    		modelView.setViewName("index");
   		modelView.addObject("producto", producto);
    		modelView=new ModelAndView("index");
    		return "nuevo_producto";
    	}else { 		
    		iproduSer.save(producto);
    		return "redirect:/productos/listado";
    	}
    }
    
    // Elimina un producto de la lista
     @GetMapping("/eliminar/{id}")
     public String eliminarProducto(@PathVariable(value="id") Long id) throws Exception {
    	 iproduSer.eliminar(id, false);
         return "redirect:/productos/listado";
    	 
    }
}

