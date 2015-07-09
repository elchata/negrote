package beans;

import java.util.Date;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "carrito")
public class Carrito extends Contenedor {
	private static final long serialVersionUID = 1L; 
	private User cliente; 
	
	@ManyToOne
	@JoinColumn(name = "idUser")
	public User getCliente() {
		return cliente;
	}
	public void setCliente(User cliente) {
		this.cliente = cliente;
	}

	public Carrito(){		
	}
	
	public Carrito(Long id, Date fecha, Map<Producto, Integer> productos,
			User cliente) {
		super(id, fecha, productos);
		this.cliente = cliente;
	}
	
}
