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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Inheritance(strategy=InheritanceType.JOINED) 
@Table(name = "estado")
public abstract class Contenedor implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private Date fecha;
	private Map<Producto, Integer> productos = new HashMap<Producto, Integer>();
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Contenedor(Long id, Date fecha, Map<Producto, Integer> productos) {
		this.id = id;
		this.fecha = fecha;
		this.productos = productos;
	}	
	
	public Contenedor() {
	}
	
	public double darPrecio(){
		double precio = 0.0;
		for (Producto producto : this.productos.keySet())
			precio += this.productos.get(producto) * producto.getPrecio(this.fecha);
		return precio;
	}
}
