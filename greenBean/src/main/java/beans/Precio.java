package beans;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "precio")
public class Precio implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idPrecio;
	private Producto producto;
	private double monto;
	private Date fecha;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idPrecio", unique = true, nullable = false)
	public Long getIdPrecio() {
		return idPrecio;
	}
	public void setIdPrecio(Long idPrecio) {
		this.idPrecio = idPrecio;
	}
	
	@ManyToOne
	@JoinColumn(name = "idProducto")
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}	
	
}
