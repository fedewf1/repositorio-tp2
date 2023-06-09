package ar.edu.unju.fi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaArticulos;
import ar.edu.unju.fi.model.Articulo;
import jakarta.validation.Valid;



@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	private ListaArticulos listaArticulos;
	@Autowired
    private Articulo articulo;
	
	
    @GetMapping("/")
    
    public String getListaArticuloPage(Model model) {
    model.addAttribute("articulos", listaArticulos.getArticulos());
    return "index";
    }
    @GetMapping("/index")
    public String getListaArticuloPag(Model model) {
        model.addAttribute("articulos", listaArticulos.getArticulos());
        return "index";
    }
    @GetMapping("/nuevo")
    public String getNuevoProductoPage(Model model) {
    	boolean edicion = false;
    	model.addAttribute("articulo", articulo);
    	model.addAttribute("edicion", edicion);
    	return "nuevo_articulo";
    }
    @PostMapping("/guardar")
    public ModelAndView getguardarArticuloPage(@Valid @ModelAttribute("articulo") Articulo articulo, BindingResult result) {
    	ModelAndView modelView = new ModelAndView("index");
		// Verificar si hay errores de validación en el objeto "articulo"
    	if(result.hasErrors()) {
    		modelView.setViewName("nuevo_articulo");
    		modelView.addObject("articulo", articulo);
    		return modelView;
    	}
		// Agregar el artículo a la lista de artículos
    	listaArticulos.getArticulos().add(articulo);
        modelView.addObject("articulos", listaArticulos.getArticulos());
        return modelView;
    }
    
	// Buscar el artículo en la lista de artículos
    @GetMapping("/modificar/{codigo}")
    public String getModificarArticuloPage(Model model, @PathVariable(value="codigo")int codigo) {
    	Articulo articuloEncontrado = new Articulo();
    	boolean edicion= true;
    	for(Articulo arti : listaArticulos.getArticulos()){
    		if(arti.getCodigo()==(codigo)) {
    			articuloEncontrado = arti;
    			break;
    		}
    	}
    	model.addAttribute("articulo", articuloEncontrado);
    	model.addAttribute("edicion", edicion);
    	return"nuevo_articulo";
    }
    @PostMapping("/modificar")
    public String modificaArticulo(@ModelAttribute("articulo")Articulo articulo) {
    	for(Articulo arti : listaArticulos.getArticulos()) {
    		
    		if(arti.getCodigo()== (articulo.getCodigo())) {
    			
    			arti.setArticulo(articulo.getArticulo());
    			arti.setCodigo(articulo.getCodigo());
    		}
    		
    	}
    	return "redirect:/index";
    }
  
		//arti.setArticulo(Integer.toString(articulo.getCodigo()));

	// Eliminar el artículo de la lista de artículos	
    @GetMapping("/eliminar/{codigo}")
    public String eliminarProducto(@PathVariable(value="codigo") int codigo) {
    	for(Articulo arti:listaArticulos.getArticulos()) {
    		if(arti.getCodigo()==(codigo)) {
    			listaArticulos.getArticulos().remove(arti);
    			break;
    			}
         }return "redirect:/index";
    }
}


