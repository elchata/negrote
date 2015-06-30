package service;


import java.io.Serializable;
import java.util.List; 

import beans.Categoria;
import beans.Cliente;
import beans.Empresa;
import beans.Medida;
import beans.Pedido;
import beans.Producto; 
import beans.User;

public interface ServiceManager extends Serializable {
    
    public List<Categoria> recuperarTodasCategorias();
    
    public List<Producto> darProductos();
    
    public List<Pedido> darPedidos();
    
    public Categoria darCategoria(Long id);
    
    public Empresa darEmpresa(Long id);
    
    public void guardarCategoria(Categoria cat);
    
    public void guardarMedida(Medida medida);
    
    public void borrarCategoria (long idCat);
    
    public Categoria borrarCategoria (Categoria cat);

	public void guardarEmpresa(Empresa emp);

	public void guardarProducto(Producto prod);

	public Medida darMedida(Long l);

	public Producto darProducto(Long l);

	public void guardarPedido(Pedido aux);

	public Pedido darPedido(Long l);

	public void guardarCliente(Cliente aux);

	public User darCliente(long l); 

}