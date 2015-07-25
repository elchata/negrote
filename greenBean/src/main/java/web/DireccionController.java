package web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.ServiceManager;
import beans.Direccion; 

@Controller
@RequestMapping(value="/direccion")
public class DireccionController {
	

  	@Autowired
    private ServiceManager productManager;
    
    public void setProductManager(ServiceManager productManager) {
        this.productManager = productManager;
    }    

	@RequestMapping(value="/ver.htm")
	public String mostrarDireccion(ModelMap model) { 
	    model.addAttribute("direcciones",this.productManager.darDirecciones()); 
	    model.addAttribute("vista","ABMdirecciones.jsp");
	    return "frontend";
	}	

    @RequestMapping(value = "new.htm", method = RequestMethod.GET)
	public String nuevaMedida(ModelMap model) { 
		model.addAttribute("command", new Direccion());
		model.addAttribute("direcciones",this.productManager.darDirecciones()); 
	    model.addAttribute("ciudades",this.productManager.darCiudades()); 
	    model.addAttribute("vista","editarDireccion.jsp");
	    return "frontend";
	}
    
    @RequestMapping(value="editar.htm", method = RequestMethod.GET)
	public String verMedidas(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idDir"));
	    model.addAttribute("direcciones",this.productManager.darDirecciones()); 
	    model.addAttribute("command", this.productManager.darDireccion(val)); 
	    model.addAttribute("ciudades",this.productManager.darCiudades()); 
	    model.addAttribute("bandas", this.productManager.darBandas());
	    model.addAttribute("vista","editarDireccion.jsp");
	    return "frontend";
	}
    

    @RequestMapping(value="/eliminar.htm", method = RequestMethod.GET)
	public String eliminarMedida(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idDir"));
		this.productManager.borrarDireccion(val);			
	    model.addAttribute("direcciones",this.productManager.darDirecciones()); 
	    model.addAttribute("vista","ABMdirecciones.jsp");
	    return "frontend";
	}
    
    @RequestMapping(value = "/create.htm", method = RequestMethod.POST)
	public String creaMedida(@ModelAttribute("command") Direccion dir, ModelMap model)  { 
    	dir.setCiudad(this.productManager.darCiudad(dir.getAuxCiu()));
    	this.productManager.guardarDireccion(dir);
	    model.addAttribute("direcciones",this.productManager.darDirecciones()); 
	    model.addAttribute("vista","ABMdirecciones.jsp");
	    return "frontend";
	}
    
    @RequestMapping(value="/mostrar.htm", method = RequestMethod.GET)
	public String mostrarMedida(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idDir"));
	    model.addAttribute("direccion", this.productManager.darDireccion(val));   
	    model.addAttribute("vista","verDireccion.jsp");
	    return "frontend";
	}
}