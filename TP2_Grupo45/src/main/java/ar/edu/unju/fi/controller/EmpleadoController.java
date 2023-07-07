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
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.entity.Empleado;
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

    /**
     * Metodo que muestra una lista de empleados, además realiza las comprobaciones
     * necesarias para filtrar un empleado por dia, sino muestra toda la lista de
     * empleados
     */

    @GetMapping("/empleados")
    public String mostrarListaServicios(@RequestParam(value = "dia", required = false) String dia, Model model) {
        List<Empleado> empleados;

        if (dia != null && !dia.isEmpty()) {
            empleados = empleadoService.getEmpleadosPorDiaYEstado(dia, true);
        } else {
            empleados = empleadoService.getEmpleadosPorEstado(true);
        }

        for (Empleado empleado : empleados) {
            // Obtener el servicio para el empleado actual
            empleado.setServicio(servicioService.obtenerServicioPorEmpleado(empleado));
        }

        model.addAttribute("empleados", empleados);

        return "empleados";
    }

    /** Metodo que muestra el formulario para agregar un nuevo empleado */
    @GetMapping("/empleado/nuevo")
    public String mostrarFormularioNuevoServicio(Model model) {
        boolean editando = false;
        model.addAttribute("empleado", new Empleado());
        model.addAttribute("editando", editando);

        model.addAttribute("servicios", servicioService.getServicios());
        return "nuevo_empleado";
    }

    /**
     * Metodo que solicita el guardado de los datos, en caso de error muestra la
     * misma pagina con los errores de validacion, y trae la lista de servicios
     * guardadas en la base de datos
     */
    @PostMapping("/empleado/guardar")
    public String guardarServicio(@Valid @ModelAttribute("empleado") Empleado empleado, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            model.addAttribute("servicios", servicioService.getServicios());
            return "nuevo_empleado";
        }

        empleadoService.guardarEmpleado(empleado);
        return "redirect:/empleados";
    }

    /**
     * Metodo que solicita el formulario para la modificación
     * 
     * @param editando es un valor booleano que permite identificar si estamos
     *                 agregando un nuevo empleado, o modificando uno
     *                 Ademas permitirá en el html cambiar algunos textos basados en
     *                 su valor
     */
    @GetMapping("/empleado/modificar/{id}")
    public String mostrarFormularioModificarEmpleado(Model model, @PathVariable Long id) {
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

    /** Metodo que envía el formulario con la modificación */
    @PostMapping("/empleado/modificar/")
    public String getguardarPorId(@Valid @ModelAttribute("empleado") Empleado empleado, BindingResult result,
            Model model) {
        ModelAndView modelView = new ModelAndView("empleados");
        if (result.hasErrors()) {
            modelView.setViewName("index");
            modelView.addObject("empleado", empleado);
            modelView = new ModelAndView("index");
            return "nuevo_empleado";
        } else {
            empleadoService.actualizarEmpleado(empleado);
            // iproduSer.save(producto);
            return "redirect:/empleados";
        }
    }

    /** Elimina un empleado segun su numero de id */
    @GetMapping("/empleado/eliminar/{id}")
    public String eliminarServicio(@PathVariable Long id) {
        Empleado empleado = empleadoService.getEmpleadoById(id);
        empleado.setEstado(false); // Establece el estado como false en lugar de eliminar
        empleadoService.guardarEmpleado(empleado);
        return "redirect:/empleados";
    }

}