package service;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.List; 

import beans.Categoria;
import beans.Ciudad;
import beans.Cliente;
import beans.Direccion;
import beans.Empresa;
import beans.Medida;
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
    
    public List<Provincia> darProvincias();

	public List<Cliente>  darClientes();
	
	public List<Medida> darMedidas();
<<<<<<< HEAD

	public List<Ciudad> darCiudades(); 

	public List<Direccion> darDirecciones();
	
	public List<Empresa> darEmpresas();
=======
>>>>>>> d5fd05378116bbfe132b15e9fc54ecad50742962
	
	/* Individuos */ 

	public Medida darMedida(Long l);

	public Producto darProducto(Long l);

	public Pedido darPedido(Long l);
	
<<<<<<< HEAD
    	public Categoria darCategoria(Long id);
=======
    public Categoria darCategoria(Long id);
>>>>>>> d5fd05378116bbfe132b15e9fc54ecad50742962
    
   	public Empresa darEmpresa(Long id);
    
	public User darCliente(long l);
	
	public Provincia darProvincia(long l);
<<<<<<< HEAD

	public Ciudad darCiudad(long auxCiu);

	public Direccion darDireccion(Long val);
	
=======
>>>>>>> d5fd05378116bbfe132b15e9fc54ecad50742962
    
/* POST */
    
    public void guardarCategoria(Categoria cat);
    
    public void guardarMedida(Medida medida);

	public void guardarEmpresa(Empresa emp);

	public void guardarProducto(Producto prod);
	
	public void guardarPedido(Pedido aux);

	public void guardarCliente(Cliente aux);
	
	public void guardarProvincia(Provincia prov);

<<<<<<< HEAD
	public void guardarDireccion(Direccion dir);

=======
>>>>>>> d5fd05378116bbfe132b15e9fc54ecad50742962
/* DETELE */
	
	public void borrarProducto(Long val);

	public void borrarMedida(Long val);

	public void borrarCliente(Long val);

	public void borrarPedido(Long val); 
	
<<<<<<< HEAD
  	public void borrarCategoria (long idCat);
	
	public void borrarProvincia(Long val);
    
    	public Categoria borrarCategoria (Categoria cat);

	public void borrarDireccion(Long val);
=======
    public void borrarCategoria (long idCat);
	
	public void borrarProvincia(Long val);
    
    public Categoria borrarCategoria (Categoria cat);
>>>>>>> d5fd05378116bbfe132b15e9fc54ecad50742962
    
/* AUX */
    
	public byte[] subirFoto(File auxImagen) throws FileNotFoundException;

}
