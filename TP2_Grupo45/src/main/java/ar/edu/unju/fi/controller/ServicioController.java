package ar.edu.unju.fi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.listas.ListaServicio;
import ar.edu.unju.fi.model.Servicio;
import jakarta.validation.Valid;


/* 
Se añaden los getmapping de sucursales y contacto que redirigen a sus respectivas paginas
*/

@Controller
public class ServicioController {
		
	@Autowired
	private Servicio servicio;

	@Autowired
	private ListaServicio listaServicios;

	@GetMapping("/servicios")
	public String mostrarListaServicios(Model model) {
		model.addAttribute("servicios", listaServicios.getServicios());
		return "servicios";
	}
	
	 @ModelAttribute("trabajadores")
	    public List<Servicio> obtenerTrabajadoresDisponibles() {
	        return listaServicios.getServicios();
	    }
	

	@GetMapping("/servicio/nuevo")
	public String mostrarFormularioNuevoServicio(Model model) {
		boolean editando = false;
		model.addAttribute("servicio", servicio);
		model.addAttribute("editando", editando);

		return "nuevo_servicio";
	}

	@PostMapping("/servicio/guardar")
	public ModelAndView getGuardarServicioPage(@Valid @ModelAttribute("servicio") Servicio servicio, BindingResult result) {
		
		  if (result.hasErrors()) {
		        ModelAndView modelView = new ModelAndView("nuevo_servicio");
		        modelView.addObject("servicio", servicio);
		        return modelView;
		    }
		
		ModelAndView modelAndView = new ModelAndView("servicios");
		listaServicios.getServicios().add(servicio);

		modelAndView.addObject("servicios", listaServicios.getServicios());
		return modelAndView;
	}

	@GetMapping("/servicio/modificar/{nombre}")
	public String getModificarServicioPage(Model model, @PathVariable(value = "nombre") String nombre) {
		Servicio servicioEncontrado = new Servicio();
		boolean editando = true;
		for (Servicio serv : listaServicios.getServicios()) {
			if (serv.getNombre().equals(nombre)) {
				servicioEncontrado = serv;
				break;
			}
		}

		model.addAttribute("servicio", servicioEncontrado);
		model.addAttribute("editando", editando);
		return "nuevo_servicio";
	}

	@PostMapping("/servicio/modificar")
	public String modificarServicio(Model model, @ModelAttribute("servicio") Servicio servicioActualizado) {
		
		

		for (Servicio serv : listaServicios.getServicios()) {
			if (serv.getNombre().equals(servicioActualizado.getNombre())) {
				serv.setDireccion(servicioActualizado.getDireccion());
				serv.setTelefono(servicioActualizado.getTelefono());
				serv.setTarifa(servicioActualizado.getTarifa());
				serv.setTipoDeServicio(servicioActualizado.getTipoDeServicio());
				serv.setDiaDisponible(servicioActualizado.getDiaDisponible());
				serv.setHorarioDisponible(servicioActualizado.getHorarioDisponible());

				break;
			}
		}

		return "redirect:/servicios";
	}

	@GetMapping("/servicio/eliminar/{nombre}")
	public String eliminarServicio(Model model, @PathVariable(value = "nombre") String nombre) {

		for (Servicio serv : listaServicios.getServicios()) {
			if (serv.getNombre().equals(nombre)) {
				listaServicios.getServicios().remove(serv);
				break;
			}
		}

		return "redirect:/servicios";
	}
	
	
 
}
