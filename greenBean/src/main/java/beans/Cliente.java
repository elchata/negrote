package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection; 
import javax.persistence.Entity;
import javax.persistence.FetchType;  
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany; 
import javax.persistence.OneToMany; 
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Cliente extends User implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Direccion> direcciones = new ArrayList<Direccion>(0);
	private Map<Producto, Integer> visitas = new HashMap<Producto, Integer>();
	private List<Pedido> pedidos = new ArrayList<Pedido>(0);
	private Contenedor carrito;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
			name="cliente_direccion",
		    joinColumns={@JoinColumn(name="idUser", referencedColumnName="idUser")},
		    inverseJoinColumns={@JoinColumn(name="idDireccion", referencedColumnName="idDireccion")})
	public List<Direccion> getDirecciones() {
		return direcciones;
	}
	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}
	
	@ElementCollection(fetch = FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	public Map<Producto, Integer> getVisitas() {
		return visitas;
	}
	public void setVisitas(Map<Producto, Integer> visitas) {
		this.visitas = visitas;
	}
	
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	@OneToOne
	@JoinColumn(name = "idContenedor")
	public Contenedor getCarrito() {
		return carrito;
	}
	public void setCarrito(Contenedor carrito) {
		this.carrito = carrito;
	}
	
	
	

}
