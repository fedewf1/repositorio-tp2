package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


//HomeController.java
@Controller
public class ContactoController {
	@GetMapping("/contacto")
	public String getHome() {
     return "contacto";
}
}
