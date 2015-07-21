package beans; 

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne; 

@Entity 
public class Carrito extends Contenedor implements Serializable{
	
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
}
