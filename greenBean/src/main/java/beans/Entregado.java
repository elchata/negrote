package beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Entregado extends Estado implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Enviado enviado;

	@OneToOne(fetch = FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "idState")
	public Enviado getEnviado() {
		return enviado;
	}

	public void setEnviado(Enviado enviado) {
		this.enviado = enviado;
	}

	public Entregado(Enviado enviado) {
		super();
		this.enviado = enviado;
	}

	public Entregado() {
		super();
	}
	
	

}
