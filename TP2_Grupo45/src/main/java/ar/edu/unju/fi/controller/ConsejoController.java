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

import ar.edu.unju.fi.entity.Consejo;
import ar.edu.unju.fi.service.IConsejoService;
import jakarta.validation.Valid;



@Controller
public class ConsejoController {

	@Autowired
	private IConsejoService consejoService;

	@GetMapping("/consejos")
	public ModelAndView getConsejosPage() {
		ModelAndView mav = new ModelAndView("consejos");
		mav.addObject("consejos", consejoService.getConsejos());
		return mav;
	}

	@GetMapping("/consejo/detallado/{id}")
	public String mostrarDetalleConsejo(@PathVariable("id") int id, Model model) {
		Consejo consejo = consejoService.findConsejoById(id);
		model.addAttribute("consejo", consejo);
		return "detalle_consejo";
	}

	@GetMapping("consejo/nuevo")
	public ModelAndView getFormularioNuevoConsejo() {
		Consejo consejo = new Consejo();
		boolean editando = false;
		ModelAndView mav = new ModelAndView("nuevo_consejo");
		mav.addObject("consejo", consejo);
		mav.addObject("editando", editando);
		return mav;
	}

	@PostMapping("/consejo/guardar")
	public ModelAndView getGuardarConsejoPage(@Valid @ModelAttribute("consejo") Consejo consejo,
			BindingResult result) {
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

	@GetMapping("consejo/modificar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") Integer id, Model model) {
		boolean editando = true;
		Consejo consejo = consejoService.findConsejoById(id);

		model.addAttribute("consejo", consejo);
		model.addAttribute("editando", editando);
		return "nuevo_consejo";
	}

	@PostMapping("/consejo/modificar/{id}")
	public String editarConsejo(@PathVariable("id") Integer id,
			@ModelAttribute("consejo") Consejo consejoModificado) {
		consejoService.actualizarConsejo(id, consejoModificado);

		return "redirect:/consejos";
	}

	@GetMapping("/consejo/eliminar/{id}")
	public String eliminarConsejo(@PathVariable(value = "id") Integer id) {
		consejoService.consejoAEliminar(id);
		return "redirect:/consejos";
	}
 
}
