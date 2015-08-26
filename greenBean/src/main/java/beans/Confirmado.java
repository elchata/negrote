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
public class Confirmado extends Estado implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String observacion;
	private Date fechaEntrega;
	
	
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public Confirmado() {
		super();
	}
	public Confirmado(Nuevo nuevo, String observacion) {
		super(new Date());
		this.setAnterior(nuevo);
		this.setObservacion(observacion);
		this.getSiguiente().add(Preparado.class);
		this.getSiguiente().add(Cancelado.class);
	}
	

}
