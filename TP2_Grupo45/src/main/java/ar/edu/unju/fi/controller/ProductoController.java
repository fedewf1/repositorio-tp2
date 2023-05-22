package ar.edu.unju.fi.controller;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import ar.edu.unju.fi.listas.*;
import ar.edu.unju.fi.model.Producto;


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
@RequestMapping("/productos")
public class ProductoController {
    ListaProductos listaProductos = new ListaProductos();

    @GetMapping("/listado")
    public String getListaProductoPage(Model model) {
        model.addAttribute("productos", listaProductos.getProductos());
        return "productos";
    }
    
    @GetMapping("/nuevo")
    public String getNuevoProductoPage(Model model) {
    	boolean edicion = false;
    	model.addAttribute("producto", new Producto());
    	model.addAttribute("edicion", edicion);
    	return "nuevo_producto";
    }
    @PostMapping("/guardar")
    public ModelAndView getguardarProductoPage(@ModelAttribute("producto") Producto producto) {
    	ModelAndView modelView = new ModelAndView("productos");
    	listaProductos.getProductos().add(producto);
        modelView.addObject("productos", listaProductos.getProductos());
        return modelView;
    }
    @GetMapping("/modificar/{nombre}")
    public String getModificarProductoPage(Model model, @PathVariable(value="nombre")String nombre) {
    	Producto productoEncontrado = new Producto();
    	boolean edicion= true;
    	for(Producto produ : listaProductos.getProductos()){
    		if(produ.getNombre().equals(nombre)) {
    			productoEncontrado = produ;
    			break;
    		}
    	}
    	model.addAttribute("producto", productoEncontrado);
    	model.addAtribute("edicion", edicion);
    	return"nuevo_producto";
    }
    @PostMapping(/modificar)
    public String modificaProducto(@ModelAttribute("producto")Producto producto) {
    	
    }
}

