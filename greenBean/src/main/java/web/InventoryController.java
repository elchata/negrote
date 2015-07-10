package web; 

import java.io.FileNotFoundException;  
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap; 
import org.springframework.web.bind.annotation.RequestMapping; 

import beans.Cliente;
import beans.Empresa; 
import beans.Pedido;
import beans.Producto; 
import beans.User;
import service.ServiceManager;


@Controller
public class InventoryController {
    
    @Autowired
    private ServiceManager productManager;
    
    public void setProductManager(ServiceManager productManager) {
        this.productManager = productManager;
    }    

    @RequestMapping(value="/hello.htm")
    public String printHello(ModelMap model) throws FileNotFoundException {  
    	model.addAttribute("menu","menuAdmin.jsp");  
    	model.addAttribute("vista","hello.jsp"); 
        return "frontend";
    }  
    
    //metodos para crear objetos y testear la bbdd
     
    public void creaEmp(){
    	Empresa aux=new Empresa("Facebook");
    	this.productManager.guardarEmpresa(aux);
    }   
    public void creaPed(){
    	Pedido aux=new Pedido();
    	aux.setPrecioFinal(270.80);
    	Producto pr = this.productManager.darProducto((long) 1);
    	aux.getProductos().put(pr, 2);
    	aux.getProductos().put(this.productManager.darProducto((long) 2), 8);
    	aux.setCliente(this.productManager.darCliente((long) 1));
    	this.productManager.guardarPedido(aux);
    }     
    
    public void datosUser(){
    	Map<String,String> dato = new HashMap<String,String>();
    	dato.put("id","100003337804280"); 
    	dato.put("name","Juan Sequeira");
    	dato.put("birthday","01/02/1985");
    	dato.put("gender" , "male");
    	dato.put("link" ,"https://www.facebook.com/juansequeira");
    	dato.put("email" , "juansequeira@hotmail.com");
    	Cliente aux = (Cliente) this.productManager.darCliente(1);
    	aux.setDatos(dato);
    	this.productManager.guardarCliente(aux);
    	}
}