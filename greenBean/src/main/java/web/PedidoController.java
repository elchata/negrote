package web; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.ServiceManager;  
import beans.Cliente;
import beans.Nuevo;
import beans.Pedido;

@Controller
@RequestMapping(value="/pedido")
public class PedidoController {

	@Autowired
    private ServiceManager productManager;
    
    public void setProductManager(ServiceManager productManager) {
        this.productManager = productManager;
    }    

	@RequestMapping(value="/ver.htm")
	public String mostrarPedidos(ModelMap model) { 
	    model.addAttribute("pedidos",this.productManager.darPedidos()); 
	    model.addAttribute("vista","ABMpedidos.jsp");
	    return "frontend";
	}

    @RequestMapping(value = "new.htm", method = RequestMethod.GET)
	public String nuevoPedido(ModelMap model) { 
		model.addAttribute("command", new Pedido());
		model.addAttribute("pedidos",this.productManager.darPedidos()); 
	    model.addAttribute("vista","editarPedido.jsp");
	    return "frontend";
	}
    
    @RequestMapping(value = "miPedido.htm", method = RequestMethod.GET)
	public String nuevoPedidoMio(HttpServletRequest req, ModelMap model) { 
    	Long val = Long.parseLong(req.getParameter("idCli"));
    	Pedido ped = new Pedido();
    	ped.setEstado(new Nuevo());
    	ped.setCliente((Cliente)this.productManager.darCliente(val));
		model.addAttribute("command", ped);
		model.addAttribute("pedidos",this.productManager.darPedidos()); 
	    model.addAttribute("vista","editarPedido.jsp");
	    return "frontend";
	}

    @RequestMapping(value="/eliminar.htm", method = RequestMethod.GET)
	public String eliminarProducto(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idPed"));
		this.productManager.borrarPedido(val);			
	    model.addAttribute("pedidos", this.productManager.darPedidos());  
	    model.addAttribute("vista","ABMpedidos.jsp");
	    return "frontend";
	}
    
    @RequestMapping(value = "/create.htm", method = RequestMethod.POST)
	public String creaPedido(@ModelAttribute("command") Pedido ped, ModelMap model, HttpSession session) { 
    	((Nuevo)ped.getEstado()).setDetalle(ped.getAuxDetalle());
    	this.productManager.guardarPedido(ped);
    	Cliente aux = (Cliente) session.getAttribute("sesion");
    	Long auxCar = aux.getCarrito().getIdContenedor();
    	aux.setCarrito(null);
    	this.productManager.guardarCliente(aux);
    	this.productManager.borrarCarrito(auxCar);
	    model.addAttribute("pedidos",this.productManager.darPedidos()); 
	    model.addAttribute("vista","ABMpedidos.jsp");
	    return "frontend";
	} 
    
    @RequestMapping(value="/mostrar.htm", method = RequestMethod.GET)
	public String mostrarPedido(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idPed"));
	    model.addAttribute("pedido", this.productManager.darPedido(val));  
	    model.addAttribute("vista","verPedido.jsp");
	    return "frontend";
	}
    
    @RequestMapping(value="confirmarCompra.htm", method = RequestMethod.GET)
    public String confirmarPedido(HttpServletRequest req, ModelMap model, HttpSession session){
    	Cliente aux = (Cliente) session.getAttribute("sesion");
		Pedido nuevo = new Pedido(aux, new Nuevo());
		model.addAttribute("command", nuevo);
		model.addAttribute("vista","editarPedido.jsp");
    	return "frontend";
    }
}
