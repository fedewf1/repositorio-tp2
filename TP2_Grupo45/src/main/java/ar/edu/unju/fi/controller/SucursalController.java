package ar.edu.unju.fi.controller;

import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Empleado;
import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.service.ICommonService;
import ar.edu.unju.fi.service.IProvinciaService;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;

@Controller
public class SucursalController {

  @Autowired
  @Qualifier("sucursalServiceMysql")
  private ISucursalService sucursalService;
  
    @Autowired
    private IProvinciaService provinciaService;



  @GetMapping("/sucursales/listado")
  public String getSucursalesPage(
            @RequestParam(name = "fechaInicio", required = false) String fechaInicioStr,
            @RequestParam(name = "fechaFin", required = false) String fechaFinStr,
            Model model
    ) {
        List<Sucursal> sucursales;
        if (fechaInicioStr != null && fechaFinStr != null) {
            LocalDate fechaInicio = LocalDate.parse(fechaInicioStr);
            LocalDate fechaFin = LocalDate.parse(fechaFinStr);
            sucursales = sucursalService.buscarPorFechas(fechaInicio, fechaFin);
        } else {
            sucursales = sucursalService.getSucursales();
        }
        model.addAttribute("sucursales", sucursales);
        return "sucursales";
    }



    @GetMapping("/sucursal/nuevo")
    public String mostrarFormularioNuevaSucursal(Model model) {
        boolean editando = false;
        model.addAttribute("sucursal", new Sucursal());
        model.addAttribute("editando", editando);

        model.addAttribute("provincias", provinciaService.getProvincias());
        return "nueva_sucursal";
    }

   
    @PostMapping("/sucursal/guardar")
    public String guardarSucursal(@Valid @ModelAttribute("sucursal") Sucursal sucursal, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            model.addAttribute("provincias", provinciaService.getProvincias());
            return "nueva_sucursal";
        }

        sucursalService.guardarSucursal(sucursal);
        return "redirect:/sucursales";
    }


    @GetMapping("/sucursal/modificar/{id}")
    public String mostrarFormularioModificarSucursal(Model model, @PathVariable Long id) {
        Sucursal sucursal = sucursalService.getSucursalById(id);
        boolean editando = true;
        if (sucursal == null) {
            return "redirect:/sucursales";
        }
        model.addAttribute("sucursal", sucursal);
        model.addAttribute("editando", editando);
        model.addAttribute("provincias", provinciaService.getProvincias());
        
        return "nueva_sucursal";
    }

    /** Metodo que envía el formulario con la modificación */
    @PostMapping("/sucursal/modificar/")

    public String getGuardarSucursalPorId(@Valid @ModelAttribute("sucursal") Sucursal sucursal, BindingResult result,
            Model model) {


        ModelAndView modelView = new ModelAndView("sucursales");
        if (result.hasErrors()) {
            modelView.setViewName("index");
            modelView.addObject("sucursal", sucursal);
            modelView = new ModelAndView("index");
            return "nuevo_empleado";
        } else {
            sucursalService.actualizarSucursal(sucursal);
            // iproduSer.save(producto);
            return "redirect:/empleados";
        }
    }

    @GetMapping("/sucursal/eliminar/{id}")
    public String eliminarUnaSucursal(@PathVariable Long id) {
        Sucursal sucursal = sucursalService.getSucursalById(id);
        sucursal.setEstado(false); // Establece el estado como false en lugar de eliminar
        sucursalService.guardarSucursal(sucursal);
        return "redirect:/sucursales";
    }

}
