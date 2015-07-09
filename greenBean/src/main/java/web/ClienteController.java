package web;

import java.io.FileNotFoundException; 

import javax.servlet.http.HttpServletRequest; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.ServiceManager; 
import beans.Cliente;

@Controller
@RequestMapping(value="/cliente")
public class ClienteController {
	

  	@Autowired
    private ServiceManager productManager;
    
    public void setProductManager(ServiceManager productManager) {
        this.productManager = productManager;
    }    

	@RequestMapping(value="/ver.htm")
	public String mostrarClientes(ModelMap model) { 
	    model.addAttribute("clientes",this.productManager.darClientes()); 
	    model.addAttribute("vista","ABMclientes.jsp");
	    return "frontend";
	}
	
	@RequestMapping(value = "/new.htm", method = RequestMethod.GET)
	public String nuevoCliente(ModelMap model) { 
		model.addAttribute("command", new Cliente());
	    model.addAttribute("clientes",this.productManager.darClientes()); 
	    model.addAttribute("vista","editarCliente.jsp");
	    return "frontend";
	}
	
	@RequestMapping(value = "/create.htm", method = RequestMethod.POST)
	public String creaCliente(@ModelAttribute("command") Cliente cli, ModelMap model) throws FileNotFoundException { 
		
		this.productManager.guardarCliente(cli);
	    model.addAttribute("clientes",this.productManager.darClientes()); 
	    model.addAttribute("vista","ABMclientes.jsp");
	    return "frontend";
	}
	
	@RequestMapping(value="/editar.htm", method = RequestMethod.GET)
	public String verClientes(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idCli"));
	    model.addAttribute("clientes",this.productManager.darClientes());
	    model.addAttribute("command", this.productManager.darCliente(val));  
	    model.addAttribute("vista","editarCliente.jsp");
	    return "frontend";
	}
	
	@RequestMapping(value="/eliminar.htm", method = RequestMethod.GET)
	public String eliminarCliente(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idCli"));
		this.productManager.borrarCliente(val);			
	    model.addAttribute("clientes", this.productManager.darClientes());  
	    model.addAttribute("vista","ABMclientes.jsp");
	    return "frontend";
	}
	
	@RequestMapping(value="/mostrar.htm", method = RequestMethod.GET)
	public String mostrarCliente(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idCli"));
	    model.addAttribute("cliente", this.productManager.darCliente(val));  
	    model.addAttribute("vista","verCliente.jsp");
	    return "frontend";
	}
	 
} 