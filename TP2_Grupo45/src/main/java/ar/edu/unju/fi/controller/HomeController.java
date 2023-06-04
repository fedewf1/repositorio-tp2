package ar.edu.unju.fi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaArticulos;
import ar.edu.unju.fi.model.Articulo;



//HomeController.java
@Controller
@RequestMapping("/")
public class HomeController {
	//ListaArticulos listaArticulos = new ListaArticulos();
	@Autowired
	private ListaArticulos listaArticulos;
	//Articulo articulo =new Articulo();
	@Autowired
    private Articulo articulo;
	//public String getHome() {
    //return "index";
 //}
	
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
    public ModelAndView getguardarArticuloPage(@ModelAttribute("articulo") Articulo articulo) {
    	ModelAndView modelView = new ModelAndView("index");
    	listaArticulos.getArticulos().add(articulo);
        modelView.addObject("articulos", listaArticulos.getArticulos());
        return modelView;
    }
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
    	//Articulo articuloEncontrado = new Articulo();
    	for(Articulo arti : listaArticulos.getArticulos()) {
    		int f=articulo.getCodigo();
    		int h=arti.getCodigo();
    		if(arti.getCodigo()== (articulo.getCodigo())) {
    			//arti.setArticulo("es igual");
    			arti.setArticulo(articulo.getArticulo());
    			//arti.setArticulo(" valor de articulo.getCodigo()"+Integer.toString(f)+" valor arti.getCodigo()"+Integer.toString(h));
    			arti.setCodigo(articulo.getCodigo());
    		}
    		else {
        		//arti.setArticulo("no entra al if "+" valor de articulo.getCodigo()"+Integer.toString(f)+" valor arti.getCodigo()"+Integer.toString(h));
        		//arti.setArticulo(Integer.toString(f));}
        	}
    	}
    	return "redirect:/index";
    }
  
		//arti.setArticulo(Integer.toString(articulo.getCodigo()));

    	
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


