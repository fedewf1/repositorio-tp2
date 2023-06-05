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
import ar.edu.unju.fi.listas.*;
import ar.edu.unju.fi.model.Producto;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
    private ListaProductos listaProductos;
    @Autowired
    private Producto producto;
    
    // Muestra la página con el listado de productos
    @GetMapping("/listado")
    public String getListaProductoPage(Model model) {
        model.addAttribute("productos", listaProductos.getProductos());
        return "productos";
    }
    
    // Muestra la página para agregar un nuevo producto
    @GetMapping("/nuevo")
    public String getNuevoProductoPage(Model model) {
    	boolean edicion = false;
    	model.addAttribute("producto", producto);
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
    	listaProductos.getProductos().add(producto);
        modelView.addObject("productos", listaProductos.getProductos());
        return modelView;
    }
    
    // Muestra la página para modificar un producto existente
    @GetMapping("/modificar/{codigo}")
    public String getModificarProductoPage(Model model, @PathVariable(value="codigo")int codigo) {
    	Producto productoEncontrado = new Producto();
    	boolean edicion= true;
    	for(Producto produ : listaProductos.getProductos()){
    		if(produ.getCodigo()==(codigo)) {
    			productoEncontrado = produ;
    			break;
    		}
    	}
    	model.addAttribute("producto", productoEncontrado);
    	model.addAttribute("edicion", edicion);
    	return"nuevo_producto";
    }
    
    // Guarda los cambios realizados en un producto existente
    @PostMapping("/modificar")
    public String modificaProducto(@ModelAttribute("producto")Producto producto) {
    	for(Producto produ:listaProductos.getProductos()) {
    		if(produ.getCodigo()==(producto.getCodigo())) {
    			produ.setCategoria(producto.getNombre());
    			produ.setPrecio(producto.getPrecio());
    			produ.setDescuento(producto.getDescuento() );
    			produ.setNombreImagen(producto.getNombreImagen());
    		}
    	}
    	return "redirect:/productos/listado";
    }
    // Elimina un producto de la lista
    @GetMapping("/eliminar/{codigo}")
    public String eliminarProducto(@PathVariable(value="codigo") int codigo) {
        // Iterar sobre la lista de productos
    	for(Producto produ:listaProductos.getProductos()) {
    		if(produ.getCodigo()==(codigo)) {
    			listaProductos.getProductos().remove(produ);
    			break;
    			}
    	    // Redireccionar al listado de productos después de eliminar
         }return "redirect:/productos/listado";
    }
}

