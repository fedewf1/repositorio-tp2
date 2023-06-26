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

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.service.ICommonService;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/sucursales")
public class SucursalController {

  @Autowired
  @Qualifier("sucursalServiceMysql")
  private ISucursalService sucursalService;

  @Autowired
  private ICommonService commonService;

  @GetMapping("/listado")
  public String getListaSucursalesPage(Model model) {
      model.addAttribute("sucursales", sucursalService.getSucursales());
      return "sucursales";
  }
  
  @GetMapping("/nuevo")
  public String getNuevaSucursalPage(Model model) {
    boolean edicion = false;
    model.addAttribute("sucursal", new Sucursal());
    model.addAttribute("provincias", commonService.getProvincias());
    model.addAttribute("edicion", edicion);
    return "nueva_sucursal";
  }

  @PostMapping("/guardar")
  public ModelAndView guardarSucursal(@Valid @ModelAttribute("sucursal") Sucursal sucursal, BindingResult result) {
    ModelAndView modelView = new ModelAndView("sucursales");
    if (result.hasErrors()) {
      modelView.setViewName("nueva_sucursal");
      modelView.addObject("sucursal", sucursal);
      return modelView;
    }

    String provinciaSeleccionada = sucursal.getProvincia();

    // Asignar la provincia seleccionada al atributo "provincia" de la sucursal
    sucursal.setProvincia(provinciaSeleccionada);

    sucursalService.guardarSucursal(sucursal);
    modelView.addObject("sucursales", sucursalService.getSucursales());
    return modelView;
  }

  @GetMapping("/modificar/{id}")
  public String getModificarSucursalPage(Model model, @PathVariable(value="id") Long id) {
    Sucursal sucursalEncontrada = sucursalService.buscarSucursalPorCodigo(id);
    boolean edicion = true;
    model.addAttribute("sucursal", sucursalEncontrada);
    model.addAttribute("provincias", commonService.getProvincias());
    model.addAttribute("edicion", edicion);
    return "nueva_sucursal";
  }

  @PostMapping("/modificar")
  public String modificaSucursal(@ModelAttribute("sucursal") Sucursal sucursal) {
    sucursalService.modificarSucursal(sucursal);
    return "redirect:/sucursales/listado";
  }

  @GetMapping("/eliminar/{id}")
  public String eliminarSucursal(@PathVariable(value="id") Long id) {
    Sucursal sucursal = sucursalService.buscarSucursalPorCodigo(id);
    sucursalService.eliminarSucursal(sucursal);
    return "redirect:/sucursales/listado";
  }
}
