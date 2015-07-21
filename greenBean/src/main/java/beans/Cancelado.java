package beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Cancelado extends Estado implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Estado estado;
	private String motivo;
	
	@OneToOne(fetch = FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "idState")
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public Cancelado(Estado estado, String motivo) {
		super(new Date());
		this.estado = estado;
		this.motivo = motivo;
	}
	public Cancelado() {
		super();
	}
	
	

	
}
