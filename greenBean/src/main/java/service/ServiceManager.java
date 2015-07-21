package service;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.List; 

import beans.Carrito;
import beans.Categoria;
import beans.Ciudad;
import beans.Cliente;
import beans.Direccion;
import beans.Empresa;
import beans.Medida;
import beans.Partido;
import beans.Pedido;
import beans.Producto; 
import beans.Provincia;
import beans.User;

public interface ServiceManager extends Serializable {
    
/*	GET	*/
	
	/* Listas */
	
    public List<Categoria> recuperarTodasCategorias();
    
    public List<Producto> darProductos();
    
    public List<Pedido> darPedidos();

    public List<Partido> darPartidos();
    
    public List<Provincia> darProvincias();

	public List<Cliente>  darClientes();
	
	public List<Medida> darMedidas();

	public List<Ciudad> darCiudades(); 

	public List<Direccion> darDirecciones();
	
	public List<Empresa> darEmpresas();
	
	public List<Producto> darProductos(String nombre);
	
	/* Individuos */ 

	public Medida darMedida(Long l);

	public Producto darProducto(Long l);

	public Pedido darPedido(Long l);
	
    public Categoria darCategoria(Long id);
    
   	public Empresa darEmpresa(Long id);
    
	public User darCliente(long l);
	
	public Provincia darProvincia(long l);

	public Ciudad darCiudad(long auxCiu);

	public Direccion darDireccion(Long val);
	
    public Partido darPartido(Long val);
	
    
/* POST */
    
    public void guardarCategoria(Categoria cat);
    
    public void guardarMedida(Medida medida);

	public void guardarEmpresa(Empresa emp);

	public void guardarProducto(Producto prod);
	
	public void guardarPedido(Pedido aux);

	public void guardarCliente(Cliente aux);
	
	public void guardarProvincia(Provincia prov);

	public void guardarDireccion(Direccion dir);

    public void guardarPartido(Partido par);
    
    public void guardarCarrito(Carrito carrito);

/* DETELE */
	
	public void borrarProducto(Long val);

	public void borrarMedida(Long val);

	public void borrarCliente(Long val);

	public void borrarPedido(Long val); 
	
  	public void borrarCategoria (long idCat);
	
	public void borrarProvincia(Long val);
    
    public Categoria borrarCategoria (Categoria cat);

	public void borrarDireccion(Long val);
	
    public void borrarPartido(Long val);
    
/* AUX */
    
	public byte[] subirFoto(File auxImagen) throws FileNotFoundException;

}
