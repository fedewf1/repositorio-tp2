package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import ar.edu.unju.fi.service.ICommonService;


//HomeController.java
@Controller
public class ContactoController {
	  @Autowired
	  private ICommonService commonService;
	
		
	  @GetMapping("/contacto")
	  public String getContactoPage(Model model) {

	  	model.addAttribute("provincias" , commonService.getProvincias());
	  	
	  	return "contacto";
	  }
	
}
