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
 * Esta es la clase controladora de Homo/Index.
 * @author federicono nicolas burgos Grupo 45
 * @version 1.0.2 date: 25/6/23
 * {@index}
 */
@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	@Qualifier("homeServiceMysql")
	private IHomeService homeService;
	/**
	 * Este método maneja una solicitud GET a la ruta "/" y devuelve la vista "index". 
	 * Agrega un atributo llamado "articulos" al modelo, que se obtiene llamando al método getArticulos() del servicio homeService. 
	 * La vista "index" utilizará este atributo para mostrar la lista de artículos.
	 */
	/*Este metodo maneja la solicitud GET a la ruta "/" y devuelve la vista index.*/
    @GetMapping("/index")
    public String getListaArticuloPag(Model model) {
        model.addAttribute("articulos", homeService.listar());
        return "index";
    } 
}


