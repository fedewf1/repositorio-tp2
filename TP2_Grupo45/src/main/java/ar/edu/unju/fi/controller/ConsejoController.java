package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.listas.ListaConsejo;
import ar.edu.unju.fi.model.Consejo;
import jakarta.validation.Valid;



@Controller
public class ConsejoController {
	
	@Autowired
	private Consejo consejo;

	@Autowired
	private ListaConsejo listaConsejos;

	
	//Muestra la lista de consejos
	@GetMapping("/consejos")
	public String mostrarListaConsejos(Model model) {
		model.addAttribute("consejos", listaConsejos.getConsejos());
		return "consejos";
	}

	//Muestra en un html, todo el contenido de un consejo a partir de su id
	@GetMapping("/consejo/detallado/{id}")
	public String mostrarDetalleConsejo(@PathVariable("id") int id, Model model) {
	    Consejo consejo = listaConsejos.findConsejoById(id);
	    model.addAttribute("consejo", consejo);
	    return "detalle_consejo";
	}
	
	
	//Muestra el formulario para nuevo consejo
	@GetMapping("/consejo/nuevo")
	public String mostrarFormularioNuevoServicio(Model model) {
		boolean editando = false;

		model.addAttribute("consejo", consejo);
		model.addAttribute("editando", editando);

		return "nuevo_consejo";
	}

	//Solicitud para guardar lo rellenado en un formulario
	@PostMapping("/consejo/guardar")
	public ModelAndView getGuardarConsejoPage(@Valid @ModelAttribute("consejo") Consejo consejo, BindingResult result) {

		if (result.hasErrors()) {
			ModelAndView modelView = new ModelAndView("nuevo_consejo");
			modelView.addObject("consejo", consejo);
			return modelView;
		}

		ModelAndView modelAndView = new ModelAndView("consejos");
		
		listaConsejos.agregarConsejo(consejo);
		modelAndView.addObject("consejos", listaConsejos.getConsejos());
		return modelAndView;
	}

	
	//Solicita la pagina de modificación segun un id
	@GetMapping("consejo/modificar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") Integer id, Model model) {
		boolean editando = true;
		Consejo consejo = listaConsejos.findConsejoById(id);
		
		model.addAttribute("consejo", consejo);
		model.addAttribute("editando", editando);
		return "nuevo_consejo";
	}
	//Solicita la modificación de un consejo a traves de su id
	@PostMapping("/consejo/modificar/{id}")
	public String editarConsejo(@PathVariable("id") Integer id, @ModelAttribute("consejo") Consejo consejoModificado) {
		
		Consejo consejo = listaConsejos.findConsejoById(id);
		consejo.setTitulo(consejoModificado.getTitulo());
		consejo.setAutor(consejoModificado.getAutor());
		consejo.setContenido(consejoModificado.getContenido());

		return "redirect:/consejos";
	}

	@GetMapping("/consejo/eliminar/{id}")
	public String eliminarConsejo(Model model, @PathVariable(value = "id") Integer id) {

		listaConsejos.eliminarConsejo(id);
		listaConsejos.actualizarId();

		return "redirect:/consejos";
	}
 
}
