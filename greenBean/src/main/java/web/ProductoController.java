package web;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.tag.rt.core.ForEachTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beans.Categoria;
import beans.Producto;
import service.ServiceManager;

@Controller
@RequestMapping(value="/producto")
public class ProductoController {
	
	@Autowired
    private ServiceManager productManager;
    
    public void setProductManager(ServiceManager productManager) {
        this.productManager = productManager;
    }    
    
    @RequestMapping(value="ver.htm")
	public String mostrarProductos(ModelMap model) { 
	    model.addAttribute("productos",this.productManager.darProductos());
	    return "ABMproductos";
	}
    
    @RequestMapping(value = "nuevo.htm", method = RequestMethod.GET)
	public String nuevoProducto(ModelMap model) { 
		model.addAttribute("command", new Producto());
		model.addAttribute("categorias",this.productManager.recuperarTodasCategorias());
	    model.addAttribute("productos",this.productManager.darProductos());
	    return "editarProducto";
	}
    
    @RequestMapping(value="editar.htm", method = RequestMethod.GET)
	public String verProductos(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idProd"));
	    model.addAttribute("productos",this.productManager.darProductos());
	    model.addAttribute("categorias",this.productManager.recuperarTodasCategorias());
	    model.addAttribute("command", this.productManager.darProducto(val)); 
	    return "editarProducto";
	}

    @RequestMapping(value="producto/mostrarimagen.htm", method = RequestMethod.GET)
    public void verFoto (HttpServletRequest req, ModelMap model, HttpServletResponse res) throws IOException { 
    	Long val = Long.parseLong(req.getParameter("id"));
    	Producto producto = this.productManager.darProducto(val);
    	
    	byte[] imagen = producto.getImagen();
    	 try {
    		 res.setContentType("image/jpeg, image/jpg, image/png, image/gif");
    		 res.getOutputStream().write(imagen);
    		 res.getOutputStream().close();
    		 
    	 } catch (Exception e) {
    	        e.printStackTrace();
    	 }
    }
    
    @RequestMapping(value="/eliminar.htm", method = RequestMethod.GET)
	public String eliminarProducto(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idProd"));
		this.productManager.borrarProducto(val);			
	    model.addAttribute("productos", this.productManager.darProductos()); 
	    return "ABMproductos";
	}
    
    @RequestMapping(value = "/create.htm", method = RequestMethod.POST)
	public String creaCategoria(@ModelAttribute("command") Producto prod, ModelMap model) throws FileNotFoundException { 
    	    
		if (prod.getAuxImagen().exists() != false) prod.setImagen(this.productManager.subirFoto(prod.getAuxImagen()));
		else {
			if (prod.getIdProducto() != null) prod.setImagen(this.productManager.darProducto(prod.getIdProducto()).getImagen());
			else prod.setImagen(null);
		}
		
		//agrega cada uno de los seleccionados en el checkbox y crea una lista nueva de categorias
		//reemplazando la que existia.
		
		List<Categoria> listaAuxiliar= new ArrayList<Categoria>(0);	
		for(String cat: prod.getCategos()){
			listaAuxiliar.add(this.productManager.darCategoria(Long.parseLong(cat)));
		}
		prod.setCategorias(listaAuxiliar);
		//-----------------------------------------------
		
		this.productManager.guardarProducto(prod);
	    model.addAttribute("productos",this.productManager.darProductos());
	    return "ABMproductos";
	}
}
