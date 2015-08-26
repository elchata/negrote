package beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Entregado extends Estado implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Entregado(Enviado enviado) {
		super(new Date());
		this.setAnterior(enviado);
	}

	public Entregado() {
		super();
	}
	
	

}
