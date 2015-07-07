package web;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException; 
import java.util.Date;  
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import auxiliares.FotoForm;
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
    public String printHello(ModelMap model) throws FileNotFoundException {  
    	String now = (new Date()).toString();
    	model.addAttribute("pedido",this.productManager.darPedido((long) 1));
        model.addAttribute("now", now);   
        return "hello";
    } 
       
    @RequestMapping(value="/subir.htm" , method = RequestMethod.POST)
    public String subirFoto(@ModelAttribute("imagenAux") FotoForm foto, ModelMap model) throws FileNotFoundException { 
    	File file = foto.getImagen();  	
    	@SuppressWarnings("resource")
		FileInputStream fis = new FileInputStream(file);
        //create FileInputStream which obtains input bytes from a file in a file system
        //FileInputStream is meant for reading streams of raw bytes such as image data. For reading streams of characters, consider using FileReader.

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                //Writes to this byte array output stream
                bos.write(buf, 0, readNum); 
            }
        } catch (IOException ex) {
        }
        byte[] bytes = bos.toByteArray();
        Producto aux = this.productManager.darProducto((long) 1);
        aux.setImagen(bytes);
        this.productManager.guardarProducto(aux);
        model.addAttribute("producto", aux); 	
        return "verProd";
    }
    
    @RequestMapping(value="/subirF.htm")
    public String subirFoto(ModelMap model) { 
    	model.addAttribute("imagenAux", new FotoForm()); 	
        return "subirImg";
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
    
    public void agregarFoto() throws FileNotFoundException{
    	
    File file = new File("/home/chata/foto.jpeg");    
    FileInputStream fis = new FileInputStream(file);
    //create FileInputStream which obtains input bytes from a file in a file system
    //FileInputStream is meant for reading streams of raw bytes such as image data. For reading streams of characters, consider using FileReader.

    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    byte[] buf = new byte[1024];
    try {
        for (int readNum; (readNum = fis.read(buf)) != -1;) {
            //Writes to this byte array output stream
            bos.write(buf, 0, readNum);  
        }
    } catch (IOException ex) {
    }
    byte[] bytes = bos.toByteArray();
    Producto aux = this.productManager.darProducto((long) 1);
    aux.setImagen(bytes);
    this.productManager.guardarProducto(aux);
	}
    
    
    //-----------------------------------------------//
    
    //trae la imagen de la bbdd y se la devuelve convertida al view
    @RequestMapping(value="/customer/mostrarimagen.htm", method = RequestMethod.GET)
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
    
}