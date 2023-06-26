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
import ar.edu.unju.fi.service.ICommonService;
import ar.edu.unju.fi.service.IConsejoService;
import ar.edu.unju.fi.service.IEmpleadoService;
import ar.edu.unju.fi.service.IProductoService;
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
	  private ICommonService commonService;
	  
	  @Autowired
		private IProductoService iproduSer;
		
	/**###########################*/
	
	@GetMapping("/gestion")
	public String getGestionPage(Model model) {
	    List<Empleado> empleados = empleadoService.getEmpleados();
	    List<Producto> productos= iproduSer.listar();
	    List<Sucursal> sucursales = sucursalService.getSucursales();
	    model.addAttribute("empleados", empleados);
	    model.addAttribute("productos", productos);
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
		        Consejo consejo = consejoService.getConsejoById(id);
		        boolean editando = true;
		        if (consejo == null) {
		            return "redirect:/consejos";
		        }
		        model.addAttribute("consejo", consejo);
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
		       Consejo consejo = consejoService.getConsejoById(id);
		       consejoService.eliminarConsejo(consejo);
		       return "redirect:/consejos";
		   }
		   
		   /**######################################################################*/
		   /**############################SECCION SUCURSALES################################*/
		   @GetMapping("/gestion/sucursal/nuevo")
		   public String getNuevaSucursalPage(Model model) {
		     boolean edicion = false;
		     model.addAttribute("sucursal", new Sucursal());
		     model.addAttribute("provincias", commonService.getProvincias());
		     model.addAttribute("edicion", edicion);
		     return "nueva_sucursal";
		   }

		   @PostMapping("/gestion/sucursal/guardar")
		   public ModelAndView guardarSucursal(@Valid @ModelAttribute("sucursal") Sucursal sucursal, BindingResult result) {
		     ModelAndView modelView = new ModelAndView("sucursales");
		     if (result.hasErrors()) {
		       modelView.setViewName("nueva_sucursal");
		       modelView.addObject("sucursal", sucursal);
		       return modelView;
		     }

		     String provinciaSeleccionada = sucursal.getProvincia();

	
		     sucursal.setProvincia(provinciaSeleccionada);

		     sucursalService.guardarSucursal(sucursal);
		     modelView.addObject("sucursales", sucursalService.getSucursales());
		     return modelView;
		   }

		   @GetMapping("/gestion/sucursal/modificar/{id}")
		   public String getModificarSucursalPage(Model model, @PathVariable(value="id") Long id) {
		     Sucursal sucursalEncontrada = sucursalService.buscarSucursalPorCodigo(id);
		     boolean edicion = true;
		     model.addAttribute("sucursal", sucursalEncontrada);
		     model.addAttribute("provincias", commonService.getProvincias());
		     model.addAttribute("edicion", edicion);
		     return "nueva_sucursal";
		   }

		   @PostMapping("/gestion/sucursal/modificar")
		   public String modificaSucursal(@ModelAttribute("sucursal") Sucursal sucursal) {
		     sucursalService.modificarSucursal(sucursal);
		     return "redirect:/sucursales/listado";
		   }

		   @GetMapping("/gestion/sucursaleliminar/{id}")
		   public String eliminarSucursal(@PathVariable(value="id") Long id) {
		     Sucursal sucursal = sucursalService.buscarSucursalPorCodigo(id);
		     sucursalService.eliminarSucursal(sucursal);
		     return "redirect:/sucursales/listado";
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
