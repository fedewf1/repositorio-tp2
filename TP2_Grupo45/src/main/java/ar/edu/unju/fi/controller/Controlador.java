package ar.edu.unju.fi.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* 
Se añaden los getmapping de sucursales y contacto que redirigen a sus respectivas paginas
*/
@Controller
public class Controlador {
	
	@GetMapping("/sucursales")
	public String getSucursalesPage() {
		return "sucursales";
	}
	
	
	@GetMapping("/contacto")
	public String getContactoPage() {
		return "contacto";
	}
}