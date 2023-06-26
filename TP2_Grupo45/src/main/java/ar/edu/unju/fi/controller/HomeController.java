package ar.edu.unju.fi.controller;
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

import ar.edu.unju.fi.entity.Articulo;
import ar.edu.unju.fi.repository.IHomeRepository;
//import ar.edu.unju.fi.model.Producto;
import ar.edu.unju.fi.service.IHomeService;
import jakarta.validation.Valid;

 

/**
 * Esta clase representa a la clase controladora del Homo/Index y articulo.
 * @author federicono nicolas burgos Grupo 45
 * @version 1.0.2 date: 25/6/23
 */
@Controller
@RequestMapping("/")
public class HomeController {
	
	//@Autowired
	
	@Autowired
	@Qualifier("homeServiceMysql")
	private IHomeService homeService;
	/**
	 * Este método maneja una solicitud GET a la ruta "/" y devuelve la vista "index". 
	 * Agrega un atributo llamado "articulos" al modelo, que se obtiene llamando al método getArticulos() del servicio homeService. 
	 * La vista "index" utilizará este atributo para mostrar la lista de artículos.
	 * @param model
	 * @return
	 */
	
    @GetMapping("/")
    
    public String getListaArticuloPage(Model model) {
    model.addAttribute("articulos", homeService.listar());
    return "index";
    }
    @GetMapping("/index")
    public String getListaArticuloPag(Model model) {
        model.addAttribute("articulos", homeService.listar());
        return "index";
    }
    @GetMapping("/nuevo")
    public String getNuevoProductoPage(Model model) {
    	
    	model.addAttribute("articulo", new Articulo());
    	return "nuevo_articulo";
    }
    //Guarda un nuevo articulo en la lista
 //   @PostMapping("/guardar")
   // public String getguardarArticuloPage(@Valid @ModelAttribute("articulo") Articulo articulo, BindingResult result) {
   // 	ModelAndView modelView = new ModelAndView("index");
		// Verificar si hay errores de validación en el objeto "articulo"
//    	if(result.hasErrors()) {
 //   		modelView.setViewName("index");
  //  		modelView.addObject("articulo", articulo);
   // 		return "nuevo_producto";
   // 	}
		// Agregar el artículo a la lista de artículos
//    	homeService.save(articulo);
        //modelView.addObject("articulos", homeService.listar());
 //       return "redirect:/productos/listado";
   	
  //  }
		// Agregar el artículo a la lista de artículos
 //   	homeService.guardarArticulo(articulo);
 //       modelView.addObject("articulos", homeService.getArticulos());
 //       return modelView;
//    }
 
    
	// Buscar el artículo en la lista de artículos
 //   @GetMapping("/modificar/{codigo}")
  //  public String getModificarArticuloPage(Model model, @PathVariable(value="codigo")int codigo) {
 //   	Articulo articuloEncontrado = homeService.buscarPorCodigo(codigo);
    //	boolean edicion= true;
   // 		if(articuloEncontrado==null) {
   /// 			return "redirect:/index";
  //  		}
    	
   // 	model.addAttribute("articulo", articuloEncontrado);
   // 	model.addAttribute("edicion", edicion);
  //  	return"nuevo_articulo";
    
 
//    }
    // El código itera sobre la lista de artículos y busca un artículo con un código coincidente. Si se encuentra, se actualizan el nombre y el código del artículo. Luego, se redirige a la página de inicio.
  //  @PostMapping("/modificar")
 //   public String modificaArticulo(@ModelAttribute("articulo")Articulo articulo) {
  //  	homeService.modificarArticulo(articulo);
  //  	return "redirect:/index";
 //   }
 //
		//arti.setArticulo(Integer.toString(articulo.getCodigo()));

	// Eliminar el artículo de la lista de artículos	
//    @GetMapping("/eliminar/{codigo}")
 //   public String eliminarArticulo(@PathVariable(value="codigo") int codigo) {
//    	homeService.eliminarArticulo(codigo);
//    	return "redirect:/index";
//   }
 
}


