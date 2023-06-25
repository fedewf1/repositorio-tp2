package ar.edu.unju.fi.controller;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entify.Consejo;
import ar.edu.unju.fi.service.IConsejoService;
import jakarta.validation.Valid;



@Controller
public class ConsejoController {

	@Autowired
	private IConsejoService consejoService;
	
	


	/**Muestra la lista de consejos*/
	@GetMapping("/consejos")
	public ModelAndView getConsejosPage() {
			ModelAndView mav = new ModelAndView("consejos");
			mav.addObject("consejos", consejoService.getConsejos());
			return mav;
	}

	/**Muestra en un html, todo el contenido de un consejo a partir de su id*/
	@GetMapping("/consejo/detallado/{id}")
	public ModelAndView mostrarDetalleConsejo(@PathVariable("id") int id) {
	    ModelAndView mav = new ModelAndView("detalle_consejo");
	    mav.addObject("consejo", consejoService.findConsejoById(id));
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

	    ModelAndView modelAndView = new ModelAndView("consejos");
	    consejoService.guardarConsejo(consejo); 
	    modelAndView.addObject("consejos", consejoService.getConsejos());
	    return modelAndView;
	}

	
	/**Solicita la pagina de modificación segun un id*/
	@GetMapping("consejo/modificar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") Integer id, Model model) {
	    boolean editando = true;
	    model.addAttribute("consejo", consejoService.findConsejoById(id));
	    model.addAttribute("editando", editando);
	    return "nuevo_consejo";
	}

	
	/**Solicita la modificación de un consejo a traves de su id*/
	@PostMapping("/consejo/modificar/{id}")
	public String editarConsejo(@PathVariable("id") Integer id, @ModelAttribute("consejo") Consejo consejoModificado) {
	    consejoService.actualizarConsejo(id, consejoModificado);

	    return "redirect:/consejos";
	}

	/**Elimina un consejo tomando como base un id*/
	@GetMapping("/consejo/eliminar/{id}")
	public String eliminarConsejo(@PathVariable(value = "id") Integer id) {
	    consejoService.consejoAEliminar(id);
	    return "redirect:/consejos";
	}
 
}
