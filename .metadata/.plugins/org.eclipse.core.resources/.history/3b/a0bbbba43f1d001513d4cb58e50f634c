package com.proyectos.comidasapp.service;

import java.io.Serializable;
import java.util.List;
 


import com.proyectos.comidasapp.clases.Categoria;
import com.proyectos.comidasapp.clases.Pedido;
import com.proyectos.comidasapp.clases.Producto;

public interface ProductManager extends Serializable {
    
    public List<Categoria> recuperarTodasCategorias();
    
    public List<Producto> darProductos();
    
    public List<Pedido> darPedidos();
    
    public Categoria darCategoria(Long id);
    
    public void guardarCategoria(Categoria cat);
    
    public void borrarCategoria (long idCat);
    
    public Categoria borrarCategoria (Categoria cat);

}