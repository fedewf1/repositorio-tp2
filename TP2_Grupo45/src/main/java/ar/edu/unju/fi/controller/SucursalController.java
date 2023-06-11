package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.model.Sucursal;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;
/**
 * Capa Controladora de Sucursal
 * @author joelrojas95
 * @version 1.0 date: 10/06/23
 */


@Controller
@RequestMapping("/sucursal")
public class SucursalController {
  @Autowired
  private ISucursalService sucursalService;
  
  @GetMapping("/listado")
  public String getListaSucursalesPage(Model model) {
      model.addAttribute("sucursales", sucursalService.getSucursales());
      return "sucursales";
  }
  
  @GetMapping("/nuevo")
  public String getNuevaSucursalPage(Model model) {
  	boolean edicion = false;
  	model.addAttribute("sucursal", sucursalService.getSucursal());
  	model.addAttribute("edicion", edicion);
  	return "nueva_sucursal";
  }
  

  /* 
Se procede a la captura de errores
*/
  
  @PostMapping("/guardar")
  public ModelAndView getGuardarSucursalPage(@Valid @ModelAttribute("sucursal") Sucursal sucursal, BindingResult result) {
	ModelAndView modelView = new ModelAndView("sucursales");
	if(result.hasErrors()) {
		modelView.setViewName("nueva_sucursal");
		modelView.addObject("sucursal", sucursal);
		return modelView;
	}
	sucursalService.getSucursales().add(sucursal);
    modelView.addObject("sucursales", sucursalService.getSucursales());
    return modelView;
  }
  
  
  @GetMapping("/modificar/{nombre}")
  public String getModificarSucursalPage(Model model, @PathVariable(value="nombre")String nombre) {
  	Sucursal sucursalEncontrada = sucursalService.buscarSucursalPorNombre(nombre);
  	boolean edicion= true;
  	model.addAttribute("sucursal", sucursalEncontrada);
  	model.addAttribute("edicion", edicion);
  	return"nueva_sucursal";
  }
  
  
  @PostMapping("/modificar")
  public String modificaSucursal(@ModelAttribute("sucursal")Sucursal sucursal) {
  	
  	for(Sucursal sucu : sucursalService.getSucursales()) {
  		if(sucu.getCodigoSucursal()==(sucursal.getCodigoSucursal())) {
  			sucu.setNombreSucursal(sucursal.getNombreSucursal());
  			sucu.setDireccion(sucursal.getDireccion());
  			sucu.setTelefono(sucursal.getTelefono());
  			sucu.setHoraLunesViernes(sucursal.getHoraLunesViernes());
  			sucu.setHoraSabados(sucursal.getHoraSabados());
  			//sucu.setHoraLunesViernes(sucursal.getHoraLunesViernes());
  		}
  	}
  	return "redirect:/sucursales/listado";
  }
  
  
  @GetMapping("/eliminar/{codigoSucursal}")
  public String eliminarSocursal(@PathVariable(value="codigoSucursal") int codigoSucursal) {
  	for(Sucursal sucu:sucursalService.getSucursales()) {
  		if(sucu.getCodigoSucursal()==(codigoSucursal)) {
  			sucursalService.getSucursales().remove(sucu);
  			break;
  			}
       }
  	return "redirect:/sucursales/listado";
  }

}