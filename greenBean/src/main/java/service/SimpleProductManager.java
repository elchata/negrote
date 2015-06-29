package service;

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component; 

import beans.Categoria;
import beans.Cliente;
import beans.Empresa;
import beans.Medida;
import beans.Pedido;
import beans.Producto;
import daos.CategoriaDAO;
import daos.ClienteDAO;
import daos.EmpresaDAO;
import daos.MedidaDAO;
import daos.PedidoDAO;
import daos.ProductoDAO;

@Component
public class SimpleProductManager implements ProductManager {

    private static final long serialVersionUID = 1L;

    @Autowired
    private ProductoDAO productoModel;
    
    @Autowired
    private MedidaDAO medidaModel;
    
    @Autowired
    private EmpresaDAO empresaModel;
    
    @Autowired
    private PedidoDAO pedidoModel;
    
    @Autowired
    private ClienteDAO clienteModel;
  
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
	public Empresa darEmpresa(Long id) {
		return empresaModel.retornarPorId(id);
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
	public void guardarMedida(Medida med) {
		medidaModel.actualizar(med);		
	}
	
	@Override
	public void guardarEmpresa(Empresa emp) {
		empresaModel.actualizar(emp);		
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

	@Override
	public void guardarProducto(Producto prod) {
		productoModel.actualizar(prod);
		
	}

	@Override
	public Medida darMedida(Long l) {
		return medidaModel.retornarPorId(l);
	}

	@Override
	public Producto darProducto(Long l) {
		// TODO Auto-generated method stub
		return productoModel.retornarPorId(l);
	}

	@Override
	public void guardarPedido(Pedido aux) {
		this.pedidoModel.actualizar(aux);
		
	}

	@Override
	public Pedido darPedido(Long l) {
		// TODO Auto-generated method stub
		return this.pedidoModel.retornarPorId(l);
	}

	@Override
	public void guardarCliente(Cliente aux) {
		this.clienteModel.actualizar(aux);
		
	}
}