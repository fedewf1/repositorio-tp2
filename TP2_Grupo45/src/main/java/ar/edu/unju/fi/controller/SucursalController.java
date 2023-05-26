package ar.edu.unju.fi.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.listas.*;
import ar.edu.unju.fi.model.Sucursal;


//@Controller
//public class ProductoController {
 //   private List<Producto> listaProductos = new ArrayList<>();
//@GetMapping("/productos")
//	public String mostrarFormulario() {
        //model.addAttribute("producto", new Producto(null, 0, 0, null, 0));
//        return "productos";
//    }

    
//}
@Controller
@RequestMapping("/sucursales")
public class SucursalController {
    ListaSucursales listaSucursales = new ListaSucursales();

    @GetMapping("/listado")
    public String getListaProductoPage(Model model) {
        model.addAttribute("sucursales", listaSucursales.getSucursales());
        return "sucursales";
    }
    
    @GetMapping("/nueva")
    public String getNuevaSucursalPage(Model model) {
    	boolean edicion = false;
    	model.addAttribute("sucursal", new Sucursal());
    	model.addAttribute("edicion", edicion);
    	return "nueva_sucursal";
    }
    @PostMapping("/guardar")
    public ModelAndView getguardarSucursalPage(@ModelAttribute("sucursal") Sucursal sucursal) {
    	ModelAndView modelView = new ModelAndView("sucursales");
    	listaSucursales.getSucursales().add(sucursal);
        modelView.addObject("sucursales", listaSucursales.getSucursales());
        return modelView;
    }
    @GetMapping("/modificar/{codigoSucursal}")
    public String getModificarSucursalPage(Model model, @PathVariable(value="codigoSucursal")int codigoSucursal) {
    	Sucursal sucursalEncontrada = new Sucursal();
    	boolean edicion= true;
    	for(Sucursal sucu : listaSucursales.getSucursales()){
    		if(sucu.getCodigoSucursal()==(codigoSucursal)) {
    			sucursalEncontrada = sucu;
    			break;
    		}
    	}
    	model.addAttribute("sucursal", sucursalEncontrada);
    	model.addAttribute("edicion", edicion);
    	return"nueva_sucursal";
    }
    @PostMapping("/modificar")
    public String modificaSucursal(@ModelAttribute("sucursal")Sucursal sucursal) {
    	int ca;
    	for(Sucursal sucu:listaSucursales.getSucursales()) {
    		
    		if(sucu.getCodigoSucursal()==(sucursal.getCodigoSucursal())) {
    			ca=sucu.getCodigoSucursal();
   //sucu.getCodigoSucursal()
    			String numeroString = String.valueOf(ca);
    			//produ= producto;
    			sucu.setNombreSucursal(numeroString);
    			sucu.setDireccion(numeroString);
    			sucu.setTelefono(sucursal.getTelefono() );
    			
    			sucu.setHoraLunesViernes(sucursal.getHoraLunesViernes());
    			sucu.setHoraSabados(sucursal.getHoraSabados());
    			//sucu.setHoraLunesViernes(sucursal.getHoraLunesViernes());
    		}else {
    			sucu.setNombreSucursal(sucursal.getNombreSucursal());
    			sucu.setDireccion(sucursal.getDireccion() );
    			sucu.setTelefono(sucursal.getTelefono() );
    			sucu.setHoraLunesViernes(sucursal.getHoraLunesViernes());
    			sucu.setHoraSabados(sucursal.getHoraSabados());
    			//ca=sucu.getCodigoSucursal();
    			//String numeroString = String.valueOf(ca);
    			//sucu.setNombreSucursal(numeroString);
    			//sucu.setDireccion(sucursal.getDireccion());
    			//sucu.setTelefono(sucursal.getTelefono() );
    		}
    	}
    	return "redirect:/sucursales/listado";
    }
    @GetMapping("/eliminar/{codigoSucursal}")
    public String eliminarSocursal(@PathVariable(value="codigoSucursal") int codigoSucursal) {
    	for(Sucursal sucu:listaSucursales.getSucursales()) {
    		if(sucu.getCodigoSucursal()==(codigoSucursal)) {
    			listaSucursales.getSucursales().remove(sucu);
    			break;
    			}
         }return "redirect:/sucursales/listado";
    }
}

