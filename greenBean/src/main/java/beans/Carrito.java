package beans;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name = "carrito")
public class Carrito implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idCarrito;
	private User cliente;
	private Date fecha;
	private Map<Producto, Integer> productos = new HashMap<Producto, Integer>();
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idCarrito", unique = true, nullable = false)
	public Long getIdCarrito() {
		return idCarrito;
	}
	public void setIdCarrito(Long idCarrito) {
		this.idCarrito = idCarrito;
	}
	
	@ManyToOne
	@JoinColumn(name = "idUser")
	public User getCliente() {
		return cliente;
	}
	public void setCliente(User cliente) {
		this.cliente = cliente;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	@ElementCollection(fetch = FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	public Map<Producto, Integer> getProductos() {
		return productos;
	}
	public void setProductos(Map<Producto, Integer> productos) {
		this.productos = productos;
	}	

}
