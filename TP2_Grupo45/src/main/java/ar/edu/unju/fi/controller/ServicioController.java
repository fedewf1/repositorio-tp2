package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* 
Se añaden los getmapping de sucursales y contacto que redirigen a sus respectivas paginas
*/
@Controller
public class ServicioController {
	@GetMapping("/servicios")
	public String getHome() {
     return "servicio_de_paseos";
 }
}
