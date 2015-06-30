package web;

import java.util.Date; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import beans.Categoria; 
import beans.Cliente;
import beans.Empresa;
import beans.Medida;
import beans.Pedido;
import beans.Producto; 
import service.ServiceManager;


@Controller
public class InventoryController {
    
    @Autowired
    private ServiceManager productManager;
    
    public void setProductManager(ServiceManager productManager) {
        this.productManager = productManager;
    }    

    @RequestMapping(value="/hello.htm")
    public String printHello(ModelMap model) {  
    	String now = (new Date()).toString();
    	this.creaPed();
        model.addAttribute("now", now);   
        return "hello";
    }
    
    //metodos para crear objetos y testear la bbdd
    public void creaMed(){
    	Medida aux=new Medida("Kilogramos", "Kg.");
    	this.productManager.guardarMedida(aux);
    }
    public void creaEmp(){
    	Empresa aux=new Empresa("Facebook");
    	this.productManager.guardarEmpresa(aux);
    }
    public void creaCat(){
    	Categoria aux=new Categoria("Liquidos");
    	this.productManager.guardarCategoria(aux);
    }
    public void creaProd1(){
    	Producto med = new Producto("Lechuga",100);
    	med.setMedida(this.productManager.darMedida((long) 1));
    	med.getCategorias().add(this.productManager.darCategoria((long) 1));
    	this.productManager.guardarProducto(med);
    }    
    public void creaProd2(){
    	Producto med = new Producto("Remolacha",20);
    	med.setMedida(this.productManager.darMedida((long) 1));
    	med.getCategorias().add(this.productManager.darCategoria((long) 1));
    	this.productManager.guardarProducto(med);
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
    public void creaCli(){
    	Cliente aux = new Cliente();
    	aux.setCarrito(null);
    	aux.setDatos(null);
    	aux.setEmpresa(this.productManager.darEmpresa((long) 1));
    	this.productManager.guardarCliente(aux);
    }
    
    
    //-----------------------------------------------//
}