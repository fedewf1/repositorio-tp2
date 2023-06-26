package ar.edu.unju.fi.controller;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Consejo;
import ar.edu.unju.fi.service.IConsejoService;
import jakarta.validation.Valid;



@Controller
public class ConsejoController {

	
	@Autowired
	@Qualifier("consejoServiceMysql")
	private IConsejoService consejoService;
		
	
//	@Autowired
//	private Consejo consejo;

	/**Muestra la lista de consejos*/
	@GetMapping("/consejos")
	public ModelAndView getConsejosPage() {
			ModelAndView mav = new ModelAndView("consejos");
			mav.addObject("consejos", consejoService.getConsejos());
			return mav;
	}

	/**Muestra en un html, todo el contenido de un consejo a partir de su id*/
	@GetMapping("/consejo/detalle/{id}")
	public ModelAndView mostrarDetalleConsejo(@PathVariable("id") Long id) {
	    ModelAndView mav = new ModelAndView("detalle_consejo");
	    
	    mav.addObject("consejo", consejoService.getConsejoById(id));

	    return mav;
	}

	

	@GetMapping("consejo/nuevo")
	public ModelAndView getFormularioNuevoConsejo() {
	    boolean editando = false;
	    ModelAndView mav = new ModelAndView("nuevo_consejo");
	    mav.addObject("consejo", consejoService.getConsejo()); 
	    mav.addObject("editando", editando);
	    return mav;
	}


	/**Solicitud para guardar lo rellenado en un formulario*/
	@PostMapping("/consejo/guardar")
	public ModelAndView getGuardarConsejoPage(@Valid @ModelAttribute("consejo") Consejo consejo, BindingResult result) {
	    if (result.hasErrors()) {
	        ModelAndView modelView = new ModelAndView("nuevo_consejo");
	        modelView.addObject("consejos", consejoService.getConsejos());
	        return modelView;
	    }

	    consejoService.guardarConsejo(consejo);
	    
	    ModelAndView modelAndView = new ModelAndView("redirect:/consejos"); // Redireccionar a la página de consejos
	    return modelAndView;
	}


	
	/**Solicita la pagina de modificación segun un id*/
	   @GetMapping("/consejo/modificar/{id}")
	    public String mostrarFormularioModificarConsejo(Model model, @PathVariable(value = "id") Long id) {
	        Consejo consejo = consejoService.getConsejoById(id);
	        boolean editando = true;
	        if (consejo == null) {
	            return "redirect:/consejos";
	        }
	        model.addAttribute("consejo", consejo);
	        model.addAttribute("editando", editando);
	        
	        return "nuevo_consejo";
	    }

	
	/**Solicita la modificación de un consejo a traves de su id*/
	   @PostMapping("/consejo/modificar")
	    public String modificarConsejo(@Valid @ModelAttribute("consejo") Consejo consejo, BindingResult result) {
	        if (result.hasErrors()) {
	            return "nuevo_consejo";
	        }
	        consejoService.actualizarConsejo(consejo);
	        return "redirect:/empleados";
	    }

	/**Elimina un consejo tomando como base un id*/
	   @GetMapping("/consejo/eliminar/{id}")
	   public String eliminarConsejo(@PathVariable Long id) {
	       Consejo consejo = consejoService.getConsejoById(id);
	       consejoService.eliminarConsejo(consejo);
	       return "redirect:/consejos";
	   }

}
