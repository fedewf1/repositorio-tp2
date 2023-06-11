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
import ar.edu.unju.fi.model.Servicio;
import ar.edu.unju.fi.service.IServicioService;
import jakarta.validation.Valid;




@Controller
public class ServicioController {
	
	
	@Autowired
	private IServicioService servicioService;
	
	
	@Autowired
	private Servicio servicio;
	
	@GetMapping("/servicios")
    public String mostrarListaServicios(Model model) {
        model.addAttribute("servicios", servicioService.getServicios());
        return "servicios";
    }

    @ModelAttribute("trabajadores")
    public List<Servicio> obtenerTrabajadoresDisponibles() {
        return servicioService.getServicios();
    }

    @GetMapping("/servicio/nuevo")
    public String mostrarFormularioNuevoServicio(Model model) {
        boolean editando = false;
        model.addAttribute("servicio", new Servicio());
        model.addAttribute("editando", editando);
        return "nuevo_servicio";
    }

    @PostMapping("/servicio/guardar")
    public String guardarServicio(@Valid @ModelAttribute("servicio") Servicio servicio, BindingResult result) {
        if (result.hasErrors()) {
            return "nuevo_servicio";
        }
        servicioService.agregarServicio(servicio);
        return "redirect:/servicios";
    }

    @GetMapping("/servicio/modificar/{nombre}")
    public String mostrarFormularioModificarServicio(Model model, @PathVariable(value = "nombre") String nombre) {
        Servicio servicio = servicioService.getServicioPorNombre(nombre);
        boolean editando = true;
        if (servicio == null) {
            return "redirect:/servicios";
        }
        model.addAttribute("servicio", servicio);
        model.addAttribute("editando", editando);
        return "nuevo_servicio";
    }

    @PostMapping("/servicio/modificar")
    public String modificarServicio(@Valid @ModelAttribute("servicio") Servicio servicioActualizado, BindingResult result) {
        if (result.hasErrors()) {
            return "nuevo_servicio";
        }
        servicioService.actualizarServicio(servicioActualizado);
        return "redirect:/servicios";
    }

    @GetMapping("/servicio/eliminar/{nombre}")
    public String eliminarServicio(@PathVariable(value = "nombre") String nombre) {
        servicioService.eliminarServicio(nombre);
        return "redirect:/servicios";
    }
 
}
