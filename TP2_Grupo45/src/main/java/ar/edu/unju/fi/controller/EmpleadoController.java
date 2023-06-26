package ar.edu.unju.fi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unju.fi.entity.Empleado;
//import ar.edu.unju.fi.service.ICommonService;
import ar.edu.unju.fi.service.IEmpleadoService;
import ar.edu.unju.fi.service.IServicioService;
import jakarta.validation.Valid;




@Controller
public class EmpleadoController {
	
	
	@Autowired
	@Qualifier("empleadoServiceMysql")
	private IEmpleadoService empleadoService;
	
	@Autowired
	private IServicioService servicioService;
	
	
	
	
	
	
//	@Autowired
//	private Empleado empleado;
	
	/**Metodo que muestra una lista de empleados, además realiza las comprobaciones necesarias para filtrar un empleado por dia, sino muestra toda la lista de empleados*/
	
	
	 @GetMapping("/empleados")
	    public String mostrarListaServicios(@RequestParam(value = "dia", required = false) String dia, Model model) {
	        List<Empleado> empleados;

	        if (dia != null && !dia.isEmpty()) {
	            empleados = empleadoService.getEmpleadosPorDia(dia);
	        } else {
	            empleados = empleadoService.getEmpleados();
	        }

	        for (Empleado empleado : empleados) {
	            // Obtener el servicio para el empleado actual
	            empleado.setServicio(servicioService.obtenerServicioPorEmpleado(empleado));
	        }

	        model.addAttribute("empleados", empleados);

	        return "empleados";
	    }


	 /**Metodo que muestra el formulario para agregar un nuevo empleado*/
    @GetMapping("/empleado/nuevo")
    public String mostrarFormularioNuevoServicio(Model model) {
        boolean editando = false;
        model.addAttribute("empleado", new Empleado());
        model.addAttribute("editando", editando);
        
        model.addAttribute("servicios", servicioService.getServicios());
        return "nuevo_empleado";
    }
    /**Metodo que solicita el guardado de los datos, en caso de error muestra la misma pagina con los errores de validacion, y trae la lista de servicios guardadas en la base de datos*/
    @PostMapping("/empleado/guardar")
    public String guardarServicio(@Valid @ModelAttribute("empleado") Empleado empleado, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("servicios", servicioService.getServicios());
            return "nuevo_empleado";
        }

        empleadoService.guardarEmpleado(empleado);
        return "redirect:/empleados";
    }

  
    @GetMapping("/empleado/modificar/{id}")
    public String mostrarFormularioModificarEmpleado(Model model, @PathVariable(value = "id") Long id) {
        Empleado empleado = empleadoService.getEmpleadoById(id);
        boolean editando = true;
        if (empleado == null) {
            return "redirect:/empleados";
        }
        model.addAttribute("empleado", empleado);
        model.addAttribute("editando", editando);
        model.addAttribute("servicios", servicioService.getServicios());
        return "nuevo_empleado";
    }
    /**Modifica un empleado segun su numero de id*/
    @PostMapping("/empleado/modificar")
    public String modificarEmpleado(@Valid @ModelAttribute("servicio") Empleado empleado, BindingResult result) {
        if (result.hasErrors()) {
            return "nuevo_empleado";
        }
        empleadoService.actualizarEmpleado(empleado);
        return "redirect:/empleados";
    }
    /**Elimina un empleado segun su numero de id*/
    @GetMapping("/empleado/eliminar/{id}")
    public String eliminarServicio(@PathVariable Long id) {
        Empleado empleado = empleadoService.getEmpleadoById(id);
        empleado.setEstado(false);  // Establece el estado como false en lugar de eliminar
        empleadoService.guardarEmpleado(empleado);
        return "redirect:/empleados";
    }

 
}