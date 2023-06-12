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
//import ar.edu.unju.fi.listas.*;
import ar.edu.unju.fi.model.Producto;
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/productos")
public class ProductoController {
	@Autowired
	private IProductoService productoService;
	
	
    //private Producto producto
    
    // Muestra la página con el listado de productos
    @GetMapping("/listado")
    public String getListaProductoPage(Model model) {
        model.addAttribute("productos", productoService.getProductos());
        return "productos";
    }
   
    // Muestra la página para agregar un nuevo producto
    @GetMapping("/nuevo")
    public String getNuevoProductoPage(Model model) {
    	boolean edicion = false;
    	model.addAttribute("producto", new Producto());
    	model.addAttribute("edicion", edicion);
    	return "nuevo_producto";
    }
    
    // Guarda un nuevo producto en la lista
    @PostMapping("/guardar")
    public ModelAndView getguardarProductoPage(@Valid @ModelAttribute("producto") Producto producto, BindingResult result) {
    	
    	ModelAndView modelView = new ModelAndView("productos");
    	if(result.hasErrors()) {
    		modelView.setViewName("nuevo_producto");
    		modelView.addObject("producto", producto);
    		return modelView;
    	}
    	productoService.guardar(producto);
    	modelView.addObject("productos", productoService.getProductos());
        return modelView;
        
    }
    
    // Muestra la página para modificar un producto existente
    @GetMapping("/modificar/{codigo}")
    public String getModificarProductoPage(Model model, @PathVariable(value="codigo")int codigo) {
    	Producto productoEncontrado = productoService.buscarPorCodigo(codigo);
    	boolean edicion= true;
    	//decidir si quito este if.
    	if (productoEncontrado == null) {
            return "redirect:/productos/listado";
        }
    	model.addAttribute("producto", productoEncontrado);
    	model.addAttribute("edicion", edicion);
    	return"nuevo_producto";
    }
    
    // Guarda los cambios realizados en un producto existente
    @PostMapping("/modificar")
    public String modificaProducto(@ModelAttribute("producto")Producto producto) {
    	productoService.modificar(producto);
    	return "redirect:/productos/listado";
    }
    // Elimina un producto de la lista
    @GetMapping("/eliminar/{codigo}")
    public String eliminarProducto(@PathVariable(value="codigo") int codigo) {
        // Iterar sobre la lista de productos
    	
    	 productoService.eliminar(codigo);
         return "redirect:/productos/listado";
    }
}

