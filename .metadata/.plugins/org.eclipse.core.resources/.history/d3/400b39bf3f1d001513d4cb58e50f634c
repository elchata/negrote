package com.proyectos.comidasapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proyectos.comidasapp.clases.Categoria;
import com.proyectos.comidasapp.clases.Pedido;
import com.proyectos.comidasapp.clases.Producto;
import com.proyectos.comidasapp.daos.CategoriaDAO;
import com.proyectos.comidasapp.daos.PedidoDAO;
import com.proyectos.comidasapp.daos.ProductoDAO;

@Component
public class SimpleProductManager implements ProductManager {

    private static final long serialVersionUID = 1L;

    @Autowired
    private ProductoDAO productoModel;
    
    @Autowired
    private PedidoDAO pedidoModel;
  
    @Autowired
    private CategoriaDAO categoriaModel;
    
	public List<Categoria> recuperarTodasCategorias() {
		return categoriaModel.recuperarTodos();
	}

	@Override
	public List<Producto> darProductos() {
		return productoModel.recuperarTodos();
	}

	@Override
	public Categoria darCategoria(Long id) {
		return categoriaModel.retornarPorId(id);
	}

	@Override
	public List<Pedido> darPedidos() {
		return pedidoModel.recuperarTodos();
	}

	@Override
	public void guardarCategoria(Categoria cat) {
		categoriaModel.actualizar(cat);		
	}

	@Override
	public void borrarCategoria(long idCat) {
		categoriaModel.borrar(idCat);		
	}

	@Override
	public Categoria borrarCategoria(Categoria cat) {
		// TODO Auto-generated method stub
		return categoriaModel.borrar(cat);
	}
}