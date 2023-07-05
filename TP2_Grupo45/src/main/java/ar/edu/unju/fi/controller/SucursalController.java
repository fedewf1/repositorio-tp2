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
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
import java.util.List;

import ar.edu.unju.fi.entity.Empleado;
//import ar.edu.unju.fi.entity.Empleado;
import ar.edu.unju.fi.entity.Provincia;
import ar.edu.unju.fi.entity.Sucursal;

import ar.edu.unju.fi.service.IProvinciaService;
//import ar.edu.unju.fi.service.ICommonService;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;

@Controller
public class SucursalController {

  @Autowired
  @Qualifier("sucursalServiceMysql")
  private ISucursalService sucursalService;

//  @Autowired
//  private ICommonService commonService;
  
  @Autowired
  private IProvinciaService provinciaService;

  @GetMapping("/sucursales")
  public String getListaSucursalesPage(Model model) {
      List<Sucursal> sucursales = sucursalService.getSucursales();

      for (Sucursal sucursal : sucursales) {
          // Obtener el nombre de la provincia directamente de la sucursal
          String nombreProvincia = sucursal.getProvincia().getNombre();
          sucursal.getProvincia().setNombre(nombreProvincia);
      }

      model.addAttribute("sucursales", sucursales);

      return "sucursales";
  }

  

  @GetMapping("/sucursales/nuevo")
  public String mostrarFormularioNuevaSucursal(Model model) {
	  boolean editando = false;
      model.addAttribute("sucursal", new Sucursal());
      model.addAttribute("editando", editando);
      
      model.addAttribute("provincias", provinciaService.getProvincias());
      return "nueva_sucursal";
  }


 
  @PostMapping("/sucursales/guardar")
  public String guardarSucursal(@Valid @ModelAttribute("sucursal") Sucursal sucursal, BindingResult result, Model model) {
	  if (result.hasErrors()) {
          model.addAttribute("provincias", provinciaService.getProvincias());
          return "nueva_sucursal";
      }

      sucursalService.guardarSucursal(sucursal);
      return "redirect:/sucursales";
  }

  @GetMapping("/sucursales/modificar/{id}")
  public String mostrarFormularioModificarSucursal(Model model, @PathVariable(value = "id") Long id) {
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

  @PostMapping("/sucursales/modificar")
  public String modificarSucursal(@Valid @ModelAttribute("provincia") Sucursal sucursal, BindingResult result) {
      if (result.hasErrors()) {
          return "nueva_sucursal";
      }
      sucursalService.actualizarSucursal(sucursal);
      return "redirect:/sucursales";
  }

 @GetMapping("/sucursales/eliminar/{id}")
 public String eliminarSucursal(@PathVariable Long id) {
     Sucursal sucursal = sucursalService.getSucursalById(id);
     sucursal.setEstado(false);  // Establece el estado como false en lugar de eliminar
     sucursalService.guardarSucursal(sucursal);
     return "redirect:/sucursales";
 }


}
