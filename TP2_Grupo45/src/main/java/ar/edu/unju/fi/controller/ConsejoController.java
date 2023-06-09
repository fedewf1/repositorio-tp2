package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ConsejoController {
	@GetMapping("/consejos")
	public String getHome() {
     return "consejos_de_salud";
 }
 
}
