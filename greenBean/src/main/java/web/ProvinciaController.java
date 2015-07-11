package web; 

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.ServiceManager; 
import beans.Provincia;

@Controller
@RequestMapping(value="/provincia")
public class ProvinciaController {

	@Autowired
    private ServiceManager productManager;
    
    public void setProductManager(ServiceManager productManager) {
        this.productManager = productManager;
    }    

	@RequestMapping(value="/ver.htm")
	public String mostrarPedidos(ModelMap model) { 
	    model.addAttribute("provincias",this.productManager.darProvincias()); 
	    model.addAttribute("vista","ABMprovincias.jsp");
	    return "frontend";
	}

    @RequestMapping(value = "new.htm", method = RequestMethod.GET)
	public String nuevoPedido(ModelMap model) { 
		model.addAttribute("command", new Provincia());
		model.addAttribute("provincias",this.productManager.darProvincias()); 
	    model.addAttribute("vista","editarProvincia.jsp");
	    return "frontend";
	}
    
    @RequestMapping(value="editar.htm", method = RequestMethod.GET)
	public String verPedidos(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idProv"));
	    model.addAttribute("pedidos",this.productManager.darProvincias()); 
	    model.addAttribute("command", this.productManager.darProvincia(val));  
	    model.addAttribute("vista","editarProvincia.jsp");
	    return "frontend";
	}
    

    @RequestMapping(value="/eliminar.htm", method = RequestMethod.GET)
	public String eliminarProducto(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idProv"));
		this.productManager.borrarProvincia(val);			
	    model.addAttribute("pedidos", this.productManager.darProvincias());  
	    model.addAttribute("vista","ABMprovincias.jsp");
	    return "frontend";
	}
    
    @RequestMapping(value = "/create.htm", method = RequestMethod.POST)
	public String creaPedido(@ModelAttribute("command") Provincia prov, ModelMap model) { 
    	this.productManager.guardarProvincia(prov);
	    model.addAttribute("pedidos",this.productManager.darProvincias()); 
	    model.addAttribute("vista","ABMprovincias.jsp");
	    return "frontend";
	}
    
    @RequestMapping(value="/mostrar.htm", method = RequestMethod.GET)
	public String mostrarPedido(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idProv"));
	    model.addAttribute("pedido", this.productManager.darProvincia(val));  
	    model.addAttribute("vista","verProvincia.jsp");
	    return "frontend";
	}
}
