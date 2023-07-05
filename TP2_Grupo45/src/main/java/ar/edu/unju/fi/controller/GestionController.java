package ar.edu.unju.fi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Consejo;
import ar.edu.unju.fi.entity.Empleado;
import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.entity.Sucursal;

import ar.edu.unju.fi.service.IConsejoService;
import ar.edu.unju.fi.service.IEmpleadoService;
import ar.edu.unju.fi.service.IProductoService;
import ar.edu.unju.fi.service.IProvinciaService;
import ar.edu.unju.fi.service.IServicioService;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;


@Controller
public class GestionController {
	
	
	/**INYECCION*/
	
	@Autowired
	@Qualifier("empleadoServiceMysql")
	private IEmpleadoService empleadoService;
	
	@Autowired
	private IServicioService servicioService;
	
	
	@Autowired
	@Qualifier("consejoServiceMysql")
	private IConsejoService consejoService;
	
	 @Autowired
	  @Qualifier("sucursalServiceMysql")
	  private ISucursalService sucursalService;

	  @Autowired
	  private IProvinciaService provinciaService;
	  
	  @Autowired
		private IProductoService iproduSer;
		
	/**###########################*/
	
	@GetMapping("/gestion")
	public String getGestionPage(Model model) {
	    List<Empleado> empleados = empleadoService.getEmpleados();
	    List<Producto> productos= iproduSer.listar();
	    List<Sucursal> sucursales = sucursalService.getSucursales();
	    List<Consejo> consejos= consejoService.getConsejos();
	    model.addAttribute("empleados", empleados);
	    model.addAttribute("productos", productos);
	    model.addAttribute("consejos", consejos);
	    
	       for (Sucursal sucursal : sucursales) {
	           // Obtener el nombre de la provincia directamente de la sucursal
	           String nombreProvincia = sucursal.getProvincia().getNombre();
	           sucursal.getProvincia().setNombre(nombreProvincia);
	       }

	       model.addAttribute("sucursales", sucursales);
	    
	    return "gestion";
	}

	 
	  /**############################SECCION EMPLEADOS################################*/

	    @GetMapping("/gestion/empleado/nuevo")
	    public String mostrarFormularioNuevoEmpleado(Model model) {
	    	boolean editando = false;
	        model.addAttribute("empleado", new Empleado());
	        model.addAttribute("editando", editando);
	        
	        model.addAttribute("servicios", servicioService.getServicios());
	        return "nuevo_empleado";
	    }

	    @PostMapping("/gestion/empleado/guardar")
	    public String guardarEmpleado(@ModelAttribute("empleado") Empleado empleado) {
	        empleadoService.guardarEmpleado(empleado);
	        return "redirect:/gestion";
	    }

	    @GetMapping("/gestion/empleado/modificar/{id}")
	    public String mostrarFormularioModificarEmpleado(@PathVariable("id") Long id, Model model) {
	        Empleado empleado = empleadoService.getEmpleadoById(id);
	        if (empleado == null) {
	            return "redirect:/gestion";
	        }
	        model.addAttribute("empleado", empleado);
	        return "nuevo_empleado";
	    }

	    @PostMapping("/gestion/empleado/modificar")
	    public String modificarEmpleado(@ModelAttribute("empleado") Empleado empleado) {
	        empleadoService.actualizarEmpleado(empleado);
	        return "redirect:/gestion";
	    }

	    @GetMapping("/gestion/empleado/eliminar/{id}")
	    public String eliminarEmpleado(@PathVariable("id") Long id) {
	    	 Empleado empleado = empleadoService.getEmpleadoById(id);
	         empleado.setEstado(false); 
	         empleadoService.guardarEmpleado(empleado);
	        return "redirect:/gestion";
	    }
		  
	    
	    /**############################SECCION CONSEJOS################################*/
	    
	    @GetMapping("/gestion/consejo/nuevo")
		public ModelAndView getFormularioNuevoConsejo() {
		    boolean editando = false;
		    ModelAndView mav = new ModelAndView("nuevo_consejo");
		    mav.addObject("consejo", consejoService.getConsejo()); 
		    mav.addObject("editando", editando);
		    return mav;
		}


		
		@PostMapping("/gestion/consejo/guardar")
		public ModelAndView getGuardarConsejoPage(@Valid @ModelAttribute("consejo") Consejo consejo, BindingResult result) {
		    if (result.hasErrors()) {
		        ModelAndView modelView = new ModelAndView("nuevo_consejo");
		        modelView.addObject("consejos", consejoService.getConsejos());
		        return modelView;
		    }

		    consejoService.guardarConsejo(consejo);
		    
		    ModelAndView modelAndView = new ModelAndView("redirect:/consejos"); // Redireccionar a la página de consejos
		    return modelAndView;
		}


		

		   @GetMapping("/gestion/consejo/modificar/{id}")
		    public String mostrarFormularioModificarConsejo(Model model, @PathVariable(value = "id") Long id) {
		        Consejo consejoEncontrado = consejoService.getConsejoById(id);
		        boolean editando = true;
		        if (consejoEncontrado == null) {
		            return "redirect:/consejos";
		        }
		        model.addAttribute("consejo", consejoEncontrado);
		        model.addAttribute("editando", editando);
		        
		        return "nuevo_consejo";
		    }

		
		   @PostMapping("/gestion/consejo/modificar")
		    public String modificarConsejo(@Valid @ModelAttribute("consejo") Consejo consejo, BindingResult result) {
		        if (result.hasErrors()) {
		            return "nuevo_consejo";
		        }
		        consejoService.actualizarConsejo(consejo);
		        return "redirect:/empleados";
		    }

	
		   @GetMapping("/gestion/consejo/eliminar/{id}")
		   public String eliminarConsejo(@PathVariable Long id) {
			      Consejo consejoAEliminar = consejoService.getConsejoById(id);
			       consejoService.eliminarConsejo(consejoAEliminar);
		       return "redirect:/consejos";
		   }
		   
		   /**######################################################################*/
		   /**############################SECCION SUCURSALES################################*/
	
		   

		   @GetMapping("/gestion/sucursal/nuevo")
		   public String mostrarFormularioNuevaSucursal(Model model) {
		 	  boolean editando = false;
		       model.addAttribute("sucursal", new Sucursal());
		       model.addAttribute("editando", editando);
		       
		       model.addAttribute("provincias", provinciaService.getProvincias());
		       return "nueva_sucursal";
		   }


		  
		   @PostMapping("/gestion/sucursales/guardar")
		   public String guardarSucursal(@Valid @ModelAttribute("sucursal") Sucursal sucursal, BindingResult result, Model model) {
		 	  if (result.hasErrors()) {
		           model.addAttribute("provincias", provinciaService.getProvincias());
		           return "nueva_sucursal";
		       }

		       sucursalService.guardarSucursal(sucursal);
		       return "redirect:/sucursales";
		   }

		   @GetMapping("/gestion/sucursal/modificar/{id}")
		   public String mostrarFormularioModificarSucursal(Model model, @PathVariable(value = "id") Long id) {
		       Sucursal sucursal = sucursalService.getSucursalById(id);
		       boolean editando = true;
		       if (sucursal == null) {
		           return "redirect:/sucursales";
		       }
		       model.addAttribute("sucursal", sucursal);
		       model.addAttribute("editando", editando);
		       model.addAttribute("provincias", provinciaService.getProvincias());
		       return "nueva_sucursal";
		   }

		   @PostMapping("/gestion/sucursales/modificar")
		   public String modificarSucursal(@Valid @ModelAttribute("provincia") Sucursal sucursal, BindingResult result) {
		       if (result.hasErrors()) {
		           return "nueva_sucursal";
		       }
		       sucursalService.actualizarSucursal(sucursal);
		       return "redirect:/sucursales";
		   }

		  @GetMapping("/gestion/sucursales/eliminar/{id}")
		  public String eliminarSucursal(@PathVariable Long id) {
		      Sucursal sucursal = sucursalService.getSucursalById(id);
		      sucursal.setEstado(false);  // Establece el estado como false en lugar de eliminar
		      sucursalService.guardarSucursal(sucursal);
		      return "redirect:/sucursales";
		  }
		   /**######################################################################*/
		   /**############################SECCION PRODUCTOS################################*/
		   


		    @GetMapping("/gestion/producto/nuevo")
		    public String getNuevoProductoPage(Model model) {
		    //	boolean edicion = false;
		    	model.addAttribute("producto", new Producto());

		    	return "nuevo_producto";
		    }
		    

		    @PostMapping("/gestion/producto/guardar")
		    public String getguardarProductoPage(@Valid @ModelAttribute("producto") Producto producto, BindingResult result) {
		    	
		
		    	ModelAndView modelView = new ModelAndView("productos");
		   	if(result.hasErrors()) {
		    		modelView.setViewName("index");
		   		modelView.addObject("producto", producto);
		    		modelView=new ModelAndView("index");
		
		    		return "nuevo_producto";
		    	}else {
		    		
		    		iproduSer.save(producto);

		    		return "redirect:/productos/listado";
		    	}

		    }

		    @GetMapping("/gestion/producto/modificar/{id}")
		   public String getModificarProductoPage(Model model, @PathVariable long id) {
		        //boolean editando = true;
		    	Optional<Producto>producto=iproduSer.listarId(id);
		    	model.addAttribute("producto", producto);
	

		    	return"nuevo_producto";
		    }

		    
		    @PostMapping("/gestion/producto/guarda/{id}")
		    public String getguardarPorId(@Valid @ModelAttribute("producto") Producto producto, BindingResult result,Model model, @PathVariable long id) {
		    ModelAndView modelView = new ModelAndView("productos");
		   	if(result.hasErrors()) {
		    		modelView.setViewName("index");
		   		modelView.addObject("producto", producto);
		    		modelView=new ModelAndView("index");
		    		return "nuevo_producto";
		    	}else {		    		
		    		iproduSer.save(producto);
		    		return "redirect:/productos/listado";
		    	}
		    }
		    
		     @GetMapping("/gestion/producto/eliminar/{id}")
		     public String eliminarProducto(@PathVariable(value="id") Long id) throws Exception {
		    	 iproduSer.eliminar(id, false);
		         return "redirect:/productos/listado";
		
		    }
		   
		
		   
}
